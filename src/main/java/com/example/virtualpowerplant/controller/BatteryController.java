package com.example.virtualpowerplant.controller;

import com.example.virtualpowerplant.model.Battery;
import com.example.virtualpowerplant.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BatteryController {
    private final BatteryService batteryService;

    @PostMapping("/batteries")
    public ResponseEntity<?> saveBatteries(@RequestBody List<Battery> batteries) {
        return batteryService.saveBatteries(batteries);
    }


    @GetMapping("/batteries")
    public ResponseEntity<?> getBatteriesInRange(@RequestParam(name = "startPostcode", defaultValue = "0") String startPostcode,
                                                 @RequestParam(name = "endPostcode", defaultValue = "0") String endPostcode) {
        return batteryService.getBatteriesInRange(startPostcode, endPostcode);
    }


}
