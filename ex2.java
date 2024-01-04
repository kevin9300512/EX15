class Test extends Thread {
    private String id;

    public Test(String id) {
        this.id = id;
    }

    public void run() {
        for (int i = 1; i <= 5; i++){
            for (int j = 0; j < 100000000; j++) ;
        System.out.println(id + " " + i);
    }
}

public class ex2 {
    public static void main(String[] args) {
        Test hi = new Test("Hello");
        Test bye = new Test("Good bye");

        hi.run();
        bye.run();
    }
}
//Thread Class Inheritance: Test 類別繼承自 Thread 類別，表示它是一個執行緒。

//建構子 (Constructor): Test 類別有一個建構子，用來設定 id 成員的值。

//run() 函數: 在 Test 類別中，有一個 run() 函數，內含一個巢狀的迴圈，用來模擬一些計算工作。在每次完成迴圈後，會印出 id 和迴圈的計數器 i。

//main() 函數: 在 main() 中，建立了兩個 Test 物件，分別使用 "Hello" 和 "Good bye" 作為 id 值。接著，分別呼叫了它們的 run() 方法。

//執行結果: 由於 run() 方法是直接呼叫的，而非透過 start()，所以它在主執行緒中運行而非在新的執行緒中。因此，會先執行完 hi.run()，再執行 bye.run()。在 hi.run() 中， i 的值在 for 迴圈之外，因此在印出時朇保持為 6。所以結果會是 "Hello 6" 和 "Good bye 6"。

//如果想要真正實現多執行緒的並行運行，應該使用 start() 方法而非 run() 方法，因為 start() 會在新的執行緒中執行 run() 方法。