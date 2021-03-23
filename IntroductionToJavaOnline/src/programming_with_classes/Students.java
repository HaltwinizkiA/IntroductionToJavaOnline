package programming_with_classes;

import java.util.Arrays;
import java.util.Scanner;

public class Students {
    String surname = "";
    int numOfgroup = 0;
    int[] progress = new int[5];

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumOfgroup() {
        return numOfgroup;
    }

    public void setNumOfgroup(int numOfgroup) {
        this.numOfgroup = numOfgroup;
    }

    public int[] getProgress() {
        return progress;
    }

    public void setProgress(int[] progress) {
        this.progress = progress;
    }

    public void bestStudents() {
        double[] grade = {};
        Students[] students = new Students[10];

        for (int i = 0; i < students.length; i++) {
            Scanner scanner = new Scanner(System.in);
            students[i] = new Students();
            System.out.println("Enter name");
            students[i].setSurname(scanner.next());
            System.out.println("Enter group");
            students[i].setNumOfgroup(scanner.nextInt());
            students[i].setProgress(getNote());


        }
        for (int i = 0; i < students.length; i++) {
            Arrays.sort(students[i].progress);
            if (students[i].progress[0] >= 9) {
                System.out.println("Forename : " + students[i].getSurname() + "/  group:  " + students[i].getNumOfgroup());
            }
        }


    }

    public int[] getNote() {
        int[] note = new int[5];
        System.out.println("enter five notes:");
        for (int i = 0; i < note.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("note num: " + (i + 1));
            note[i] = scanner.nextInt();

        }
        return note;
    }
}
