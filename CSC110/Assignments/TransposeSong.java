/*
 * Created by gareth on 11/24/2016.
 * v00875748
 */

import java.util.*;
import java.io.*;

public class TransposeSong {

    public static void main(String[] args) throws Exception{
        //String fileName = args[0];
        String fileName = "/Users/gareth/uvic/in_text.txt";
        //String newFile = args[1];
        String newFile = "/Users/gareth/uvic/out_text.txt";
        //String stringTranspose = args[2];
        //int dsemitones = Integer.parseInt(stringTranspose);
        int dsemitones = -3;

        Scanner song = new Scanner(new File(fileName));
        PrintStream transposedSong = new PrintStream(newFile);

        String tempo = song.nextLine();
        String voicesString = "voices ";
        song.next();
        int voices = song.nextInt();
        song.nextLine();
        String title = song.nextLine();

        transposedSong.println(tempo);
        transposedSong.println(voicesString + voices);
        transposedSong.println(title);


        for (int i = 0; i < voices; i++) {
            song.nextLine();
            transposedSong.println();
            Voice aa = new Voice(song);
            aa.transpose(dsemitones);
            transposedSong.print(aa.toString());
            aa.toStream(transposedSong);
        }

//        aa.toString();
        transposedSong.close();




        //System.out.println(fileName + newFile + voices + title + tempo + voicesString);
    }

}
