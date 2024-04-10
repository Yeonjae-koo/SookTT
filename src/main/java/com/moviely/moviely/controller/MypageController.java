package com.moviely.moviely.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
/mypage
/mypage/wantmovie
/movies/watchmovie
/movies/calendar
*/


@RequestMapping("/mypage")
@Controller
public class MypageController {

    @GetMapping
    public String mypage(ModelMap map) {
        map.addAttribute("mypage", List.of());
        return "/mypage";
    }
}
