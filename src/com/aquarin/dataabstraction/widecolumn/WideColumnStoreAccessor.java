package com.aquarin.dataabstraction.widecolumn;

import java.io.IOException;

public interface WideColumnStoreAccessor {
  void InsertDataRow(String tableName, DataRow row) throws IOException; // What's ideal return value here?
  String InsertDataRowAutoKey(String tableName, DataRow row) throws IOException;
  
  // Query definitions to come...
}
