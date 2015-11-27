package com.hk.utils;

import java.io.File;
import java.util.LinkedList;


public class FileQueue {

	private static LinkedList<Entry> entris = new LinkedList<Entry>();

	public static void add(Entry entry) {
		entris.add(entry);
	}
	
	public static Entry pop() {
		return entris.pop();
	}
	
	public static boolean hasNext() {
		return entris.size() > 0;
	}
	
	public static class Entry {
		
		private File file;
		private String content;

		public Entry(File file, String content) {
			this.file = file;
			this.content = content;
		}

		public File getFile() {
			return file;
		}

		public String getContent() {
			return content;
		}

	}
}
