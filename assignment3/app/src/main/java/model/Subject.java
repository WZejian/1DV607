package model;

/**
 * Subject interface for player implements.
 */
public interface Subject {
  
  public void attach(Observer observer);

  public void notifyObserver();
}
