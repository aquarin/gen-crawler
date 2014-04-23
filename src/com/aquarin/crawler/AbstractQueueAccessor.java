package com.aquarin.crawler;

public abstract class AbstractQueueAccessor {
  public abstract AbstractTask dequeue();
  public abstract void enqueue(AbstractTask task);
}
