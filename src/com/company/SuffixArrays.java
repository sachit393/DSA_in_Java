package com.company;

public class SuffixArrays {
    private int size=0;
    private String [] new_arr;
    private String [] arr;
    private int rank[];
    SuffixArrays(String s){
        this.size=s.length();
        arr= new String[s.length()];
        new_arr= new String[s.length()];
        rank = new int[s.length()+1];
        rank[0]=-1;
        for (int i = 0; i < s.length(); i++) {
            arr[i]=s.substring(i,s.length());
            new_arr[i]=arr[i];
            rank[i+1]=i;
        }
        int maxindex=0;
        String max;
        for (int i = 0; i < s.length(); i++) {
            maxindex=0;
            for (int j = 0; j <s.length() ; j++) {
                if(new_arr[j].compareTo(new_arr[maxindex])>0){
                    maxindex=j;
                }
            }
            rank[size-i]=maxindex;
            new_arr[maxindex]="";

        }

    }

    public int size(){
        return size;
    }
    public void printSuffixArray(){
        for (int i = 1; i <=size ; i++) {
            System.out.println(arr[rank[i]]);
        }
    }
    public String get(int rank){
        return arr[this.rank[rank]];
    }
    public int lengthOfPrefix(String s1,String s2){
        int minlength=s2.length();
        if(s1.length()<s2.length()){
            minlength=s1.length();
        }
        for (int i = 0; i < minlength; i++) {
            if(s1.charAt(i)==s2.charAt(i)){
                continue;
            }
            else return i;
        }
        return minlength;


    }

    public int [] LCP(){
        int lcp[] =new int[size+1];
        for (int i = 1; i <= size-1; i++) {
                lcp[i] = lengthOfPrefix(arr[rank[i]], arr[rank[i+1]]);
        }
        return lcp;
    }
    public int uniqueSubstrings(int []LCP){
        int sum=0;
        for (int i = 1; i <LCP.length ; i++) {
            sum+=LCP[i];
        }
        return (this.size*(this.size+1)/2)-sum;
    }

    public DynamicArray<String> longestRepeatedSubstring(int []LCP){
        DynamicArray<String> v=new DynamicArray<String>(this.size+1);
        int max_length=0;
        for (int i = 1; i < LCP().length ; i++) {
            if(LCP[i]>max_length){
                max_length=LCP[i];
            }

        }

        for (int i = 1; i < LCP.length; i++) {
            if(LCP[i]==max_length){
                v.add(arr[rank[i]].substring(0,max_length));
            }
        }
        return v;
    }

}
