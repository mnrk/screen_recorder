import java.awt.*;
import java.io.File;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoRecord {
    private ScreenRecorder screenRecorder;

     public static void main(String[] args) throws Exception {

          VideoRecord  videoRecord = new VideoRecord();
          videoRecord.startRecording();
          System.out.println("Recording...");
          System.in.read();
          videoRecord.stopRecording();
    }


       public void startRecording() throws Exception
       {

            GraphicsConfiguration gc = GraphicsEnvironment
               .getLocalGraphicsEnvironment()
               .getDefaultScreenDevice()
               .getDefaultConfiguration();

           this.screenRecorder = new ScreenRecorder(gc,
               new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                    QualityKey, 1.0f,
                    KeyFrameIntervalKey, 15 * 60),
               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                    FrameRateKey, Rational.valueOf(30)),
               null);
          this.screenRecorder.start();

       }

       public void stopRecording() throws Exception
       {
         this.screenRecorder.stop();
       }
}
