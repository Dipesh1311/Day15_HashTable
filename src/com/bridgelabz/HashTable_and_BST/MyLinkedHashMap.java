package com.bridgelabz.HashTable_and_BST;

import java.util.ArrayList;

public class MyLinkedHashMap<K,V> {
    private final int numBuckets;
    ArrayList<LinkedList<K>> myBucketArray;

    public MyLinkedHashMap() {
        this.numBuckets = 10;
        this.myBucketArray = new ArrayList<LinkedList<K>>(numBuckets);

        for(int index=0 ; index <numBuckets ; index++) {
            this.myBucketArray.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numBuckets;
        return index;
    }

    public V get(K key) {

        int index = this.getBucketIndex(key);
        LinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null)
            return null;
        MyMapNode<K,V> myMapNode = (MyMapNode<K,V>) myLinkedList.search(key);
        return(myMapNode == null)?null:myMapNode.getValue();
    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        LinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null) {
            myLinkedList = new LinkedList<K>();
            this.myBucketArray.set(index, myLinkedList);
        }

        MyMapNode<K, V>myMapNode = (MyMapNode<K,V>) myLinkedList.search(key);
        if(myMapNode == null) {
            myMapNode = new MyMapNode<K, V>(key, value);
            myLinkedList.append(myMapNode);
        }
        else {
            myMapNode.setValue(value);
        }
    }

    public MyMapNode<K,V> remove(K key) {

        int index = this.getBucketIndex(key);
        LinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null) {
            System.out.println("No Linked List found.");
            return null;
        }
        MyMapNode<K,V> tempNode = (MyMapNode<K,V>) myLinkedList.deleteNodeWithKey(key);
        if(tempNode == null) {
            return null;
        }
        else
            return tempNode;
    }

    @Override
    public String toString() {
        return "MyLinkedHashMap List{" + myBucketArray + '}';
    }
}
