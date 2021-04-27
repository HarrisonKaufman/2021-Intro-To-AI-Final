import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class AudioListener {

    public AudioListener(){
        
        //create format for audio recording, include sample rate, size in bits, stereo/mono, bigEndian
        AudioFormat format = new AudioFormat(1600, 16, 2, true, true);
        
        //line is final because it is used in anonymous inner class
        final TargetDataLine line;
        
        //looks for datalines on system and checks if they support format
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format); 
        
        // exception for if line is not supported
        if (!AudioSystem.isLineSupported(info)) {
            System.err.println("Line not supported");
            System.exit(0);
        }

        try {
            
            //get the dataline and cast to TargetDataLine
            line = (TargetDataLine) AudioSystem.getLine(info);
        
            line.open(format);
            line.start();

            AudioInputStream audioStream = new AudioInputStream(line);
            File audioFile = new File("recording.wav");
            
            // write the audio recording to recording.wav in the desired format
            try {
                AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile);
            }
            catch (IOException e) {
                System.out.println("ioe");
                e.printStackTrace();
            }
            Thread.sleep(5000);
            line.stop();
            line.close();
        }
        
        //exception handling
        catch (InterruptedException ie) {
            System.out.println("interrupted");
            ie.printStackTrace();
        }
        catch (LineUnavailableException lue) {
            System.out.println("Line unavailable");
            lue.printStackTrace();
        }

    }

}
