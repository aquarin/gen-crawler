package com.aquarin.crawler;

import com.aquarin.dataabstraction.widecolumn.DataRow;

// TODO: think about if should separate the physical representation (DataRow) from this.
public abstract class AbstractTaskQueueItem {
  // TODO: think about what if it is not NoSQL/widecolumn storage.
  // TODO: DataRow is a wide-column concept, this should not be associated with wide-column only.
  public abstract DataRow createDataRow();
}
