package com.aquarin.crawler;

import java.io.IOException;

public abstract class AbstractDocumentFetcher {
	abstract AbstractDocument fetchDocument(AbstractUrl url) throws IOException;
}
