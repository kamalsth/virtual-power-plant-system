package com.example.virtualpowerplant.service;

import com.example.virtualpowerplant.model.Battery;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface BatteryService {
    ResponseEntity<?> saveBatteries(List<Battery> batteries);

    ResponseEntity<?> getBatteriesInRange(String startPostcode, String endPostcode);
}
