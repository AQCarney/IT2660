package Assginment3;

import Assignment2.StudentListing;

public class Stack {
    private int top;
    private int size;
    private StudentListing[] student;

    public Stack(){
        top = -1;
        size = 50;
        student = new StudentListing[50];
    }
    public Stack (int n){
        top = -1;
        size = n;
        student = new StudentListing[n];
    }
    public boolean push(StudentListing newStudentListing) {
        if (top == size - 1)
            return false;
        else {
            top = top + 1;
            student[top] = newStudentListing.deepCopy();
            return true;
        }
    }
    public StudentListing pop(){
        int topLocation;
        if(top == -1)
            return null;
        else{
            topLocation = top;
            top = top -1;
            return student[topLocation];
        }
    }
    public void showAll(){
        for (int i = top; i >=0; i--)
            System.out.println(student[i].toString());
    }
}
