package com.company;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Restroom1 obj1 = new Restroom1();
        Restroom2 obj2 = new Restroom2();
        Restroom3 obj3 = new Restroom3();
        Restroom4 obj4 = new Restroom4();
        Timer obj5 = new Timer();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        Thread t3 = new Thread(obj3);
        Thread t4 = new Thread(obj4);
        Thread t5 = new Thread(obj5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        /*
        Semaphore sem = new Semaphore(1, true);
        try {sem.acquire();} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("Number of available permits is currently:" + sem.availablePermits());
        System.out.println(sem.isFair());
        sem.release();
        System.out.println("Number of available permits is currently:" + sem.availablePermits());
        */

        Main.bathrooms.add(Main.open);
        Main.bathrooms.add(Main.open);
        Main.bathrooms.add(Main.open);
        Main.bathrooms.add(Main.open);

    }
    static int j = 20;
    static Semaphore sem = new Semaphore(2, true);
    static String open =
            """
            _______
            |      |\\
            |      | \\
            |      |  \\
            |      |  |
            --------\\ |
                     \\|
                      \\
            """;
    static String closed =
            """
            _______
            |      |
            |closed|
            |      |
            |      |
            --------
            """;
    static ArrayList<String> bathrooms = new ArrayList<>();

}
class Restroom1 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.j; i++) {
            try {Main.sem.acquire();} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("Restroom 1 Is being used");
            Main.bathrooms.set(0, Main.closed);
            try {Thread.sleep(2250); } catch (InterruptedException e) { e.printStackTrace();}
            Main.bathrooms.set(0, Main.open);
            System.out.println("Restroom 1 Is being available");
            Main.sem.release();
            Main.j--;
        }
    }
}
class Restroom2 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.j; i++) {
            try {Main.sem.acquire();} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("Restroom 2 Is being used");
            Main.bathrooms.set(1, Main.closed);
            try {Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace();}
            Main.bathrooms.set(1, Main.open);
            System.out.println("Restroom 2 Is being available");
            Main.sem.release();
            Main.j--;
        }
    }
}
class Restroom3 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.j; i++) {
            try {Main.sem.acquire();} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("Restroom 3 Is being used");
            Main.bathrooms.set(2, Main.closed);
            try {Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace();}
            Main.bathrooms.set(2, Main.open);
            System.out.println("Restroom 3 Is being available");
            Main.sem.release();
            Main.j--;
        }
    }
}
class Restroom4 implements Runnable{
    public void run(){
        for (int i = 0; i < Main.j; i++) {
            try {Main.sem.acquire();} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("Restroom 4 Is being used");
            Main.bathrooms.set(3, Main.closed);
            try {Thread.sleep(3500); } catch (InterruptedException e) { e.printStackTrace();}
            Main.bathrooms.set(3, Main.open);
            System.out.println("Restroom 4 Is being available");
            Main.sem.release();
            Main.j--;
        }
    }
}
class Timer implements Runnable{
    public void run(){
        for (int i = 0; i < 30; i++) {
            System.out.println("Timer:"+i+"-----------------------------------------------------------------------------------------------");
            try {Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
            System.out.print(Main.bathrooms);
        }
    }
}
