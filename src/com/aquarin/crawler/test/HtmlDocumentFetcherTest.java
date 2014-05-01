package com.aquarin.crawler.test;

import java.net.URL;
import java.io.IOException;

import com.aquarin.crawler.*;

public class HtmlDocumentFetcherTest {
	public static void main(String[] args) throws IOException {
	    HtmlDocumentFetcher docFetcher = new HtmlDocumentFetcher();
	    HtmlDocument doc = docFetcher.fetchDocument(new URL("http://www.indeed.com/jobs?q=&l=Seattle%2C+WA"));
	    System.out.println(doc.getContent());
	}
}
