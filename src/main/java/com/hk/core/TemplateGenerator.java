package com.hk.core;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hk.entitys.Table;
import com.hk.templates.DaoImplHolderTemplate;
import com.hk.templates.ModelDaoImplTemplate;
import com.hk.templates.ModelDaoTemplate;
import com.hk.templates.ModelHolderTemplate;
import com.hk.templates.ModelServiceImplTemplate;
import com.hk.templates.ModelServiceTemplate;
import com.hk.templates.ModelTemplate;
import com.hk.utils.FileAssistant;
import com.hk.utils.FileQueue;
import com.hk.utils.FileQueue.Entry;
import com.hk.utils.PropertiesUtils;
import com.hk.utils.SpellingIgnore;

public abstract class TemplateGenerator {

	private static final String JAVA_DIR = "./src/main/java/";
//	private static final String RESOURCE_DIR = "./src/main/resources/";

	protected static final String ROOT_DIR = getPackage("root.path");

	protected static final String MODEL_PACKAGE = getPackage("model.path");

	protected static final String MODEL_OUT_DIR = getPackagePath(ROOT_DIR,
			MODEL_PACKAGE);

	protected static final String DAO_PACKAGE = getPackage("dao.path");

	protected static final String DAO_OUT_DIR = getPackagePath(ROOT_DIR,
			DAO_PACKAGE);

	protected static final String DAO_IMPL_PACKAGE = getPackage("dao.impl.path");

	protected static final String DAO_IMPL_OUT_DIR = getPackagePath(ROOT_DIR,
			DAO_IMPL_PACKAGE);

	protected static final String SERVICE_PACKAGE = getPackage("service.path");

	protected static final String SERVICE_OUT_DIR = getPackagePath(ROOT_DIR,
			SERVICE_PACKAGE);

	protected static final String SERVICE_IMPL_PACKAGE = getPackage("service.impl.path");

	protected static final String SERVICE_IMPL_OUT_DIR = getPackagePath(
			ROOT_DIR, SERVICE_IMPL_PACKAGE);

	private static String className;

	private static File outputFile;

	public static void generate(List<Table> tables) {
		TemplateBuilder builder = new TemplateBuilder();
		builder.setModelTemplates(getModelTemplates(tables));
		builder.setModelHolderTemplate(getModelHolderTemplate(tables));

		builder.setDaoHolderTemplate(getDaoHolderTemplate(tables));
		builder.setDaoImplTemplates(getDaoImplTemplates(tables));
		builder.setDaoTemplates(getDaoTemplates(tables));

		builder.setModelServiceTemplates(getModelServiceTemplates(tables));
		builder.setModelServiceImplTemplates(getModelServiceImplTemplates(tables));

		builder.buildModelTemplate();
		builder.buildDaoTemplate();
		builder.buildServiceTemplate();

		execute();
	}

	private static void execute() {
		while (FileQueue.hasNext()) {
			Entry entry = FileQueue.pop();
			print(entry);
			FileAssistant.write(entry.getContent(), entry.getFile());
		}
		System.out
				.println("[C] ------------------------------------------------------------------------\n");
		System.out.println("[C] BUILD SUCCESS\n");
		System.out
				.println("[C] ------------------------------------------------------------------------\n");
	}

	private static void print(Entry entry) {
		String path = entry.getFile().getAbsolutePath();
		path = path.replace("\\", "/");
		while (path.indexOf("/..") != -1) {
			int index = path.indexOf("../");
			String lpath = path.substring(0, index - 1);
			String rpath = path.substring(index + 2);
			path = lpath.substring(0, lpath.lastIndexOf("/")) + rpath;
		}
		path = path.replace("/.", "");
		String info = String.format("%s %s %s", "[C]", path, "\n");
		System.out.println(info);
	}

