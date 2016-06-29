package com.rayzr522.webutils.utils;


public class FilesUtils {
	
	public static String getExtension(String fileName) {
		
		if (!fileName.contains(".")) {
			return "";
		}
		
		String[] split = fileName.split("\\.");
		
		return split[split.length - 1];
		
	}

}
