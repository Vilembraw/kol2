package music;

import java.util.ArrayList;

public class Playlist extends ArrayList<Song> {
    public Song atSecond(int sec){
        int sumOfSec = 0;
        if(sec < 0){
            throw new IndexOutOfBoundsException("Too small.");
        }
        for(Song song: this){
            if((sec >= sumOfSec) && (sec < (sumOfSec + song.getDuration()))){
                return song;
            }
            sumOfSec += song.getDuration();
        }
        throw new IndexOutOfBoundsException("Too big.");
    }
}
