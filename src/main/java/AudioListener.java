import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class AudioListener {

    Timer timer = new Timer();

    public AudioListener(){

        AudioFormat format = new AudioFormat(1600, 16, 2, true, true);

        final TargetDataLine line;

        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format); // format is an AudioFormat object

        if (!AudioSystem.isLineSupported(info)) {
            System.err.println("Line not supported");
            System.exit(0);
        }
// Obtain and open the line.

        try {
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);

            line.start();


            AudioInputStream audioStream = new AudioInputStream(line);
            File audioFile = new File("recording.wav");
            try {
                AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile);
            } catch (IOException e) {
                System.out.println("ioe");
                e.printStackTrace();
            }

            Thread.sleep(5000);
            line.stop();
            line.close();
        }

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
