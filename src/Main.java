import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");

        TreeSet treeSet = new TreeSet(
                (student1, student2) -> !(student1.getName().compareTo(student2.getName()) > 0));
        TreeSet treeSet2 = new TreeSet(
                (student1, student2) -> student1.getSurname().compareTo(student2.getSurname()) > 0);
        TreeSet treeSet3 = new TreeSet(
                (student1, student2) -> student1.getAvgBal() < student2.getAvgBal());
        treeSet.AddStudent("Dima", "Li", 16);
        treeSet.AddStudent("ka", "Li", 16);
        treeSet.AddStudent("Anton", "Li", 16);
        treeSet.AddStudent("Andrey", "Li", 16);

        treeSet2.AddStudent("Dima", "Li2", 16);
        treeSet2.AddStudent("ka", "Li3", 16);
        treeSet2.AddStudent("Anton", "Li1", 16);
        treeSet2.AddStudent("Andrey", "Li0", 16);

        treeSet3.AddStudent("Dima", "Li", 18);
        treeSet3.AddStudent("ka", "Li", 16);
        treeSet3.AddStudent("Anton", "Li", 17);
        treeSet3.AddStudent("Andrey", "Li", 15);

        System.out.println(treeSet.GetAllStudents());
        System.out.println(treeSet2.GetAllStudents());
        System.out.println(treeSet3.GetAllStudents());

        System.out.println("\n=============Task2=============\n");

        boolean user = true;
        int sticks = 15;
        Scanner scanner = new Scanner(System.in);
        int takeSticks;
        while (sticks != 0){
            System.out.println("Sticks " + sticks +":");
            if (user){
                System.out.print("User take => ");
                takeSticks = scanner.nextInt();
                if (takeSticks <= 3 && takeSticks > 0 && takeSticks <= sticks){
                    sticks -= takeSticks;
                    user = false;
                } else {
                    System.out.println("======Error======");
                }
            }
            else{
                takeSticks = sticks % 4 - 1;
                switch (takeSticks){
                    case 0:
                        takeSticks = 1;
                        break;
                    case -1:
                        takeSticks = 3;
                        break;
                }
                sticks -= takeSticks;
                System.out.println("Computer took " + takeSticks + " sticks");
                user = true;
            }
        }
        if (!user){
            System.out.println("\n\t===>Computer won!<===");
        }
        else{
            System.out.println("\n\t===>User won!<===");
        }

    }
}