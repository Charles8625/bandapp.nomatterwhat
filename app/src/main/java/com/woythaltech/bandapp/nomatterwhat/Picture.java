package com.woythaltech.bandapp.nomatterwhat;

import java.io.Serializable;

public class Picture implements Serializable {

    private final String leftImageText;
    private final String rightImageText;

    Picture(String leftImageText, String rightImageText){

        this.leftImageText = leftImageText;
        this.rightImageText = rightImageText;
    }


    String getLeftImageText(){
        return leftImageText;
    }

    String getRightImageText() { return rightImageText; }


}
