package com.company;

import org.w3c.dom.Node;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        AVLTree<Integer> avl=new AVLTree<Integer>(23);
        avl.insert(12);

        avl.insert(4);
        avl.insert(57);
        avl.insert(60);
        avl.insert(13);
        avl.insert(2);
        avl.insert(3);
        avl.remove(13);

        avl.preorder();

    }


}