package com.example;


import java.io.Serializable;

/**
 * Created by M1039838 on 11/15/2017.
 */
public class MyMessage implements Serializable {

    String val;

    public MyMessage(String val) {
        this.val = val;
    }


    public String getVal(){
        return val;
    }

}
