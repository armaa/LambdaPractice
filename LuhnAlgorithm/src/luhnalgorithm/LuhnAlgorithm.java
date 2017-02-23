package luhnalgorithm;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author armaa
 */
public class LuhnAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "5594";
        List<Integer> list = Stream.of(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        
        List<Integer> multiplied;
        List<Integer> numbersOverTen;
        
        multiplied = IntStream.range(0, list.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> list.get(i) * 2)
                .collect(Collectors.toList());
        
        numbersOverTen = IntStream.range(0, multiplied.size())
                .mapToObj(i -> (multiplied.get(i) % 10 + multiplied.get(i) / 10))
                .collect(Collectors.toList());
        
        int suma = IntStream.range(0, list.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(list::get)
                .mapToInt(i -> i)
                .sum() + numbersOverTen.stream().mapToInt(i -> i).sum();
        
        System.out.println(suma % 10 == 0 ? "Right sum" : "Wrong sum");
    }
    
}
