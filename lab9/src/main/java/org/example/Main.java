package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ImageProcessor imageProcessor = new ImageProcessor();

        try {
            imageProcessor.readImage("img.jpg");
            imageProcessor.setBrightness(10);
            imageProcessor.setBrightness(-10);
            {
                long startTime = System.currentTimeMillis();
                imageProcessor.setBrightness(10);
                long endTime = System.currentTimeMillis();
                System.out.println(endTime-startTime);
            }
            {
                long startTime = System.currentTimeMillis();
                imageProcessor.setBrightness2(10);
                long endTime = System.currentTimeMillis();
                System.out.println(endTime-startTime);
            }
            {
                long startTime = System.currentTimeMillis();
                imageProcessor.setBrightnessThreadPool(100);
                long endTime = System.currentTimeMillis();
                System.out.println(endTime-startTime);
            }
            imageProcessor.writeImage("objasioneimg.jpeg");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}