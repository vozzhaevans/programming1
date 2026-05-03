package Lr12;


public class Example5 {

    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Используется потоков: " + cores);

        if (array.length < cores) {
            cores = array.length;
        }

        MaxFinderThread[] threads = new MaxFinderThread[cores];
        int chunkSize = array.length / cores;

        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end = (i == cores - 1) ? array.length : start + chunkSize;
            threads[i] = new MaxFinderThread(array, start, end);
            threads[i].start();
        }

        int globalMax = Integer.MIN_VALUE;
        for (MaxFinderThread thread : threads) {
            try {
                thread.join();
                globalMax = Math.max(globalMax, thread.getPartialMax());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return globalMax;
    }

    static class MaxFinderThread extends Thread {
        private final int[] array;
        private final int start;
        private final int end;
        private int partialMax;

        public MaxFinderThread(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.partialMax = Integer.MIN_VALUE;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                if (array[i] > partialMax) {
                    partialMax = array[i];
                }
            }
            System.out.println(Thread.currentThread().getName() +
                    ": участок [" + start + ":" + end + "], максимум = " + partialMax);
        }

        public int getPartialMax() {
            return partialMax;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }
        array[500000] = 9999999;
        int max = findMax(array);
        System.out.println("Максимальный элемент: " + max);
    }
}