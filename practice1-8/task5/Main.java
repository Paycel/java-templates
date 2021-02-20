package task5;

public class Main {
    /*
    Реализовать паттерн Singleton как минимум 3-мя способами.
     */
    public static void main(String[] args) {
        EagerInitializedSingleton singleton1 = EagerInitializedSingleton.getInstance();
        LazyInitializedSingleton singleton2 = LazyInitializedSingleton.getInstance();
        StaticBlockSingleton singleton3 = StaticBlockSingleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton3);
    }
}
