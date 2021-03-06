﻿package algosprobs;

import java.util.HashSet;

public class lists {

    private static final Node NULL = null;
    Node head;
    static class Node {
        public static Node new_node;
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public void print() { //printing list
        Node n = head;
        while (n != null) {

            System.out.println(n.data);
            n = n.next;
        }
    }
    void insertatfront(int new_data) //insert new element at the front
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;

    }
    void insertAfter(Node prev_node, int new_data) { //Insert new element after node
        if (prev_node == NULL) {
            System.out.println("Prev node is null,try again");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }
    void insertatEnd(int new_data) { // Inserting new element at the End
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new Node(new_data);
            return;
        }
        new_node.next = NULL;
        Node last = head;
        while (last.next != NULL) {
            last = last.next;
        }
        last.next = new_node;
        return;
    }
    void deleteNode(int key) { //deleting a node using key
        Node temp = head, prev = null;
        if (temp != null && temp.data != key) { //if head holds key to be deleted
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;

        prev.next = temp.next;
    }

    void deleteNode_pos(int pos) { // delete a node using position
        if (head == NULL)
            return;
        Node temp = head;
        if (pos == 0) {
            head = temp.next;
            return;
        }
        for (int i = 0; temp != NULL && i < pos - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;
        Node next = temp.next.next;
        temp.next = next; //points to itself, deleted

    }
    void deletelist() {

        head = NULL;
    }
    public int getCountRec(Node node) { // length of list using recursion
        if (node == NULL)
            return 0;
        return 1 + getCountRec(node.next);
    }
    public int getCount() {
        return getCountRec(head);
    }
    public boolean searchvalue(Node head, int x) // searching a value
    {
        // Base case 
        if (head == null)
            return false;

        if (head.data == x)
            return true;

        return searchvalue(head.next, x);
    }

    static void removeDuplicate(Node head) { // Removing duplicate elements
        HashSet < Integer > hs = new HashSet < > ();
        Node current = head, prev = NULL;
        while (current != NULL) {
            int curval = current.data;
            if (hs.contains(curval))
                prev.next = current.next;

            else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }

    Node reverseUtil(Node curr, Node prev) { //reversing a list using recursion

        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;

            /* Update next to prev node */
            curr.next = prev;

            return head;
        }

        /* Save curr->next node for recursive call */
        Node next1 = curr.next;

        /* and update next ..*/
        curr.next = prev;

        reverseUtil(next1, curr);
        return head;
    }



    public static void main(String args[]) {
        lists list = new lists();
        list.head = new Node(1);
        Node second = new Node(4);
        Node third = new Node(3);
        list.head.next = second;
        second.next = third;
        list.print();
    }
} //class