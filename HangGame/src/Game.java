import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {

    private int nrLoop = 0;
    private int nrTrials = 0;

    private Boolean alreadypicked = false;

    public void starts(String pickedMovie) {

        String clearTitle = pickedMovie;
        String hideLetter = new String(new char[pickedMovie.length()]).replace('\0', '_');        //replace word with "_"
        String usedLetter = "";


        System.out.println("Welcome to HangMan!!(Guess the movie edition)");
        System.out.println("Only first letter and letters are accepted ");


        Scanner scanner = new Scanner(System.in);                                                                // read user input
        for (int i = 20; i > 0; i--) {                                                                          // loop to count nr trials


            System.out.println("You have " + i + " guess(es) left. Choose again:");
            System.out.println("Letters used until now " + usedLetter);
            System.out.println("Guess counter: " + nrTrials + " total guesses");
            System.out.println("Current word " + hideLetter);

            String picks = scanner.nextLine();
            try {
            char currentPick = picks.charAt(0);                                                             // initialize with index 0

                for (int x = 1; x <= nrLoop; x++) {                                                        // loop for letter check
                    if (currentPick == usedLetter.charAt(x - 1)) {                                        // substracts used letters
                        System.out.println("Letter already used " + currentPick);                        // print letters used
                        i++;                                                                            //show remaining trials
                        nrLoop++;
                        alreadypicked = true;                                                            // boolean became true so the letter was used before
                        break;                                                                       // used because boolean statement became true
                    } else {
                        alreadypicked = false;
                    }                                                                               // else  letter unused go to next if
                }

                    if (!alreadypicked) {                                                            //Check the logic to see where it is and reveal the letter in the word
                    for (int y = 0; y <= pickedMovie.length() - 1; y++) {
                        char current = pickedMovie.charAt(y);

                        currentPick = Character.toUpperCase(currentPick);                          //conversion to upper case
                        if (current == currentPick) {

                            //System.out.println("Picked letter is correct ");
                            char[] charHide = hideLetter.toCharArray();
                            charHide[y] = current;
                            hideLetter = String.valueOf(charHide);

                        }

                        currentPick = Character.toLowerCase(currentPick);                        // lower case conversion
                        if (current == currentPick) {
                            //System.out.println("Picked letter is correct ");
                            char[] charHide = hideLetter.toCharArray();
                            charHide[y] = current;
                            hideLetter = String.valueOf(charHide);

                        }
                    }
                    usedLetter = usedLetter + currentPick + ", ";
                    nrTrials++;
                    nrLoop++;


                }
                //else {
                // nrTrials = nrTrials++;
                // nrLoop = nrLoop++;
                //}


                if (clearTitle.equals(hideLetter)) {
                    System.out.println("Congratulation you won !!! " + pickedMovie + " was the movie title");
                    break;

                } else {
                    System.out.println("The title was " + pickedMovie);
                    System.out.println("Game Over !!! Better luck next time ");
                }

            }catch(Exception e){System.out.println("Fatal error!! Restart");}
        }
    }
}





