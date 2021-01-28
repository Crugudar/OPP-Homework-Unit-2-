package com.ironhack.utils;
// Java program to play an Audio
// file using Clip Object 
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    Clip clip;
    AudioInputStream audioInputStream;

    // constructor to initialize streams and clip 
    public Sound(String filePath){
        try {
            // create AudioInputStream object
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

            // create clip reference
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);


        }catch (UnsupportedAudioFileException e){

        }catch (LineUnavailableException e){

        }catch (IOException e){}
    }


    public void playSound(){
        try
        {
            // open audioInputStream to the clip
            clip.loop(0);
            //Sounds audioPlayer = new Sounds();
            clip.setMicrosecondPosition(0);
            clip.start();
            new Scanner(System.in).nextLine();
            clip.stop();
        }

        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

    public void closeSound(){
        clip.close();
    }


} 