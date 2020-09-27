package Assignment3;

import Assignment2.StudentListing;

public class MainOfStack {
    public static void main(String[] args){
        Stack s = new Stack(4);

        StudentListing k;
        StudentListing arthur = new StudentListing("Arthur", "1", "2.5");
        StudentListing lancelot = new StudentListing("Lancelot", "2", "3.5");
        StudentListing robin = new StudentListing("Brave Sir Robin", "42", "1.5");
        StudentListing tim = new StudentListing("Tim", "64", "4.0");
        System.out.println("Assemble");
        System.out.println(s.push(arthur));
        System.out.println(s.push(lancelot));
        System.out.println(s.push(robin));
        System.out.println(s.push(tim));
        s.showAll();
        k = s.pop();

        System.out.println("Empty it back out");
        System.out.println(k.toString());
        k = s.pop();
        System.out.println(k.toString());
        k = s.pop();
        System.out.println(k.toString());
        k = s.pop();
        System.out.println(k.toString());
        k = s.pop();
        System.out.println(k);
        




    }
    
}
