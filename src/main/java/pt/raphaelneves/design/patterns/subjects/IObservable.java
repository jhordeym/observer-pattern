package pt.raphaelneves.design.patterns.subjects;

import pt.raphaelneves.design.patterns.observers.IObserver;

public interface IObservable {
    void add(IObserver observer);
    void remove(IObserver observer);
    void notifyObservers();
}
