package com.aquarin.dataabstraction.widecolumn;

import java.IO.IOException;

public interface WideColumnStoreAccessor {
  void InsertDataRow(DataRow row) throws IOException; // What's ideal return value here?
  String InsertDataRowAutoKey(DataRow row) throws IOException;  
  
  // Query definitions to come...
}
