/*
 * Created by gareth on 11/24/2016.
 * v00875748
 */
import java.util.*;
import java.io.*;

public class Voice {

    private Note[] notes;
    private String instrument;
    private int numbOfNotes;



    public Voice(Scanner input){
        input.next();
        this.instrument = input.next();
        input.nextLine();
        input.next();
        this.numbOfNotes = input.nextInt();
        this.notes = new Note[this.numbOfNotes];
        input.nextLine();

        for (int i = 0; i < numbOfNotes; i++){
            String str = input.nextLine();
            String[] line = str.split(" ");
            String pitchHold = line[0];
            String duration = line[1];
            int octive = Integer.parseInt(pitchHold.replaceAll("\\D", ""));

            char aaa = pitchHold.charAt(0);
            char bbb;
            String pitch;
            if (pitchHold.charAt(1) == '_' || pitchHold.charAt(1) == '^') {
                bbb = pitchHold.charAt(1);
                pitch = "" + aaa + bbb;
            }else{
                pitch = "" + aaa;
            }

            Note noteholder = new Note(pitch , duration , octive);
            this.notes[i] = noteholder;
            //System.out.println(str);
        }
    }

    public String toString(){
        String response = "instrument " + instrument + "\nnotes " + numbOfNotes;

        for (int i = 0; i < numbOfNotes; i++){
            response = response + "\n" + this.notes[i].toString();
        }

        return response;
    }

    public void toStream(PrintStream ps){
        ps.println(this.notes.toString());
    }

    public void transpose(int semitones){
        for (int i = 0; i < numbOfNotes; i++) {
            this.notes[i].transpose(semitones);
        }
    }
}
