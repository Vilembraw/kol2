package music;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class Song{
    private final String artist;
    private final String title;
    private final int duration;

    public Song(String artist, String title, int duration) {
        this.artist = artist;
        this.title = title;
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public static class Persistence {
        public static Optional<Song> read(int id) throws SQLException {
            String sql = "SELECT artist, title, length FROM song WHERE id = ?";
            PreparedStatement statement = DatabaseConnection.getConnection("songs").prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                return Optional.of(new Song(
                        resultSet.getString("artist"),
                        resultSet.getString("title"),
                        resultSet.getInt("length")
                ));
            }
            return Optional.empty();
        }
    }
}
