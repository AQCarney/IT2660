package Assignment4;

import Assignment2.StudentListing;

public class LinkedList
 {  private Node h;
    public LinkedList()
    {
        h = new Node();
        h.l = null;
        h.next = null;
    }
    public boolean insert(StudentListing newStudentListing)
    {
        Node n = new Node();
        n.next = h.next;
        h.next = n;
        n.l = newStudentListing.deepCopy();
        return true;
    }
    public StudentListing fetch (String targetKey){
        Node p = h.next;
        while (p != null && !(p.l.compareTo(targetKey) == 0)){
            p = p.next;
        }
        if (p != null)
            return p.l.deepCopy();
        else 
            return null;
    }
    public boolean delete(String targetKey)
    {
        Node q = h;
        Node p = h.next;
        while (p != null && !(p.l.compareTo(targetKey) == 0)){
            q = p;
            p = p.next;
        }
        if (p != null){
            q.next = p.next;
            return true;
        }else  
            return false;
    }
    public boolean update(String targetKey, StudentListing newStudentListing){
        if (delete(targetKey) == false)
            return false;
        else if (insert(newStudentListing) == false)
            return false;
        return true;
    }
    public void showAll(){
        Node p = h.next;
        while (p != null){
            System.out.println(p.l.toString());
            p = p.next;
        }
    }
    public class Node {
        private StudentListing l;
        private Node next;

        public Node(){

        }
    }
}

