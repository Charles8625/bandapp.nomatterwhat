package com.woythaltech.bandapp.nomatterwhat;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Picture implements Serializable {

    //private final Bitmap leftImage;
    //private final Bitmap rightImage;
    private final String leftImageText;
    private final String rightImageText;

    Picture(String leftImageText, String rightImageText){
        //this.leftImage = leftImage;
        //this.rightImage = rightImage;
        this.leftImageText = leftImageText;
        this.rightImageText = rightImageText;
    }

    /*
    Bitmap getLeftImage() {
        return leftImage;
    }

    Bitmap getRightImage(){
        return rightImage;
    }
     */

    String getLeftImageText(){
        return leftImageText;
    }

    String getRightImageText() { return rightImageText; }


}
