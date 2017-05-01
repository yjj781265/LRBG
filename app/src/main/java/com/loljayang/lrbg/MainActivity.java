package com.loljayang.lrbg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import com.rokolabs.sdk.share.RokoShare;




public class MainActivity extends AppCompatActivity {

    static ToggleButton toggle;
    static  MediaPlayer rift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rift = MediaPlayer.create(this,R.raw.rift);
        final MediaPlayer startsound = MediaPlayer.create(MainActivity.this, R.raw.start_sound);
        final MediaPlayer exitsound = MediaPlayer.create(MainActivity.this, R.raw.exit_sound);





// configure RokoShare object

        Button startbutton = (Button) this.findViewById(R.id.srButton);
         toggle = (ToggleButton) findViewById(R.id.toggleButton);
        final Button exitbutton = (Button) this.findViewById(R.id.exitButton);

        startbutton.setOnClickListener(new View.OnClickListener() {   /* two clicklisteners for
                                                                         Summnoner's Rift Button and
                                                                        Exit Button*/
            //two mediaplayer

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                if(!toggle.isChecked()) {
                    startsound.start();
                }
            }
        });


        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitsound.start();

                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
                System.exit(0);
            }
        });

        // toggle mute button

        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (toggle.isChecked()) {
                    startsound.setVolume(0, 0);
                    exitsound.setVolume(0, 0);
                    MainActivity.rift.setVolume(0, 0);


                } else {
                    startsound.setVolume(1, 1);
                    exitsound.setVolume(1, 1);
                    MainActivity.rift.setVolume(1, 1);

                }
            }
            });



        MainActivity.rift.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.reset();
                rift = MediaPlayer.create(MainActivity.this,R.raw.rift);
            }
        });

    }

}

