package com.company;

public class BinaryHeap <T extends Comparable<T>> {
    private int heapSize=0;
    private int heapCapacity=0;
    DynamicArray<T> a=new DynamicArray<T>();
    BinaryHeap(T elem){
        a.add(null);
        a.add(elem);
        heapCapacity=a.capacity-1;
        heapSize = a.len-1;
    }
    public void add(T elem){

        a.add(elem);
        heapCapacity=a.capacity-1;
        heapSize = a.len-1;
        int i=heapSize;
        while(i>1 && (a.get(i/2).compareTo(elem)>0)){
            a.replace(a.get(i/2),i);
            i /= 2;
        }
        a.replace(elem,i);
        heapCapacity=a.capacity-1;
        heapSize = a.len-1;
    }
    public void createHeap(T arr[],int n){
        for (int i = 0; i < n; i++) {
            a.add(arr[i]);
        }
        heapCapacity=a.capacity-1;
        heapSize = a.len-1;
    }
    public T root(){
        if(a.isEmpty())throw new RuntimeException("Empty Heap");
        return a.get(1);
    }

    public T remove(){
        if(a.isEmpty())throw new RuntimeException("Empty Heap");
        T data = a.get(1);
        a.replace(a.get(heapSize),1);
        a.removeAt(heapSize);
        heapSize=a.len-1;
        heapCapacity=a.capacity-1;
        int i=1;
        int j=2*i;
        while(j<=heapSize) {
            if (j+1<=heapSize  && a.get(j).compareTo(a.get(j + 1)) > 0 ) {
                j = j + 1;
            }
            if(a.get(i).compareTo(a.get(j))>0){
                a.swap(i,j);
                i=j;
                j=2*j;
            }
            else{
                break;
            }
        }
        return data;
    }
}


