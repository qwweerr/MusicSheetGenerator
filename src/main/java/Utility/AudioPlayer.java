package Utility;

import java.io.*;
import javax.sound.*;
import javax.sound.sampled.*;

import javazoom.spi.*;

public class AudioPlayer {
    //FilePath
    AudioInputStream din;
    AudioFormat decodedFormat;
    SourceDataLine line;
    int nBytesRead, nBytesWritten;

    public AudioPlayer(String FilePath) throws IOException, UnsupportedAudioFileException {
        File file = new File(FilePath);
        AudioInputStream in = AudioSystem.getAudioInputStream(file);
        AudioFormat baseFormat = in.getFormat();
        decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                                        baseFormat.getSampleRate(), 16,
                                        baseFormat.getChannels(), baseFormat.getChannels() * 2,
                                        baseFormat.getSampleRate(), false);
        din = AudioSystem.getAudioInputStream(decodedFormat, in);
    }

    public void play() throws IOException, LineUnavailableException {
        byte[] data = new byte[4096];
        line = getLine(decodedFormat);
        if (line != null)
        {
            // Start
            line.start();
            while (nBytesRead != -1)
            {
                nBytesRead = din.read(data, 0, data.length);
                if (nBytesRead != -1) nBytesWritten = line.write(data, 0, nBytesRead);
            }
            // Stop
            line.drain();
            line.stop();
            line.close();
            din.close();
        }
    }

    private SourceDataLine getLine(AudioFormat decodedFormat) throws LineUnavailableException
    {
        SourceDataLine res = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, this.decodedFormat);
        res = (SourceDataLine) AudioSystem.getLine(info);
        res.open(this.decodedFormat);
        return res;
    }


    public void pause() throws IOException, LineUnavailableException{
        line.drain();
        line.stop();
    }

    public void stop() throws IOException, LineUnavailableException{
        line.drain();
        line.stop();
        line.close();
        din.close();
    }
}
