package com.Hardeymorlah.Music_App.Controller;

import com.Hardeymorlah.Music_App.Model.Music;
import com.Hardeymorlah.Music_App.Model.MusicResource;
import com.Hardeymorlah.Music_App.Service.MusicService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/resource")
public class ResourceController {
    private int year;
    private String title;
    private String genre;
    private String artist;
    private String album;
    private Music newMusic;
    @Autowired
    private MusicService musicService;

    // HATEOAS at Work!!!
    @GetMapping("/{id}")
    public ResponseEntity<MusicResource> getMusicResource(@PathVariable int id) {

        Music musicToSend = musicService.getMusicById(id).getBody();
        MusicResource musicResource = new MusicResource();
        musicResource.setMusic(musicToSend);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).getMusicById(id)).withSelfRel();
        Link getByTitle = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).getMusicByTitle(title)).withRel("getByTitle");
        Link getByGenre = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).getMusicByGenre(genre)).withRel("getByGenre");
        Link getByArtist = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).getMusicByArtistName(artist)).withRel("getByArtist");
        Link getByAlbum = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).getMusicByAlbumName(album)).withRel("getByAlbum");
        Link getByYear = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).getMusicByYear(year)).withRel("getByYear");
        Link update = WebMvcLinkBuilder.linkTo((WebMvcLinkBuilder.methodOn(MusicController.class).updateMusic(id, musicToSend))).withRel("update");
        Link allMusic = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).getAllMusic()).withRel("allMusic");
        Link addNewMusic = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).addNewMusic(newMusic)).withRel("addNewMusic");
        Link deleteById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).deleteMusicById(id)).withRel("deleteById");
        Link deleteByTitle = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).deleteMusicByTitle(title)).withRel("deleteByTitle");
        Link deleteByGenre = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).deleteMusicByGenre(genre)).withRel("deleteByGenre");
        Link deleteByArtistName = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).deleteMusicByArtistName(artist)).withRel("deleteByArtistName");
        Link deleteByAlbumName = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).deleteMusicByAlbumName(album)).withRel("deleteByAlbumName");
        Link deleteByYear = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).deleteMusicByYear(year)).withRel("deleteByYear");
        musicResource.add(selfLink,getByTitle,getByAlbum,getByArtist,getByGenre,getByYear,update,addNewMusic,allMusic,deleteById,deleteByTitle,deleteByGenre,deleteByArtistName,deleteByAlbumName,deleteByYear);
        return new ResponseEntity<>(musicResource, HttpStatus.OK);
    }
}