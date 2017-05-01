package com.loljayang.lrbg;

import android.media.MediaPlayer;

import java.util.Objects;

/**
 * Created by LoLJay on 12/16/2016.
 */
public class Champ<T> {
public int champIcon;
public int champSound;
    public String name;
    public String role;



    public Champ(int icon,int sound,String champName,String champRole){
        champIcon=icon;
        champSound= sound;
        name = champName;
        role = champRole;
    }
    @Override
    public boolean equals(Object o){
        if (o.equals(champIcon)){
            return true;
        }else{
            return false;
        }

    }
    public String toString(){
        return name ;
    }

}

