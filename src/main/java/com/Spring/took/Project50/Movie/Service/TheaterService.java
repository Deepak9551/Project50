package com.Spring.took.Project50.Movie.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TheaterService {
    List<Theater> theaters = new ArrayList<>(10);

    public List<Theater> theaterList(){
        if (theaters!=null && !theaters.isEmpty()){
            return theaters;
        }
        return new ArrayList<>();
    }
    public void printAllTheaters(){
        theaters.forEach(System.out::println);
    }
    
    public void FindTheaterById(UUID theaterId){
        theaters.stream().filter(theater -> theater.)
    }
}
