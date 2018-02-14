/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morebasicthreads;

public class MoreBasicThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++) 
            new Thread(new LiftOff()).start(); 
        System.out.println("Waiting for LiftOff"); 
    }

    private static class LiftOff implements Runnable {
        protected int countDown = 10; // Default 
          private static int taskCount = 0; 
          private final int id = taskCount++; 
          public LiftOff() {} 
          public LiftOff(int countDown) { 
            this.countDown = countDown; 
          } 
          public String status() { 
            return "#" + id + "(" + 
              (countDown > 0 ? countDown : "Liftoff!") + "), "; 
          } 
          @Override
          public void run() { 
            while(countDown-- > 0) { 
              System.out.println(status()); 
              Thread.yield(); 
            } 
          } 
    }
    
}
