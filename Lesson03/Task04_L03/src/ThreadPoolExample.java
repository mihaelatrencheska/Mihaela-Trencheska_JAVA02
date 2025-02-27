import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private final int message;

    public Task(int message) {
        this.message = message;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " (Start) message = " + message);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(threadName + " (End)");
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Task(i));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        System.out.println("Finished all threads");
    }
}