package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class SpotifyRepository {
    public HashMap<Artist, List<Album>> artistAlbumMap;
    public HashMap<Album, List<Song>> albumSongMap;
    public HashMap<Playlist, List<Song>> playlistSongMap;
    public HashMap<Playlist, List<User>> playlistListenerMap;
    public HashMap<User, Playlist> creatorPlaylistMap;
    public HashMap<User, List<Playlist>> userPlaylistMap;
    public HashMap<Song, List<User>> songLikeMap;

    public List<User> users;
    public List<Song> songs;
    public List<Playlist> playlists;
    public List<Album> albums;
    public List<Artist> artists;

    public SpotifyRepository(){
        //To avoid hitting apis multiple times, initialize all the hashmaps here with some dummy data
        artistAlbumMap = new HashMap<>();
        albumSongMap = new HashMap<>();
        playlistSongMap = new HashMap<>();
        playlistListenerMap = new HashMap<>();
        creatorPlaylistMap = new HashMap<>();
        userPlaylistMap = new HashMap<>();
        songLikeMap = new HashMap<>();

        users = new ArrayList<>();
        songs = new ArrayList<>();
        playlists = new ArrayList<>();
        albums = new ArrayList<>();
        artists = new ArrayList<>();
    }

    public User createUser(String name, String mobile) {
        User user = new User(name,mobile);
        users.add(user);
        return user;
    }

    public Artist createArtist(String name) {
        Artist artist =  new Artist(name);
        artists.add(artist);
        return artist;
    }

    public Album createAlbum(String title, String artistName) {

        // first check in aritsts list, artist Name is present if not then create artist first
        boolean isArtistNamePresent = false;
        for(Artist artist : artists){
            if(artist.getName() == artistName){
                isArtistNamePresent = true;
                break;
            }
        }
        if(!isArtistNamePresent){
            createArtist(artistName);
        }


        // now get the artist object so that by using this as key, we can add in map
        Album album = new Album(title);           // do something with artistName
        albums.add(album);

        for(Artist artist : artists){
            if(artist.getName() == artistName){
                artistAlbumMap.put(artist, albums);       // since in this format needed to add
            }
        }

        return album;
    }

    public Song createSong(String title, String albumName, int length) throws Exception{

        Album foundAlbum = null;
        // first check in album list, album Name is present if not then exception
        for(Album album : albums){
            if(album.getTitle().equals(albumName) ){
                foundAlbum = album;
                break;
            }
        }

        if(foundAlbum != null){
            // as we find the albumName, so add new song in songs list and add that list with hashmap albumSongMap
            Song song = new Song(title, length);
            albumSongMap.get(foundAlbum).add(song);
            return song;
        }
        else{
            // If the albumName is not found, throw an exception
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
        return "selfadded";
    }

    public String mostPopularSong() {
        return "selfadded";
    }
}
