import java.util.Arrays;
import java.util.Scanner;
public class Hangman {

    public static String[] words = {"vikash", "football", "india", "bat", "bear", "bihar", "cashewnut",
    "cat", "congress", "cobra", "book", "russia", "crow", "deer",
    "dog", "donkey", "duck", "doga", "mobile", "jeans", "frog", "goat",
    "hotel", "puppy", "lion", "lizard", "fridge", "sugarcane", "monkey", "moose",
    "java", "shivam", "school", "college", "shree", "viji", "parrot", "pigeon", 
    "python", "laptop", "cycle", "rat", "teddy","rhino", "ganton", "pencil",
    "table", "sheep", "bicycle", "movie", "snake", "spider", "shoe", "pen",
    "tiger", "modi", "news", "liverpool", "navy", "samosa", "whale", "bag",
    "youtube", "zebra","apple", "banana", "carrot", "dog", "elephant", "flower", "guitar", "hat", "island", "jacket", "kangaroo", "lemon", "mango", "notebook", "orange", "piano", "quilt", "rainbow", "sunset", "table"

};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static int gallI = 0;



    public static void main(String[] args) {

        System.out.println("Lets play HANGMAN!\n");
        System.out.println("You have to guess the word by entering ONE character at a time");
        System.out.println("And for every WRONG guess, a part of the GALLOW is drawn\n");
        System.out.println("your task is to...GUESS the word before the gallow is formed fully");
       int x =  rand(words);
       String str = randomString(x);
       
       char [] arr1 = str.toCharArray();
       
       char [] dummy = new char[arr1.length];

       String missed = "";

       

       for (int i = 0; i < dummy.length; i++) {
            dummy[i] = '_';
       }

       char [] boxes = Arrays.copyOf(dummy, arr1.length);
       
       System.out.println(gallows[0]);

        

        System.out.print("Word : ");
        printBoxes(boxes);

   
    
    Scanner scan = new Scanner(System.in);
    
    while(gallI < 6) {
        System.out.print("Guess : ");
        char guess = scan.next().charAt(0);
        boolean res = checkGuess(guess, arr1);
        if(res == true){
            
            
            System.out.println(gallows[gallI]);
            update(arr1, guess, boxes);
            System.out.print("Word : ");
            printBoxes(boxes);
            System.out.println("Missed : " + missed + "\n");
            boolean win = checkWin(boxes);
            if(win){
                System.out.println("\nCONGRAGUALTONS!! You WON!!!");
                System.exit(0);
            }
            
        }
        else{
            
            gallI++;
            missed += guess;
            System.out.println(gallows[gallI]);
            System.out.print("Word : ");
            printBoxes(boxes);
            System.out.println("Missed : " + missed + "\n");
            
        }
    }

    System.out.println("RIP!");
       
    System.out.println("The word was "+ str);

   
    
    scan.close();
    
    }




    public static void printGallows(){
        for (int i = 0; i < gallows.length; i++) {
            
        }
    }

    


    public static boolean checkGuess(char guess, char [] arr1){
        
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] == guess){
                return true;
            }
            
        }

        return false;

    }

    public static void update(char [] arr1, char guess , char [] boxes){
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] == guess){
                boxes [i] = guess;
            }
        }
    }

    public static boolean checkWin(char[] boxes){
        
        boolean result = false; 
        
        
        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i] != '_'){
                 result = true;
            }
            else{
                 result = false;
                 break;
                
            }

        }

        return result;
        
        
    }
    
   
        
    


    
    

    public static int rand(String [] words){
        double i = Math.random();
        i = i*words.length;

        return (int) i;
        


    }

    public static String randomString(int i){
        return words[i];
        
    }

    public static void printBoxes(char boxes[]){
        for (int i = 0; i < boxes.length; i++) {
        
            System.out.print(boxes[i] + " ");
           
        }
        System.out.println("\n");
    }
    

}








//convert random string to a char array
//print _ for the length of the char array
//take a input prompt from the user
//check if the letter is present in the array
//checkGuess is called to check if guessed char is present in the sec word
//if true...                            


