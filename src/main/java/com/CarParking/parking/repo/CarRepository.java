package com.CarParking.parking.repo;

import com.CarParking.parking.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
