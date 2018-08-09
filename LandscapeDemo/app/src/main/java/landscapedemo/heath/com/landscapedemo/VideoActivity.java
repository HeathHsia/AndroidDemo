package landscapedemo.heath.com.landscapedemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class VideoActivity extends BaseActivity {

    // 图层设置
    private SurfaceView surfaceView;
    // 多媒体player
    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceview);
        String urlPath = "http://www.html5videoplayer.net/videos/toystory.mp4";
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(this, Uri.parse(urlPath));
            surfaceHolder = surfaceView.getHolder();
            surfaceHolder.addCallback(new MyCallBack());
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
                }
            });
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class MyCallBack implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            mediaPlayer.setDisplay(surfaceHolder);
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

        }
    }


}
