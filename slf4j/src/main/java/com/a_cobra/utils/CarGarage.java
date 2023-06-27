package com.a_cobra.utils;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.a_cobra.models.Car;

public class CarGarage {
    private final int fastCarsTopSpeed = 400;
    private final int normalCarsTopSpeed = 200;

    private ArrayList<Car> carGarage = new ArrayList<>();
    private final Logger logger = LoggerFactory.getLogger(CarGarage.class);

    public CarGarage() {
        logger.info("Car garage instantiated");
    }

    public void addCar(Car car) {
        try {
            if (car.topSpeed() <= normalCarsTopSpeed) {
                logger.warn("The vehicle [{}] of color {} was place in the normal cars zone [{}] km/h!", car.id(),
                        car.color(),
                        car.topSpeed());
            } else if (car.topSpeed() <= fastCarsTopSpeed) {
                logger.warn("The vehicle [{}] of color {} was place in the fast cars zone [{}] km/h!", car.id(),
                        car.color(),
                        car.topSpeed());
            } else {
                throw new Exception("This ain't a car but a plane with " + car.topSpeed() + " km/h of speed!");
            }
            carGarage.add(car);
        } catch (Exception e) {
            logger.error("There was an error adding the car with id {}", car.id());
            logger.error("Error message: {}", e.getMessage());
        }
    }

    public void moveCar(int id) {
        Optional<Car> optionalCar = carGarage.stream().filter(car -> car.id() == id).findFirst();
        if (optionalCar.isPresent()) {
            Car presentCar = optionalCar.get();
            logger.debug("Car with id [{}] is moving at {} km/h", presentCar.id(), presentCar.topSpeed());
        } else {
            logger.error("Car with id [{}] doesn't exist in the garage", id);
        }
    }
}
