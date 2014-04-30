package com.aquarin.crawler;

public class HtmlDocument extends AbstractDocument {
  public String htmlContent;
  
  public HtmlDocument(String content) {
	  this.htmlContent = content;
  }
  
  public String getContent() {
	  return this.htmlContent;  
  }
}
