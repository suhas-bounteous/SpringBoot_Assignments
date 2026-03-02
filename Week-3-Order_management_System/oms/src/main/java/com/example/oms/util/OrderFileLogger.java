package com.example.oms.util;

import com.example.oms.model.Order;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class OrderFileLogger {

    private static final String FILE_NAME = "orders.log";

    public synchronized void log(Order order) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(order.toString());
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
