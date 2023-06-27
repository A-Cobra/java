package com.a_cobra;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.a_cobra.models.Car;
import com.a_cobra.utils.CarGarage;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final Random random = new Random();
    private static final int TOP_SPEED = 500;

    private static final String[] CAR_COLORS = { "White", "Black", "Red", "Yellow", "Gray", "Gold", "Pink", "Purple" };

    public static void main(String[] args) {
        logger.info("App starting");
        final int carsToAdd = 5;
        final int carsToMove = 7;

        CarGarage carGarage = new CarGarage();

        for (int i = 0; i < carsToAdd; i++) {
            carGarage.addCar(new Car(i, getRandomCarColor(), getRandomCarSpeed()));
        }

        for (int i = 0; i < carsToMove; i++) {
            carGarage.moveCar(random.nextInt(carsToMove));
        }

        logger.info("App ending");
    }

    private static String getRandomCarColor() {
        final int index = random.nextInt(CAR_COLORS.length);
        return CAR_COLORS[index];
    }

    private static int getRandomCarSpeed() {
        return random.nextInt(TOP_SPEED);
    }
}
