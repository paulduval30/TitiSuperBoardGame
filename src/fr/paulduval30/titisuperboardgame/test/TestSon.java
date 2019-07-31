package fr.paulduval30.titisuperboardgame.test;
import java.io.File;
import java.io.IOException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class TestSon
{

    private static Media mp3File;
    private static MediaPlayer musicPlayer;
    private static File songFile=new File("res/music/epee.mp3");
    private static final String songSource=songFile.toURI().toString();

    public static void jouerSon()
    {
        try
        {
            mp3File = new Media(songSource);
            musicPlayer = new MediaPlayer(mp3File);
            musicPlayer.setVolume(0.9);
            musicPlayer.play();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }

}
