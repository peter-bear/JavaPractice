/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Ting.Cao
 */
public class ArrayBagTest {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] agrs){
//        final int word_per_bag = 4;
//        ArrayBag<String> names = new ArrayBag<>(word_per_bag);
//        ArrayBag<String> mood = new ArrayBag<>(word_per_bag); 
//        ArrayBag<String> activities = new ArrayBag<>(word_per_bag);
//               
//        System.out.println("Help me write a story.");
//        getWords(names,word_per_bag,"first names");
//        getWords(mood,word_per_bag,"adjective that describe a good or bad mood, such as 'happy',");
//  
//        getWords(activities,word_per_bag,"single word activities such as 'reading',");
//        for(int line = 0; line < 3; line ++){
//            System.out.println(names.grab() + " is " + activities.grab() + " and s/he feels " + mood.grab() + ".");
//        }
//    	
       ArrayBag<String> bag = new ArrayBag<>();
       bag.add("Jim");
       bag.add("Steaven");
       bag.add("Bob");
       bag.add("Jerry");
       System.out.println("Pop Element Randomnly: "+bag.grab());
       System.out.println("Bag Size: "+bag.size());
       System.out.print("Before deleting��");
       bag.print();
       System.out.println();
       bag.remove("Jerry");
       System.out.print("After deleting: ");
       bag.print();
       
       
    }
    
    public static void getWords(ArrayBag<String> b, int n, String prompt){
        String userInput;
        int i;
        
        System.out.print("Please type " + n +" " + prompt);
        System.out.println(", separated by space. Press the <return> key after the final entry:");
        
        for(i = 0; i < n; i++){
            userInput = input.next();
            b.add(userInput);
        }
        System.out.println();
    }
}
