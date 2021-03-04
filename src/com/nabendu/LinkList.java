package com.nabendu;

public class LinkList {
    Node head;
    Node tail;
    int counter;
    public LinkList(){
        head = tail = null;
        counter = 0;
    }
    public void insertFront(int data){
        Node newNode = new Node(data);
        if(head != null)
            newNode.after = head;
        head = newNode;
        counter++;
    }
    public void insertEnd(int data){
        if(head == null){
            head = new Node(data);
            tail = head;
        }else {
            Node newNode = new Node(data);
            tail.after = newNode;
            newNode.before = tail;
            tail = newNode ;
        }
        counter++;
    }
    public void deleteFront(){
        if(head != null){
            head = head.after;
            head.before = null;
            counter--;
            System.out.println("Delete Successful");
        }
        System.out.println("List is Empty. Deletion Failed.");
    }
    public void deleteEnd(){
        if(tail != null){
            tail = tail.before;
            tail.after = null;
            counter--;
            System.out.println("Delete Successful");
        }
        System.out.println("List is Empty. Deletion Failed.");
    }
    public Node search(int target){
        Node temp = head;
        while (temp != null){
            if (temp.data == target)
                return temp;
            temp= temp.after;
        }
        return null;
    }
    public void delete(int target){
        Node temp = search(target);
        if(temp != null){
            Node pre = temp.before;
            Node aft = temp.after;
            temp=temp.before;
            temp.after=aft;
            temp=temp.after;
            temp.before = pre;
            System.out.println("Delete Successful");
            counter--;
        }else
            System.out.println("Not found");
    }
    public void insert(int previousNode, int data){
        Node temp = search(previousNode);
        if(temp != null){
            Node newNode = new Node(data);
            newNode.before = temp;
            temp=temp.after;
            newNode.after = temp;
            temp.before = newNode;
            temp=temp.before;
            temp = temp.before;
            temp.after=newNode;
            System.out.println("Insert Success...");
            counter++;
        }else {
            System.out.println("Insertion Failed");
        }
    }
    public void updateNode(int target, int newValue){
        Node temp = search(target);
        if(temp != null){
            temp.data = newValue;
            System.out.println("Update Successful");
        }else {
            System.out.println("Data Not Found");
        }
    }

}

class Node{
    public int data;
    public Node before;
    public Node after;
    public Node(int data){
        this.data = data;
        this.before = null;
        this.after = null;
    }
    public Node(int data, Node before){
        this(data);
        this.before = before;
    }
    public Node(int data, Node before, Node after){
        this(data, before);
        this.after = after;
    }
}
