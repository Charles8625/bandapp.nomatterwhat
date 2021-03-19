package com.woythaltech.bandapp.nomatterwhat;

import java.io.Serializable;

public class Video implements Serializable {

    private final String videoDescription;

    Video(String videoDescription){
        this.videoDescription = videoDescription;
    }

    String getVideoDescription(){ return videoDescription; }
}
