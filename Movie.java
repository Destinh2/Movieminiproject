public class Movie {
    private String name1;
    private String cast1;
    private String director1;
    private String overview1;
    private String runtime1;
    private String userating1;
    public Movie(String name, String cast, String director, String overview, String runtime, String userrating){
        this.name1 = name;
        this.cast1 = cast;
        this.director1 = director;
        this.overview1  = overview;
        this.runtime1 = runtime;
        this.userating1 = userrating;


    }
    public String getName(){
        return name1;
    }
    public String getCast(){
        return cast1;
    }
    public String getDirector(){
        return director1;
    }
    public String getOverview(){
        return overview1;
    }
    public String getRuntime(){
        return runtime1;
    }
    public String getUserRating(){
        return userating1;
    }
}

