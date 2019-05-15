package pt.raphaelneves.design.patterns.models;

import java.time.LocalDateTime;
import java.util.UUID;

import pt.raphaelneves.design.patterns.interfaces.IModel;

public class Temperature implements IModel {

    private final String uuid;
    private Double temperature;
    private LocalDateTime updatedAt;

    public Temperature() {
        this.uuid = UUID.randomUUID().toString();
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(final Double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return String.format("{uuid : %s, temperature: %fº, updatedAt: %s}",
                uuid, temperature, updatedAt.toString());
    }
}
