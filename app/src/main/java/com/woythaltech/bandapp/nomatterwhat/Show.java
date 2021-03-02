package com.woythaltech.bandapp.nomatterwhat;

import java.io.Serializable;

public class Show implements Serializable {

    private final String showVenue;
    private final String showAddress;
    private final String showDate;
    private final String showTime;

    Show(String showVenue, String showAddress, String showDate, String showTime){

        this.showVenue = showVenue;
        this.showAddress = showAddress;
        this.showDate = showDate;
        this.showTime = showTime;

    }

    String getShowVenue() {
        return showVenue;
    }

    String getShowAddress() {
        return showAddress;
    }

    String getShowDate(){
        return showDate;
    }

    String getShowTime(){
        return showTime;
    }


}
