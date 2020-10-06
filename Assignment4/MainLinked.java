package Assignment4;

import Assignment2.StudentListing;

public class MainLinked {
    public static void main(String[] args){
        LinkedList test = new LinkedList();
        StudentListing one = new StudentListing("Arthur", "1", "2.5");
        StudentListing two = new StudentListing("Lancelot", "2", "3.5");
        StudentListing three = new StudentListing("Brave Sir Robin", "42", "1.5");
        StudentListing four = new StudentListing("Tim", "64", "4.0");
        System.out.println("Test insert");
        test.insert(one);
        test.insert(two);
        test.insert(three);
        test.insert(four);
        test.showAll();
        //fetch
        System.out.println("Test fetch");
        three = test.fetch("Brave Sir Robin");
        System.out.println(three.toString());
        // delete
        System.out.println("Test delete");
        test.delete("Tim");
        test.showAll();
        //update
        System.out.println("Test update");
        test.update("Brave Sir Robin", two);
        test.showAll();

    }
    
}
