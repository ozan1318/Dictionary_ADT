package coen352.ch4.list;

import java.util.Comparator;

public class BST<E> {
    private BSTNode<E> root;
    private BSTNode<E> parent;
    private BSTNode<E> child;
    private BSTNode<E> current;
    private int size;

    BST(){
        root = parent = child = null;
    }
    public BSTNode<E> getChild() {
        return child;
    }
    public BSTNode<E> getParent() {
        return parent;
    }
    public BSTNode<E> getRoot() {
        return root;
    }
    public BSTNode<E> getCurrent() {
        return current;
    }
    public int getSize() {
        return size;
    }
    public void setChild(BSTNode<E> child) {
        this.child = child;
    }
    public void setParent(BSTNode<E> parent) {
        this.parent = parent;
    }
    public void setRoot(BSTNode<E> root) {
        this.root = root;
    }
    public void setCurrent(BSTNode<E> current) {
        this.current = current;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public void clear(){ root = null; size = 0;}

    public void buildBST(DLink<E> head, int count){
        DLink<E> temp = head.getNext();
        root = current = new BSTNode<>(null, null, head);
        for (int i = 0; i < count; i++){
            insert(temp, count);
            temp = temp.getNext();
        }
    }

    public void insert(DLink<E> in, int count){
        while (!(current.isLeaf())){
            if (current.getValue().getValue().getName().compareTo(in.getValue().getName()) <= 0){
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
        }
        if (current.getValue().getValue().getName().compareTo(in.getValue().getName()) <= 0){
            current.setLeft(new BSTNode<E>(null, null, in));
        }
        else {
            current.setRight(new BSTNode<E>(null, null, in));
        }
        size++;
    }

    public void find(DLink<E> fin){
        current = root;
        while (current.getRight().getValue() != fin && current.getLeft().getValue() != fin){
            if (fin.getValue().getName().compareTo(current.getValue().getValue().getName()) < 0){
                current = current.getLeft();
            }
            else if (fin.getValue().getName().compareTo(current.getValue().getValue().getName()) > 0){
                current = current.getRight();
            }
        }
    }

    public void remove(DLink<E> rem){
        find(rem);
        if (current.getLeft().getValue() == rem){
            if (current.getLeft().isLeaf()){
                current.setLeft(null);
            }
            else if (current.getLeft().getLeft() != null && current.getLeft().getRight() == null){
                current.setLeft(current.getLeft().getLeft());
            }
            else if (current.getLeft().getLeft() == null && current.getLeft().getRight() != null){
                current.setLeft(current.getLeft().getRight());
            }
            else {
                BSTNode<E> temp = current.getLeft();
                current.inorder(temp);
                current.setLeft(temp);
            }
        }
        if (current.getRight().getValue() == rem){
            if (current.getRight().isLeaf()){
                current.setLeft(null);
            }
            else if (current.getRight().getLeft() != null && current.getRight().getRight() == null){
                current.setLeft(current.getRight().getLeft());
            }
            else if (current.getRight().getLeft() == null && current.getRight().getRight() != null){
                current.setLeft(current.getRight().getRight());
            }
            else {
                BSTNode<E> temp = current.getRight();
                current.inorder(temp);
                current.setLeft(temp);
            }
        }
    }
}