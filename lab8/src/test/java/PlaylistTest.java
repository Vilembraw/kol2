import music.Playlist;
import music.Song;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {
    //1b
    @Test
    public void testEmptyPlaylist(){
        Playlist playlist = new Playlist();
        assertTrue(playlist.isEmpty());

    }
    //1b
    @Test
    public void testLenghthAfterAddingRecord(){
        Playlist playlist = new Playlist();
        playlist.add(new Song("Artist","Title",10));
//        assertTrue(playlist.size() == 1);
        assertEquals(1, playlist.size());
    }
    //1d
    //ten sam obiekt - ta sama przestrzeń w pamięci (podobnie do softlinku)
    //taki sam - takie same atrybuty, inna przestrzeń (podobnie do kopii)
    @Test
    public void testSameElement(){
        Playlist playlist = new Playlist();
        Song Song = new Song("Artist", "Title", 10);
        playlist.add(Song);
        assertEquals(Song, playlist.getFirst());
    }
    //1e
    @Test
    public void testEqualElement(){
        Playlist playlist = new Playlist();
        Song Song = new Song("Artist", "Title", 10);
        playlist.add(Song);
        Song Song1 = new Song("Artist", "Title", 10);
        //sprawdza obiekty nie atrybuty
        assertEquals(Song1, Song);
    }

    //1f
    @Test
    public void testatSong(){
        Playlist playlist = new Playlist();
        Song Song = new Song("Artist", "Title", 10);
        playlist.add(Song);
        Song Song1 = new Song("1", "1", 50);
        playlist.add(Song1);
        Song Song2 = new Song("2", "2", 70);
        playlist.add(Song2);
        Song Song3 = new Song("3", "3", 120);
        playlist.add(Song3);
        assertEquals(Song2, playlist.atSecond(100));

    }


    @Test
    public void doesThrowException(){
        Playlist playlist = new Playlist();
        Song Song = new Song("Artist", "Title", 10);
        playlist.add(Song);
        Song Song1 = new Song("1", "1", 50);
        playlist.add(Song1);
        Song Song2 = new Song("2", "2", 70);
        playlist.add(Song2);
        Song Song3 = new Song("3", "3", 120);
        playlist.add(Song3);
        assertEquals(Song2, playlist.atSecond(-10));

    }



    @Test
    public void doesThrowExceptionNegative(){
        Playlist playlist = new Playlist();
        Song Song = new Song("Artist", "Title", 10);
        playlist.add(Song);
        Song Song1 = new Song("1", "1", 50);
        playlist.add(Song1);
        Song Song2 = new Song("2", "2", 70);
        playlist.add(Song2);
        Song Song3 = new Song("3", "3", 120);
        playlist.add(Song3);
        assertEquals(Song2, playlist.atSecond(2000));

    }
}
