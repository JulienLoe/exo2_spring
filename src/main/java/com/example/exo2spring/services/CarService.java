package com.example.exo2spring.services;

import com.example.exo2spring.models.CarDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Primary
public class CarService {

    private final Map<UUID, CarDTO> cars;

    public CarService() {
        cars = new HashMap<>();

        CarDTO carA = CarDTO.builder()
                .id(UUID.randomUUID())
                .Marque("Citroen")
                .Model("C4")
                .Puissance(110)
                .build();

        CarDTO carB = CarDTO.builder()
                .id(UUID.randomUUID())
                .Marque("Peugeot")
                .Model("3008")
                .Puissance(140)
                .build();

        CarDTO carC = CarDTO.builder()
                .id(UUID.randomUUID())
                .Marque("Renault")
                .Model("Captur")
                .Puissance(120)
                .build();

        cars.put(carA.getId(), carA);
        cars.put(carB.getId(), carB);
        cars.put(carC.getId(), carC);
    }

    public List<CarDTO> getCars() {
        return cars.values().stream().toList();
    }

    public CarDTO getCarById(UUID id) {
        return cars.values().stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
}
