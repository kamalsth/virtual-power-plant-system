package com.example.virtualpowerplant.service;

import com.example.virtualpowerplant.dto.BatteryResponseDto;
import com.example.virtualpowerplant.model.Battery;
import com.example.virtualpowerplant.repo.BatteryRepo;
import com.example.virtualpowerplant.utils.BatteryValidation;
import com.example.virtualpowerplant.utils.MsgResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatteryServiceImpl implements BatteryService {
    private final BatteryRepo batteryRepo;

    @Override
    public ResponseEntity<?> saveBatteries(List<Battery> batteries) {
        BatteryValidation.validateBattery(batteries);
        batteryRepo.saveAll(batteries);
        return ResponseEntity.ok(new MsgResponse("Batteries saved successfully"));
    }

    @Override
    public ResponseEntity<?> getBatteriesInRange(String startPostcode, String endPostcode) {
        List<Battery> batteries = batteryRepo.findByPostcodeBetween(startPostcode, endPostcode);
        if (batteries.isEmpty()) {
            return new ResponseEntity<>(new MsgResponse("No batteries found in the given range"), HttpStatus.NOT_FOUND);
        }
        List<String> batterNames = batteries.stream().map(Battery::getName).sorted().toList();
        int totalWattCapacity = getTotalWattCapacity(batteries);
        double averageWattCapacity = getAverageWattCapacity(batteries);
        return ResponseEntity.ok(new BatteryResponseDto(batterNames, totalWattCapacity, averageWattCapacity));
    }

    public int getTotalWattCapacity(List<Battery> batteries) {
        return batteries.stream().mapToInt(Battery::getWattCapacity).sum();
    }

    public double getAverageWattCapacity(List<Battery> batteries) {
        return batteries.stream().mapToInt(Battery::getWattCapacity).average().orElse(0);
    }


}
