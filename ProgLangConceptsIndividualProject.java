import java.lang.*;
import java.util.*;
import java.util.Scanner;
import java.io.*;

 
class Bank { //Will represent superclass/parent class
   //Establishing the data members
   public int balance;
   public int debt;
   public String name;
   
   /*Mutator methods
   *These will later be used when setting the constants of the program to verfiy the code's performance
   */
   public void setName(String updatedName) { 
      name = updatedName;
   }
   
   public void setBalance(int updatedBalance) {
      balance = updatedBalance;
   }
   
   public void setDebt(int updatedDebt) {
      debt = updatedDebt;
   }   
   
   //These are the Accessor methods
   public int getBalance() {
      return balance;
   }
   
   public int getDebt() {
      return debt;
   }
   
   public String getName() {
      return name;
   } 
   
   //These data members are for method overloadding
   static int multiply(int e, int f) {return e*f;} 
   static int multiply(int e, int f, int g) {return e*f*g;}
   
   //Will represent the first method that will be overriden
   void run(){System.out.println("Sorry to inform you but, the bank is closed today.");} 
   
   static void realtor()
    {
        System.out.println("The realtor name is John Smith."); 
    }

    static int base = 3; //Starts the beginning point at
    static void interest(){
    base--; //Will count down by 1
    if (base >= 0){ //Will repaeat for three times
        System.out.println("Maybe this class isn't too bad");
    interest();
}
}
    public void show(){
        System.out.println("I think that will be all for today.");
    }
}
interface ProgLangConcepts {
    public void setMortgage(int mortgage);
    public void setEnddate(String enddate);
}


public class ProgLangConceptsIndividualProject extends Bank { //Acts as subclass
    //Data members
    private float balanceanddebt;
    private int creditscore;
    private float income;
    //Accessor methods
    public float getBalanceanddebt() {
      return balanceanddebt;
    }
    public float getCreditscore() {
      return creditscore;
    }
    public float getIncome() {
      return income;
    }
    //Mutator methods
    public void setBalanceanddebt(int updatedBalanceanddebt) {
        balanceanddebt = updatedBalanceanddebt;
    } 
    public void setCreditscore(int updatedCreditscore) {
        creditscore = updatedCreditscore;
    } 
    public void setIncome(int updatedIncome) {
        income = updatedIncome;
    } 
    
    //Second method that will override the first
    void run(){System.out.println("The bank is open today.");}
   
    public static void main(String args[]) {
        try {
            Scanner keyboard = new Scanner(System.in);
            String inFileName, outFileName, input, output;
            
            System.out.print("What is the input file PATH?: ");
            inFileName = keyboard.nextLine();
            
            System.out.print("What is the outputput file?: ");
            outFileName = keyboard.nextLine();
            
            //Opens the connection for reading and writing
            File file = new File(inFileName);
            Scanner inputConnection = new Scanner(file);
            
            PrintWriter outputConnection = new PrintWriter(outFileName);
            
            //Reads from the original file and writes output into a file
            while(inputConnection.hasNext())
            {
                input = inputConnection.nextLine();
                output = input.toUpperCase();
                outputConnection.println(output);
            }
            //Closes the connection of the input and output
            inputConnection.close();
            outputConnection.close();
        }
        catch (IOException t) {  
        /**
        *IOException is a built-in exception in Java that tries to catch the I/O exception that may arise when program is tasked 
        with loading in a txt file
        */
            t.printStackTrace();
        }
        {        
       
        ProgLangConceptsIndividualProject bankcustomer = new ProgLangConceptsIndividualProject(); //Creates new object from the subclass
        //Calls the mutator methods
        bankcustomer.setName("Jerome");
        bankcustomer.setBalance(1000);
        bankcustomer.setDebt(1400);

        System.out.println("The name of the customer is " + bankcustomer.getName());
        System.out.println("The customer's balance is " + bankcustomer.getBalance());
        System.out.println("The customer's debt is " + bankcustomer.getDebt());
        
        //Method overloading through the adjustment of the number of arguments
        System.out.println("This is the first argument of the method where the two integers, 5 and 10, are multiplied: " +Bank.multiply(5,10)); 
        System.out.println("This is the second argument of the method that causes overloading since we are now multiplying three integers, 5, 10, and 5: " 
        + Bank.multiply(5,10,3));

        bankcustomer.run(); //Overrides the first method that was created in the parent class and instead accepts the method from the subclass

        realtor(); /*This will call the static method
        *Also should count towards Polymorphism since the same method of the superclass is in refrence with the subclass although
        *they perform differnt tasks
        */
        
        Stack<String> stackdata = new Stack<String>(); //Creating an empty stack
        //Need to add elements into the stack
        stackdata.add("Hello, what can I do for you today?");
        stackdata.add("Okay, I believe I can fix that for you.");
        stackdata.add("Please give me a few minutes before the change to be implemented in your account.");
        stackdata.add("Will that be all for today?");
        
        Object[] array = stackdata.toArray(); //Converts the stack into an array
        
        System.out.println("Displaying my stack: " + stackdata);  
        System.out.println("The array data structure that will be selected from the Stack is: ");
        for (int i = 0; i <array.length; i++)
            System.out.println(array[i]); //Code for seperating the lines of stack
        
        interest(); //Recursion
        
        List<Integer> binarylist = new ArrayList<Integer>(); //Creation of ArrayList that will consist of integers
        //Add integeres to the list
        binarylist.add(1); 
        binarylist.add(2);
        binarylist.add(3);
        int result = Collections.binarySearch(binarylist,2); //Use the binary search from the Collections class
        //Print the result
        System.out.println("The result of the binary search is " + result);
        
        Bank agg = new Bank(); //Reference the superclass
        agg.show(); //Use the same method that was mentioned before 
   }
}
}
        