package com.example.virtualpowerplant.repo;

import com.example.virtualpowerplant.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BatteryRepo extends JpaRepository<Battery, Long>{
    List<Battery> findByPostcodeBetween(String startPostcode, String endPostcode);

    @Query("SELECT b.name FROM Battery b WHERE b.name IN :names")
    List<String> findExistingNames(@Param("names") List<String> names);


}
