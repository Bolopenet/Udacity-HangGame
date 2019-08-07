import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        int nrMovies = 0;
        int randomMovie;

        String pickedMovie = "";                                               // string to get a random movie
        String moviesDisp = "";                                               //display movies

        File file = new File("movies.txt");                        // read the file first time to count nr of lines
        Scanner scanner = new Scanner(file);
                                                                           //  System.out.println(); test
        while (scanner.hasNextLine() == true) {
            String line = scanner.nextLine();
                                                                         //System.out.println("Title: " + line);
                                                                        //System.out.println(line.split(" "));
                                                                       // to count nr of words in that line we want to split it
                                                                      // we want to split it on te spaces " "
                                                                     // each line of out give the array object created from line split
                                                                    //System.out.println(line.split("").length); //now will show how many words are in each line
            moviesDisp +=line+"\n";
            nrMovies++;
        }
        System.out.println("Number of movies: " + nrMovies);

        randomMovie = (int) (Math.random() * nrMovies);               // like in Number guess game
        System.out.println("Random movie number: " + randomMovie);   // test to verify if u get a random movie

        File file2 = new File("movies.txt");               // read the file second time to pick a line
        Scanner sc = new Scanner(file2);

        int reference = 0;
        while (reference <= randomMovie) {
            pickedMovie = sc.nextLine();
            reference++;
        }

                                                                    //System.out.println(pickedMovie); // show the selected word
         Game game =new Game();
         game.starts(pickedMovie);
    }
}
