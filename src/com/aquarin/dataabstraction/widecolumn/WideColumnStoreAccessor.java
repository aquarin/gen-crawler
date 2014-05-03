package com.aquarin.dataabstraction.widecolumn;

import com.aquarin.dataabstraction.DataRow;

import java.io.IOException;

public interface WideColumnStoreAccessor {
  // Should table name be given on each access call, or as part of the constructor?
  void InsertDataRow(String tableName, DataRow row) throws IOException; // What's ideal return value here?
  String InsertDataRowAutoKey(String tableName, DataRow row) throws IOException;
  
  // Query definitions to come...
}
