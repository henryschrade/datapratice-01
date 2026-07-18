import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class Main{
    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<>(); 
        ArrayList<Integer> grades = new ArrayList<>();
        File data = new File("data.txt");


        //filescan, arraylist
        try(Scanner scan = new Scanner(data)){
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                names.add(line.substring(0, line.indexOf(",")));
                grades.add(Integer.parseInt(line.substring(line.indexOf(",")+1, line.length())));
                System.out.println(line); //task 1
            }
        } catch (FileNotFoundException e){
            System.out.println("Error: The file could not be found.");
            e.printStackTrace();
        }
        

        //find max/min grade
        int max = grades.get(0);
        int studentmax = 0;
        for(int i = 0; i < grades.size(); i++){
            if(grades.get(i) > max){
                max = grades.get(i);
                studentmax = i;

            }
        }
        System.out.println("Max Grade: " + max + ", by " + names.get(studentmax)); //task 2
        
        int min = grades.get(0);
        int studentmin = 0;
        for(int i = 0; i < grades.size(); i++){
            if(grades.get(i) < min){
                min = grades.get(i);
                studentmin = i;
            }
        }
        System.out.println("Min Grade: " + min + ", by " + names.get(studentmin)); //task 3 


        //sorting
        
        for(int i = 0; i < grades.size(); i++){
            for(int j = 0; j < grades.size(); j++){
                if(grades.get(i) > grades.get(j)){
                    int temp = grades.get(i);
                    grades.set(i, grades.get(j));
                    grades.set(j, temp);
                    String temp2 = names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, temp2);
                }
            }
        }
        
        //average, median, range
        double sum = 0;
        for(int i = 0; i < grades.size(); i++){ 
            sum += grades.get(i);
        }
        double average = Math.round((sum / grades.size()) * 100.0) / 100.0;
        double median = grades.get(grades.size()/2);
        double range = max - min;
        System.out.println("Average Grade: " + average); //task 4
        System.out.println("Median Grade: " + median); //task 4
        System.out.println("Range of Grades: " + range); //task 4

        //find by name
        Scanner input = new Scanner(System.in);
        System.out.print("name: ");
        String name = input.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).toLowerCase().equals(name)) {
                System.out.println("Grade: " + grades.get(i)); //task 5
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found."); 
        }
            
        //find by score
        System.out.print("score: ");
        int score = input.nextInt();
        found = false;
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) == score) {
                System.out.println("Student: " + names.get(i)); //task 6
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with that score.");
        }


        
        

        
        System.out.println("Sorted Grades:");
        for(int i = 0; i < grades.size(); i++){ 
            System.out.println(names.get(i) + ": " + grades.get(i)); //task 7
        }
        
        
        

        //names by alphabetical order
        ArrayList<String> alphabetical = new ArrayList<>();
        for(int i = 0; i < names.size(); i++){
            alphabetical.add(names.get(i));
        }
        for(int i = 0; i < alphabetical.size(); i++){
            for(int j = 0; j < alphabetical.size(); j++){
                if(alphabetical.get(i).compareTo(alphabetical.get(j)) < 0){
                    String temp = alphabetical.get(i);
                    alphabetical.set(i, alphabetical.get(j));
                    alphabetical.set(j, temp);
                }
            }
        }
        System.out.println("Names in Alphabetical Order:");
        for(int i = 0; i < alphabetical.size(); i++){
            System.out.println(alphabetical.get(i)); //task 8
        }
        
        //binary search name
        System.out.println("Name Search:");
        String name = input.nextLine().toLowerCase();
        int left = 0;
        int right = alphabetical.size() - 1;
        boolean found = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (alphabetical.get(mid).toLowerCase().equals(name)) {
                System.out.println("Student found at location" + mid); //task 9
                found = true;
                break;
            } else if (alphabetical.get(mid).toLowerCase().compareTo(name) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }
}
