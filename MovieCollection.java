import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<String>parts = new ArrayList<>();
        ArrayList<String> titles2 = new ArrayList<>();
        int counter2 = 0;
        System.out.println("enter a person to search for (first or last name): ");
        String name = scanner.nextLine();
        for(int i = 0; i < movies.size(); i++ ){
              String[] parts2 = movies.get(i).getCast().split("\\|");
                for(String cast : parts2){
                    parts.add(cast.toLowerCase());
                }
        }
        for(int j = 0; j < parts.size() ; j++){}
        selectionSortWordList2(parts);
        int counter4 = 0;
        for(int i = 0; i < parts.size() ; i++){
            if(parts.get(i).contains(name)){
                int counterrr = 0;
                for(int z = 0; z < titles2.size() ; z++){
                    if(titles2.get(z).equals(parts.get(i))){
                        counterrr++;
                    }
                }
                if(counterrr == 0){
                    titles2.add(parts.get(i));
                    System.out.println(1+counter2 + ". " + parts.get(i));
                    counter2++;
                }
                counter4++;
            }
        }
        if(counter4 == 0){
            System.out.println("NO results match this");
        } else{
            ArrayList<Movie> moviesActor = new ArrayList<>();
            System.out.println("Which would you like to see all the movies for");
            System.out.print("enter number: ");
            int searchName = scanner.nextInt();
            int counter3 = 0;
            //System.out.println(movies.size());
            selectionSortWordList(movies);
            for (Movie movie : movies) {
//            System.out.println(movie.getName());
//            System.out.
                if (movie.getCast().toLowerCase().contains(titles2.get(searchName - 1))) {
                    System.out.println(1 + counter3 + ". " + movie.getName());
                    moviesActor.add(movie);
                    counter3++;
                }
            }
            System.out.println("which movie would you like to learn more about?");
            System.out.print("enter number: ");
            int searchName2 = scanner.nextInt();
            Movie finalname = moviesActor.get(searchName2-1);
            System.out.println("title: " + finalname.getName());
            System.out.println("runtime: " + finalname.getRuntime() + " minutes");
            System.out.println("Directed by:" + finalname.getDirector());
            System.out.println("cast: " + finalname.getCast());
            System.out.println("overview: " + finalname.getOverview());
            System.out.println("user rating: " + finalname.getUserRating());

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
    public static void selectionSortWordList2(ArrayList<String> words){
        for (int i = 0; i < words.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(j).compareTo(words.get(minIndex))< 0){
                    minIndex = j;
                }
            }


            String temp = words.get(i);
            words.set(i,words.get(minIndex));
            words.set(minIndex,temp);
        }
    }
}

