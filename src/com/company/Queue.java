package com.company;

public class Queue <T> {
    private DoublyLinkedList<T> linkedList = new DoublyLinkedList<T>();
    public Queue(){
    }
    public Queue(T elem){
        linkedList.addLast(elem);
    }
    public int size(){
        return linkedList.size();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
    public void enqueue(T elem){
        linkedList.addLast(elem);
    }

    public T dequeue(){
        if(isEmpty())throw new RuntimeException("Queue empty");
        return linkedList.removeFirst();
    }

    public T first(){
        if(isEmpty())throw new RuntimeException("Queue empty");
        return linkedList.peekFirst();

    }

    public T last(){
        if(isEmpty())throw new RuntimeException("Queue empty");
        return linkedList.peekLast();
    }
    public void printQueue(){
        linkedList.printList();
    }
}
