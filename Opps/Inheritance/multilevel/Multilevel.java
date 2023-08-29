package Opps.Inheritance.multilevel;

public class Multilevel {
    public static void main(String[] args) {
        BabyDog obj= new BabyDog();
        obj.eat();
        obj.bark();
        obj.weep();
    }
}




////////////////////////////////////////////////////////

interface AnimalEat {
   void eat();
}
interface AnimalTravel {
   void travel();
   void eat();
}
class Animal implements AnimalEat, AnimalTravel {
   public void eat() {
      System.out.println("Animal is eating");
   }
   
   public void travel() {
      System.out.println("Animal is travelling");
   }
}
public class Main
{
	public static void main(String[] args) {
	  Animal a = new Animal();
    	  a.eat();
    	  a.travel();    
	}
}

//////////////////////////////////

// First parent abstract class
abstract class ParentA {
    abstract void methodA();
}

// Second parent abstract class
abstract class ParentB {
    abstract void methodB();
}

// Concrete child class inheriting from both ParentA and ParentB
class Child extends ParentA, ParentB { // This is not valid in Java!
    @Override
    void methodA() {
        System.out.println("Child's implementation of methodA");
    }

    @Override
    void methodB() {
        System.out.println("Child's implementation of methodB");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.methodA(); // Output: Child's implementation of methodA
        child.methodB(); // Output: Child's implementation of methodB
    }
}








////////////////

// First interface
interface ParentA {
    void methodA();
}

// Second interface
interface ParentB {
    void methodB();
}

// Concrete class implementing both ParentA and ParentB interfaces
class Child implements ParentA, ParentB {
    @Override
    public void methodA() {
        System.out.println("Child's implementation of methodA");
    }

    @Override
    public void methodB() {
        System.out.println("Child's implementation of methodB");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.methodA(); // Output: Child's implementation of methodA
        child.methodB(); // Output: Child's implementation of methodB
    }
