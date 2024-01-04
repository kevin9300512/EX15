class Test extends Thread {
    private String id;

    public Test(String id) {
        this.id = id;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 100000000; j++) ;
            System.out.println(id + " " + i);
        }
    }
}

public class ex3 {
    public static void main(String[] args) {
        Test morning = new Test("goodmorning");
        Test night = new Test("Good night");

        // 啟動3個執行緒
        morning.start();

        // 加入一個新物件，再啟動一個執行緒
        Test afternoon = new Test("Good afternoon");
        afternoon.start();

        // 啟動第四個執行緒
        night.start();
    }
}
