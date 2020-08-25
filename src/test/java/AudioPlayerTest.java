import Utility.AudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AudioPlayerTest {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        String FilePath ="C:\\Users\\Rober\\Downloads\\戴荃ilem大氿歌人声本家专辑23收录曲.mp3";

        AudioPlayer player = new AudioPlayer(FilePath);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter command:");
        String s = br.readLine();
        while(s != "q"){
            switch(s){
                case "p": player.play();
                    break;
                case "s": player.stop();
                    break;
                case "t": player.pause();
                    break;
            }
            s = br.readLine();
        }
    }
}
