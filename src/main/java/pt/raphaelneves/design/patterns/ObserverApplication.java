package pt.raphaelneves.design.patterns;

import java.time.LocalDateTime;
import java.util.Random;

import pt.raphaelneves.design.patterns.models.Temperature;
import pt.raphaelneves.design.patterns.observers.EmailDisplay;
import pt.raphaelneves.design.patterns.observers.IObserver;
import pt.raphaelneves.design.patterns.observers.PhoneDisplay;
import pt.raphaelneves.design.patterns.observers.SensorDisplay;
import pt.raphaelneves.design.patterns.subjects.IObservable;
import pt.raphaelneves.design.patterns.subjects.WeatherStation;

public class ObserverApplication {
    public static void main(String[] args) {
        IObservable station = new WeatherStation();
        IObserver phone = new PhoneDisplay(station);
        IObserver email = new EmailDisplay(station);
        IObserver sensor = new SensorDisplay(station);

        station.add(phone);
        station.add(email);
        station.add(sensor);

        Random random = new Random();

        for(;;) {
            Temperature temp = new Temperature();
            temp.setTemperature(50 * random.nextDouble());
            temp.setUpdatedAt(LocalDateTime.now());
            ((WeatherStation) station).setState(temp);
            station.notifyObservers();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
