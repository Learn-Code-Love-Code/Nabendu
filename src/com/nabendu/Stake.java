package com.nabendu;
public class Stake<p> {
    final p [] stake;
    public int presentSize=0;
    private final int limit;
    public Stake(int size){
        stake = (p[]) new Object[size];
        limit = size;
    }
    public boolean push(p data){
        if(presentSize<limit){
            stake[presentSize]=data;
            System.out.println(data+" pushed");
            presentSize++;
            return true;
        }else {
            System.out.println("Pushing failed");
            return false;
        }
    }
    public boolean pop(){
        if(presentSize>0){
            stake[--presentSize]=null;
            return true;
        }else {
            System.out.println("Popping failed");
            return false;
        }
    }
    public p peek(){
        if(presentSize>0)
            return stake[presentSize];
        else
            return null;
    }
    public void printAll(){
        System.out.println();
        for(p ex: stake){
            System.out.print(ex+"  ");
        }
    }
}
