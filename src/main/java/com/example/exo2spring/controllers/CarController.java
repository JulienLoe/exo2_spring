package com.example.exo2spring.controllers;


import com.example.exo2spring.exceptions.ResourceNotFoundException;
import com.example.exo2spring.models.CarDTO;
import com.example.exo2spring.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @RequestMapping(value = "/elementName/listing")
    public String carList(Model model) {

        List<CarDTO> cars = carService.getCars();

        model.addAttribute("cars", cars);

        return "car/list";
    }

    @RequestMapping(value = "/elementName/{carId}")
    public String carDetail( @PathVariable("carId") UUID id, Model model) {

        CarDTO car = carService.getCarById(id);
        model.addAttribute("car", car);
        if (car != null) {

            return "car/detail";
        } else {
            throw new ResourceNotFoundException();
        }



    }
}
