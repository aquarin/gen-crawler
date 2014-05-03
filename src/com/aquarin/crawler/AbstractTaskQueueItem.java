package com.aquarin.crawler;

import com.aquarin.dataabstraction.DataRow;

// TODO: think about if should separate the physical representation (DataRow) from this.
public abstract class AbstractTaskQueueItem {
  public abstract DataRow createDataRow();
}
