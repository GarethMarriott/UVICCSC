/**
 * Created by gareth on 11/24/2016.
 * v00875748
 */
public class Note {

    private String pitch;
    private String duration;
    private int octive;

    public Note(String pitch , String duration , int octive){

        this.pitch = pitch;
        this.duration = duration;
        this.octive = octive;

    }

    public String toString(){
        String str = this.pitch + " " + this.duration;
        return str;
    }

    public void transpose(int dsemitones){

        if (dsemitones > 0){
            for (int i = 0; dsemitones < i; i++){
                transposeUp();
            }
        }
        if (dsemitones < 0){
            for (int i = 0; dsemitones < i; i++){
                transposeDown();
            }
        }
    }

    private void transposeDown(){
        int i = 0;
        while (!(transposeTable[i][1].equals(this.pitch)) ){
            i++;
        }
        this.pitch = transposeTable[i][0];
    }

    private void transposeUp(){
        int i = 0;
        while (!(transposeTable[i][0].equals(this.pitch))){
            i++;
        }
        this.pitch = transposeTable[i][1];
    }

    private static final String[][] transposeTable = {
            {"c_", "c"},
            {"c", "d_"},
            {"c", "c^"},
            {"c^", "d"},
            {"d_", "d"},
            {"d", "d^"},
            {"d", "e_"},
            {"d^", "e"},
            {"e_", "e"},
            {"e", "e^"},
            {"e_", "f_"},
            {"e", "f"},
            {"e^", "f^"},
            {"f", "f^"},
            {"f", "g_"},
            {"f^", "g"},
            {"g", "g^"},
            {"g", "a_"},
            {"g^", "a"},
            {"g_", "g"},
            {"a_", "a"},
            {"a", "a^"},
            {"a", "b_"},
            {"a^", "b"},
            {"b_", "b"},
            {"b_", "c_"},
            {"b", "b^"},
            {"b", "c"},
            {"b^", "c^"}
    };


}
