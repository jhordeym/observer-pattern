package pt.raphaelneves.design.patterns.subjects;

import java.util.ArrayList;
import java.util.List;

import pt.raphaelneves.design.patterns.models.Temperature;
import pt.raphaelneves.design.patterns.observers.IObserver;

public class WeatherStation implements IObservable {

    private List<IObserver> observers;
    private Temperature temperature;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void add(final IObserver observer) {
        observers.add(observer);
    }

    public void remove(final IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(IObserver::update);
    }

    public Temperature getState() {
        return temperature;
    }

    public void setState(final Temperature temperature) {
        this.temperature = temperature;
    }
}
