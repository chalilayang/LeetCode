package com.cases;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int index = 0;
                try {
                    while(index < 100) {
                        queue.put(index);
                        System.out.println("put " + index);
                        index ++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int index = 0;
                try {
                    while(index < 100) {
                        int result = queue.take();
                        System.out.println("take " + result);
                        index ++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static class MyBlockingQueue<T> {
        Queue<T> queue;
        int limit;
        ReentrantLock reentrantLock;
        Condition notFullCondition;
        Condition notEmptyCondition;
        public MyBlockingQueue(int limit) {
            this.limit = limit;
            queue = new LinkedList<>();
            reentrantLock = new ReentrantLock();
            notEmptyCondition = reentrantLock.newCondition();
            notFullCondition = reentrantLock.newCondition();
        }
        public void put(T data) throws InterruptedException {
            reentrantLock.lockInterruptibly();
            try {
                while(queue.size() == limit) {
                    notFullCondition.await();
                }
                queue.offer(data);
                notEmptyCondition.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
        public T take() throws InterruptedException {
            T result = null;
            reentrantLock.lockInterruptibly();
            try {
                while(queue.isEmpty()) {
                    notEmptyCondition.await();
                }
                result = queue.poll();
                notFullCondition.signal();
            } finally {
                reentrantLock.unlock();
            }
            return result;
        }
    }
}
