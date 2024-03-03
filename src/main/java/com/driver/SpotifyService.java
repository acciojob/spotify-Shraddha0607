package com.driver;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class SpotifyService {

    //Auto-wire will not work in this case, no need to change this and add autowire

    SpotifyRepository spotifyRepository = new SpotifyRepository();

    public User createUser(String name, String mobile){
        User user = spotifyRepository.createUser(name, mobile);
        return user;

    }

    public Artist createArtist(String name) {

        Artist artist = spotifyRepository.createArtist(name);
        return artist;
    }

    public Album createAlbum(String title, String artistName) {

        Album album = spotifyRepository.createAlbum(title, artistName);
        return album;
    }

    public Song createSong(String title, String albumName, int length) throws Exception {


        try {
            Song song = spotifyRepository.createSong(title, albumName,length);

            return song;
            // Handle the case where the song is successfully created
        } catch (Exception e) {
            // Handle the case where an exception occurred, e.g., album not found
            System.out.println("Error: " + e.getMessage());
//            return "Error: " + e.getMessage();
            throw new Exception("Album with name '" + albumName + "' not found");

        }
    }

    public Playlist createPlaylistOnLength(String mobile, String title, int length) throws Exception {

        Playlist playlist = new Playlist();
        return playlist;
    }

    public Playlist createPlaylistOnName(String mobile, String title, List<String> songTitles) throws Exception {

        Playlist playlist = new Playlist();
        return playlist;
    }

    public Playlist findPlaylist(String mobile, String playlistTitle) throws Exception {

        Playlist playlist = new Playlist();
        return playlist;
    }

    public Song likeSong(String mobile, String songTitle) throws Exception {

        Song song = new Song();
        return song;
    }

    public String mostPopularArtist() {

        return "Success";
    }

    public String mostPopularSong() {

        return "Success";
    }
}
