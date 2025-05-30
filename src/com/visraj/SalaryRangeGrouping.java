package com.visraj;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalaryRangeGrouping {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(1, "Alice", 28, 50000),
            new Employee(2, "Bob", 32, 52000),
            new Employee(3, "Charlie", 26, 48000),
            new Employee(4, "Diana", 35, 61000),
            new Employee(5, "Edward", 29, 53000),
            new Employee(6, "Fiona", 31, 58000),
            new Employee(7, "George", 45, 72000),
            new Employee(8, "Hannah", 27, 49000),
            new Employee(9, "Ian", 34, 60000),
            new Employee(10, "Jane", 30, 55000)
        );

        // Group employees by salary range and count
        Map<String, Long> salaryRangeCount = employees.stream()
            .collect(Collectors.groupingBy(
                emp -> getSalaryRange(emp.salary()),
                Collectors.counting()
            ));

        // Print result
        salaryRangeCount.forEach((range, count) -> 
            System.out.println("Range: " + range + " => Count: " + count));
    }

    // Helper method to classify salary into a range
    private static String getSalaryRange(double salary) {
        int lower = ((int) salary / 10000) * 10;
        int upper = lower + 10;
        return lower + "k-" + upper + "k";
    }
}
