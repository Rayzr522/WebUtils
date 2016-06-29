
package com.rayzr522.webutils.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Downloader {

	public static boolean downloadFile(HTTPRequest req, File outFile) {
		
		if (!req.isValid()) {
			
			System.err.println("Tried to download file with invalid HTTPRequest");
			
			return false;
			
		}

		try {

			InputStream is = req.getInputStream();
			
			outFile.createNewFile();

			OutputStream os = new FileOutputStream(outFile);

			int next = is.read();

			while (next != -1) {

				os.write(next);

				next = is.read();

			}

			os.close();
			is.close();
			
			return true;

		} catch (Exception e) {

			System.err.println("Failed to download '" + req.getFileName() + "' file.");
			e.printStackTrace();
			
			return false;

		}

	}

}
