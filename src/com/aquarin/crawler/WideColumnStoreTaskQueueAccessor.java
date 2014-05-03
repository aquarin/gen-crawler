package com.aquarin.crawler;

import java.io.IOException;

import com.aquarin.crawler.AbstractQueueAccessor;
import com.aquarin.crawler.AbstractTaskQueueItem;
import com.aquarin.dataabstraction.widecolumn.WideColumnStoreAccessor;

public class WideColumnStoreTaskQueueAccessor extends AbstractQueueAccessor {
  private WideColumnStoreAccessor accessor;
  private String tableName;
  
  @Override
  public AbstractTaskQueueItem dequeue() {
    throw new UnsupportedOperationException("Method not implemented");
  }

  @Override
  public void enqueue(AbstractTaskQueueItem task) throws IOException {
    accessor.InsertDataRowAutoKey(tableName, task.createDataRow());
  }
  
  public WideColumnStoreTaskQueueAccessor(WideColumnStoreAccessor accessor, String tableName) {
    this.accessor = accessor;
    this.tableName = tableName;
  }  
}
