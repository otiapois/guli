package com.fouo.test;

import java.util.concurrent.*;

/**
 * 异步测试
 */
public class ThreadTest {


    //juc中创建线程池的方式 (当前系统中线程池只有一两个，每个异步任务，都提交给线程池去执行即可)
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    /**
     * 创建和初始化多线程的几种方式
     * <p>
     * 1.继承Thread
     * <p>
     * Thread01 t1 = new Thread01();
     * //启动线程
     * t1.start();
     * <p>
     * 2.实现Runnable接口
     * <p>
     * <p>
     * Runable01 runable01 = new Runable01();
     * new Thread(runable01).start();
     * <p>
     * 3.实现Callable接口+FutureTask（可以拿到返回结果，可以处理异常，允许异步任务具有返回值）
     * <p>
     * Callable01 callable01 = new Callable01();
     * FutureTask<Integer> futureTask = new FutureTask<>(callable01);
     * new Thread(futureTask).start();
     * Integer integer = futureTask.get();
     * System.out.println("等待线程完成后，获取结果"+integer);
     * <p>
     * 4.线程池 （以上三种启动线程的方式均不使用） 将所有的多线程异步任务都交给线程池执行
     * 给线程池提交任务
     * executorService.execute(new Runable01());
     * <p>
     * 区别：1和2 不能得到返回值
     * 3 可以获取返回值
     * 123都不能达到资源控制的目的
     * 4可以控制资源，性能稳定
     * <p>
     * Future：可以获取到异步结果
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("当前线程" + Thread.currentThread().getId());
//        }, executorService);


//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程" + Thread.currentThread().getId());
//            return 1;
//        }, executorService).whenCompleteAsync((result,exception)->{
//            System.out.println("异步任务成功完成 结果："+result+"异常是："+exception);
//        });、

//        方法完成后的感知
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程" + Thread.currentThread().getId());
//            return 1;
//        }, executorService).whenCompleteAsync((result,exception)->{
//            System.out.println("异步任务成功完成 结果："+result+"异常是："+exception);
//        }).exceptionally(t ->{
//            //可以感知异常，同时返回默认值
//            return 10;
//        });


//       方法完成后的处理
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程" + Thread.currentThread().getId());
//            return 1;
//        }, executorService).handle((res,thr)->{
//            // 返回结果不为空
//            if(res!=null){
//                return res+1;
//            }
//            // 异常结果不为空
//            if(thr!=null){
//                return 0;
//            }
//
//            return 0;
//        });

        /**
         *  线程串行化
         *  1.thenRun：不能获取到上一步的执行结果
         *  .thenRunAsync(()->{
         *             System.out.println("当前线程" + Thread.currentThread().getId());
         *         });
         *
         *  2.thenAcceptAsync：接收上一步的结果，但是无返回值
         *
         *  .thenAcceptAsync(res->{
         *             System.out.println("当前线程" + Thread.currentThread().getId()+"接收上一线程返回的参数:"+res);
         *         })
         *
         *  3.thenSupplyAsync： 接收上一步的结果，有返回值
         *
         */
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程" + Thread.currentThread().getId());
            return 1;
        }, executorService).thenApplyAsync(res -> {
            System.out.println(Thread.currentThread().getId()+"任务2启动:" + res);

            return "Hello World" + res;
        }, executorService);
    }

    public static void thread(String[] args) throws Exception {
        Runable01 runable01 = new Runable01();
        new Thread(runable01).start();
        executorService.execute(new Runable01());
    }

    public static class Thread01 extends Thread {
        @Override
        public void run() {
            System.out.println("当前线程" + Thread.currentThread().getId());
        }
    }

    public static class Runable01 implements Runnable {

        @Override
        public void run() {
            System.out.println("当前线程" + Thread.currentThread().getId());
        }
    }

    public static class Callable01 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("当前线程" + Thread.currentThread().getId());
            return 5;
        }
    }
}

