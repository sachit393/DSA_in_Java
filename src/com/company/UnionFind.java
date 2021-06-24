package com.company;

public class UnionFind {
    private int size=0;
    private int [] sz;
    private int [] id;
    private int componentNo;
    public UnionFind(int size){
        this.size=size;
        this.componentNo =size;
        id = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {

            id[i]=i;
            sz[i]=1;
        }
    }
    // find root(main parent) of node p and also do path compression
    public int find(int p){
        int root=p;
        while(root!=id[root])root=id[root];
        while(p!=root){
            int next=id[p];
            id[p]=root;
            p=next;
        }


        return root;
    }

    public boolean connected(int index1,int index2) {
        return find(index1) == find(index2);
    }
    public int componentSize(int p){
        return sz[find(p)];
    }
    public int noOfComponents(){
        return componentNo;
    }

    public void unify (int index1,int index2){
        int root1=find(index1);
        int root2 = find(index2);
        if(root1==root2)return;  //already unified
        else{
            if(sz[root1]<sz[root2]){
                sz[root1]+=sz[root2];
                sz[root2]=sz[root1];
                id[root1]=root2;

            }
            else{
                sz[root1]+=sz[root2];
                sz[root2]=sz[root1];
                id[root2]=root1;
            }
            componentNo--;
        }
    }

}
