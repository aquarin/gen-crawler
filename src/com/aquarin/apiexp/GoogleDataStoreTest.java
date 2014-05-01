package com.aquarin.apiexp;

import com.google.api.services.datastore.DatastoreV1.*;
import com.google.api.services.datastore.client.Datastore;
import com.google.api.services.datastore.client.DatastoreException;
import com.google.api.services.datastore.client.DatastoreFactory;
import com.google.api.services.datastore.client.DatastoreHelper;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.lang.ProcessBuilder;
import java.security.GeneralSecurityException;

public class GoogleDataStoreTest {
  public static void main(String[] args) {
    String datasetId = "shuishiy-dogfood";

    Datastore datastore = null;
    try {
	// Setup the connection to Google Cloud Datastore and infer credentials
	// from the environment.
    datastore = DatastoreFactory.get().create(DatastoreHelper.getOptionsfromEnv()
	        .dataset(datasetId).build());
	  } catch (GeneralSecurityException exception) {
	    System.err.println("Security error connecting to the datastore: " + exception.getMessage());
	    System.exit(1);
	  } catch (IOException exception) {
	    System.err.println("I/O error connecting to the datastore: " + exception.getMessage());
	    System.exit(1);
	  }
    
    try {
      // Create an RPC request to begin a new transaction.
      // Execute the RPC synchronously.

      for (int i = 0; i < 10000; i ++) {
        BeginTransactionRequest.Builder treq = BeginTransactionRequest.newBuilder();
        
        BeginTransactionResponse tres = datastore.beginTransaction(treq.build());
        // Get the transaction handle from the response.
        ByteString tx = tres.getTransaction();
        CommitRequest.Builder creq = CommitRequest.newBuilder();
      	
      	Key.Builder key = Key.newBuilder().addPathElement(
            Key.PathElement.newBuilder()
            .setKind("shuishiytestkind1")
            .setName(String.format("%d", i + 1)));
      	
        // Set the transaction to commit.
        creq.setTransaction(tx);
        Entity entity;
  			// If no entity was found, create a new one.
  			Entity.Builder entityBuilder = Entity.newBuilder();
  			// Set the entity key.
  			entityBuilder.setKey(key);
  			// Add two entity properties:
  			// - a utf-8 string: `question`
  			entityBuilder.addProperty(Property.newBuilder()
  			    .setName("testprop1")
  			    .setValue(Value.newBuilder().setIntegerValue(i)));
  			// - a 64bit integer: `answer`
  			entityBuilder.addProperty(Property.newBuilder()
  			    .setName("testprop2")
  			    .setValue(Value.newBuilder().setIntegerValue(i * 20)));
  			// Build the entity.
  			entity = entityBuilder.build();
  			// Insert the entity in the commit request mutation.
  			
  			creq.getMutationBuilder().addUpsert(entity);
        // Execute the Commit RPC synchronously and ignore the response.
        // Apply the insert mutation if the entity was not found and close
        // the transaction.
        // Get `question` property value.
        datastore.commit(creq.build());
      }
      
    } catch (DatastoreException exception) {
      // Catch all Datastore rpc errors.
      System.err.println("Error while doing datastore operation");
      // Log the exception, the name of the method called and the error code.
      System.err.println(String.format("DatastoreException(%s): %s %s",
              exception.getMessage(),
              exception.getMethodName(),
              exception.getCode()));
      System.exit(1);
    }
	}	
}
