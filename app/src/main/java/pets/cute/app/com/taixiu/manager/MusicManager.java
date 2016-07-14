package pets.cute.app.com.taixiu.manager;

import android.content.Context;
import android.media.MediaDescription;
import android.media.MediaPlayer;

import pets.cute.app.com.taixiu.R;
import pets.cute.app.com.taixiu.main.MainApp;

/**
 * Created by Forev on 7/6/2016.
 */
public class MusicManager {
    final static String background_song = "music.mp3";
    final static String win_song = "win.mp3";
    final static String lose_song = "lose.mp3";
    final static String dice_song = "dice.mp3";

    Context mContext;

    public static MusicManager instance;
    MediaPlayer media;

    public static MusicManager getInstance(Context context) {
        if (instance == null)
            instance = new MusicManager(context);
        return instance;
    }

    public MusicManager(Context context) {
        this.mContext = context;
        media = MediaPlayer.create(mContext, R.raw.music);
        media.setLooping(true);
    }

    public void playMusic() {
        if (!media.isPlaying()) {
            media = MediaPlayer.create(mContext, R.raw.music);
            media.setLooping(true);
            media.start();
        }
    }

    public void stopMusic() {
        if (media.isPlaying())
            media.stop();
    }

    public static void playDice() {
        MediaPlayer media = MediaPlayer.create(MainApp.getInstance(), R.raw.dice);
        media.start();
    }

    public static void playLose() {
        MediaPlayer media = MediaPlayer.create(MainApp.getInstance(), R.raw.lose);
        media.start();
    }

    public static void playWin() {
        MediaPlayer media = MediaPlayer.create(MainApp.getInstance(), R.raw.win);
        media.start();
    }
}
