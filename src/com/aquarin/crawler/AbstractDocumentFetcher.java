package com.aquarin.crawler;

import java.io.IOException;

public abstract class AbstractDocumentFetcher {
	abstract AbstractDocument fetchDocument(URL url) throws IOException;
}
