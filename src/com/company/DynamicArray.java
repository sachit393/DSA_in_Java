package com.company;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    public int len = 0;
    public int capacity = 0;
    public DynamicArray(){
        this(16);
    }
    public DynamicArray(int capacity){
        if(capacity <0) throw new IllegalArgumentException("Illegal Capacity: "+capacity);
        else{
            this.capacity=capacity;
            arr = (T[])new Object[capacity];
        }
    }
    public int size(){
        return len;
    }

    public boolean isEmpty(){
        return len==0;
    }
    public T get(int index){
        return arr[index];
    }
    public void clear(){
        for (int i = 0; i < len; i++) {
            arr[i]=null;
        }
        len=0;
    }

    public void add(T elem){
        if(len +1 >=capacity){
            if(capacity==0)capacity+=1;
            else{
                capacity*=2;
            }
            T[] new_arr = (T[])new Object[capacity];
            for (int i = 0; i <len ; i++) {
                new_arr[i]=arr[i];
            }
            arr = new_arr;
            arr[len] =elem;
            len++;
        }
        else{
            arr[len]=elem;
            len++;
        }
    }

    public T removeAt(int rm_index){
        if(rm_index<0 || rm_index>=len)throw new IndexOutOfBoundsException();
        T data = arr[rm_index];
        T [] new_arr = (T[]) new Object[capacity-1];
        int j=0;
        for (int i = 0; i < len; i++) {
            if(i==rm_index)continue;
            else{
                new_arr[j++]=arr[i];
            }
        }
        len--;
        capacity--;
        arr=new_arr;
        return data;
    }

    public int indexOf(T elem){
        for (int i = 0; i < len; i++) {
            if(elem==arr[i]){
                return i;
            }
        }
        return -1;
    }

    //returns index of element which is removed from array
    public int remove(T elem){
        int index= indexOf(elem);
        if(index==-1)return -1;
        removeAt(index);
        return index;
    }

    public boolean contains(T elem){
        return indexOf(elem)!=-1;
    }

    public void printArray(){
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public T replace(T elem1,int index){
        T data = arr[index];
        arr[index]=elem1;
        return data;
    }

    public void swap(int index1,int index2){
        T data=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=data;
        return;
    }




    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
