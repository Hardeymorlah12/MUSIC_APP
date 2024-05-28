package com.Hardeymorlah.Music_App.Controller;

import com.Hardeymorlah.Music_App.Model.Music;
import com.Hardeymorlah.Music_App.Service.MusicService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/music")
public class ThymeleafController {
    private final MusicService musicService;

    public ThymeleafController(MusicService musicService) {
        this.musicService = musicService;
    }
    @GetMapping("/display-music")
    public ModelAndView displayMusic(){
        ModelAndView allMusicView = new ModelAndView("all-Music");
        Iterable<Music> allMusic = musicService.getAllMusic().getBody();
        allMusicView.addObject("allMusic", allMusic);
        return  allMusicView;
    }
    @GetMapping("/submit")
    public String submitForm(){
        return "redirect://music/display-music";
    }
    @GetMapping("/new-form")
    public String htmlForm(){
        System.out.println("I got here");
        return "create-new-music";
    }

    @PostMapping("/addNewMusic")
    public String addMusic(@ModelAttribute("music") @Valid Music music){
        System.out.println("I entered here");
        musicService.addNewMusic(music);
        return displayMusic().getViewName();
    }
}
