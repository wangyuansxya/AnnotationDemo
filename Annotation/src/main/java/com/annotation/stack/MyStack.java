package com.annotation.stack;

/**
 * 栈的特点，FILO 先进的后出
 * @param <T> 栈内元素的类型
 */
public class MyStack<T> {

    /**
     * 保存栈内的元素，双向链表来实现
     * @param <T>
     */
    private static class Node<T> {
        private Node(T value) {
            this.value = value;
        }
        T value;
        Node<T> next;
        Node<T> pre;
    }

    private int elementCount = 0;

    private Node<T> head;
    private Node<T> last;

    /**
     * 读取最后一个push元素的值
     * @return
     */
    public T peek() {
        return last == null ? null : last.value;
    }

    /**
     * 出栈最后一个入栈的元素
     * @return
     */
    public T pop() {
        Node<T> node;
        if(last == null) {
            node = null;
        }
        else {
            node = last;
            last = last.pre;
            if(last != null) {
                last.next = null;
            }
        }
        if(elementCount > 0) {
            elementCount--;
        }
        return node == null ? null : node.value;
    }

    /**
     * push一个非空元素
     * @param item
     * @return
     */
    public T push(T item) {
        if(item == null)return null;
        if(head == null) {
            head = new Node<>(item);
            last = head;
        } else {
            Node<T> t = last;
            last.next = new Node<>(item);
            last = last.next;
            last.pre = t;
        }
        elementCount++;
        return item;
    }

    /**
     * 栈的长度
     * @return
     */
    public int size() {
        return elementCount;
    }


    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("peek = [" + stack.peek() + "]");
        System.out.println("count = [" + stack.size() + "]");

        System.out.println("one = [" + stack.pop() + "]");
        System.out.println("c1 = [" + stack.size() + "]");

        System.out.println("two = [" + stack.pop() + "]");
        System.out.println("c2 = [" + stack.size() + "]");

        System.out.println("three = [" + stack.pop() + "]");
        System.out.println("c3 = [" + stack.size() + "]");

        System.out.println("four = [" + stack.pop() + "]");
        System.out.println("c4 = [" + stack.size() + "]");

        System.out.println("five = [" + stack.pop() + "]");
        System.out.println("c5 = [" + stack.size() + "]");

    }

}
