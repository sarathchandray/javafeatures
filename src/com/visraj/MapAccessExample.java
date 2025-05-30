package com.visraj;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapAccessExample {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(1, "Alice", 28, 50000),
            new Employee(2, "Bob", 32, 52000),
            new Employee(3, "Charlie", 26, 48000),
            new Employee(1, "Edward", 29, 53000), // duplicate ID
            new Employee(2, "Hannah", 27, 49000)  // duplicate ID
        );

        // Collect into a map keeping the latest Employee per ID
        Map<Integer, Employee> employeeMap = employees.stream()
            .collect(Collectors.toMap(
                Employee::id,
                Function.identity(),
                (oldVal, newVal) -> newVal // keep latest
            ));

        // 1. Access keys (employee IDs)
        System.out.println("Employee IDs:");
        for (Integer id : employeeMap.keySet()) {
            System.out.println(id);
        }

        // 2. Access values (Employee objects)
        System.out.println("\nEmployee Records:");
        for (Employee emp : employeeMap.values()) {
            System.out.println(emp);
        }

        // 3. Access key-value pairs (entries)
        System.out.println("\nEmployee Entries:");
        for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}

// Employee record (Java 16+)
record Employee(int id, String name, int age, double salary) {}
