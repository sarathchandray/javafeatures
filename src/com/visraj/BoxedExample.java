package com.visraj;

import java.util.*;
import java.util.stream.*;

public class BoxedExample {
	
    public static void main(String[] args) {
    	
        int[] scores = {45, 67, 89, 32, 50, 76, 28};

        // Convert to Stream<Integer> using boxed(), then collect into a List
        List<Integer> scoreList = Arrays.stream(scores)
                                        .boxed()
                                        .collect(Collectors.toList());

        System.out.println("All Scores: " + scoreList);

        // Filter passing scores and collect
        List<Integer> passingScores = Arrays.stream(scores)
                                            .filter(score -> score >= 50)
                                            .boxed()
                                            .collect(Collectors.toList());

        System.out.println("Passing Scores: " + passingScores);

        // Calculate average of passing scores
        double average = passingScores.stream()
                                      .mapToInt(Integer::intValue)
                                      .average()
                                      .orElse(0.0);

        System.out.println("Average Passing Score: " + average);
        
    }
}
