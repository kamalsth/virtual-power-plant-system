package com.example.virtualpowerplant.utils;

import com.example.virtualpowerplant.model.Battery;
import java.util.List;

public class BatteryValidation {
    public static void validateBattery(List<Battery> batteries) {
        if (batteries.isEmpty()) {
            throw new IllegalArgumentException("Battery list cannot be empty");
        }

        batteries.forEach(battery -> {
            if (battery.getName() == null || battery.getName().isBlank()) {
                throw new IllegalArgumentException("Battery name cannot be empty");
            }
            if (battery.getPostcode() == null || battery.getPostcode().isEmpty()) {
                throw new IllegalArgumentException("Battery postcode cannot be empty");
            }
            if (battery.getWattCapacity() <= 0) {
                throw new IllegalArgumentException("Battery watt capacity must be greater than 0");
            }
        });
    }
}
