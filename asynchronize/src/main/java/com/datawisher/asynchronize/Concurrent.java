package com.datawisher.asynchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurrent {

    public static void main(String[] args) {

        Concurrent concurrent = new Concurrent();

        List<String> lists = concurrent.getLists();

        System.out.println(lists);
    }

    public List<String> getLists() {
        List<String> strs = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            int finalI = i + 1;
            executorService.execute(() -> {
                if (finalI == 3) {
                    return;
                }
                strs.add(String.valueOf(finalI));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + finalI);
            });
        }

        executorService.shutdown();

        // 等待所有子线程结束
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println("共耗时:" + (System.currentTimeMillis() - startTime) / 1000.0 + "s");
                break;
            }
        }

        return strs;
    }
}
