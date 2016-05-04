package com.example.supremelordjudah.beachelectriccompany;

import java.util.ArrayList;

/**
 * Created by Supreme Lord Judah on 5/3/2016.
 */
public class PassArray {
    String string;
    String[] strings;
    ArrayList<String> stringArrayList;

    public PassArray(String s){
        string = s;
    }

    public PassArray(String[] s){
        strings = s.clone();
    }

    public PassArray(ArrayList<String> s)
    {
        stringArrayList = s;
    }

}
