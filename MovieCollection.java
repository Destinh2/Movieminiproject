import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private ArrayList<Movie> movies = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public MovieCollection(){
        try{
            File myFile = new File("movies.csv");
            Scanner fileScanner = new Scanner(myFile);
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {


                String data = fileScanner.nextLine();
                String[] splitdata = data.split(",");
                String name = splitdata[0];
                String cast = splitdata[1];
                String director = splitdata[2];
                String overview = splitdata[3];
                String runtime = splitdata[4];
                String userRating = splitdata[5];
                movies.add(new Movie(name, cast, director, overview, runtime, userRating));
            }
            fileScanner.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println(movies.size());
    }






    public void MainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the movie collection!");
        String menuOption = "";


        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = scanner.nextLine();


            if (menuOption.equals("t")) {
                searchTitles();
            } else if (menuOption.equals("c")) {
                searchCast();
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }


    }


    public void searchTitles(){
        ArrayList<Movie> titles = new ArrayList<>();
        System.out.print("Enter part of the title of the movie you wish to find: ");
        String search = scanner.nextLine().toLowerCase();
        for(int i = 0; i < movies.size(); i++ ){
            if(movies.get(i).getName().toLowerCase().contains(search)){
                //System.out.println("here");
                titles.add(movies.get(i));
            }
        }
        if(titles.size() == 0){
            System.out.println("No movie titles match that search term");
        }
        selectionSortWordList(titles);
        for (int j = 0; j < titles.size(); j++) {
            System.out.println(j+1 + ". " + titles.get(j).getName());
        }
        System.out.print("which number movie would you like to learn more about?: ");
        int num = scanner.nextInt()-1;
        System.out.println("title: " + titles.get(num).getName());
        System.out.println("runtime: " + titles.get(num).getRuntime() + " minutes");
        System.out.println("Directed by:" + titles.get(num).getDirector());
        System.out.println("cast: " + titles.get(num).getCast());
        System.out.println("overview: " + titles.get(num).getOverview());
        System.out.println("user rating: " + titles.get(num).getUserRating());
    }


    public void searchCast(){
        ArrayList<Movie> titles2 = new ArrayList<>();
        System.out.println("enter a person to search for (first or last name): ");
        String name = scanner.nextLine();
        String temp = "";
        for(int i = 0; i < movies.size(); i++ ){
            temp = "";
            if(movies.get(i).getCast().toLowerCase().contains(name)){

            }
        }

    }

    public static void selectionSortWordList(ArrayList<Movie> words){
        for (int i = 0; i < words.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(j).getName().compareTo(words.get(minIndex).getName())< 0){
                    minIndex = j;
                }
            }


            Movie temp = words.get(i);
            words.set(i,words.get(minIndex));
            words.set(minIndex,temp);
        }
    }
}

