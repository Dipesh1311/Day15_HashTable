package com.bridgelabz.HashTable_and_BST;

public class MyLinkedHashMapMain {
    public static void main(String[] args) {

        System.out.println("----- Welcome To Data Structure: Linked HashMap -----");

        String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations”";
        MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");

        for(String word : words) {
            Integer value = myLinkedHashMap.get(word);
            if(value == null)
                value = 1;
            else
                value = value+1;
            myLinkedHashMap.add(word, value);
        }
        System.out.println(myLinkedHashMap);

        for (String word:words) {
            int frequency = myLinkedHashMap.get(word);
            System.out.println("Frequency of "+word+" : "+frequency);
        }
    }
}
