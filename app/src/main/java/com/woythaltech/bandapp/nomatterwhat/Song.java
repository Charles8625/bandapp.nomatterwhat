package com.woythaltech.bandapp.nomatterwhat;


import java.io.Serializable;

public class Song implements Serializable {

    private final String songName;
    private final String bandName;
    private final String releaseYear;
    private final String lyrics;

    Song(String songName, String bandName, String releaseYear, String lyrics){

        this.songName = songName;
        this.bandName = bandName;
        this.releaseYear = releaseYear;
        this.lyrics = lyrics;

    }

    String getSongName() {
        return songName;
    }

    String getBandName(){
        return bandName;
    }

    String getReleaseYear(){
        return releaseYear;
    }

    String getLyrics() { return lyrics; }
}
