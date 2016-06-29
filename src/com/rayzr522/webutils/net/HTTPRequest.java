
package com.rayzr522.webutils.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequest {

	private HttpURLConnection	conn;
	private boolean				valid		= false;
	private String				fileName	= "";

	public static HTTPRequest get(URL url) {

		HTTPRequest req = new HTTPRequest();

		HttpURLConnection conn;

		try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
			return req;
		}

//		conn.setReadTimeout(60000);

		if (!conn.getHeaderField(0).toString().endsWith("200 OK")) {

			System.err.println("Invalid URL: " + url.toString());
			return req;

		}

		String fileName = "";

		String raw = conn.getHeaderField("Content-Disposition");

		// raw = "attachment; filename=abc.jpg"
		if (raw != null && raw.indexOf("=") != -1) {

			fileName = raw.split("=")[1]; // getting value after '='

		} else {

			String[] seperatedPath = conn.getURL().getPath().split("/");
			fileName = seperatedPath[seperatedPath.length - 1];

		}

		req.conn = conn;
		req.fileName = fileName;
		req.valid = true;

		return req;

	}

	public static HTTPRequest get(String url) {

		try {

			return get(new URL(url));

		} catch (Exception e) {

			System.err.println("Failed to get URL for '" + url + "'");
			e.printStackTrace();
			return new HTTPRequest();

		}

	}

	public HttpURLConnection getConn() {
		return conn;
	}

	public boolean isValid() {
		return valid;
	}

	public String getFileName() {
		return fileName;
	}

	public InputStream getInputStream() throws IOException {
		return conn.getInputStream();
	}

}
