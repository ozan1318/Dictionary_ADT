package coen352.ch4.list;

import coen352.ch4.dictionary.ADTDictionary;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DLDict<E> implements ADTDictionary<Key, E>{

    private DLink<E> current;
    private DLink<E> head;
    private DLink<E> tail;
    private int count;

    DLDict(){
        current = head = tail = new DLink<E>(null, null);
        count = 0;
    }

    public DLink<E> getCurrent() {
        return current;
    }

    public DLink<E> getHead() {
        return head;
    }

    public DLink<E> getTail() {
        return tail;
    }

    public int getCount() {
        return count;
    }

    public void setCurrent(DLink<E> current) {
        this.current = current;
    }

    public void setHead(DLink<E> head) {
        this.head = head;
    }

    public void setTail(DLink<E> tail) {
        this.tail = tail;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /** Reinitialize dictionary */
    public void clear(){
        current = head = tail = new DLink<E>(null, null);
        count = 0;
    }

    /** Insert a record
     @param k The key for the record being inserted.
     @param e The record as an object of InventoryRecord being inserted. */
    public void insert(Key k, InventoryRecord e){
        current.setNext(new DLink<E>(e, current, current.getNext(), count));
        current.getNext().getNext().setPrev(current);
    }

    /** Remove and return a record.
     @param k The key of the record to be removed.
     @return A maching record. If multiple records match
     "k", remove an arbitrary one. Return null if no record
     with key "k" exists. */
    public String remove(int k){
        if (head.getKeyNum() == k){
            head = head.getNext();
            head.setPrev(null);
        }
        else if (tail.getKeyNum() == k){
            tail = tail.getPrev();
            tail.setNext(null);
        }
        else if (k > current.getKeyNum()){
            DLink<E> temp = current;
            while (temp.getKeyNum() != k){
                temp = temp.getNext();
            }
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        else if (k < current.getKeyNum())  {
            DLink<E> temp = current;
            while (temp.getKeyNum() != k){
                temp = temp.getPrev();
            }
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        else if (current.getKeyNum() == k){
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        else {
            System.out.println("key not found");
            return null;
        }
        count--;
        return "IN" + k;
    }

    /** Remove and return an arbitrary record from dictionary.
     @return the record removed, or null if none exists. */
    public String removeAny(){
        String key = current.getKey();
        if (current == head) {
            current.getNext().setPrev(null);
            head = current.getNext();
            current = head;
        }
        else if (current == tail) {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            current = tail;
        }
        else{
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        count--;
        return key;
    }

    /** @return A record matching "k" (null if none exists).
    If multiple records match, return an arbitrary one.
     @param k The key of the record to find */
    public E find(int k){
        if (head.getKeyNum() == k){
            return (E) head;
        }
        else if (tail.getKeyNum() == k){
            return (E) tail;
        }
        else if (k > current.getKeyNum()){
            DLink<E> temp = current;
            while (temp.getKeyNum() != k){
                temp = temp.getNext();
            }
            return (E) temp;
        }
        else if (k < current.getKeyNum())  {
            DLink<E> temp = current;
            while (temp.getKeyNum() != k){
                temp = temp.getPrev();
            }
            return (E) temp;
        }
        else if (current.getKeyNum() == k){
            return (E) current;
        }
        else {
            System.out.println("key not found");
            return null;
        }
    }

    /** @return The number of records in the dictionary. */
    public int size(){
        return count;
    }

    public E[] createIndex(String attribute) {

        DLink<E> temp = head;
        InventoryRecord[] index = new InventoryRecord[count];

        for (int i = 0; i < count; i++){
            index[i] = temp.getValue();
            temp = temp.getNext();
        }

        if (attribute == "name"){
            java.util.Arrays.sort(index, Comparator.comparing(InventoryRecord::getName));
        }
        else if (attribute == "desc"){
            java.util.Arrays.sort(index, Comparator.comparing(InventoryRecord::getDesc));
        }
        else if (attribute == "price"){
            java.util.Arrays.sort(index, Comparator.comparing(InventoryRecord::getPrice));
        }
        else if (attribute == "stockQuant"){
            java.util.Arrays.sort(index, Comparator.comparing(InventoryRecord::getStockQuant));
        }
        else if (attribute == "value"){
            java.util.Arrays.sort(index, Comparator.comparing(InventoryRecord::getValue));
        }
        else if (attribute == "reorderLevel"){
            java.util.Arrays.sort(index, Comparator.comparing(InventoryRecord::getReorderLevel));
        }
        else if (attribute == "reorderTime"){
            java.util.Arrays.sort(index, Comparator.comparing(InventoryRecord::getReorderTime));
        }
        else if (attribute == "reorderQuant"){
            java.util.Arrays.sort(index, Comparator.comparing(InventoryRecord::getReorderQuant));
        }

        DLink<E>[] ret = new DLink[count];
        temp = head;
        for (int i = 0; i < count; i++){
            ret[Arrays.binarySearch(index, temp.getValue())] = temp;
            temp = temp.getNext();
        }
        return (E[]) ret;
    }
}
