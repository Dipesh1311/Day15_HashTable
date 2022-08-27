package com.bridgelabz.HashTable_and_BST;

public class MyHashMap<K, V> {

    LinkedList<K> hashLinkedList;

    public MyHashMap() {
        this.hashLinkedList = new LinkedList<>();
    }

    public V get(K key) {
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.hashLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void add(K key, V value) {
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.hashLinkedList.search(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<K, V>(key, value);
            this.hashLinkedList.append(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }

    @Override
    public String toString() {
        return "Hash Map{" + hashLinkedList + "}";
    }

}
