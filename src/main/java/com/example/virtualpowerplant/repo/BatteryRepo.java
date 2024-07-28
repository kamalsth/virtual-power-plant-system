package com.example.virtualpowerplant.repo;

import com.example.virtualpowerplant.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BatteryRepo extends JpaRepository<Battery, Long>{
    List<Battery> findByPostcodeBetween(String startPostcode, String endPostcode);
}
