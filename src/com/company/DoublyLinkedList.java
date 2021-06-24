package com.company;

public class DoublyLinkedList<T> {
    private int size=0;
    private static class Node<T>{
        private T data;
        private Node <T> prev;
        private Node <T> next;
        public Node(T data,Node<T> prev,Node <T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        public String toString(){
            return data.toString();
        }
    }
    private Node<T>  head=null,tail=null;
    public void clear(){
        Node <T> trav = head;
        Node <T> Next ;
        while(trav!=null){
            Next = trav.next;
            trav.data = null;
            trav = Next;
        }
        head=null;
        tail=null;
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
    public void addLast(T elem){
        if(isEmpty()){
            Node t = new Node(elem,null,null);
            head=t;
            tail=t;
            size++;
            return;
        }
        else{
            Node t = new Node(elem,tail,null);
            tail.next=t;
            tail=t;
            size++;
        }
    }

    public void addFirst(T elem){
        if(isEmpty()){
            Node t= new Node(elem,null,null);
            size++;
            head=t;
            tail=t;
        }
        else{
            Node t= new Node(elem,null,head);
            head.prev=t;
            head=t;
            size++;
        }
    }
    // position will be the newly occupied position by the new node
    public void addPosition(T elem,int position){
        if(isEmpty()){
            Node t =new Node(elem,null,null);
            head =t;
            tail =t;
            size++;
        }
        else{
            if(position==1){
                addFirst(elem);
                return ;
            }
            Node t=head;
            for (int i = 1; i <position-1 ; i++) {
                t=t.next;
            }
            Node q=new Node(elem,t,t.next);
            t.next.prev=q;
            t.next=q;
            size++;

        }
    }
    public T peekFirst(){
        if(isEmpty())throw new RuntimeException("Empty List");
        return head.data;
    }
    public T peekLast(){
        if(isEmpty())throw new RuntimeException("Empty List");
        return tail.data;
    }
    public T get(int position){
        if(isEmpty())throw new RuntimeException("Empty list");
        Node t=head;

        for (int i = 1; i <=size ; i++) {
            if(i==position) {
                return (T) t.data;
            } else{
                t=t.next;
            }
        }
        return null;
    }
    public T removeFirst(){
        if(isEmpty())throw new RuntimeException("Empty List");
        else{
            T data = head.data;
            head=head.next;
            size--;

            if(isEmpty())tail=null;
            else head.prev=null;
            return data;
        }

    }
    public T removeLast(){
        if(isEmpty())throw new RuntimeException("Empty list");
        T data = tail.data;
        tail= tail.prev;

        size--;
        if(isEmpty())head=null;
        else{
            tail.next=null;
        }
        return data;
    }
    private T remove(Node<T> node){
        if(node.prev==null)return removeFirst();
        else if(node.next==null)return removeLast();
        T data = node.data;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        --size;
        node.data=null;
        node.prev=null;
        node.next=null;
        node=null;
        return data;
    }


    public T removePosition(int position){
        Node t=head;
        if(isEmpty())throw new RuntimeException("Empty list");
        if(position<1 || position>size)throw new IllegalArgumentException();
        if(position<size/2){
            for (int i = 1; i <=size ; i++) {
                if(position==i){
                    return (T) remove(t);
                }
                else{
                    t=t.next;
                }

            }
        }
        else{
            t=tail;
            for (int i = size; i >=1 ; i--) {
                if(position==i){
                    return (T) remove(t);
                }
                else{
                    t=t.prev;
                }

            }
        }
        return null;
    }
    public int positionOf(T elem){
        if(isEmpty())throw new RuntimeException("Empty list");
        Node t= head;
        for (int i = 1; i <=size ; i++) {
            if(t.data==elem)return i;
            else{
                t=t.next;
            }
        }
        return -1;
    }
    public boolean contains(T elem){
        if(positionOf(elem)<1 || positionOf(elem)>size)return false;
        else{
            return true;
        }
    }
    public void printList(){
        Node t=head;
        for (int i = 1; i <=size ; i++) {
            System.out.print(t.data+" ");
            t=t.next;
        }
        System.out.println("\n");
    }
}


