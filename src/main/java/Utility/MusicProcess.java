package Utility;

import org.tritonus.share.sampled.TAudioFormat;
import org.tritonus.share.sampled.file.TAudioFileFormat;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;

public class MusicProcess {
    AudioFileFormat baseFileFormat;
    AudioFormat baseFormat;

    public MusicProcess(String FilePath) throws IOException, UnsupportedAudioFileException {
        File file = new File(FilePath);
        baseFileFormat = AudioSystem.getAudioFileFormat(file);
        baseFormat = baseFileFormat.getFormat();
    }
}


