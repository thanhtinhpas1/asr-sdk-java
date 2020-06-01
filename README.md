# Speech to Text

## Installation

##### Maven

```xml
<dependency>
  <groupId>com.asr.vietspeech</groupId>
  <artifactId>asr-vietspeech</artifactId>
  <version>0.0.1</version>
</dependency>
```

##### Gradle

```gradle
'com.vietspeech:asr-vietspeech:0.0.1'
```
##### JAR

Download the jar with dependencies [here][jar].

## Usage

Use the [Speech to Text][speech_to_text] service to recognize the text from a .wav file.

```java

public class MavenSample {
    public static void main(String[] args) {
        File file = new File("src/main/resources/process.wav");
        if (file.canRead()) {
            String token = "replace token here";
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

```
[jar]: https://github.com/thanhtinhpas1/asr-sdk-java/asr-vietspeech.jar
[speech_to_text]: http://asr.vietspeech.com:3200/docs
