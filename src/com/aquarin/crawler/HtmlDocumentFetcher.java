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
    BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(url.openStream()));
    StringBuilder strBuilder = new StringBuilder();
    int len;

    while ((len = bufferedReader.read(buffer, 0, DEFAULT_BUFFER_SIZE)) > 0) {
      strBuilder.append(buffer, 0, len);
    }

    return new HtmlDocument(strBuilder.toString());
  }
}
