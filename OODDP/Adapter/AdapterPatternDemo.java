package OODDP.Adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3","beyond the horizon.mp3");
        audioPlayer.play("mp4","beyond.mp4");
        audioPlayer.play("mp3","tracking.mp3");
        audioPlayer.play("vlc","madara.vlc");
        audioPlayer.play("vlc","Trantung.vlc");
        audioPlayer.play("mp4","Co2.mp4");
        
    }
}
