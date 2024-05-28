package com.Hardeymorlah.Music_App.Respository;

import com.Hardeymorlah.Music_App.Model.Music;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import com.Hardeymorlah.Music_App.Model.Music;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends CrudRepository<Music, Integer> {

///    @Query(value = "SELECT MAX(id) FROM music", nativeQuery = true)
    @Query("SELECT MAX(id) FROM Music")
    Integer getLastId();
    Music findByArtistName(String artistName);
    Music findByTitle(String title);
    Music findByGenre(String genre);
    Music findByYearOfProd(int year);
    Music findByAlbumName(String album);

}
