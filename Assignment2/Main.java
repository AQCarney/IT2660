package Assignment2;



public class Main {
    public static void main(String[]args)
    {
        Nodes test = new Nodes();
        StudentListing temp;

        StudentListing arthur = new StudentListing("Arthur", "1", "2.5");
        StudentListing lancelot = new StudentListing("Lancelot", "2", "3.5");
        StudentListing robin = new StudentListing("Brave Sir Robin", "42", "1.5");
        StudentListing tim = new StudentListing("Tim", "64", "4.0");
        //insert test
        System.out.println("Test the insert");
        System.out.println(test.insert(arthur));
        System.out.println(test.insert(lancelot));
        System.out.println(test.insert(robin));
        System.out.println(test.insert(tim));

        //fetch test
        System.out.println("Bring me Brave Sir Robin");
        temp = test.fetch("Brave Sir Robin");
        System.out.println(temp.toString());

        //delete test
        System.out.println("Goodbye Tim");
        System.out.println(test.delete("Tim"));
        System.out.println(test.fetch("Tim"));

        //update test
        System.out.println("Arthur I will now call you Tim");
        System.out.println(test.update("Arthur", tim));
        System.out.println(test.fetch("Tim"));
        temp = test.fetch("Tim");
        System.out.println(temp.toString());
        System.exit(0);

    }
    
}
