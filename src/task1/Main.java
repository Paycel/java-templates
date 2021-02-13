package task1;

public class Main {

    public static void main(String[] args) {
	    Comparator<Integer> cmp = Integer::compare;
	    Integer result = cmp.compare(1, 2);
        System.out.println(result);
    }
}
