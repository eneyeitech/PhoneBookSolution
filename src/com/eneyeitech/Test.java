package com.eneyeitech;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // put your code here
        // If a is 0, then equation is not
        // quadratic, but linear
        System.out.println(Math.floor(Math.sqrt(14)));

        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double x = 0;
        double y = 0;

        if (a == 0) {
            System.out.println("Invalid");
            return;
        }

        double d = b * b - 4 * a * c;
        double sqrt_val = Math.sqrt(Math.abs(d));

        if (d > 0) {
            x = (-b + sqrt_val) / (2 * a);
            y = (-b - sqrt_val) / (2 * a);
        }
        else if (d == 0) {
            x = -b / (2 * a);
            y = -b / (2 * a);
        }
        else // d < 0
        {

        }

        if(x > y){
            System.out.println(y + " " +x);
        }else{
            System.out.println(x + " " +y);
        }
    }

    public static int jumpSearch(int[] arrayToSearch, int element) {
        int blockSize = (int) Math.floor(Math.sqrt(arrayToSearch.length));

        int currentLastIndex = blockSize-1;

        // Jump to next block as long as target element is > currentLastIndex
        // and the array end has not been reached
        while (currentLastIndex < arrayToSearch.length && element > arrayToSearch[currentLastIndex]) {
            currentLastIndex += blockSize;
        }

        // Find accurate position of target element using Linear Search
        for (int currentSearchIndex = currentLastIndex - blockSize + 1;
             currentSearchIndex <= currentLastIndex && currentSearchIndex < arrayToSearch.length; currentSearchIndex++) {
            if (element == arrayToSearch[currentSearchIndex]) {
                return currentSearchIndex;
            }
        }
        // Target element not found. Return negative integer as element position.
        return -1;
    }
}
