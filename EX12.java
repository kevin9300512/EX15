import java.util.Random;

class PrePaid extends Thread {
    private int sum;

    public PrePaid() {
        this.sum = 200;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            int fee = new Random().nextInt(100); // 產生0~99的隨機通話費
            if (sum > 10) {
                talk(fee);
            }
        }
    }

    public synchronized void talk(int fee) {
        try {
            Thread.sleep(1000); // 故意拖延時間模擬同步問題
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum -= fee;
        System.out.println("打了" + fee + "元，餘額" + sum + "元");
    }
}

public class EX12 {
    public static void main(String[] args) {
        PrePaid phone1 = new PrePaid();
        PrePaid phone2 = new PrePaid();
        PrePaid phone3 = new PrePaid();

        phone1.start();
        phone2.start();
        phone3.start();
    }
}
