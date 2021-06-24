package com.company;

public class FenwickTree {
    private int sz=0;  //size of Fenwick Tree
    private long [] tree;
    FenwickTree(int size){
        this.sz=size;
        tree=new long[size+1];
    }

    private int lsb(int i){
        return i&(-i);
    }

    public void createTree(long [] values){
        tree[0]=0;
        for (int i = 1; i <=sz ; i++) {
            tree[i]=values[i];
        }
        int temp=0;
        for (int i = 1; i <=sz ; i++) {
            temp=i+lsb(i);
            if(temp<=sz){
                tree[temp]+=tree[i];
            }
        }
    }

    public long prefixSum(int i){
        long sum=0L;
        while(i!=0){
            sum+=tree[i];
            i-=lsb(i);
        }
        return sum;
    }
    //i>=1 && j<=sz(sz of Fenwick Tree)
    public long sum(int i, int j){
        long sum=0l;
        return prefixSum(j)-prefixSum(i-1);
    }

    public void add(int i,long elem){
        while(i<=sz){
            tree[i]+=elem;
            i+=lsb(i);
        }
    }




}
