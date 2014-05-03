package com.aquarin.accessor.googledatastore;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;

import com.google.api.services.datastore.DatastoreV1.CommitRequest;
import com.google.api.services.datastore.DatastoreV1.CommitResponse;
import com.google.api.services.datastore.DatastoreV1.Entity;
import com.google.api.services.datastore.DatastoreV1.Mutation;
import com.google.api.services.datastore.client.Datastore;
import com.google.api.services.datastore.client.DatastoreException;
import com.google.api.services.datastore.client.DatastoreFactory;
import com.google.api.services.datastore.client.DatastoreHelper;
import static com.google.api.services.datastore.client.DatastoreHelper.*;

import com.aquarin.dataabstraction.DataRow;
import com.aquarin.dataabstraction.widecolumn.WideColumnStoreAccessor;

public class GoogleDatastoreAccessor implements WideColumnStoreAccessor {
  private Datastore datastore;
  private String kind; // kind is Datastore's term of "table"
  
  @Override
  public void InsertDataRow(String tableName, DataRow row) throws IOException {
    throw new UnsupportedOperationException("Method not implemented");
  }

  @Override
  public String InsertDataRowAutoKey(String tableName, DataRow row) throws IOException {
    Entity.Builder entity = Entity.newBuilder()
        .setKey(makeKey(tableName));

    for (String key : row.properties.keySet()) {
      entity.addProperty(makeProperty(key, TypeUtils.getAcceptedValue(row.properties.get(key))));
      }

    CommitRequest commitRequest = CommitRequest.newBuilder()
        .setMode(CommitRequest.Mode.NON_TRANSACTIONAL)
        .setMutation(Mutation.newBuilder().addInsertAutoId(entity))
        .build();
    try {
      CommitResponse response = datastore.commit(commitRequest); // TODO: add handling of response errors. 
    } catch (DatastoreException e) {
      throw new IOException(e);
    }

    return null; // TODO: return auto key here
  }
  
  private GoogleDatastoreAccessor() {
    
  }

  public static GoogleDatastoreAccessor createFromEnvSettings(String datasetId) throws IllegalArgumentException, GeneralSecurityException, IOException { // awkward signature, blame Google API
    GoogleDatastoreAccessor accessor = new GoogleDatastoreAccessor();
    accessor.datastore = DatastoreFactory.get().create(DatastoreHelper.getOptionsfromEnv()
        .dataset(datasetId).build());
    
    return accessor;
  }
}
