package denis.step.async;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class AsyncDemo {
    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    public void run() {
        generatePandigital();
    }

    private void generatePandigital() {

        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            digits.add(i);
        }

        Collections.shuffle(digits);

        StringBuilder pandigitalNumber = new StringBuilder();

        Future<?>[] tasks = new Future<?>[10];

        for (int i = 0; i < 10; i++) {
            final int digit = digits.get(i);
            tasks[i] = pool.submit(new PandigitalTask(digit, pandigitalNumber));
        }

        for (int i = 0; i < 10; i++) {
            try {
                tasks[i].get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Pandigital number: " + pandigitalNumber.toString());
    }

    class PandigitalTask implements Runnable {
        private final int digit;
        private final StringBuilder buffer;

        public PandigitalTask(int digit, StringBuilder buffer) {
            this.digit = digit;
            this.buffer = buffer;
        }

        @Override
        public void run() {
            synchronized (buffer) {
                buffer.append(digit);
            }
        }
    }


}
