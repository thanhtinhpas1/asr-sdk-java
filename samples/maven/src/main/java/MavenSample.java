import java.io.File;
import java.io.IOException;

public class MavenSample {
    public static void main(String[] args) {
        File file = new File("src/main/resources/process.wav");
        if (file.canRead()) {
            String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImNjNDExOWMwLWExYzEtMTFlYS1iOTdjLTFiOTdlMzMzNTc2NCIsImlhdCI6MTU5MDc2NjYzNn0.K36Axz4FnuORA9jGr_6cs0CjV2vVAI9DZLxe5sjNb7A";
            int timeout = 10000;
            int sampleRate = 16000;
            int maxSize = 51200;
            Configuration config = new Configuration(token, AudioEncoding.AMR, timeout, sampleRate, maxSize);
            SpeechToText asrSpeech = new SpeechToText(config);
            try {
                String result = asrSpeech.call(file);
                if (result == null) System.out.println("Invalid file.");
                else System.out.println("Transcription: " + result);
            } catch (IllegalArgumentException arEx) {
                System.out.println("Token invalid.");
            } catch (IOException ex) {
                System.out.println("Server connection aborted.");
            }
        } else {
            System.out.println("File not found.");
        }
    }
}
