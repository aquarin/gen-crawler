package com.aquarin.accessor.googledatastore;

import static org.junit.Assert.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.aquarin.dataabstraction.DataRow;

@RunWith(JUnit4.class)
public class GoogleDatastoreAccessorTest {
  // TODO: move this to integration test
  @Test
  public void testInsertEntity() throws IllegalArgumentException, GeneralSecurityException, IOException {
    GoogleDatastoreAccessor accessor = GoogleDatastoreAccessor
        .createFromEnvSettings("shuishiy-dogfood");
    DataRow datarow = new DataRow();
    datarow.properties.put("testname", "GoogleDatastoreAccessorTest");
    datarow.properties.put("testdate", new Date());
    accessor.InsertDataRowAutoKey("junit-test", datarow);
  }
  
  // TODO: get rid of this after find better Google API without env var
  @Test
  public void testRequiredEnvVariables() {
    Map<String, String> env = System.getenv();

    assertTrue("DATASTORE_SERVICE_ACCOUNT must be set", env.get("DATASTORE_SERVICE_ACCOUNT") != null);
    assertTrue("DATASTORE_PRIVATE_KEY_FILE must be set", env.get("DATASTORE_PRIVATE_KEY_FILE") != null);
  }
  
  public static void main(String[] args) {
    System.out.println("hello");
  }
}
