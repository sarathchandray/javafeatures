package com.visraj;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.visraj.dto.Employee;

public class LatestEntry {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(1, "Alice", 28, 50000),
            new Employee(2, "Bob", 32, 52000),
            new Employee(3, "Charlie", 26, 48000),
            new Employee(4, "Diana", 35, 61000),
            new Employee(1, "Edward", 29, 53000),
            new Employee(6, "Fiona", 31, 58000),
            new Employee(7, "George", 45, 72000),
            new Employee(2, "Hannah", 27, 49000),
            new Employee(9, "Ian", 34, 60000),
            new Employee(3, "Jane", 30, 55000)
        );

     // Keep the latest entry (last occurrence) for each employee ID
        /*
         1. Employee::id -> Key Mapper
            This function tells the collector:
            "Use the employee's ID as the key in the map."

         2. Function.identity() -> Value Mapper
            This means:
            "Use the entire Employee object as the value."

         3. (oldVal, newVal) -> newVal -> Merge Function
            This is critical when duplicate keys (same ID) are encountered:

            oldVal = the existing Employee for that ID
            newVal = the new Employee being added

            So this says:
            "If there's a duplicate key, replace the old value with the new one (i.e., keep the latest entry)."
        */

        
        Map<Integer, Employee> employeeMap = employees.stream()
            .collect(Collectors.toMap(
                Employee::id,
                Function.identity(),
                (oldVal, newVal) -> newVal // merge function: keep latest
            ));

        // Print the resulting map
        employeeMap.forEach((id, emp) -> System.out.println(id + " => " + emp));
    }
}
