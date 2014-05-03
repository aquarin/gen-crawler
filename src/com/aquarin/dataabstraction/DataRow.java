package com.aquarin.dataabstraction;

import java.util.HashMap;
import java.util.Map;

public class DataRow {
  public String key;
  public Map<String, Object> properties; // Technically value type shouldn't 
                                         // be object. Ignore for now. 
  
  public DataRow() {
    properties = new HashMap<String, Object>();
  }
}
