package Assignment2;


public class Nodes {
    private int nxt;
    private int sz;
    private StudentListing[] student;

    public Nodes(){
        nxt = 0;
        sz = 10;
        student = new StudentListing[sz];

    }
    public Nodes(int s){
        nxt = 0;
        student = new StudentListing[s];
        sz = s;
    }
    public boolean insert(StudentListing newStudentListing)
    {
        if (nxt >= sz)
            return false;
        student[nxt] = newStudentListing.deepCopy();
        if (student[nxt] == null)
            return false;
        nxt = nxt +1;
        return true;
    }
    public StudentListing fetch(String targetKey){
        StudentListing node;
        StudentListing temp;
        int i = 0;
        while (i < nxt && !(student[i].compareTo(targetKey) == 0)){
            i++;
        }
        if (i == nxt)
            return null;
        node = student[i].deepCopy();
        if (i != 0){
            temp = student[i-1];
            student[i-1] = student[i];
            student[i] = temp;
        }
        return node;

    }
    public boolean delete(String targetKey){
        int i = 0;
        while (i < nxt && !(student[i].compareTo(targetKey) == 0)){
            i++;
        }
        if (i == nxt)
        return false;
        student[i] = student[nxt - 1];
        student[nxt - 1] = null;
        nxt = nxt - 1;
        return true;
    }
    public boolean update(String targetKey, StudentListing newStudentListing){
        {
            if (delete(targetKey) == false)
                return false;
            else if (insert(newStudentListing) == false)
                return false;
            else
                return true;
        }
    }
}
