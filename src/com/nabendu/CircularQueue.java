package com.nabendu;

public class CircularQueue {
    private int frontPointer, backPointer;
    private int counter;
    private final int size;
    int [] queue;
    public CircularQueue(int size){
        frontPointer = 0;
        backPointer = 0;
        counter=0;
        queue = new int[size];
        this.size = size;
    }
    public void printFrontBack(){
        System.out.println("Back pointer: "+backPointer+"\t front Pointer: "+frontPointer);
    }
    private boolean isEmpty(){
        if(counter==0)
            return true;
        return false;
    }
    public boolean push(int data){
        if(counter<size){
            queue[frontPointer]=data;
            counter++;
            frontPointer=(frontPointer==size-1)? 0 : ++frontPointer;
            return true;
        }
        System.out.println("Queue full");
        return false;
    }
    public int pop(){
        if(counter>0){
            int data=queue[backPointer];
            queue[backPointer]=0;
            counter--;
            backPointer=(backPointer==size-1)? 0 : ++backPointer;
            return data;
        }
        System.out.println("Popping Failed");
        return Integer.MAX_VALUE;
    }
    private int peek(){
        if(!isEmpty()){
            return queue[backPointer];
        }
        System.out.println("Queue Empty");
        return Integer.MAX_VALUE;
    }
}

class QueueCheck{
    public static void main(String[] args) {
        CircularQueue circleQueue = new CircularQueue(4);
        circleQueue.push(4);
        circleQueue.push(6);
        circleQueue.printFrontBack();
        circleQueue.pop();
        circleQueue.pop();
        circleQueue.printFrontBack();
        circleQueue.push(6);
        circleQueue.push(3);
        circleQueue.printFrontBack();
        circleQueue.push(5);
        circleQueue.pop();
        circleQueue.pop();
        circleQueue.printFrontBack();
        circleQueue.pop();
        circleQueue.pop();
        circleQueue.printFrontBack();
        circleQueue.pop();
        circleQueue.push(5);
        circleQueue.pop();
        circleQueue.pop();
        circleQueue.printFrontBack();
    }
}
