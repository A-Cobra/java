package com.a_cobra.utils;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.a_cobra.models.Car;

public class CarGarage {
    private ArrayList<Car> carGarage = new ArrayList<>();
    private final Logger logger = LoggerFactory.getLogger(CarGarage.class);

    public CarGarage() {
        logger.debug("Car garage instantiated");
        System.out.println("STARTING");
    }
}
