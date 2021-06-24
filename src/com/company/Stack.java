package com.company;

public class Stack<T> {
    private DoublyLinkedList<T> linkedList = new DoublyLinkedList<T>();
    public Stack(){

    }
    public Stack(T elem){
        linkedList.addLast(elem);
    }
    public int size(){
        return linkedList.size();
    }
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
    public void push(T elem){
        linkedList.addLast(elem);
    }
    public T pop(){
        if(isEmpty())throw new java.util.EmptyStackException();
        return linkedList.removeLast();
    }
    public T top(){
        if(isEmpty())throw new java.util.EmptyStackException();
        return linkedList.peekLast();
    }
    public void printStack(){
        linkedList.printList();
    }
}
