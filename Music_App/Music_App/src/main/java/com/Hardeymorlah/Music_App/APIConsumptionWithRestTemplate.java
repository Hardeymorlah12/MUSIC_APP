package com.Hardeymorlah.Music_App;

import com.Hardeymorlah.Music_App.Model.Music;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class APIConsumptionWithRestTemplate {
    public static void main(String[] args) {
        // Performing CRUD OPERATIONS

        // C -> Creating Objects of Music and sending to the Database using PostMapping Method/ URL
        RestTemplate restTemplate = new RestTemplate();
        Music musicObj = new Music();
        musicObj.setMusicDuration(2.25);
        musicObj.setTitle("Forget It");
        musicObj.setGenre("Pop Up");
        musicObj.setArtistName("Saheed");
        musicObj.setAlbumName("Compilation 2");
        musicObj.setYearOfProd(2008);
        // Posting to the Music Database using RestTemplate
        ResponseEntity<Music> postMusic = restTemplate.postForEntity("http://localhost:8082/music/addMusic", musicObj, Music.class);
        System.out.println(postMusic.getBody());
        System.out.println(postMusic.getStatusCode());
        System.out.println(postMusic.getClass());
        System.out.println(postMusic.getHeaders());

        // R ->   Reading From The Music Database using GetMapping Method from Crud Operations
                        // Music Resources ->  HATEOAS LINKS
//        MusicResource getMusicFromDatabase = restTemplate.getForObject("http://localhost:8082/resource/1", MusicResource.class);
//        assert getMusicFromDatabase != null;
//        System.out.println(getMusicFromDatabase.getMusic());
//        // getMusicFromDatabase.getLinks("deleteById").forEach(System.out::println);
//        System.out.println(getMusicFromDatabase.getLinks("deleteById"));

                        // Music Controller
     //   Music getMusic = restTemplate.getForObject("http://localhost:8082/music/getMusic/1", Music.class);
//        Music getByTitle = restTemplate.getForObject("http://localhost:8082/music/getMusicByTitle/Forget It",Music.class);
       // Music getByArtist = restTemplate.getForObject("http://localhost:8082/music/getMusicByArtist/Saheed",Music.class);
//        Music getByAlbum = restTemplate.getForObject("http://localhost:8082/music/getMusicByAlbum/Compilation 4",Music.class);
//        Music getByGenre = restTemplate.getForObject("http://localhost:8082/music/getMusicByGenre/Rip",Music.class);
//        Music getByYear = restTemplate.getForObject("http://localhost:8082/music/getMusicByYear/1998",Music.class);
//        //System.out.println(getMusic);
      //  System.out.println(getByTitle);
        //System.out.println(getByArtist);
//        System.out.println(getByAlbum);
//        System.out.println(getByGenre);
//        System.out.println(getByArtist);
//        System.out.println(getByYear);
//        assert getMusic != null;

//        // Print id, Title and Genre
//        assert getByArtist != null;
//        System.out.printf("id is: %d\n",getByArtist.getId());
//        System.out.printf("Music Duration is: %s\n",getByArtist.getMusicDuration());
//        System.out.printf("Album Name is: %s\n",getByArtist.getAlbumName());
//        System.out.printf("Title is: %s\n", getByArtist.getTitle());
//        System.out.printf("Genre is: %s\n",getByArtist.getGenre());
//        System.out.printf("Artist Name is: %s\n", getByArtist.getArtistName());
//        System.out.printf("Year of Production is: %d\n",getByArtist.getYearOfProd());

        // Updating -> Updating the Music Objects in the Database using PutMapping Method form CRUD Operations
        // Update these Fields
//        getMusic.setTitle("Hasbunallah");
//        getMusic.setGenre("Islamic Gospel");
//        restTemplate.put("http://localhost:8082/music/updateMusic/3", getMusic);

        System.out.println("==============**********=============");
        // Printing out the updated Music details
//        Music fetchedUpdatedMusic = restTemplate.getForObject("http://localhost:8082/music/getMusic/3", Music.class);
//        System.out.println(fetchedUpdatedMusic);
//        assert fetchedUpdatedMusic != null;
//        System.out.printf("id is: %d\n",fetchedUpdatedMusic.getId());
//        System.out.printf("Title is: %s\n",fetchedUpdatedMusic.getTitle());
//        System.out.printf("Genre is: %s\n",fetchedUpdatedMusic.getGenre());


        // D -> Deleting
//        restTemplate.delete("http://localhost:8082/music/deleteById/3");
//        restTemplate.delete("http://localhost:8082/music/deleteByTitle/Hasbunallah");
//        restTemplate.delete("http://localhost:8082/music/deleteByArtist/H.O.M.A");
//        restTemplate.delete("http://localhost:8082/music/deleteByAlbum/Compilation 2");
//        restTemplate.delete("http://localhost:8082/music/deleteByGenre/Rip");
//        restTemplate.delete("http://localhost:8082/music/deleteByYear/1998");


//        ResponseEntity<List<Music>> listResponseEntity = restTemplate.exchange("http://localhost:8082/music/allMusic", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
//        });
//        List<Music> musicList = listResponseEntity.getBody();
//        assert musicList != null;
//        musicList.forEach(System.out::println);
//
//    }
//
}
}