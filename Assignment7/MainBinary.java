package Assignment7;

import java.util.Arrays;

import Assignment2.StudentListing;
import Assignment6.MergeSort;

public class MainBinary {
    public static void main(String[] args){
        BinaryTree t = new BinaryTree();
        
        StudentListing arthur = new StudentListing("Arthur", "1", "2.5");
        StudentListing lancelot = new StudentListing("Lancelot", "2", "3.5");
        StudentListing robin = new StudentListing("Brave Sir Robin", "42", "1.5");
        StudentListing tim = new StudentListing("Tim", "64", "4.0");

        t.insert(arthur);
        t.insert(lancelot);
        t.insert(robin);
        t.insert(tim);
        System.out.println(t.fetch("Arthur"));
        System.out.println(t.fetch("Lancelot"));
        System.out.println(t.fetch("Brave Sir Robin"));
        System.out.println(t.fetch("Tim"));
        t.delete("Tim");
        System.out.println("Goodbye Tim");
        System.out.println(t.fetch("Tim"));
        t.update("Brave Sir Robin", lancelot);
        System.out.println(t.fetch("Arthur"));
        System.out.println(t.fetch("Lancelot"));
        System.out.println(t.fetch("Brave Sir Robin"));
  
    }
    
}
