package application;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class MaxLedLight {

	public static void main(String[] args) {
        try {
            // Input: Read from file
            Scanner scan = new Scanner(new File("C:\\Users\\user\\input1.txt")); 

            // Read the LED data from the file
            int n = scan.nextInt();
            int[] leds = new int[n];
            int[] ledSources = new int[n];

            for (int i = 0; i < n; i++) {
                leds[i] = scan.nextInt();
                
                for (int j = 0; j < i; j++) {
                    if (leds[i] == leds[j]) {
                        System.out.println("Error: Duplicate LED number found!");
                        System.exit(1);
                    }
                }
            }

          
            
            for (int i = 0; i < n; i++) {
                ledSources[i] = i+1 ; // Adding 1 to convert from 0-based to 1-based index
            }
            

            // Call the method to perform dynamic programming
            int[][] dp = new int[n + 1][n + 1];  // for the numbers
            int [][] b = new int [n + 1][n + 1];  // for paths 

        
            fillDpTable(leds, ledSources, dp, b, n);

            // Output the results
            System.out.println("1. Maximum number of LEDs that can be lit: " + dp[n][n]);
            System.out.println("2. DP Table:");
            printTable(dp, n + 1, n + 1);
            System.out.println("3. LEDs that give the expected result: ");
           
            printSelectedLeds(b, leds, n, n);

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            e.printStackTrace();
        }
    }

  
    public static void fillDpTable (int[] leds, int[] ledSources, int[][] dp, int[][] b, int n) {
    	
    	 for (int i = 0; i <= n; i++) {
             dp[i][0] = 0;
             b[i][0] = ' ';
         }

         for (int j = 0; j <= n; j++) {
             dp[0][j] = 0;
             b[0][j] = ' ';
         }
    	
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (leds[i - 1] == ledSources[j - 1]) {  // 
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    b[i][j] = '\\'; // Diagonal arrow
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    b[i][j] = '|'; // Vertical arrow
                } else {
                    dp[i][j] = dp[i][j - 1];
                    b[i][j] = '-'; // Horizontal arrow
                }
            }
        }
    }
    

    private static void printTable(int[][] table, int rows, int columns) {
        for (int i = 0; i < rows; i++) {  // iterate over rows 
            for (int j = 0; j < columns; j++) {  // over columns
                System.out.print(table[i][j] + " "); // print the value at the current position 
            }
            System.out.println();  // to open a new line 
        }
    }

   
    
    public static void printSelectedLeds (int[][] c, int[] led, int i, int j) {  // print the leds that will light 
  		if (i == 0 || j == 0) 
  			return;

  		if (c[i][j] == '\\') {
  			printSelectedLeds(c, led, i - 1, j - 1);
  			System.out.print(led[i - 1]);
  		} 
  		else if (c[i][j] == '|') {
  			printSelectedLeds(c, led, i - 1, j);
  		}
  		else {
  			printSelectedLeds(c, led, i, j - 1);
  		}
  	}
  
}	
		
       



