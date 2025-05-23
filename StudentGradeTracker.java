import java.util.Scanner;

class Student {
    String name;
    int[] grades;
    int gradeCount;

    public Student(String name, int numberOfGrades) {
        this.name = name;
        this.grades = new int[numberOfGrades];
        this.gradeCount = 0;
    }

    public void addGrade(int grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount] = grade;
            gradeCount++;
        }
    }

    public double getAverage() {
        if (gradeCount == 0) return 0;
        int sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        return (double) sum / gradeCount;
    }

    public int getHighest() {
        int highest = grades[0];
        for (int i = 1; i < gradeCount; i++) {
            if (grades[i] > highest) highest = grades[i];
        }
        return highest;
    }

    public int getLowest() {
        int lowest = grades[0];
        for (int i = 1; i < gradeCount; i++) {
            if (grades[i] < lowest) lowest = grades[i];
        }
        return lowest;
    }

    public void displaySummary() {
        System.out.println("\nStudent Name: " + name);
        System.out.print("Grades: ");
        for (int i = 0; i < gradeCount; i++) {
            System.out.print(grades[i] + " ");
        }
        System.out.println("\nAverage Score: " + getAverage());
        System.out.println("Highest Score: " + getHighest());
        System.out.println("Lowest Score: " + getLowest());
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();
        sc.nextLine(); 

        Student[] students = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();

            System.out.print("Enter number of grades for " + name + ": ");
            int numGrades = sc.nextInt();

            Student student = new Student(name, numGrades);

            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = sc.nextInt();
                student.addGrade(grade);
            }

            sc.nextLine();
            students[i] = student;
        }

        System.out.println("\n--- Student Summary Report ---");
        for (int i = 0; i < numberOfStudents; i++) {
            students[i].displaySummary();
        }

        sc.close();
    }
}
