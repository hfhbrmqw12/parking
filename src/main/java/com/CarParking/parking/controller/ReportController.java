package com.CarParking.parking.controller;

import com.CarParking.parking.models.Car;
import com.CarParking.parking.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/report")
    public String mainPage(Model model) {
        Iterable<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "report";
    }

}
