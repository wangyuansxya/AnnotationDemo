package com.annotation.queue;

import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * 队列的特点，FIFO 先进的先出
 * @param <T> 队列内元素的类型
 */
public class MyQueue<T> extends AbstractQueue<T> {

    /**
     * 保存队列内的元素，双向链表来实现
     * @param <T>
     */
    private static class Node<T> {
        private Node(T value) {
            this.value = value;
        }
        T value;
        Node<T> next;
    }

    private int elementCount = 0;

    private Node<T> head;
    private Node<T> last;

    /**
     * 队列中添加一个元素
     * @param t
     * @return
     */
    @Override
    public boolean offer(T t) {
        if(t == null)return false;
        if(head == null) {
            head = new Node<>(t);
            last = head;
        } else {
            Node<T> n = last;
            last.next = new Node<>(t);
            last = last.next;
        }
        elementCount++;
        return true;
    }

    /**
     * 取出队列的最早入队的元素
     * @return
     */
    @Override
    public T poll() {
        Node<T> node;
        if(head == null) {
            node = null;
        } else {
            node = head;
            head = head.next;
        }
        if(elementCount > 0) {
            elementCount--;
        }
        return node == null ? null : node.value;
    }

    /**
     * 读取最早入队的元素值
     * @return
     */
    @Override
    public T peek() {
        return head == null ? null : head.value;
    }

    /**
     * 队列的迭代器
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Itor<T>(head);
    }

    /**
     * 队列的长度
     * @return
     */
    @Override
    public int size() {
        return elementCount;
    }

    /**
     * 队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return elementCount <= 0;
    }


    private static class Itor<T> implements Iterator {
        private Node<T> head;
        private Itor(Node<T> head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public T next() {
            Node<T> n = head;
            head = head.next;
            return n.value;
        }
    }


    public static void main(String[] args) {

        MyQueue<Integer> stack = new MyQueue<>();
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        stack.offer(4);

        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            System.out.println("Iterator = [" + it.next() + "]");
        }

        System.out.println("count = [" + stack.size() + "]");


//        System.out.println("peek = [" + stack.peek() + "]");
//        System.out.println("count = [" + stack.size() + "]");
//
        System.out.println("one = [" + stack.poll() + "]");
////        System.out.println("c1 = [" + stack.size() + "]");

        System.out.println("two = [" + stack.poll() + "]");
////        System.out.println("c2 = [" + stack.size() + "]");
//
        System.out.println("three = [" + stack.poll() + "]");
////        System.out.println("c3 = [" + stack.size() + "]");
//
//        System.out.println("empty = [" + stack.isEmpty() + "]");
        System.out.println("four = [" + stack.poll() + "]");
////        System.out.println("c4 = [" + stack.size() + "]");
//
//        System.out.println("five = [" + stack.poll() + "]");
//
//        System.out.println("empty = [" + stack.isEmpty() + "]");

    }

}
