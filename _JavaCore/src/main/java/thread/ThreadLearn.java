package thread;

import domain.DomainInterfaces;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThreadLearn  {
    public static void  run() {
        DomainInterfaces a = ()-> {
            for (int i =0;i< 10;i++) {
                System.out.println(i);
            }
        };

        a.run();
    }

    public static void  runOnThread() throws ExecutionException, InterruptedException {

        Thread t1 = new Thread(ThreadLearn::run);
        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(()->{
            ThreadLearn.run();
            System.out.println("Run //2");
            return null;
        });
        CompletableFuture<Void> cf2 = CompletableFuture.supplyAsync(()->{
            ThreadLearn.run();
            System.out.println("Run //2");
            return null;
        });
        CompletableFuture<Void> allOf = CompletableFuture.allOf(cf,cf2);

        allOf.get();



        CompletableFuture<Void> cf3 = CompletableFuture.runAsync(()-> {
            ThreadLearn.run();
            return;
        });


        System.out.println("Run task 2");
        cf3.get();
        System.out.println("Run task 3");
        t1.start();



    }
 }
