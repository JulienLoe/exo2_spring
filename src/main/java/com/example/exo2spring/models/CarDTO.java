package com.example.exo2spring.models;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CarDTO {
    private UUID id;
    private String Marque;
    private String Model;
    private Integer Puissance;
}
