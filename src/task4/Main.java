package task4;

import java.util.concurrent.*;

public class Main {
    /*
    Реализовать собственную имплементацию ExecutorService с
    единственным параметром конструктора – количеством потоков.
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Runnable runnableTask = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Runnable task completed");
            }
        };
        Callable<String> callableTask = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Callable task completed";
        };
        Future<String> future = service.submit(callableTask);
        service.execute(runnableTask); // sout "Runnable task completed"
        service.shutdown(); // service will be stopped after callable task
        try {
            if (!service.awaitTermination(600, TimeUnit.MILLISECONDS)) // wait for existing tasks to terminate
                service.shutdownNow(); // cancel executing tasks
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result); // "Callable task completed"
    }
}
