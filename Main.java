//Shashank Raghuraj
//Task: Re-create the game of hangman using array lists
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
class Main {
  public static void main(String[] args) 
  {
    System.out.println("Welcome to hangman: the point of this game is to guess the word. the theme is animals. Good luck!");
    String[] words = new String[]{"cat", "dog", "elephant", "moose", "kangaroo", "iguana", "aligator", "crocodile", "gorilla", "monkey", "armadillo", "parrot"};
    ArrayList<Character> letters = new ArrayList<>();
    int randomInt = randomNumberGenerator();
    String charecters = words[randomInt];
    //System.out.println(charecters);
    for(int i=0; i< charecters.length(); i++)
    {
      char ch = charecters.charAt(i);
      letters.add(i,ch);
    }
    playHangman(letters, charecters);
  }
  public static int randomNumberGenerator()
  {
    int min = 0;
    int max = 11;
    int randomInt = (int)(Math.random() * (max - min + 1) + min);
    return randomInt;
  }
  public static void playHangman(ArrayList<Character> list, String word)
  {
    ArrayList<Character> correctLetters = new ArrayList<>();
    char[] guessedLetters = new char[list.size()];
    Scanner reader = new Scanner(System.in);
    int bodyPartsLeft = 6;
    System.out.println("");
    for(int i = 0; i < list.size();i++){
      System.out.print("_  ");
    }
    System.out.println("\nThere are " + list.size() + " letters in this word\n");
    for(int i = 0; i < list.size(); i++)
    {
      correctLetters.add(i, ' ');
    }
    while(bodyPartsLeft != 0)
    {
      boolean letterInList = false;
      boolean allCorrectLetters = false;
      System.out.print("\nGuess a letter: ");
      char letter = reader.next().charAt(0); 
      letter = Character.toLowerCase(letter);
      for(int i = 0; i < list.size(); i++)
      {
        if(list.get(i) == letter)
        {
          if(letter == guessedLetters[i])
          {
            System.out.println("You have already guessed this letter before");
            letterInList = true;
          }
          else
          {
            letterInList = true;
            System.out.println("The letter " + letter + " exists in the word and is the " + (i+1) + " spot");
            correctLetters.set(i,letter);
            
            guessedLetters[i] = letter;
          }
        }
      }
      if(list.equals(correctLetters))
      {
        System.out.println("\nYou have correctly guessed the word!\nThe word was " + word);
        System.exit(0);
      }
      if(letterInList == false)
      {
        bodyPartsLeft--;
        System.out.println("This letter does not exist in the word. Tim has lost a limb. There are " + bodyPartsLeft + " body parts left");
      }
      letterInList = false;
    }
    if(bodyPartsLeft == 0){
      System.out.println("You loose, Tim has sadly passed away from having no body parts left\nThe word was " + word);
    }
  }
}
