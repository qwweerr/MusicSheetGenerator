import Utility.AudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class AudioPlayerTest {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        String FilePath ="C:\\Users\\Rober\\Downloads\\戴荃ilem大氿歌人声本家专辑23收录曲.mp3";

        AudioPlayer player = new AudioPlayer(FilePath);

        player.play();
    }
}
