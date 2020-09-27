package Assginment3;

import Assignment2.StudentListing;

public class Queue {
    private int size;
    private int numOfNodes;
    private int front;
    private int rear;
    private StudentListing[] student;

    public Queue(int n ){
        size = n;
        numOfNodes = 0;
        front = 0;
        rear = 0;
        student = new StudentListing[50];
    }
    public boolean enque (StudentListing newStudentListing){
        if (numOfNodes == size)
            return false;
        else {
            numOfNodes = numOfNodes + 1;
            student[rear] = newStudentListing.deepCopy();
            rear = (rear + 1) % size;
            return true;
        }
    }
    public StudentListing deque(){
        int frontLocation;
        if (numOfNodes == 0)
            return null;
        else {
            frontLocation = front;
            front = (front + 1) % size;
            numOfNodes = numOfNodes -1;
            return student[frontLocation];
        }
    }
    public void showAll() {
        int i = front;
        for (int c = 1; c <= numOfNodes; c++){
            System.out.println(student[i].toString());
            i = (i + 1) % size;
        }
    }
        
}
    

