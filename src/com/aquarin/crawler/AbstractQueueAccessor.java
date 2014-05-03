package com.aquarin.crawler;

public abstract class AbstractQueueAccessor {
  public abstract AbstractTaskQueueItem dequeue();
  public abstract void enqueue(AbstractTaskQueueItem task);
}
