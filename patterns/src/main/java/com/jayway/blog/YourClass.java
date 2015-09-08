package com.jayway.blog;

public class YourClass {

    public static void main(String[] args) {
        YourClass yourClass = new YourClass();
        yourClass.yourMethodBefore();
        yourClass.yourMethodAfter();
        yourClass.yourMethodAround(1);
        yourClass.yourMethodAround(1,"Test");
    }

    public void yourMethodBefore() {
        System.out.println("Executing TestTarget.yourMethodBefore()");
    }

    public void yourMethodAfter(){
        System.out.println("Executing TestTarget.yourMethodAfter()");
    }

    public void yourMethodAround(Integer i){
        System.out.println("Executing TestTarget.yourMethodAround()");
        System.out.println("i : "+i);
    }

    public void yourMethodAround(Integer i,String x){
        System.out.println("Executing TestTarget.yourMethodAround()");
        System.out.println("i : "+i);
        System.out.println("x : "+x);
    }
}
