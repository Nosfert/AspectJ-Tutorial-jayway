package com.jayway.blog;


public class YourClass {

    public static void main(String[] args) {
        YourClass yourClass = new YourClass();
        yourClass.yourMethodAroundDontRun();
        yourClass.yourMethodAroundRunTrue();
        yourClass.yourMethodAroundRun();
    }

    @YourAnnotation(isRun = false)
    public void yourMethodAroundDontRun() {
        System.out.println("Executing TestTarget.yourMethodAroundDontRun()");
    }

    @YourAnnotation(isRun = true)
    public void yourMethodAroundRunTrue() {
        System.out.println("Executing TestTarget.yourMethodAroundRunTrue()");
    }

    @YourAnnotation()
    public void yourMethodAroundRun() {
        System.out.println("Executing TestTarget.yourMethodAroundRun()");
    }
}
