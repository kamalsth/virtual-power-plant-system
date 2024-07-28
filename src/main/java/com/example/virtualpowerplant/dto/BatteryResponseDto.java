package com.example.virtualpowerplant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class BatteryResponseDto {
    private List<String> batteries;
    private int totalWattCapacity;
    private double averageWattCapacity;
}
