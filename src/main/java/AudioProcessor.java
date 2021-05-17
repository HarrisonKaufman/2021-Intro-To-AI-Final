import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;


public class AudioProcessor extends GUI {

    float pitchResult;
    public AudioProcessor() {
        try {
            AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);
        }
        catch (NoClassDefFoundError ncdfe){
            label.setText("YOUR MICROPHONE IS NOT SUPPORTED");
            System.out.println("microphone bad");
        }
        PitchDetectionHandler pitchDetectionHandler = (pitchDetectionResult, audioEvent) -> {
            final float pitchInHz = pitchDetectionResult.getPitch();
            pitchResult = pitchInHz;
        };

        processPitch(pitchResult);
    }

    public void processPitch(float pitch) {

        label.setText("" + pitch);

        if(pitch >= 110 && pitch < 123.47) {
            //A
            label.setText("A");
        }
        else if(pitch >= 123.47 && pitch < 130.81) {
            //B
            label.setText("B");
        }
        else if(pitch >= 130.81 && pitch < 146.83) {
            //C
            label.setText("C");
        }
        else if(pitch >= 146.83 && pitch < 164.81) {
            //D
            label.setText("D");
        }
        else if(pitch >= 164.81 && pitch <= 174.61) {
            //E
            label.setText("E");
        }
        else if(pitch >= 174.61 && pitch < 185) {
            //F
            label.setText("F");
        }
        else if(pitch >= 185 && pitch < 196) {
            //G
            label.setText("G");
        }
    }

    public void run(){
        processPitch(pitchResult);
    }
}
