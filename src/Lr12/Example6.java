package Lr12;

public class Example6 {

    public static long parallelSum(int[] array) throws InterruptedException {
        if (array == null || array.length == 0) {
            return 0;
        }

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Используется потоков: " + cores);

        int numThreads = Math.min(cores, array.length);

        SumThread[] threads = new SumThread[numThreads];
        int chunkSize = array.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? array.length : start + chunkSize;
            threads[i] = new SumThread(array, start, end);
            threads[i].start();
        }

        long totalSum = 0;
        for (SumThread thread : threads) {
            thread.join();
            totalSum += thread.getPartialSum();
        }

        return totalSum;
    }

    static class SumThread extends Thread {
        private final int[] array;
        private final int start;
        private final int end;
        private long partialSum;

        public SumThread(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.partialSum = 0;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                partialSum += array[i];
            }
            System.out.printf("%s: участок [%d-%d], сумма = %d%n",
                    Thread.currentThread().getName(), start, end, partialSum);
        }

        public long getPartialSum() {
            return partialSum;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[1_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        long sum = parallelSum(array);
        System.out.println("Сумма: " + sum);
    }
}