	private static Set<ModelServiceImplTemplate> getModelServiceImplTemplates(
			List<Table> tables) {
		Set<ModelServiceImplTemplate> sets = new HashSet<ModelServiceImplTemplate>();
		for (Table table : tables) {
			className = table.getName() + "ServiceImpl";
			outputFile = buildOutputFile(SERVICE_IMPL_OUT_DIR, className);
			sets.add(new ModelServiceImplTemplate(table.getName() + "Service" ,SERVICE_PACKAGE,table.getName(),
					MODEL_PACKAGE, DAO_PACKAGE, SERVICE_IMPL_PACKAGE, className,
					outputFile));
		}
		return sets;
	}

	private static Set<ModelServiceTemplate> getModelServiceTemplates(
			List<Table> tables) {
		Set<ModelServiceTemplate> sets = new HashSet<ModelServiceTemplate>();
		for (Table table : tables) {
			className = table.getName() + "Service";
			outputFile = buildOutputFile(SERVICE_OUT_DIR, className);
			sets.add(new ModelServiceTemplate(table.getName(),SERVICE_PACKAGE, className,
					MODEL_PACKAGE, outputFile));
		}
		return sets;
	}

	private static Set<ModelDaoTemplate> getDaoTemplates(List<Table> tables) {
		Set<ModelDaoTemplate> sets = new HashSet<ModelDaoTemplate>();
		for (Table table : tables) {
			className = table.getName() + "Dao";
			outputFile = buildOutputFile(DAO_OUT_DIR, className);
			sets.add(new ModelDaoTemplate(table.getName() ,MODEL_PACKAGE, DAO_PACKAGE,
					className, outputFile));
		}
		return sets;
	}

	private static Set<ModelDaoImplTemplate> getDaoImplTemplates(
			List<Table> tables) {
		Set<ModelDaoImplTemplate> sets = new HashSet<ModelDaoImplTemplate>();
		for (Table table : tables) {
			className = table.getName() + "DaoImpl";
			outputFile = buildOutputFile(DAO_IMPL_OUT_DIR, className);
			sets.add(new ModelDaoImplTemplate(DAO_PACKAGE, table.getName()+"Dao",DAO_IMPL_PACKAGE, className,
					outputFile));
		}

		return sets;
	}

	private static DaoImplHolderTemplate getDaoHolderTemplate(List<Table> tables) {
		outputFile = buildOutputFile(DAO_IMPL_OUT_DIR, "DaoImplHolder");
		return new DaoImplHolderTemplate(DAO_IMPL_PACKAGE, "DaoImplHolder", MODEL_PACKAGE ,tables,
				outputFile);
	}

	/**
	 * ModelHolder.java
	 * 
	 * @param tables
	 * @return
	 */
	private static ModelHolderTemplate getModelHolderTemplate(List<Table> tables) {
		outputFile = buildOutputFile(MODEL_OUT_DIR, "ModelHolder");
		return new ModelHolderTemplate(MODEL_PACKAGE, "ModelHolder", tables,
				SpellingIgnore.ignoreColumns(), outputFile);
	}

	/**
	 * 每一个实体文件
	 * 
	 * @param tables
	 * @return
	 */
	private static Set<ModelTemplate> getModelTemplates(List<Table> tables) {
		Set<ModelTemplate> sets = new HashSet<ModelTemplate>();
		for (Table table : tables) {
			className = table.getName(); 
			outputFile = buildOutputFile(MODEL_OUT_DIR, className);
			sets.add(new ModelTemplate(MODEL_PACKAGE, className, outputFile));
		}
		return sets;
	}

	private static File buildOutputFile(String outputDir, String fileName) {
		return buildOutputFile(outputDir, fileName, "java");
	}

	private static File buildOutputFile(String outputDir, String fileName,
			String suffix) {
		fileName += "." + suffix;
		return new File(outputDir, fileName);
	}

	private static String getPackage(String suffix) {
		return PropertiesUtils.get(suffix);
	}

	private static String getPackagePath(String rootDir, String suffix) {
		String outputDir = JAVA_DIR + suffix.replace(".", "/");
		outputDir = rootDir == null ? outputDir : rootDir + outputDir;
		File file = new File(outputDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return file.getAbsolutePath();
	}
}
