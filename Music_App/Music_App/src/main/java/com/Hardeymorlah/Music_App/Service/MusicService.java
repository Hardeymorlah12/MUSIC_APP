package com.Hardeymorlah.Music_App.Service;

import com.Hardeymorlah.Music_App.Model.Music;
import com.Hardeymorlah.Music_App.Respository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MusicService {
    private final MusicRepository musicRepository;
    @CacheEvict(value = "allMusic", allEntries = true)
    public ResponseEntity<Iterable<Music>> getAllMusic(){
        System.out.println("This Should be faster");
        return new ResponseEntity<>(musicRepository.findAll(), HttpStatus.OK);
    }
//    @Cacheable(value = "musicId", key = "#id")
    @CacheEvict(value = "music_Id", key = "#id", allEntries = true)
    public ResponseEntity<Music> getMusicById(int id){
        System.out.println("This was reached");
        return new ResponseEntity<>(musicRepository.findById(id).get(), HttpStatus.OK);
    }
//    @Cacheable(value = "mArtist", key = "#artistName")
    @CacheEvict(value = "music_Artist", key = "#artistName", allEntries = true)
    public ResponseEntity<Music> getMusicByArtistName(String artistName){
        return new ResponseEntity<>(musicRepository.findByArtistName(artistName), HttpStatus.OK);
    }
//    @Cacheable(value = "mAlbum", key = "#albumName")
    @CacheEvict(value = "music_Album", key = "#albumName", allEntries = true)
    public ResponseEntity<Music> getMusicByAlbumName(String albumName){
        return new ResponseEntity<>(musicRepository.findByAlbumName(albumName), HttpStatus.OK);
    }
//    @Cacheable(value = "mTitle", key = "#title")
    @CacheEvict(value = "music_Title", key = "#title", allEntries = true)
    public ResponseEntity<Music> getMusicByTitle(String title){
        return new ResponseEntity<>(musicRepository.findByTitle(title), HttpStatus.OK);
    }
//    @Cacheable(value = "mGenre", key = "#genre")
    @CacheEvict(value = "music_Genre", key = "#genre", allEntries = true)
    public ResponseEntity<Music> getMusicByGenre(String genre){
        return new ResponseEntity<>(musicRepository.findByGenre(genre), HttpStatus.OK);
    }
//    @Cacheable(value = "mYear", key = "#yearOfProd")
    @CacheEvict(value = "music_Year", key = "#yearOfProd", allEntries = true)
    public ResponseEntity<Music> getMusicByYearOfProd(int yearOfProd){
        return new ResponseEntity<>(musicRepository.findByYearOfProd(yearOfProd), HttpStatus.OK);
    }
    @CachePut(value = "addNewMusic", key = "#newMusic")
//    @CacheEvict(value = "allMusic", allEntries = true)
    public ResponseEntity<Music> addNewMusic(Music newMusic){
        Integer id = musicRepository.getLastId();
        System.out.println(id);
        Music musicWithId = new Music();
        musicWithId.setId(id+1);
        musicWithId.setTitle(newMusic.getTitle());
        musicWithId.setArtistName(newMusic.getArtistName());
        musicWithId.setMusicDuration(newMusic.getMusicDuration());
        musicWithId.setGenre(newMusic.getGenre());
        musicWithId.setYearOfProd(newMusic.getYearOfProd());
        musicWithId.setAlbumName(newMusic.getAlbumName());
////       Music musicWithId = new Music(id + 1, newMusic.getTitle(), newMusic.getArtistName(),newMusic.getAlbumName(),newMusic.getMusicDuration(), newMusic.getGenre(),newMusic.getYearOfProd());
/////        return new ResponseEntity<>(musicRepository.save(newMusic), HttpStatus.CREATED);
//    return new ResponseEntity<>(musicRepository.save(newMusic),HttpStatus.CREATED);
        return new ResponseEntity<>(musicRepository.save(musicWithId),HttpStatus.CREATED);
    }
@CachePut(value = "mUpdate", key = "#id")
    public ResponseEntity<Music> updateMusic(int id, Music updateMusic){
        Music dbMusic = musicRepository.findById(id).get();
        dbMusic.setMusicDuration(updateMusic.getMusicDuration());
        dbMusic.setAlbumName(updateMusic.getAlbumName());
        dbMusic.setArtistName(updateMusic.getArtistName());
        dbMusic.setTitle(updateMusic.getTitle());
        dbMusic.setYearOfProd(updateMusic.getYearOfProd());
        dbMusic.setGenre(updateMusic.getGenre());
        return new ResponseEntity<>(musicRepository.save(dbMusic), HttpStatus.ACCEPTED);
    }
@CacheEvict(value = "deleteMusic", key = "#deleteId", allEntries = true)
    public ResponseEntity<Music> deleteMusicById(int deleteId){
        Music musicId = musicRepository.findById(deleteId).get();
        musicRepository.deleteById(deleteId);
        return new ResponseEntity<>(musicId, HttpStatus.OK);
    }
    @CacheEvict(value = "dTitle", key = "#title", allEntries = true)
     public ResponseEntity<Music> deleteMusicByTitle(String title){
        Music musicTitle = getMusicByTitle(title).getBody();
         assert musicTitle != null;
         musicRepository.deleteById(musicTitle.getId());
        return new ResponseEntity<>(musicTitle, HttpStatus.OK);
     }
     @CacheEvict(value = "dGenre", key = "#genre",allEntries = true)
    public ResponseEntity<Music> deleteMusicByGenre(String genre){
        Music musicGenre = getMusicByGenre(genre).getBody();
        assert musicGenre != null;
        musicRepository.deleteById(musicGenre.getId());
        return new ResponseEntity<>(musicGenre, HttpStatus.OK);
    }
    @CacheEvict(value = "dAlbum", key = "#album", allEntries = true)
    public ResponseEntity<Music> deleteMusicByAlbumName(String album){
        Music musicAlbum = getMusicByAlbumName(album).getBody();
        assert musicAlbum != null;
        musicRepository.deleteById(musicAlbum.getId());
        return new ResponseEntity<>(musicAlbum, HttpStatus.OK);
    }
    @CacheEvict(value = "dYear", key = "#year", allEntries = true)
    public ResponseEntity<Music> deleteMusicByYear(int year){
        Music musicYear = getMusicByYearOfProd(year).getBody();
        assert musicYear != null;
        musicRepository.deleteById(musicYear.getId());
        return new ResponseEntity<>(musicYear, HttpStatus.OK);
    }
    @CacheEvict(value = "dArtist", key = "#artist", allEntries = true)
    public ResponseEntity<Music> deleteMusicByArtist(String artist){
        Music musicArtist = getMusicByArtistName(artist).getBody();
        assert musicArtist != null;
        musicRepository.deleteById(musicArtist.getId());
        return new ResponseEntity<>(musicArtist, HttpStatus.OK);
    }
}
