package com.aquarin.accessor.googledatastore;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.services.datastore.client.Datastore;
import com.google.api.services.datastore.client.DatastoreFactory;
import com.google.api.services.datastore.client.DatastoreHelper;
import com.aquarin.dataabstraction.widecolumn.DataRow;
import com.aquarin.dataabstraction.widecolumn.WideColumnStoreAccessor;

public class GoogleDatastoreAccessor implements WideColumnStoreAccessor {
  private Datastore datastore;
  
  @Override
  public void InsertDataRow(DataRow row) throws IOException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public String InsertDataRowAutoKey(DataRow row) throws IOException {
    // TODO Auto-generated method stub
    return null;
  }
  
  private GoogleDatastoreAccessor() {
    
  }

  public GoogleDatastoreAccessor createFromEnvSettings(String datasetId) throws IllegalArgumentException, GeneralSecurityException, IOException { // awkward signature, blame Google API
    GoogleDatastoreAccessor accessor = new GoogleDatastoreAccessor();
    accessor.datastore = DatastoreFactory.get().create(DatastoreHelper.getOptionsfromEnv()
        .dataset(datasetId).build());
    
    return accessor;
  }
}
