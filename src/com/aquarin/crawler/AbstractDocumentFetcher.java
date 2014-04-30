package com.aquarin.crawler;

import java.io.IOException;
import java.net.URL;

public abstract class AbstractDocumentFetcher {
	abstract AbstractDocument fetchDocument(URL url) throws IOException;
}
