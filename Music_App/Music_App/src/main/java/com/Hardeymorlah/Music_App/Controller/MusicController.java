package com.Hardeymorlah.Music_App.Controller;

import com.Hardeymorlah.Music_App.Model.Music;
import com.Hardeymorlah.Music_App.Service.MusicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/music")
public class MusicController {

    private final MusicService musicService;
    @Autowired
    private ThymeleafController controller;
    @GetMapping("/allMusic")
    public ResponseEntity<Iterable<Music>> getAllMusic(){
        return musicService.getAllMusic();
    }
    @GetMapping("/getMusic/{id}")
    public ResponseEntity<Music> getMusicById(@PathVariable int id){
        return musicService.getMusicById(id);
    }
    @GetMapping("/musicTitle/{title}")
    public ResponseEntity<Music> getMusicByTitle(@PathVariable String title){
        return musicService.getMusicByTitle(title);
    }
    @GetMapping("/musicGenre/{genre}")
    public ResponseEntity<Music> getMusicByGenre(@PathVariable String genre){
        return musicService.getMusicByGenre(genre);
    }
    @GetMapping("/musicArtist/{artist}")
    public ResponseEntity<Music> getMusicByArtistName(@PathVariable String artist){
        return musicService.getMusicByArtistName(artist);
    }
    @GetMapping("/musicAlbum/{album}")
    public ResponseEntity<Music> getMusicByAlbumName(@PathVariable String album){
        return musicService.getMusicByAlbumName(album);
    }
    @GetMapping("/musicYear/{year}")
    public ResponseEntity<Music> getMusicByYear(@PathVariable int year){
        return musicService.getMusicByYearOfProd(year);
    }

    @PostMapping("/addMusic")
    public ResponseEntity<Music> addNewMusic(@RequestBody @Valid Music newMusic){
        return musicService.addNewMusic(newMusic);
    }
    @PutMapping("/updateMusic/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable int id, @Valid @RequestBody Music updateMusic){
        return musicService.updateMusic(id, updateMusic);
    }
    @DeleteMapping("/deleteById")
    public ResponseEntity<Music> deleteMusicById(@RequestParam int id){
        return musicService.deleteMusicById(id);
    }
    @DeleteMapping("/deleteByTitle/{title}")
    public ResponseEntity<Music> deleteMusicByTitle(@PathVariable String title){
        return musicService.deleteMusicByTitle(title);
    }
    @DeleteMapping("/deleteByArtist/{artist}")
    public ResponseEntity<Music> deleteMusicByArtistName(@PathVariable String artist){
        return musicService.deleteMusicByArtist(artist);
    }
    @DeleteMapping("/deleteByGenre/{genre}")
    public ResponseEntity<Music> deleteMusicByGenre(@PathVariable String genre){
        return musicService.deleteMusicByGenre(genre);
    }
    @DeleteMapping("/deleteByAlbum/{album}")
    public ResponseEntity<Music> deleteMusicByAlbumName(@PathVariable String album){
        return musicService.deleteMusicByAlbumName(album);
    }
    @DeleteMapping("/deleteByYear/{year}")
    public ResponseEntity<Music> deleteMusicByYear(@PathVariable int year){
        return musicService.deleteMusicByYear(year);
    }
    @GetMapping("/reg-form")
    public ModelAndView registrationForm(){
        ModelAndView allMusicView = new ModelAndView("create-music");
        Music createMusic = new Music();
        allMusicView.addObject("createMusic", createMusic);
        return allMusicView;
    }

    @PostMapping("/postNewMusic")
    public ModelAndView addMusic(@ModelAttribute("music") @Valid Music music){
        musicService.addNewMusic(music);
        return controller.displayMusic();
    }
}
