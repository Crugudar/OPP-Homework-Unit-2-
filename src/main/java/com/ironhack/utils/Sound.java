// A fancy audio player
// Original code was simplified, you can check it here: https://www.geeksforgeeks.org/play-audio-file-using-java/
package com.ironhack.utils;
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

        // nobody likes exceptions
        }catch (UnsupportedAudioFileException e){

        }catch (LineUnavailableException e){

        }catch (IOException e){}
    }


    public void playSound(){
        try
        {
            // this makes our file only play once
            clip.loop(0);
            // every time the method is executed, we set the sound starting position to 0
            clip.setMicrosecondPosition(0);
            clip.start();
            new Scanner(System.in).nextLine();
            clip.stop(); // enough, thank you!
        }

        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

    // This closes the file, so we won't have problems executing and opening the file again
    public void closeSound(){
        clip.close();
    }


} 