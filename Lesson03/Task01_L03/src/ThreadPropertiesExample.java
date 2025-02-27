class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadPropertiesExample {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        MyThread[] threads = new MyThread[numberOfThreads];


        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new MyThread("Thread-" + (i + 1));
            threads[i].setPriority(Thread.MIN_PRIORITY + i); // Set initial priority
            threads[i].start();
        }


        for (int i = 0; i < numberOfThreads; i++) {
            MyThread thread = threads[i];
            System.out.println("Thread Name: " + thread.getName());
            System.out.println("Thread Priority: " + thread.getPriority());
            System.out.println("Is Thread Alive: " + thread.isAlive());
            System.out.println("Thread Declaration: Name = " + thread.getName() +
                    ", Priority = " + thread.getPriority() +
                    ", Group = " + thread.getThreadGroup().getName());


            int newPriority = Math.min(Thread.MAX_PRIORITY, thread.getPriority() + 1);
            thread.setPriority(newPriority);
            System.out.println("New Thread Priority: " + thread.getPriority());
            System.out.println();
        }


        for (MyThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

