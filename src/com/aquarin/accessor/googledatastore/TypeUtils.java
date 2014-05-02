package com.aquarin.accessor.googledatastore;

import com.google.api.services.datastore.DatastoreV1.Value;
import static com.google.api.services.datastore.client.DatastoreHelper.*;

public class TypeUtils {
  public static Value.Builder getAcceptedValue(Object value) {
    // TODO: support more types
    if (value instanceof String) {
      return makeValue((String) value);
    } else if (value instanceof Integer) {
      return makeValue((Integer) value);
    } else {
      throw new IllegalArgumentException("Google Datastore accessor not yet supporting type " 
            + value.getClass().getName());
    }
  }
}
