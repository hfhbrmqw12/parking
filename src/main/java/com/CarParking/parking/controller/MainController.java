package com.CarParking.parking.controller;

import com.CarParking.parking.models.Car;
import com.CarParking.parking.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/")
    public String mainPage(Model model) {
        Iterable<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "main";
    }

    @GetMapping("/car/add")
    public String carAdd(Model model) {
        return "car-add";
    }

    @PostMapping("/car/add")
    public String carPostAdd(@RequestParam String comment, String carNumber, String carModel, String carColor, Integer parkingNumber, String parkingTimeStart, String parkingTimeEnd, Double parkingSum, Boolean parkingPaid, Model model) {
        Car car = new Car(comment, carNumber, carModel, carColor, parkingNumber, parkingTimeStart, parkingTimeEnd, parkingSum, parkingPaid);
        carRepository.save(car);
        Thread myThread = new Thread(() -> {
            System.out.println("Успешно записано в БД car:" + car.getCarNumber());
        });
        myThread.setPriority(Thread.MAX_PRIORITY);
        myThread.start();
        return "redirect:/";
    }

    @GetMapping("/car/{id}")
    public String carInfo(@PathVariable(value = "id") long id, Model model) {
        if (!carRepository.existsById(id)) {
            return "404";
        }
        Optional<Car> car = carRepository.findById(id);
        ArrayList<Car> result = new ArrayList<>();
        car.ifPresent(result::add);
        model.addAttribute("cars", result);
        return "car-info";
    }

    @GetMapping("/car/{id}/edit")
    public String carEdit(@PathVariable(value = "id") long id, Model model) {
        if (!carRepository.existsById(id)) {
            return "404";
        }
        Optional<Car> car = carRepository.findById(id);
        ArrayList<Car> result = new ArrayList<>();
        car.ifPresent(result::add);
        model.addAttribute("cars", result);
        return "car-edit";
    }

    @PostMapping("/car/{id}/edit")
    public String carPostUpdate(@PathVariable(value = "id") long id, @RequestParam String comment, String carNumber, String carModel, String carColor, Integer parkingNumber, String parkingTimeStart, String parkingTimeEnd, Double parkingSum, Boolean parkingPaid, Model model) {
        Car car = carRepository.findById(id).orElseThrow(IllegalStateException::new);
        car.setComment(comment);
        car.setCarNumber(carNumber);
        car.setCarModel(carModel);
        car.setCarColor(carColor);
        car.setParkingNumber(parkingNumber);
        car.setParkingTimeStart(parkingTimeStart);
        car.setParkingTimeEnd(parkingTimeEnd);
        car.setParkingSum(parkingSum);
        car.setParkingPaid(parkingPaid);
        carRepository.save(car);
        model.addAttribute("cars", car);
        return "car-info";
    }

    @PostMapping("/car/{id}/delete")
    public String carPostDelete(@PathVariable(value = "id") long id, Model model) {
        Car car = carRepository.findById(id).orElseThrow(IllegalStateException::new);
        carRepository.delete(car);
        return "redirect:/";
    }
}
