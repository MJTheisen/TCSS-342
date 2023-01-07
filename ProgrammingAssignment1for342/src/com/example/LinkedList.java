package com.example;

//Linked List
public class LinkedList {

    //Make Node Class with character data and next node.
    static class Node {
        char data;
        Node next;
    }

    //For New character nodes.
//    static Node charNode(char data) {
//        Node temp = new Node();
//        temp.data = data;
//        temp.next = null;
//        return temp;
//    }

    Node head;
    //For add()
    public void add(char data) {
        Node myNode = new Node();
        myNode.data = data;
        myNode.next = null;

        if (head == null) {
            head = myNode;
        } else {
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = myNode;
        }
//        while (myNode.next != null)
//            myNode = myNode.next;
//            myNode.next = charNode;
//        return;
    }

// This wont work because add requires LL to be static and that breaks everything
//    static Node stringIntoLL(String characters, Node head) {
//        head = LinkedList.add(characters.charAt(0));
//        Node current = head;
//
//        for (int i = 1; i < characters.length(); i++)
//        {
//            current.next = LinkedList.add(characters.charAt(i));
//            current = current.next;
//        }
//        return head;
//    }

// returns the number of elements in the SLL
    public int size() {
        Node temp = head;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

// return a String representation of the SLL in the format “elem1 -> elem2 -> elem3 -> elem4 -> ...”
    public String toString() {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        return "null";
    }
}

