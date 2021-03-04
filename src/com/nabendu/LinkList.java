package com.nabendu;

/**
 * @Author: Nabendu Bikash Binda
 */
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
        if(head == null)
            tail = newNode;
        else
            newNode.after = head;
        head = newNode;
        counter++;
    }
    public void insertEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = head;
        }else {
            tail.after = newNode;
            newNode.before = tail;
            tail = newNode ;
        }
        counter++;
    }
    public void deleteFront(){
        if(head != null){
            if(head == tail){
                head = tail = null;
            }else{
                head = head.after;
                head.before = null;
            }
            counter--;
            System.out.println("Delete Successful");
        }else
            System.out.println("List is Empty. Deletion Failed.");
    }
    public void deleteEnd(){
        if(tail != null){
            if(head == tail){
                head = tail = null;
            }else {
                tail = tail.before;
                tail.after = null;
            }
            counter--;
            System.out.println("Delete Successful");
        }else
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
        if(temp != null) {
            if (temp.data == head.data) {
                deleteFront();
            } else if (temp.data == tail.data) {
                deleteEnd();
            } else {
                Node pre = temp.before;
                Node aft = temp.after;
                temp = temp.before;
                temp.after = aft;
                temp = temp.after;
                temp.before = pre;
                System.out.println("Delete Successful");
                counter--;
            }
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
    public void print(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.after;
        }
        System.out.println();
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
class LinkListChecker{
    public static void main(String[] args) {
        //-----Below of all this code for just test purpuse for linked list---------------------
        LinkList linkList = new LinkList();
        linkList.insertFront(34);
        linkList.insertEnd(23);
        linkList.insert(34,55);
        linkList.insert(35,55);
        linkList.insertFront(45);
        linkList.insertEnd(232);
        linkList.print();
        linkList.deleteEnd();
        linkList.print();
        linkList.delete(55);
        linkList.print();
        linkList.deleteFront();
        linkList.print();
        linkList.deleteFront();
        linkList.delete(23);

        linkList.deleteFront();
        linkList.delete(23);
        linkList.deleteEnd();
        linkList.print();

    }
}
