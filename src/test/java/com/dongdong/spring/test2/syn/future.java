package com.dongdong.spring.test2.syn;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

public class future {
    //创建一个线程池
    private static final int FIXED_THREAD_POOL_SIZE = 5;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(FIXED_THREAD_POOL_SIZE);

    public static void main(String[] args) {
       /* final CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> {
            return "hello world";
        }, executorService);
        System.out.println(task.join());*/

       /* Supplier<String> taskA = () -> {
            return "hello world";
        };
        Function<String, String> taskB = (s) -> {
            return s + "hello world";
        };

        CompletableFuture<String> task = CompletableFuture.supplyAsync(taskA, executorService);
        final CompletableFuture<String> stringCompletableFuture =  task.thenApplyAsync(taskB);
        final CompletableFuture<String> stringCompletableFuture1 = task.thenApply(taskB);*/

       /* final CompletableFuture<String> taskA = CompletableFuture.supplyAsync(() -> {
            return "hello world A";
        }, executorService);

        final CompletableFuture<String> taskB = CompletableFuture.supplyAsync(() -> {
            return "hello world B";
        }, executorService);*/

       /* final CompletableFuture<String> taskC = taskA.thenCombine(taskB, (a, b) -> {
            return a + b;
        });*/

        // taskA.runAfterEitherAsync(taskB, System.out::println);
        //  System.out.println(taskC.join());

       /* CompletableFuture.anyOf(taskA, taskB).join();
        System.out.println("!!!!!!!!");*/



    }
}
