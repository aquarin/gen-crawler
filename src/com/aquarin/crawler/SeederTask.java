package com.aquarin.crawler;

import java.util.Date;

import com.aquarin.dataabstraction.widecolumn.DataRow;

/**
 * A seeder task is a url fetch task that's not automated from reading 
 * anchors, but from manual input or seeding tools.
 * Example: iterations of keyword searches on job.com are seeder tasks
 * @author shuishiy
 *
 */
public class SeederTask extends AbstractTaskQueueItem {
  
  // TODO: design considerations: how to prioritize this? 
  // TODO: design considerations: what if the task is done?   
  private String url;
  private Date date;
  
  @Override
  public DataRow createDataRow() {
    DataRow datarow = new DataRow();
    datarow.properties.put("url", url);
    
    return datarow;
  }

  public SeederTask(String url) {
    this(url, new Date());
  }
  
  public SeederTask(String url, Date creationDate) {    
  }
}
