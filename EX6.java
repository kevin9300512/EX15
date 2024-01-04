class Sub implements Runnable {
    private int n;
    private int result = 1;

    public Sub(int a) {
        n = a;
    }

    // 計算1*2*...*n的程式
    private void calculateFactorial() {
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
    }

    // 實作Runnable介面的run()方法
    public void run() {
        calculateFactorial();
        System.out.println("Result for n=" + n + ": " + result);
    }
}

public class EX6 {
    public static void main(String[] args) {
        // 建立兩個Sub物件，分別計算1 * 2 * ... * 5 與 1 * 2 * ... * 10的值
        Sub sub1 = new Sub(5);
        Sub sub2 = new Sub(10);

        // 使用Thread建立執行緒，並啟動
        Thread thread1 = new Thread(sub1);
        Thread thread2 = new Thread(sub2);

        thread1.start();
        thread2.start();
    }
}
