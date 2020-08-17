import Utility.Mp3ToWav;

import java.io.File;

public class Mp3ToWavTest {
    public static void main(String[] args){
        try
        {
            String filePath = "C:\\Users\\Rober\\Downloads\\戴荃ilem大氿歌人声本家专辑23收录曲.mp3";
            String directPath = "C:\\Users\\Rober\\Downloads\\大氿歌.wav";
            Mp3ToWav mv = new Mp3ToWav();
            mv.convert(new File(filePath), directPath);
        }

        catch (Exception ex)
        {
            System.out.println("Convert Failure");
            ex.printStackTrace();

        }
    }
}
