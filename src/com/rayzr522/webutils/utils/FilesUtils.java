
package com.rayzr522.webutils.utils;

public class FilesUtils {

	public static String getExtension(String fileName) {

		if (!fileName.contains(".")) { return ""; }

		String[] split = fileName.split("\\.");

		String output = split[split.length - 1];

		if (output.endsWith("\"")) {
			output = output.substring(0, output.length() - 1);
		}

		return output;

	}

}
