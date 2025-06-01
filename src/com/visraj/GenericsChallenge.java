package com.visraj;

public class GenericsChallenge {
	
	/*
	Java allows a generic type to have multiple bounds.

	The first must be a class (like Number), and the rest must be interfaces (like Comparable<T>).

	2. compareTo
	This method works because both Integer and Double implement Comparable<T>.
	
	<T extends Number & Comparable<T>>
	*/

    public static <T extends Number & Comparable<T>> T getMax(T num1, T num2) {
        return num1.compareTo(num2) > 0 ? num1 : num2;
    }

    public static void main(String[] args) {
        Integer int1 = 5;
        Integer int2 = 10;
        Double double1 = 3.5;
        Double double2 = 7.5;

        Integer maxInt = getMax(int1, int2);
        Double maxDouble = getMax(double1, double2);

        System.out.println("Max Integer: " + maxInt);       // Output: 10
        System.out.println("Max Double: " + maxDouble);     // Output: 7.5
    }
}
