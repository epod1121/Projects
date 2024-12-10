import java.util.Scanner;

class Student {
    String name;
    int age;
    double grade;

    // Constructor (if you're familiar with it)
    // Your code here
}

public class StudentDetails
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many students would you like to enter? ");
        int num = scanner.nextInt();

        Student[] students = new Student[num];

        for(int i = 0; i < num; i++)
        {
            students[i] = new Student();

            System.out.print("Enter name for student " + (i + 1) + ": ");
            students[i].name = scanner.next();

            System.out.print("Enter age for student " + (i + 1) + ": ");
            students[i].age = scanner.nextInt();

            System.out.print("Enter grade for student " + (i + 1) + ": ");
            students[i].grade = scanner.nextDouble();
        }

        for (int i = 0; i < num; i++) {
            System.out.println("Student " + (i + 1) + " details:");
            System.out.println("Name: " + students[i].name);
            System.out.println("Age: " + students[i].age);
            System.out.println("Grade: " + students[i].grade);
            System.out.println();
        }

        scanner.close();
    }
}
