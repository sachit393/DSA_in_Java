package com.company;

public class BinarySearchTrees <T extends  Comparable <T>> {
    private Node root;
    private int nodeCount=0;
    public BinarySearchTrees(T elem){
        root =new Node(elem,null,null);
    }
        public class Node {
            T data;
            Node left, right;

            public Node(T elem, Node left, Node right) {
                this.data = elem;
                this.left = left;
                this.right = right;

            }
        }

        public int size(){
            return nodeCount;
        }

        public boolean isEmpty(){
            return size()==0;
        }

        public boolean contains(T elem){
            Node t= root;
            while(t!=null && t.data.compareTo(elem)!=0){
                if((t.data).compareTo(elem)<0){
                    t=t.right;
                }
                else if((t.data).compareTo(elem)>0){
                    t=t.left;
                }
                else{
                    return true;
                }
            }
            if(t==null)return false;
            else{
                return true;
            }

        }
        public void add(T elem){
            Node t=root;

            while(t!=null && t.data.compareTo(elem)!=0){
                if((t.data).compareTo(elem)<0){
                    if(t.right==null){
                        t.right=new Node(elem,null,null);
                        return;
                    }
                    t=t.right;
                }
                else if((t.data).compareTo(elem)>0){

                    if(t.left==null){
                        t.left=new Node(elem,null,null);
                        return ;
                    }
                    t=t.left;
                }
                else{
                    return;
                }
            }
            return ;
        }
        public int heightBST(){
        return height(root);
        }

        public int height(Node root){
            if((root==null) )return 0;
            if(root.data==null)return 0;
            else{
                return Math.max(height(root.left),height(root.right))+1;
            }
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

        public void remove(T elem) {
            Node t = root;

            while (t != null && t.data.compareTo(elem) != 0) {
                if ((t.data).compareTo(elem) < 0) {
                    t = t.right;
                } else if ((t.data).compareTo(elem) > 0) {
                    t = t.left;
                } else {
                    break;
                }
            }
            if(height(t.left)>height(t.right)){
                Node q=inorderPredecessor(t);
                t.data=q.data;
                q.data=null;
                q.left=null;
                q.right=null;
            }
            else{
                Node q=inorderSuccessor(t);
                t.data=q.data;
                t.left=null;
                q.data=null;
                q=null;

            }
        }
        public void preorder(){
            preorderTraversal(root);
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
