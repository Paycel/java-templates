package task1;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    /*
    Вариант 5. Имплементировать интерфейс Comparator, сравнивающий две строки
    по сумме всех чисел, представленных в строке.
     */
    public static void main(String[] args) {
        Comparator<String> cmp = (str1, str2) -> {
            Integer sum1 = Arrays.stream(str1.split(" ")).mapToInt(Integer::parseInt).sum();
            Integer sum2 = Arrays.stream(str2.split(" ")).mapToInt(Integer::parseInt).sum();
            return sum1.compareTo(sum2);
        };
        System.out.println(cmp.compare("1 1 1 1 1", "1 2 3 4 5"));
    }
}
