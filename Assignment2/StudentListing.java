package Assignment2;

import javax.swing.JOptionPane;

public class StudentListing {
    private String name; //key field
    private String number;
    private String average;

    public StudentListing(String n, String a, String gpa){
        name = n;
        number = a;
        average = gpa;
    }
    public String toString(){
        return("Student name is " + name + " ID number is " + number + " GPA is " + average);
    }
    public StudentListing deepCopy(){
        StudentListing clone = new StudentListing(name, number, average);
        return clone;
    }
    public int compareTo(String targetKey){
        return(name.compareTo(targetKey));
    }
    public void input(){
        name = JOptionPane.showInputDialog("Enter a name");
        number = JOptionPane.showInputDialog("Enter ID number");
        average = JOptionPane.showInputDialog("Enter the GPA");
    }

}