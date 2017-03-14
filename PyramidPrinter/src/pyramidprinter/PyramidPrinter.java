/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramidprinter;

import java.util.stream.IntStream;

/**
 *
 * @author armaa
 */
public class PyramidPrinter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 5;
        char symbol = '*';
        
        IntStream.rangeClosed(1, n)
                .forEach(i -> 
                IntStream.rangeClosed(1, n * 2)
                    .forEach(j -> System.out.print(j == n * 2 ? System.lineSeparator() : j <= n - i || j >= n + i ? " " : symbol)));
    }
    
}
