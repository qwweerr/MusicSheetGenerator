import Utility.AudioPlayer;

import java.util.Scanner;

public class test {
    public static void main(String[] args){
        try
        {
            String filepath = "C:\\Users\\Rober\\Downloads\\戴荃ilem大氿歌人声本家专辑23收录曲.mp3";
            AudioPlayer audioPlayer = new AudioPlayer(filepath);

            audioPlayer.play();
            Scanner sc = new Scanner(System.in);

            while (true)
            {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.println("5. Jump to specific time");
                int c = sc.nextInt();
                   
                audioPlayer.gotoChoice(c);
                if (c == 4)
                    break;
            }
            sc.close();
        }

        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }
}

