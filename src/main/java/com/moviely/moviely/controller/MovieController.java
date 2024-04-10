package com.moviely.moviely.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/*
/movies
/moviesnotfound
/movies/search
/movies/{movie_id}
/movies/{movie_id}/details
*/


@RequestMapping("/movies")
@Controller
public class MovieController {

    @GetMapping
    public String movies(ModelMap map) {
        map.addAttribute("movies", List.of());
        return "/movies";
    }
}
