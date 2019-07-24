

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main (String [] args) {

        try {

            File file;
            try {
                file = new File("movies.txt");
            } catch (NullPointerException e) {
                throw new Exception("Brak pliku: movies.txt");
            }

            Scanner fileScanner;
            try {
                fileScanner = new Scanner(file);
            } catch (FileNotFoundException fnfe) {
                throw new Exception("Brak pliku: movies.txt");
            }

            ArrayList<String> movies;
            movies = new ArrayList<String>();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (line.length() > 0) {
                    movies.add(line);
                }
            }

            // losuj film
            //Random generator = new Random(seed);
            int index = (int) (Math.random() * movies.size());
            String movieTitle = movies.get(index);

            Movie movie;
            movie = new Movie(movieTitle);

            Scanner inScanner = new Scanner(System.in);
            System.out.println("Odgadnij tytuł filmu: " + movie.getTitleEncode());
            System.out.println("Odgadnij literę: ");

            int attemptCount = 0;

            while (inScanner.hasNextLine()) {
                attemptCount++;
                String line = inScanner.nextLine();

                int guessCount = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (movie.charSearch(line.charAt(i))) {
                        guessCount++;
                    }
                }


                if (attemptCount > 10) {
                    throw new Exception("PRZEGRAŁEŚ! Tytuł to: " + movie.getTitle());
                }
                else
                {
                    if (movie.winnerTest ())
                        throw new Exception("WYGRAŁEŚ! Tytuł to: " + movie.getTitle());
                }


                System.out.println("Odgadujesz: " + movie.getTitleEncode());
                if (movie.getChatNotFinded().length() > 0)
                    System.out.println("Nie trafiłeś: " + movie.getChatNotFinded());
                System.out.println("Odgadnij literę: ");
            }



        }
        catch (Exception e) {
            System.out.println (e.getMessage());
        }
    }



}
