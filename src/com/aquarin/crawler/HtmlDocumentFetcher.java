package com.aquarin.crawler;

import java.net.*;
import java.io.*;
import java.lang.IllegalArgumentException;
import java.lang.StringBuilder;

public class HtmlDocumentFetcher extends AbstractDocumentFetcher {
  private final int DEFAULT_BUFFER_SIZE = 2048;
  private final char[] buffer = new char[DEFAULT_BUFFER_SIZE];

  @Override
  public HtmlDocument fetchDocument(URL url) throws IOException {
	  
	URLConnection connection = url.openConnection();
	connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U;"
	    + "Intel Mac OS X 10_5_8; en-US) AppleWebKit/532.5 (KHTML, like Gecko) Chrome/4.0.249.0 Safari/532.5");

    BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(connection.getInputStream()));
    StringBuilder strBuilder = new StringBuilder();
    int len;

    while ((len = bufferedReader.read(buffer, 0, DEFAULT_BUFFER_SIZE)) > 0) {
      strBuilder.append(buffer, 0, len);
    }
    
    bufferedReader.close();

    return new HtmlDocument(strBuilder.toString());
  }
}
