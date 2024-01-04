class HiBye implements Runnable {
    private String message;
    private int interval;
    private int repetitions;

    public HiBye(String message, int interval, int repetitions) {
        this.message = message;
        this.interval = interval;
        this.repetitions = repetitions;
    }

    public void run() {
        for (int i = 1; i <= repetitions; i++) {
            System.out.println(message + " " + i);

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class EX07 {
    public static void main(String[] args) {
        // 建立兩個 HiBye 物件，分別代表 hi 與 bye 的執行緒
        HiBye hi = new HiBye("Hello", 1000, 5);
        HiBye bye = new HiBye("Good bye", 2500, 5);

        // 使用 Thread 建立執行緒，並啟動
        Thread threadHi = new Thread(hi);
        Thread threadBye = new Thread(bye);

        threadHi.start();
        threadBye.start();
    }
}
