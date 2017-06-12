package jd.callable;

import java.util.*;
import java.util.concurrent.*;

public class CallableExample {
    public static class WordLengthCallable
            implements Callable {
        private String word;

        public WordLengthCallable(String word) {
            this.word = word;
        }

        public Integer call() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + ": длина =>" + word.length());
            Thread.sleep(3000);
            return Integer.valueOf(word.length());
        }
    }

    public static void main(String args[]) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<Integer>> set = new HashSet<Future<Integer>>();
        for (String word : args) {
            Callable<Integer> callable = new WordLengthCallable(word);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }
        int sum = 0;
        for (Future<Integer> future : set) {
            sum += future.get();
        }
        System.out.printf("Сумма длин всех слов %s%n", sum);
        System.exit(sum);
    }
}