package com.aquarin.crawler;

import java.io.IOException;

public abstract class AbstractQueueAccessor {
  public abstract AbstractTaskQueueItem dequeue();
  public abstract void enqueue(AbstractTaskQueueItem task) throws IOException;
}
