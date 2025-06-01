package com.visraj;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
	
	public static void main(String[] args) {
		
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			
			System.out.println("Processing...");
			try {
				
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			if(Math.random() > 0.5) {
				throw new RuntimeException("Random error!");
			}
			
			return "Data ";
			
		})
		.exceptionally(ex -> {
		    System.out.println("Error: " + ex.getMessage());
		    return "Error data";
		});
		
		future.thenApply(data -> data + " processed")
	    .thenApply(result -> result + " by thread " + Thread.currentThread().getName())
	    .thenAccept(System.out::println);
		
		future.join();
		
		System.out.println(Thread.currentThread().getName() + " Running...");
		
	}

}
