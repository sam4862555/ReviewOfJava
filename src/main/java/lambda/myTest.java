package lambda;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Func {
    boolean choice(Integer a);
}


/**
 * Created by szh on 2017/8/6.
 */
public class myTest {

    public static void filter(List<Integer> arr, Func c) {

        System.out.println("过滤器 ：");

        for (Integer tmp : arr) {
            if (c.choice(tmp)) {
                System.out.println(tmp + " ");
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 4, 3, 6, 2, -1);

        filter(array, (Integer n) -> {
            n += 1;
            return n * n > 4;
        });

        filter(array, (n) -> Math.abs(n) < 2);

        filter(array, n -> n > 3);

    }
}
