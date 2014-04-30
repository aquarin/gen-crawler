package com.aquarin.crawler;

public class HttpUrl extends AbstractUrl {
  public HttpUrl(String url) {
    this.url = url;
  }

  public String getUrl() {
    return this.url;
  }

  private String url;
}
