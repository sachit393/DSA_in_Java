package com.company;

public class AVLTree<T extends Comparable<T>>{
    Node root;
    class Node{
        T data;
        Node left;
        Node right;
        Node(T elem,Node left,Node right){
            this.data=elem;
            this.left=left;
            this.right=right;
        }
    }

    AVLTree(T elem){
        this.root=new Node (elem,null,null);
    }
    public int nodeHeight(Node root){
        if(root==null)return -1;
        if(root.data==null)return -1;
        else{
            return (nodeHeight(root.left)<nodeHeight(root.right))?nodeHeight(root.right)+1:nodeHeight(root.left)+1;
        }
    }

    public int balanceFactor(Node root){
        return nodeHeight(root.left)-nodeHeight(root.right);
    }

    public Node insert(T elem){
        return Rinsert(elem,root);
    }

    public Node LLrotation(Node root){
        if(this.root==root){
            this.root=root.left;
        }
        Node p=root;
        Node q=root.left;
        Node r=root.left.left;
        p.left=q.right;
        q.right=p;

        return q;
    }
    public Node RRrotation(Node root){
        if(this.root==root){
            this.root=root.right;
        }
        Node p=root;
        Node q=root.right;
        Node r=root.right.right;
        p.right=q.left;
        q.left=p;

        return q;
    }

    public Node LRrotation(Node root){
        Node p=root;
        Node q=root.left;
        Node r=root.left.right;
        if(this.root==root){
            this.root=r;
        }
        q.right=r.left;
        p.left=r.right;
        r.left=q;
        r.right=p;

        return r;
    }
    public Node RLrotation(Node root){
        Node p=root;
        Node q=root.right;
        Node r=root.right.left;
        if(this.root==root){
            this.root=r;
        }
        q.left=r.right;
        p.right=r.left;
        r.right=q;
        r.left=p;

        return r;
    }


    private Node Rinsert(T elem,Node root){
        if(root==null){
            return (new Node(elem,null,null));
        }
        if(elem==root.data){
            return null;
        }
        else if(elem.compareTo(root.data)<0){
            root.left=Rinsert(elem, root.left);
        }
        else{
            root.right=Rinsert(elem, root.right);
        }
        if(balanceFactor(root)==2 && balanceFactor(root.left)==1){
            return LLrotation(root);
        }
        else if(balanceFactor(root)==2 && balanceFactor(root.left)==-1){
            return LRrotation(root);
        }
        else if(balanceFactor(root)==-2 && balanceFactor(root.right)==-1){
            return RRrotation(root);
        }
        else if(balanceFactor(root)==-2 && balanceFactor(root.right)==1){

            return RLrotation(root);
        }
        return root;
    }

    public Node inorderPredecessor(Node t){
        t=t.left;
        while(t.right!=null)t=t.right;
        return t;
    }
    public Node inorderSuccessor(Node t){
        t=t.right;
        while(t.left!=null)t=t.left;
        return t;
    }

    public void remove(T elem){
        Rremove(elem,this.root);
    }
    private Node Rremove(T elem,Node root) {
        Node t = root;


            if ((t.data).compareTo(elem) < 0) {
                root.right=Rremove(elem,t.right);
            } else if ((t.data).compareTo(elem) > 0) {
                root.left= Rremove(elem,t.left);
            }

            else {
                if(t.left==null && t.right==null){
                    t.data = null;
                    t.left = null;
                    t.right = null;
                    t=null;

                }
                else if (nodeHeight(t.left) > nodeHeight(t.right)) {
                    Node q = inorderPredecessor(t);
                    t.data = q.data;
                    q.data = null;
                    q.left = null;
                    q.right = null;
                    q=null;
                } else {
                    Node q = inorderSuccessor(t);
                    t.data = q.data;
                    q.data = null;
                    q.left = null;
                    q.right = null;
                    q=null;

                }
            }
        if(balanceFactor(root)==2 && balanceFactor(root.left)==1){
            return LLrotation(root);
        }
        else if(balanceFactor(root)==2 && balanceFactor(root.left)==-1){
            return LRrotation(root);
        }
        else if(balanceFactor(root)==-2 && balanceFactor(root.right)==-1){
            return RRrotation(root);
        }
        else if(balanceFactor(root)==-2 && balanceFactor(root.right)==1){

            return RLrotation(root);
        }
        else if(balanceFactor(root)==2 && balanceFactor(root.left)==0){
            return LLrotation(root);
        }
        else if(balanceFactor(root)==-2 && balanceFactor(root.right)==0){
            return RRrotation(root);
        }
        return root;


    }
    public void preorder(){
        preorderTraversal(this.root);
    }

    private void preorderTraversal(Node root){
        if(root==null)return;
        if(root.data==null)return;
        System.out.println(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public void inorder(){
        inorderTraversal(root);
    }

    private void inorderTraversal(Node root){
        if(root==null)return;
        if(root.data==null)return;

        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }
    public void postorder(){
        postorderTraversal(root);
    }

    private void postorderTraversal(Node root){
        if(root==null)return;
        if(root.data==null)return;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.data);
    }

}
