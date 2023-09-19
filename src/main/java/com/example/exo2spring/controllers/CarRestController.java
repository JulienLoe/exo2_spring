package com.example.exo2spring.controllers;

import com.example.exo2spring.models.CarDTO;
import com.example.exo2spring.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/elementName")
public class CarRestController {
    private final CarService carService;

    @GetMapping("listing")
    public List<CarDTO> listcars() {
        return carService.getCars();
    }

    @GetMapping("details/{carId}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable("carId") UUID id) {
        CarDTO found = carService.getCarById(id);

        if (found != null) {
            return ResponseEntity.ok(found);
        } else {
            return new ResponseEntity<CarDTO>(HttpStatus.NOT_FOUND);
        }
    }
}
