package com.annotation.automic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AutomicTest {

    private AtomicInteger i = new AtomicInteger(1);

    public void lock() {
        i.incrementAndGet();

        boolean flag;
        do {
            flag = this.i.compareAndSet(1, 2);
            System.out.println("flag=" + flag);
        } while (!flag);
    }

    public void unLock() {
        this.i.compareAndSet(2, 1);
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();



    private void doLock() {
        lock.lock();
        try {
            //doSomeThing();
            full.signalAll();
            empty.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    private void doSomeThing() {
    }


    private synchronized void doOne(String a) {
        doOnther(a);
    }

    private synchronized void doOnther(String b) {
        System.out.println("b = [" + b + "]");
    }


    private Object syncLock = new Object();

    private void syncLock() {
        synchronized (syncLock) {
            doSomeThing();
        }
        //执行完同步块，自动释放锁
    }

    public static void main(String[] args) {
//        AutomicTest t = new AutomicTest();
//        t.lock();
//        System.out.println("args = [" + t.i + "]");
//
//        t.unLock();
//        System.out.println("args = [" + t.i + "]");

        new AutomicTest().doOne("AAAA");
    }

}
