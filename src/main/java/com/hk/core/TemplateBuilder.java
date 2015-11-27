package com.hk.core;

import java.io.File;
import java.util.Set;

import com.hk.templates.DaoImplHolderTemplate;
import com.hk.templates.ModelDaoImplTemplate;
import com.hk.templates.ModelDaoTemplate;
import com.hk.templates.ModelHolderTemplate;
import com.hk.templates.ModelServiceImplTemplate;
import com.hk.templates.ModelServiceTemplate;
import com.hk.templates.ModelTemplate;
import com.hk.utils.FileQueue;
import com.hk.utils.FileQueue.Entry;

public class TemplateBuilder {

	private File outputFile;

	private String templateSource;
	private TemplateEngine engine;

	private Set<ModelTemplate> modelTemplates;
	private ModelHolderTemplate modelHolderTemplate; 

	private DaoImplHolderTemplate daoHolderTemplate;
	private Set<ModelDaoTemplate> daoTemplates;
	private Set<ModelDaoImplTemplate> daoImplTemplates;

	private Set<ModelServiceTemplate> modelServiceTemplates;
	private Set<ModelServiceImplTemplate> modelServiceImplTemplates;

	public TemplateBuilder() {
		engine = new TemplateEngine();
	}

	public void setModelTemplates(Set<ModelTemplate> modelTemplates) {
		this.modelTemplates = modelTemplates;
	}

	public void setModelHolderTemplate(ModelHolderTemplate modelHolderTemplate) {
		this.modelHolderTemplate = modelHolderTemplate;
	}

	public void setDaoHolderTemplate(DaoImplHolderTemplate daoHolderTemplate) {
		this.daoHolderTemplate = daoHolderTemplate;
	}

	public void setDaoTemplates(Set<ModelDaoTemplate> daoTemplates) {
		this.daoTemplates = daoTemplates;
	}

	public void setDaoImplTemplates(Set<ModelDaoImplTemplate> daoImplTemplates) {
		this.daoImplTemplates = daoImplTemplates;
	}

	public void setModelServiceTemplates(
			Set<ModelServiceTemplate> modelServiceTemplates) {
		this.modelServiceTemplates = modelServiceTemplates;
	}

	public void setModelServiceImplTemplates(
			Set<ModelServiceImplTemplate> modelServiceImplTemplates) {
		this.modelServiceImplTemplates = modelServiceImplTemplates;
	}

	
	public void buildModelTemplate() {
		outputFile = modelHolderTemplate.getOutputFile();
		templateSource = engine.parseTemplate(modelHolderTemplate);	
		FileQueue.add(new Entry(outputFile, templateSource));
		
		for (ModelTemplate modelTemplate : modelTemplates) {
			outputFile = modelTemplate.getOutputFile();
			if(!outputFile.exists()) {
				templateSource = engine.parseTemplate(modelTemplate);
				FileQueue.add(new Entry(outputFile, templateSource));
			}
		}
	}
	
	public void buildDaoTemplate() {
		outputFile = daoHolderTemplate.getOutputFile();
		templateSource = engine.parseTemplate(daoHolderTemplate);
		FileQueue.add(new Entry(outputFile, templateSource));
		
		for (ModelDaoTemplate daoTemplate : daoTemplates) {
			outputFile = daoTemplate.getOutputFile();
			if(!outputFile.exists()) {
				templateSource = engine.parseTemplate(daoTemplate);
				FileQueue.add(new Entry(outputFile, templateSource));
			}
		}
		
		for (ModelDaoImplTemplate modelDaoImplTemplate : daoImplTemplates) {
			outputFile = modelDaoImplTemplate.getOutputFile();
			if(!outputFile.exists()) {
				templateSource = engine.parseTemplate(modelDaoImplTemplate);
				FileQueue.add(new Entry(outputFile, templateSource));
			}
		}
	}
	
	public void buildServiceTemplate() {
		for (ModelServiceTemplate modelServiceTemplate : modelServiceTemplates) {
			outputFile = modelServiceTemplate.getOutputFile();
			if(!outputFile.exists()) {
				templateSource = engine.parseTemplate(modelServiceTemplate);
				FileQueue.add(new Entry(outputFile, templateSource));
			}
		}
		for (ModelServiceImplTemplate modelServiceImplTemplate : modelServiceImplTemplates) {
			outputFile = modelServiceImplTemplate.getOutputFile();
			if(!outputFile.exists()) {
				templateSource = engine.parseTemplate(modelServiceImplTemplate);
				FileQueue.add(new Entry(outputFile, templateSource));
			}
		}
	}

}
