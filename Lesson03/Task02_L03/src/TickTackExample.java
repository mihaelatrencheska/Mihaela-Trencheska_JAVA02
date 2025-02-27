class TickTack implements Runnable {
    private String name;
    private int rate;

    public TickTack(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(name + ": Tick");
                Thread.sleep(rate);
                System.out.println(name + ": Tack");
                Thread.sleep(rate);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " has been interrupted.");
        }
    }
}

public class TickTackExample {
    public static void main(String[] args) {

        TickTack clock1 = new TickTack("Seiko", 600);
        TickTack clock2 = new TickTack("Casio", 800);

        Thread thread1 = new Thread(clock1);
        Thread thread2 = new Thread(clock2);


        thread1.start();
        thread2.start();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        thread1.interrupt();
        thread2.interrupt();
    }
}