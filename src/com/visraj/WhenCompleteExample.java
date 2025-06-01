package com.visraj;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WhenCompleteExample {

    public static void main(String[] args) {
        // Create an async task using supplyAsync
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Processing in async thread...");

            // Randomly succeed or fail
            if (Math.random() > 0.5) {
                return "success";
            } else {
                throw new RuntimeException("Something went wrong!");
            }
        });

        // Handle completion or error (non-blocking)
        future.whenComplete((result, error) -> {
            if (error != null) {
                System.out.println("Error: " + error.getMessage());
            } else {
                System.out.println("Result: " + result);
            }
        });

        // Block and wait for the future to complete (optional in real async use)
        try {
            future.get();  // Ensures main thread waits for async task
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}
