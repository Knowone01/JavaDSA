
public class OOPS {
    public static void main(String[] args) {
       EnggStudent s1 = new EnggStudent();
       System.out.print(s1.age);
}
}
// Calling a contructor from another contructor
class Student{
    String name;
    int age;

    // Default constructor
    Student() {
        this("Default Name", 18); // Calling another constructor
    }

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class pen {
    String colour;
    int tip;

    void setColour(String newColour) {
        this.colour = newColour;
    }

    void setTip(int tip) {
        this.tip = tip;
    }

    String getColour() {
        return this.colour;
    }

    int getTip() {
        return this.tip;
    }

    // Constructors : Created by default if not created by user
}

class student {
    String name;
    int age;
    int marks[];

    student(){
        marks = new int[3];
    }

    student(String name) {
        this.name = name;
        marks = new int[3];
    }

    //Copy constructor (shallow copy, changes in the original array do reflect)
    // student(student s){
    //     marks = new int[3];
    //     this.name = s.name;
    //     this.age = s.age;
    //     this.marks = s.marks;
    // }

    //Copy constructor (deep copy, changes in the original array do NOT reflect)
    student(student s){
        marks = new int[3];
        this.name = s.name;
        this.age = s.age;
        for(int i = 0; i < marks.length; i++){
            this.marks[i] = s.marks[i];
        }
    }
}

    // class Animal {
    //     void eat(){
    //         System.out.println("eats");
    //     }
    //     void breath(){
    //         System.out.println("breathes");
    //     }
    // }

    // class Fish extends Animal{
    //     void swim(){
    //         System.err.println("swims");
    //     }
    // }


// Method Overloading : Same name of the function but different parameters 

class Calculator{
    int sum(int a, int b){
        return a + b;
    }
    double sum(double a, double b){
        return a + b;
    }
}

// Method overriding : Same function name but different definitions 
// The definiton defined in child class is used 


class Calc extends Calculator{
    int sum(int a, int b){
        return a * b;
    }
}

// Abstract classes : 

abstract class Animal{
    Animal(){
        System.out.println("Animal is called ");
    }
    void eat(){
        System.out.println("eats");
    }
    abstract void run(); // here run can have many definitions 
}
class Horse extends Animal{
    void run(){
        System.out.println("runs");
    }
    Horse(){
        System.out.println("Horse is called "); // First the parent constructor is called then the child constructor is called
    }
}

// Interfaces : 
interface herbivores {
   void grass();
}
interface carniovores{
    void meat();
}
class bear implements herbivores, carniovores {
    public void grass(){                        //making the function public is necessary as the function belongs to an interface(absract 100%)
        System.out.println("eat grass");
    }
    public void meat(){
        System.out.println("eat meat");
    }    
    }


// Use of static keyword

class CollegeStudent{
    static int age;
}

//Use of super keyword

class EnggStudent extends CollegeStudent{
    EnggStudent(){
       super.age = 21;
    }
}

