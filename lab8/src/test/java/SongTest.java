import music.DatabaseConnection;
import music.Song;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.crypto.Data;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
    @BeforeAll
    static void openDatabase(){
        DatabaseConnection.connect("songs.db","songs");
    }
    @Test
    public void checkid() throws SQLException {
        Optional<Song> testSong = Song.Persistence.read(1);
        Song expectedSong = new Song("Queen","Bohemian Rhapsody",355);
//        assertTrue(testSong.isPresent());
        assertEquals(expectedSong,testSong.get());
    }
}
