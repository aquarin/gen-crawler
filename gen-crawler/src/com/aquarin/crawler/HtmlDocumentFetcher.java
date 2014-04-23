package com.aquarin.crawler;

import java.net.*;
import java.io.*;
import java.lang.IllegalArgumentException;
import java.lang.StringBuilder;

public class HtmlDocumentFetcher extends AbstractDocumentFetcher {
  @Override
  public HtmlDocument fetchDocument(AbstractUrl url) throws IOException {
    if (!(url instanceof HttpUrl)) {
      throw new IllegalArgumentException("url must be an instance of HttpUrl");
    }

    HttpUrl httpUrl = (HttpUrl) url;

    URL urlObject;
    try {
      urlObject = new URL(httpUrl.getUrl());
    } catch (MalformedURLException ex) {
      throw new IOException("Cannot process url format");
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(urlObject.openStream()));
    // Continue at here

    return null;
  }
}
