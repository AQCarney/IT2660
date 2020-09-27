package Assignment3;

import Assignment2.StudentListing;


public class MainOfQueue {
    public static void main (String[] args){
        Queue q = new Queue(4);
        StudentListing l;
        StudentListing arthur = new StudentListing("Arthur", "1", "2.5");
        StudentListing lancelot = new StudentListing("Lancelot", "2", "3.5");
        StudentListing robin = new StudentListing("Brave Sir Robin", "42", "1.5");
        StudentListing tim = new StudentListing("Tim", "64", "4.0");
        System.out.println("Test the undeflow");
        System.out.println(q.deque());

        System.out.println("Line up");
        System.out.println(q.enque(arthur));
        System.out.println(q.enque(lancelot));
        System.out.println(q.enque(robin));
        System.out.println(q.enque(tim));
        q.showAll();

        System.out.println("Empty the queue");
        l = q.deque();
        System.out.println(l.toString());
        l = q.deque();
        System.out.println(l.toString());
        l = q.deque();
        System.out.println(l.toString());
        l = q.deque();
        System.out.println(l.toString());

        l = q.deque();
        System.out.println(l);
        
        


    }
    
}
