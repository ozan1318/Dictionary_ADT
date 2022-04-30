package coen352.ch4.list;

public class BSTNode<E> {
    private BSTNode<E> left;
    private BSTNode<E> right;
    private DLink<E> value;

    BSTNode(){ left = right = null; value = null;}

    BSTNode(BSTNode<E> l, BSTNode<E> r, DLink<E> val){
        this.left = l;
        this.right = r;
        this.value = val;
    }

    public BSTNode<E> getLeft() {
        return left;
    }

    public BSTNode<E> getRight() {
        return right;
    }

    public DLink<E> getValue() {
        return value;
    }

    public void setLeft(BSTNode<E> left) {
        this.left = left;
    }

    public void setRight(BSTNode<E> right) {
        this.right = right;
    }

    public void setValue(DLink<E> value) {
        this.value = value;
    }

    public boolean isLeaf(){
        return ((left == null) && (right == null));
    }

    public void inorder(BSTNode<E> curr){
        if (curr.getLeft() != null){
            inorder(curr.getLeft());
        }
        else if (curr.getRight() != null){
            inorder(curr.getRight());
        }
    }
}
