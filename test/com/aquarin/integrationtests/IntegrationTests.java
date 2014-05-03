package com.aquarin.integrationtests;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.aquarin.accessor.googledatastore.GoogleDatastoreAccessor;
import com.aquarin.crawler.AbstractTaskQueueItem;
import com.aquarin.crawler.SeederTask;
import com.aquarin.crawler.WideColumnStoreTaskQueueAccessor;

@RunWith(JUnit4.class)
public class IntegrationTests {

  @Test
  public void testInsertTaskWithGoogleDatastore() throws IllegalArgumentException, GeneralSecurityException, IOException {
    GoogleDatastoreAccessor gdsAccessor = 
        GoogleDatastoreAccessor.createFromEnvSettings("shuishiy-dogfood"); // TODO: make this configurable
    WideColumnStoreTaskQueueAccessor taskAccessor = 
        new WideColumnStoreTaskQueueAccessor(gdsAccessor, "integrationtest"); 
    AbstractTaskQueueItem queueItem = new SeederTask("http://en.wikipedia.org/wiki/Website");
    taskAccessor.enqueue(queueItem);
  }
}
