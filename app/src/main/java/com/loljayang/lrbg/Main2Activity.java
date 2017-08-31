package com.loljayang.lrbg;

import android.content.Context;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.loljayang.lrbg.MainActivity.rift;


public class Main2Activity extends AppCompatActivity {

    ImageView view1, view2, view3, view4, view5, view6, view7, view8, keyStoneView, sspell1View, sspell2View;
    private MediaPlayer champSD;
    private float px, px2, champx, bannerWidth, bannerHeight, keyW, keyH, sspellsize;
    private List<Integer> bootsList = Collections.synchronizedList(new ArrayList());
    private List<Integer> iconsList = Collections.synchronizedList(new ArrayList());
    private List<Integer> jgList = Collections.synchronizedList(new ArrayList());
    private List<Integer> nonjgItemList = Collections.synchronizedList(new ArrayList());
    private List<String> DropList = Collections.synchronizedList(new ArrayList());
    private List<Integer> meleeItemList = Collections.synchronizedList(new ArrayList());
    private List<Integer> rangeItemList = Collections.synchronizedList(new ArrayList());
    private List<Champ> champList = Collections.synchronizedList(new ArrayList());
    private List<Champ> meleeList = Collections.synchronizedList(new ArrayList());
    private List<Champ> rangeList = Collections.synchronizedList(new ArrayList());
    private List<Champ> bothList = Collections.synchronizedList(new ArrayList());
    private List<KeyStone> KeyStoneList = Collections.synchronizedList(new ArrayList());
    private List<Spell> SpellList = Collections.synchronizedList(new ArrayList());
    private Button generate;
    private Spinner champdrop;
    private SoundPool splash;
    private int splashID;
    private int index;
    private boolean checked = false;
    int height, width = 0;
    DisplayMetrics displayMetrics;
    CheckBox jgbox;
    ArrayAdapter<String> myadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if (isNetworkAvailable()) {
            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }


        rift.start();
        displayMetrics = new DisplayMetrics();

        WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);

        width = Math.round(displayMetrics.widthPixels / displayMetrics.density);
        height = Math.round(displayMetrics.heightPixels / displayMetrics.density);
        jgbox = (CheckBox) Main2Activity.this.findViewById((R.id.checkBox));
        generate = (Button) Main2Activity.this.findViewById(R.id.button);
        view1 = (ImageView) Main2Activity.this.findViewById(R.id.bootsview);
        view2 = (ImageView) Main2Activity.this.findViewById(R.id.icon2);
        view3 = (ImageView) Main2Activity.this.findViewById(R.id.icon3);
        view4 = (ImageView) Main2Activity.this.findViewById(R.id.icon4);
        view5 = (ImageView) Main2Activity.this.findViewById(R.id.icon5);
        view6 = (ImageView) Main2Activity.this.findViewById(R.id.icon6);
        view7 = (ImageView) Main2Activity.this.findViewById(R.id.icon7);
        view8 = (ImageView) Main2Activity.this.findViewById(R.id.banner2);
        keyStoneView = (ImageView) Main2Activity.this.findViewById(R.id.keystone);
        sspell1View = (ImageView) Main2Activity.this.findViewById(R.id.sspell1);
        sspell2View = (ImageView) Main2Activity.this.findViewById(R.id.sspell2);

        champdrop = (Spinner) findViewById(R.id.champdrop);


        Resources r = getResources();
        px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (width - 30) / 6, r.getDisplayMetrics());
        px2 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (height / 10), r.getDisplayMetrics());
        champx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (height / 5), r.getDisplayMetrics());
        bannerWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (width - 20), r.getDisplayMetrics());
        bannerHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (height / 10), r.getDisplayMetrics());
        keyW = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (width - 60) / 6, r.getDisplayMetrics());
        keyH = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (width - 60) / 6, r.getDisplayMetrics());
        sspellsize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (width - 10) / 5, r.getDisplayMetrics());

//set view size
        view1.getLayoutParams().width = (int) px;
        view1.getLayoutParams().height = (int) px2;
        view2.getLayoutParams().width = (int) px;
        view2.getLayoutParams().height = (int) px2;
        view3.getLayoutParams().width = (int) px;
        view3.getLayoutParams().height = (int) px2;
        view4.getLayoutParams().width = (int) px;
        view4.getLayoutParams().height = (int) px2;
        view5.getLayoutParams().width = (int) px;
        view5.getLayoutParams().height = (int) px2;
        view6.getLayoutParams().width = (int) px;
        view6.getLayoutParams().height = (int) px2;
        view7.getLayoutParams().width = (int) champx;
        view7.getLayoutParams().height = (int) champx;
        view8.getLayoutParams().width = (int) bannerWidth;
        view8.getLayoutParams().height = (int) bannerHeight;
        keyStoneView.getLayoutParams().height = (int) keyH;
        keyStoneView.getLayoutParams().width = (int) keyW;
        sspell1View.getLayoutParams().width = (int) sspellsize;
        sspell1View.getLayoutParams().height = (int) sspellsize;
        sspell2View.getLayoutParams().width = (int) sspellsize;
        sspell2View.getLayoutParams().height = (int) sspellsize;
//set view source pics
        view1.setBackgroundResource(R.drawable.qmark1);
        view2.setBackgroundResource(R.drawable.qmark1);
        view3.setBackgroundResource(R.drawable.qmark1);
        view4.setBackgroundResource(R.drawable.qmark1);
        view5.setBackgroundResource(R.drawable.qmark1);
        view6.setBackgroundResource(R.drawable.qmark1);
        view7.setBackgroundResource(R.drawable.kappa);
        keyStoneView.setBackgroundResource(R.drawable.qmark1);
        sspell1View.setBackgroundResource(R.drawable.qmark2);
        sspell2View.setBackgroundResource(R.drawable.qmark2);

        Main2Activity.this.setBootsList();
        setSplash();
        setjgList();
        setbothList();
        new myAsyntask().execute();

        myadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DropList);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();





            jgbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { // checkbox
                    if (isChecked) {
                        checked = true;
                    } else {
                        checked = false;
                    }
                }
            });


            generate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    rift.stop();
                    rift = MediaPlayer.create(Main2Activity.this, R.raw.rift);
                    Collections.shuffle(champList);
                    Collections.shuffle(KeyStoneList);
                    Collections.shuffle(SpellList);
                    ;

                    splash.play(splashID, 1, 1, 1, 0, 1);
                    String champStr = champdrop.getSelectedItem().toString();
                    AnimationDrawable champAnimation = new AnimationDrawable();
                    champAnimation.setOneShot(true);
                    AnimationDrawable keyStoneAnimation = new AnimationDrawable();
                    keyStoneAnimation.setOneShot(true);

                    AnimationDrawable spell1Animation = new AnimationDrawable();
                    spell1Animation.setOneShot(true);
                    AnimationDrawable spell2Animation = new AnimationDrawable();
                    spell2Animation.setOneShot(true);


                    if (champStr.equals("Random")) {
                        index = 9;

                        for (int d = 0; d < 10; d++) {
                            champAnimation.addFrame(getResources().getDrawable
                                    (champList.get(d).champIcon), 50);
                        }  // champion icon anime
                    } else {
                        for (int i = 0; i < champList.size(); i++) {
                            if (champList.get(i).name.equals(champStr)) {
                                index = i;

                                champAnimation.addFrame(getResources().getDrawable
                                        (champList.get(index).champIcon), 50);

                            }
                        }
                    }
                    //keystone Animation
                    for (int i = 0; i < KeyStoneList.size(); i++) {
                        keyStoneAnimation.addFrame(getResources().getDrawable(KeyStoneList.get(i).
                                getKeyStone()), 100);
                    }

                    //spell 1+2 animation
                    Spell spelltemp = null, spelltemp2 = null;
                    if (checked) {
                        spell1Animation.addFrame(getResources().getDrawable(R.drawable.smite), 150);
                        spelltemp = new Spell(R.drawable.smite, "Smite");
                        for (int i = 0; i < SpellList.size(); i++) {
                            if (SpellList.get(i).getSpell() != R.drawable.smite) {
                                spell2Animation.addFrame(getResources().getDrawable(SpellList.get(i).getSpell()), 250);
                                spelltemp2 = SpellList.get(i);
                            }
                        }

                    } else {

                        for (int i = 0; i < SpellList.size(); i++) {
                            if (SpellList.get(i).getSpell() != R.drawable.smite) {
                                spell2Animation.addFrame(getResources().getDrawable(SpellList.get(i).getSpell()), 150);
                                spelltemp2 = SpellList.get(i);
                            }
                        }

                        for (int i = 0; i < SpellList.size(); i++) {
                            if (SpellList.get(i) != spelltemp2
                                    && (SpellList.get(i).getSpell() != R.drawable.smite)) {
                                spell1Animation.addFrame(getResources().getDrawable(SpellList.get(i).getSpell()), 250);
                                spelltemp = SpellList.get(i);
                            }
                        }

                    }

                    final Spell spell1 = spelltemp;
                    final Spell spell2 = spelltemp2;

                    Champ champ = new Champ(champList.get(index).champIcon, champList.get(index)
                            .champSound, champList.get(index).name, champList.get(index).role);


                    final Champ temp = champ;


                    champSD = MediaPlayer.create(Main2Activity.this, champ.champSound);
                    if (MainActivity.toggle.isChecked()) {
                        champSD.setVolume(0, 0);
                        ;
                    } else {
                        champSD.setVolume(1, 1);
                    }
                    champSD.start();


                    champSD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            generate.setEnabled(true);
                            mp.reset();
                            champList.remove(index);
                            champList.add(index, temp);
                        }
                    });


                    view1.setBackgroundColor(Color.rgb(0, 0, 0));
                    view2.setBackgroundColor(Color.rgb(0, 0, 0));
                    view3.setBackgroundColor(Color.rgb(0, 0, 0));
                    view4.setBackgroundColor(Color.rgb(0, 0, 0));
                    view5.setBackgroundColor(Color.rgb(0, 0, 0));
                    view6.setBackgroundColor(Color.rgb(0, 0, 0));
                    keyStoneView.setBackgroundColor(Color.rgb(0, 0, 0));
                    sspell1View.setBackgroundColor(Color.rgb(0, 0, 0));
                    sspell2View.setBackgroundColor(Color.rgb(0, 0, 0));


                    AnimationDrawable bootsAnimation = new AnimationDrawable();
                    bootsAnimation.setOneShot(true);
                    Collections.shuffle(bootsList);

                    AnimationDrawable iconsAnimation = new AnimationDrawable();
                    iconsAnimation.setOneShot(true);

                    AnimationDrawable icon3Animation = new AnimationDrawable();
                    icon3Animation.setOneShot(true);

                    AnimationDrawable icon4Animation = new AnimationDrawable();
                    icon4Animation.setOneShot(true);

                    AnimationDrawable icon5Animation = new AnimationDrawable();
                    icon5Animation.setOneShot(true);

                    AnimationDrawable icon6Animation = new AnimationDrawable();
                    icon6Animation.setOneShot(true);


                    if (checked) {

                        if (champ.champIcon == R.drawable.cassiopia) {  //checked cassiopia
                            setrangeItemList();
                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 5; i++) {
                                bootsAnimation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100); // first item
                            }

                            rangeItemList.remove(4);


                            Collections.shuffle(jgList);
                            for (int i = 0; i < 10; i++) {
                                iconsAnimation.addFrame(getResources().getDrawable(jgList.get(i)), 100); // second item(jg)
                            }
                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 15; i++) {
                                icon3Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100); //third slot
                            }

                            rangeItemList.remove(14);


                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 20; i++) {
                                icon4Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);//forth slot
                            }

                            rangeItemList.remove(19);


                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 25; i++) {
                                icon5Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);//fifth slot
                            }

                            rangeItemList.remove(24);


                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 30; i++) {
                                icon6Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);
                            }

                            rangeItemList.remove(29);

                            // icon is not cassipoia (checked)
                        } else if (rangeList.contains(champ) && champ.champIcon != R.drawable.cassiopia) {  //non-cass range champ(jg)
                            Collections.shuffle(bootsList);
                            for (int i = 0; i < 5; i++) {
                                bootsAnimation.addFrame(getResources().getDrawable(bootsList.get(i)), 100);
                            }

                            Collections.shuffle(jgList);
                            for (int i = 0; i < 10; i++) {
                                iconsAnimation.addFrame(getResources().getDrawable(jgList.get(i)), 100);
                            }

                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 15; i++) {
                                icon3Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100); //third slot
                            }

                            rangeItemList.remove(14);


                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 20; i++) {
                                icon4Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);//forth slot
                            }

                            rangeItemList.remove(19);

                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 25; i++) {
                                icon5Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);//fifth slot
                            }

                            rangeItemList.remove(24);


                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 30; i++) {
                                icon6Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);//sisth slot
                            }

                            rangeItemList.remove(29);


                        } else if (meleeList.contains(champ)) {
                            Collections.shuffle(bootsList);
                            for (int i = 0; i < 5; i++) {
                                bootsAnimation.addFrame(getResources().getDrawable(bootsList.get(i)), 100);
                            }
                            Collections.shuffle(jgList);
                            for (int i = 0; i < 10; i++) {
                                iconsAnimation.addFrame(getResources().getDrawable(jgList.get(i)), 100);
                            }
                            Collections.shuffle(meleeItemList);
                            for (int i = 0; i < 15; i++) {
                                icon3Animation.addFrame((getResources().getDrawable(meleeItemList.get(i))), 100);
                            }
                            meleeItemList.remove(14);


                            Collections.shuffle(meleeItemList);
                            for (int i = 0; i < 20; i++) {
                                icon4Animation.addFrame((getResources().getDrawable(meleeItemList.get(i))), 100);
                            }

                            meleeItemList.remove(19);

                            Collections.shuffle(meleeItemList);
                            for (int i = 0; i < 25; i++) {
                                icon5Animation.addFrame((getResources().getDrawable(meleeItemList.get(i))), 100);
                            }

                            meleeItemList.remove(24);

                            Collections.shuffle(meleeItemList);
                            for (int i = 0; i < 30; i++) {
                                icon6Animation.addFrame((getResources().getDrawable(meleeItemList.get(i))), 100);
                            }

                            meleeItemList.remove(29);


                        } else if (bothList.contains(champ)) {
                            Collections.shuffle(bootsList);
                            for (int i = 0; i < 5; i++) {
                                bootsAnimation.addFrame(getResources().getDrawable(bootsList.get(i)), 100);
                            }
                            Collections.shuffle(jgList);
                            for (int i = 0; i < 10; i++) {
                                iconsAnimation.addFrame(getResources().getDrawable(jgList.get(i)), 100);
                            }
                            Collections.shuffle(nonjgItemList);
                            for (int i = 0; i < 15; i++) {
                                icon3Animation.addFrame((getResources().getDrawable(nonjgItemList.get(i))), 100);
                            }

                            nonjgItemList.remove(14);


                            Collections.shuffle(nonjgItemList);
                            for (int i = 0; i < 20; i++) {
                                icon4Animation.addFrame((getResources().getDrawable(nonjgItemList.get(i))), 100);
                            }

                            nonjgItemList.remove(19);


                            Collections.shuffle(nonjgItemList);
                            for (int i = 0; i < 25; i++) {
                                icon5Animation.addFrame((getResources().getDrawable(nonjgItemList.get(i))), 100);
                            }

                            nonjgItemList.remove(24);


                            Collections.shuffle(nonjgItemList);
                            for (int i = 0; i < 30; i++) {
                                icon6Animation.addFrame((getResources().getDrawable(nonjgItemList.get(i))), 100);
                            }

                            nonjgItemList.remove(29);

                        }
/**********************************************************************/

                    } else { //checkbox unchecked condition
                        if (champ.champIcon == R.drawable.cassiopia) {  //unchecked cassiopia
                            setrangeItemList();
                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 5; i++) {
                                bootsAnimation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100); // first item
                            }

                            rangeItemList.remove(4);


                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 10; i++) {
                                iconsAnimation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100); // second item()
                            }
                            rangeItemList.remove(9);
                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 15; i++) {
                                icon3Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100); //third slot
                            }

                            rangeItemList.remove(14);


                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 20; i++) {
                                icon4Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);//forth slot
                            }

                            rangeItemList.remove(19);


                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 25; i++) {
                                icon5Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);//fifth slot
                            }

                            rangeItemList.remove(24);


                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 30; i++) {
                                icon6Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);
                            }

                            rangeItemList.remove(29);

                            // icon is not cassipoia (unchecked)
                        } else if (rangeList.contains(champ) && champ.champIcon != R.drawable.cassiopia) {  //non-cass range champ(jg)
                            Collections.shuffle(bootsList);
                            for (int i = 0; i < 5; i++) {
                                bootsAnimation.addFrame(getResources().getDrawable(bootsList.get(i)), 100);
                            }

                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 10; i++) {
                                iconsAnimation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);
                            }
                            rangeItemList.remove(9);

                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 15; i++) {
                                icon3Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100); //third slot
                            }

                            rangeItemList.remove(14);


                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 20; i++) {
                                icon4Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);//forth slot
                            }

                            rangeItemList.remove(19);

                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 25; i++) {
                                icon5Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);//fifth slot
                            }

                            rangeItemList.remove(24);


                            Collections.shuffle(rangeItemList);
                            for (int i = 0; i < 30; i++) {
                                icon6Animation.addFrame(getResources().getDrawable(rangeItemList.get(i)), 100);//sisth slot
                            }

                            rangeItemList.remove(29);


                        } else if (meleeList.contains(champ)) {
                            Collections.shuffle(bootsList);
                            for (int i = 0; i < 5; i++) {
                                bootsAnimation.addFrame(getResources().getDrawable(bootsList.get(i)), 100);
                            }
                            Collections.shuffle(meleeItemList);
                            for (int i = 0; i < 10; i++) {
                                iconsAnimation.addFrame(getResources().getDrawable(meleeItemList.get(i)), 100);
                            }
                            meleeItemList.remove(9);
                            Collections.shuffle(meleeItemList);
                            for (int i = 0; i < 15; i++) {
                                icon3Animation.addFrame((getResources().getDrawable(meleeItemList.get(i))), 100);
                            }
                            meleeItemList.remove(14);


                            Collections.shuffle(meleeItemList);
                            for (int i = 0; i < 20; i++) {
                                icon4Animation.addFrame((getResources().getDrawable(meleeItemList.get(i))), 100);
                            }

                            meleeItemList.remove(19);

                            Collections.shuffle(meleeItemList);
                            for (int i = 0; i < 25; i++) {
                                icon5Animation.addFrame((getResources().getDrawable(meleeItemList.get(i))), 100);
                            }

                            meleeItemList.remove(24);

                            Collections.shuffle(meleeItemList);
                            for (int i = 0; i < 30; i++) {
                                icon6Animation.addFrame((getResources().getDrawable(meleeItemList.get(i))), 100);
                            }

                            meleeItemList.remove(29);


                        } else if (bothList.contains(champ)) {
                            Collections.shuffle(bootsList);
                            for (int i = 0; i < 5; i++) {
                                bootsAnimation.addFrame(getResources().getDrawable(bootsList.get(i)), 100);
                            }
                            Collections.shuffle(nonjgItemList);
                            for (int i = 0; i < 10; i++) {
                                iconsAnimation.addFrame(getResources().getDrawable(nonjgItemList.get(i)), 100);
                            }
                            nonjgItemList.remove(9);
                            Collections.shuffle(nonjgItemList);
                            for (int i = 0; i < 15; i++) {
                                icon3Animation.addFrame((getResources().getDrawable(nonjgItemList.get(i))), 100);
                            }

                            nonjgItemList.remove(14);


                            Collections.shuffle(nonjgItemList);
                            for (int i = 0; i < 20; i++) {
                                icon4Animation.addFrame((getResources().getDrawable(nonjgItemList.get(i))), 100);
                            }

                            nonjgItemList.remove(19);


                            Collections.shuffle(nonjgItemList);
                            for (int i = 0; i < 25; i++) {
                                icon5Animation.addFrame((getResources().getDrawable(nonjgItemList.get(i))), 100);
                            }

                            nonjgItemList.remove(24);


                            Collections.shuffle(nonjgItemList);
                            for (int i = 0; i < 30; i++) {
                                icon6Animation.addFrame((getResources().getDrawable(nonjgItemList.get(i))), 100);
                            }

                            nonjgItemList.remove(29);
                        }
                    }


                    bootsAnimation.stop();
                    view1.setImageDrawable(bootsAnimation);
                    bootsAnimation.start();

                    iconsAnimation.stop();
                    view2.setImageDrawable(iconsAnimation);
                    iconsAnimation.start();

                    icon3Animation.stop();
                    view3.setImageDrawable(icon3Animation);
                    icon3Animation.start();

                    icon4Animation.stop();
                    view4.setImageDrawable(icon4Animation);
                    icon4Animation.start();

                    icon5Animation.stop();
                    view5.setImageDrawable(icon5Animation);
                    icon5Animation.start();

                    icon6Animation.stop();
                    view6.setImageDrawable(icon6Animation);
                    icon6Animation.start();

                    champAnimation.stop();
                    view7.setImageDrawable(champAnimation);
                    champAnimation.start();

                    keyStoneAnimation.stop();
                    keyStoneView.setImageDrawable(keyStoneAnimation);
                    keyStoneAnimation.start();

                    spell1Animation.stop();
                    sspell1View.setImageDrawable(spell1Animation);
                    spell1Animation.start();

                    spell2Animation.stop();
                    sspell2View.setImageDrawable(spell2Animation);
                    spell2Animation.start();

                    view7.setOnClickListener(new View.OnClickListener() {
                        //two mediaplayer

                        @Override
                        public void onClick(View view) {
                            Context context = getApplicationContext();
                            CharSequence text = temp.name;
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        }
                    });

                    keyStoneView.setOnClickListener(new View.OnClickListener() {
                        //two mediaplayer

                        @Override
                        public void onClick(View view) {
                            Context context = getApplicationContext();
                            CharSequence text = KeyStoneList.get(KeyStoneList.size() - 1).getKeyStoneName();
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        }
                    });
                    sspell1View.setOnClickListener(new View.OnClickListener() {
                        //two mediaplayer

                        @Override
                        public void onClick(View view) {
                            Context context = getApplicationContext();
                            CharSequence text = spell1.getSpellName();
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        }
                    });
                    sspell2View.setOnClickListener(new View.OnClickListener() {
                        //two mediaplayer

                        @Override
                        public void onClick(View view) {
                            Context context = getApplicationContext();
                            CharSequence text = spell2.getSpellName();
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        }
                    });
                    nonjgItemList.clear();
                    meleeItemList.clear();
                    rangeItemList.clear();
                    new myAsyntask2().execute();


                    if (champSD.isPlaying()) {
                        generate.setEnabled(false);
                    }


                }
            });
        }






    protected void setSplash() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            splash = new SoundPool.Builder().setMaxStreams(1).build();
            splashID = splash.load(Main2Activity.this, R.raw.air_button_press_7, 1);
        } else {
            splash = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
            splashID = splash.load(Main2Activity.this, R.raw.air_button_press_7, 1);
        }
    }

    protected void setDroplist() {
        DropList.add(0, "Random");
        for (int i = 0; i < champList.size(); i++) {
            DropList.add(champList.get(i).name);
        }

    }

    protected void setKeyStoneList() {
        KeyStoneList.add(new KeyStone(R.drawable.courage, "Courage Of The Colossus"));
        KeyStoneList.add(new KeyStone(R.drawable.grasp, "Grasp Of The Undying"));
        KeyStoneList.add(new KeyStone(R.drawable.stone, "Stoneborn Pact"));
        KeyStoneList.add(new KeyStone(R.drawable.stormraider, "Stormraider's Surge"));
        KeyStoneList.add(new KeyStone(R.drawable.thunderlord, "Thunderlord's Decree"));
        KeyStoneList.add(new KeyStone(R.drawable.windspeaker, "Windspeaker's Blessing"));
        KeyStoneList.add(new KeyStone(R.drawable.deathfire, "Deathfire Touch"));
        KeyStoneList.add(new KeyStone(R.drawable.fervor, "Fervor Of Battle"));
        KeyStoneList.add(new KeyStone(R.drawable.warlord, "Warloard's Bloodlust"));


    }
    protected void setSpellList(){
        SpellList.add(new Spell(R.drawable.ghost,"Ghost"));
        SpellList.add(new Spell(R.drawable.flash,"Flash"));
        SpellList.add(new Spell(R.drawable.barrier,"Barrier"));
        SpellList.add(new Spell(R.drawable.exhaust,"Exhaust"));
        SpellList.add(new Spell(R.drawable.heal,"Heal"));
        SpellList.add(new Spell(R.drawable.ignite,"Ignite"));
        SpellList.add(new Spell(R.drawable.cleanse,"Cleanse"));
        SpellList.add(new Spell(R.drawable.teleport,"Teleport"));
        SpellList.add(new Spell(R.drawable.smite,"Smite"));

    }


    protected void setmeleeItemList() {
        meleeItemList.add(R.drawable.icon1);
        meleeItemList.add(R.drawable.icon8);
        meleeItemList.add(R.drawable.icon10);
        meleeItemList.add(R.drawable.icon11);
        meleeItemList.add(R.drawable.icon12);
        meleeItemList.add(R.drawable.icon13);
        meleeItemList.add(R.drawable.icon14);
        meleeItemList.add(R.drawable.icon18);
        meleeItemList.add(R.drawable.icon19);
        meleeItemList.add(R.drawable.icon20);
        meleeItemList.add(R.drawable.icon21);
        meleeItemList.add(R.drawable.icon22);
        meleeItemList.add(R.drawable.icon23);
        meleeItemList.add(R.drawable.icon24);
        meleeItemList.add(R.drawable.icon25);
        meleeItemList.add(R.drawable.icon26);
        meleeItemList.add(R.drawable.icon27);
        meleeItemList.add(R.drawable.icon28);
        meleeItemList.add(R.drawable.icon29);
        meleeItemList.add(R.drawable.icon30);
        meleeItemList.add(R.drawable.icon31);
        meleeItemList.add(R.drawable.icon32);
        meleeItemList.add(R.drawable.icon33);
        meleeItemList.add(R.drawable.icon34);
        meleeItemList.add(R.drawable.icon35);
        meleeItemList.add(R.drawable.icon36);
        meleeItemList.add(R.drawable.icon37);
        meleeItemList.add(R.drawable.icon38);
        meleeItemList.add(R.drawable.icon39);
        meleeItemList.add(R.drawable.icon40);
        meleeItemList.add(R.drawable.icon42);
        meleeItemList.add(R.drawable.icon43);
        meleeItemList.add(R.drawable.icon44);
        meleeItemList.add(R.drawable.icon45);
        meleeItemList.add(R.drawable.icon46);
        meleeItemList.add(R.drawable.icon47);
        meleeItemList.add(R.drawable.icon48);
        meleeItemList.add(R.drawable.icon49);
        meleeItemList.add(R.drawable.icon51);
        meleeItemList.add(R.drawable.icon52);
        meleeItemList.add(R.drawable.icon53);
        meleeItemList.add(R.drawable.icon54);
        meleeItemList.add(R.drawable.icon55);
        meleeItemList.add(R.drawable.icon56);
        meleeItemList.add(R.drawable.icon57);
        meleeItemList.add(R.drawable.icon58);
        meleeItemList.add(R.drawable.icon59);
        meleeItemList.add(R.drawable.icon61);
        meleeItemList.add(R.drawable.icon62);
        meleeItemList.add(R.drawable.icon63);
        meleeItemList.add(R.drawable.icon64);
        meleeItemList.add(R.drawable.icon65);
        meleeItemList.add(R.drawable.icon67);
        meleeItemList.add(R.drawable.icon68);
        meleeItemList.add(R.drawable.icon70);
        meleeItemList.add(R.drawable.icon71);
        meleeItemList.add(R.drawable.icon72);
        meleeItemList.add(R.drawable.icon74);
        meleeItemList.add(R.drawable.icon75);
        meleeItemList.add(R.drawable.icon76);
        meleeItemList.add(R.drawable.icon77);
        meleeItemList.add(R.drawable.icon78);
        meleeItemList.add(R.drawable.icon80);
        meleeItemList.add(R.drawable.icon81);
        meleeItemList.add(R.drawable.icon82);
        meleeItemList.add(R.drawable.icon83);
        meleeItemList.add(R.drawable.icon84);
    }

    protected void setrangeItemList() {
        rangeItemList.add(R.drawable.icon1);
        rangeItemList.add(R.drawable.icon8);
        rangeItemList.add(R.drawable.icon10);
        rangeItemList.add(R.drawable.icon11);
        rangeItemList.add(R.drawable.icon12);
        rangeItemList.add(R.drawable.icon13);
        rangeItemList.add(R.drawable.icon14);
        rangeItemList.add(R.drawable.icon16);
        rangeItemList.add(R.drawable.icon18);
        rangeItemList.add(R.drawable.icon19);
        rangeItemList.add(R.drawable.icon20);
        rangeItemList.add(R.drawable.icon21);
        rangeItemList.add(R.drawable.icon22);
        rangeItemList.add(R.drawable.icon23);
        rangeItemList.add(R.drawable.icon24);
        rangeItemList.add(R.drawable.icon25);
        rangeItemList.add(R.drawable.icon26);
        rangeItemList.add(R.drawable.icon27);
        rangeItemList.add(R.drawable.icon28);
        rangeItemList.add(R.drawable.icon29);
        rangeItemList.add(R.drawable.icon30);
        rangeItemList.add(R.drawable.icon31);
        rangeItemList.add(R.drawable.icon33);
        rangeItemList.add(R.drawable.icon34);
        rangeItemList.add(R.drawable.icon35);
        rangeItemList.add(R.drawable.icon36);
        rangeItemList.add(R.drawable.icon37);
        rangeItemList.add(R.drawable.icon38);
        rangeItemList.add(R.drawable.icon39);
        rangeItemList.add(R.drawable.icon40);
        rangeItemList.add(R.drawable.icon42);
        rangeItemList.add(R.drawable.icon43);
        rangeItemList.add(R.drawable.icon45);
        rangeItemList.add(R.drawable.icon46);
        rangeItemList.add(R.drawable.icon47);
        rangeItemList.add(R.drawable.icon48);
        rangeItemList.add(R.drawable.icon49);
        rangeItemList.add(R.drawable.icon51);
        rangeItemList.add(R.drawable.icon52);
        rangeItemList.add(R.drawable.icon53);
        rangeItemList.add(R.drawable.icon54);
        rangeItemList.add(R.drawable.icon55);
        rangeItemList.add(R.drawable.icon56);
        rangeItemList.add(R.drawable.icon57);
        rangeItemList.add(R.drawable.icon58);
        rangeItemList.add(R.drawable.icon59);
        rangeItemList.add(R.drawable.icon61);
        rangeItemList.add(R.drawable.icon62);
        rangeItemList.add(R.drawable.icon63);
        rangeItemList.add(R.drawable.icon64);
        rangeItemList.add(R.drawable.icon65);
        rangeItemList.add(R.drawable.icon67);
        rangeItemList.add(R.drawable.icon68);
        rangeItemList.add(R.drawable.icon70);
        rangeItemList.add(R.drawable.icon71);
        rangeItemList.add(R.drawable.icon72);
        rangeItemList.add(R.drawable.icon74);
        rangeItemList.add(R.drawable.icon75);
        rangeItemList.add(R.drawable.icon76);
        rangeItemList.add(R.drawable.icon77);
        rangeItemList.add(R.drawable.icon78);
        rangeItemList.add(R.drawable.icon80);
        rangeItemList.add(R.drawable.icon81);
        rangeItemList.add(R.drawable.icon82);
        rangeItemList.add(R.drawable.icon83);
        rangeItemList.add(R.drawable.icon84);
    }

    protected void setnonjgItemList() {
        nonjgItemList.add(R.drawable.icon1);
        nonjgItemList.add(R.drawable.icon8);
        nonjgItemList.add(R.drawable.icon10);
        nonjgItemList.add(R.drawable.icon11);
        nonjgItemList.add(R.drawable.icon12);
        nonjgItemList.add(R.drawable.icon13);
        nonjgItemList.add(R.drawable.icon14);
        nonjgItemList.add(R.drawable.icon16);
        nonjgItemList.add(R.drawable.icon18);
        nonjgItemList.add(R.drawable.icon19);
        nonjgItemList.add(R.drawable.icon20);
        nonjgItemList.add(R.drawable.icon21);
        nonjgItemList.add(R.drawable.icon22);
        nonjgItemList.add(R.drawable.icon23);
        nonjgItemList.add(R.drawable.icon24);
        nonjgItemList.add(R.drawable.icon25);
        nonjgItemList.add(R.drawable.icon26);
        nonjgItemList.add(R.drawable.icon27);
        nonjgItemList.add(R.drawable.icon28);
        nonjgItemList.add(R.drawable.icon29);
        nonjgItemList.add(R.drawable.icon30);
        nonjgItemList.add(R.drawable.icon31);
        nonjgItemList.add(R.drawable.icon32);
        nonjgItemList.add(R.drawable.icon33);
        nonjgItemList.add(R.drawable.icon34);
        nonjgItemList.add(R.drawable.icon35);
        nonjgItemList.add(R.drawable.icon36);
        nonjgItemList.add(R.drawable.icon37);
        nonjgItemList.add(R.drawable.icon38);
        nonjgItemList.add(R.drawable.icon39);
        nonjgItemList.add(R.drawable.icon40);
        nonjgItemList.add(R.drawable.icon42);
        nonjgItemList.add(R.drawable.icon43);
        nonjgItemList.add(R.drawable.icon44);
        nonjgItemList.add(R.drawable.icon45);
        nonjgItemList.add(R.drawable.icon46);
        nonjgItemList.add(R.drawable.icon47);
        nonjgItemList.add(R.drawable.icon48);
        nonjgItemList.add(R.drawable.icon49);
        nonjgItemList.add(R.drawable.icon51);
        nonjgItemList.add(R.drawable.icon52);
        nonjgItemList.add(R.drawable.icon53);
        nonjgItemList.add(R.drawable.icon54);
        nonjgItemList.add(R.drawable.icon55);
        nonjgItemList.add(R.drawable.icon56);
        nonjgItemList.add(R.drawable.icon57);
        nonjgItemList.add(R.drawable.icon58);
        nonjgItemList.add(R.drawable.icon59);
        nonjgItemList.add(R.drawable.icon61);
        nonjgItemList.add(R.drawable.icon62);
        nonjgItemList.add(R.drawable.icon63);
        nonjgItemList.add(R.drawable.icon64);
        nonjgItemList.add(R.drawable.icon65);
        nonjgItemList.add(R.drawable.icon67);
        nonjgItemList.add(R.drawable.icon68);
        nonjgItemList.add(R.drawable.icon70);
        nonjgItemList.add(R.drawable.icon71);
        nonjgItemList.add(R.drawable.icon72);
        nonjgItemList.add(R.drawable.icon74);
        nonjgItemList.add(R.drawable.icon75);
        nonjgItemList.add(R.drawable.icon76);
        nonjgItemList.add(R.drawable.icon77);
        nonjgItemList.add(R.drawable.icon78);
        nonjgItemList.add(R.drawable.icon80);
        nonjgItemList.add(R.drawable.icon81);
        nonjgItemList.add(R.drawable.icon82);
        nonjgItemList.add(R.drawable.icon83);
        nonjgItemList.add(R.drawable.icon84);
    }


    protected void setBootsList() {

        bootsList.add(R.drawable.imageb1);
        bootsList.add(R.drawable.imageb2);
        bootsList.add(R.drawable.imageb4);
        bootsList.add(R.drawable.imageb5);
        bootsList.add(R.drawable.imageb6);
        bootsList.add(R.drawable.imageb7);


    }

   /* protected void setIconsList() {
        iconsList.add(R.drawable.icon1);
        iconsList.add(R.drawable.icon2);
        iconsList.add(R.drawable.icon3);
        iconsList.add(R.drawable.icon4);
        iconsList.add(R.drawable.icon5);
        iconsList.add(R.drawable.icon6);
        iconsList.add(R.drawable.icon7);
        iconsList.add(R.drawable.icon8);
        iconsList.add(R.drawable.icon9);
        iconsList.add(R.drawable.icon10);
        iconsList.add(R.drawable.icon11);
        iconsList.add(R.drawable.icon12);
        iconsList.add(R.drawable.icon13);
        iconsList.add(R.drawable.icon14);
        iconsList.add(R.drawable.icon15);
        iconsList.add(R.drawable.icon16);
        iconsList.add(R.drawable.icon17);
        iconsList.add(R.drawable.icon18);
        iconsList.add(R.drawable.icon19);
        iconsList.add(R.drawable.icon20);
        iconsList.add(R.drawable.icon21);
        iconsList.add(R.drawable.icon22);
        iconsList.add(R.drawable.icon23);
        iconsList.add(R.drawable.icon24);
        iconsList.add(R.drawable.icon25);
        iconsList.add(R.drawable.icon26);
        iconsList.add(R.drawable.icon27);
        iconsList.add(R.drawable.icon28);
        iconsList.add(R.drawable.icon29);
        iconsList.add(R.drawable.icon30);
        iconsList.add(R.drawable.icon31);
        iconsList.add(R.drawable.icon32);
        iconsList.add(R.drawable.icon33);
        iconsList.add(R.drawable.icon34);
        iconsList.add(R.drawable.icon35);
        iconsList.add(R.drawable.icon36);
        iconsList.add(R.drawable.icon37);
        iconsList.add(R.drawable.icon38);
        iconsList.add(R.drawable.icon39);
        iconsList.add(R.drawable.icon40);
        iconsList.add(R.drawable.icon42);
        iconsList.add(R.drawable.icon43);
        iconsList.add(R.drawable.icon44);
        iconsList.add(R.drawable.icon45);
        iconsList.add(R.drawable.icon46);
        iconsList.add(R.drawable.icon47);
        iconsList.add(R.drawable.icon48);
        iconsList.add(R.drawable.icon49);
        iconsList.add(R.drawable.icon50);
        iconsList.add(R.drawable.icon51);
        iconsList.add(R.drawable.icon52);
        iconsList.add(R.drawable.icon53);
        iconsList.add(R.drawable.icon54);
        iconsList.add(R.drawable.icon55);
        iconsList.add(R.drawable.icon56);
        iconsList.add(R.drawable.icon57);
        iconsList.add(R.drawable.icon58);
        iconsList.add(R.drawable.icon59);
        iconsList.add(R.drawable.icon60);
        iconsList.add(R.drawable.icon61);
        iconsList.add(R.drawable.icon62);
        iconsList.add(R.drawable.icon63);
        iconsList.add(R.drawable.icon64);
        iconsList.add(R.drawable.icon65);
        iconsList.add(R.drawable.icon67);
        iconsList.add(R.drawable.icon68);
        iconsList.add(R.drawable.icon70);
        iconsList.add(R.drawable.icon71);
        iconsList.add(R.drawable.icon72);
        iconsList.add(R.drawable.icon73);
        iconsList.add(R.drawable.icon74);
        iconsList.add(R.drawable.icon75);
        iconsList.add(R.drawable.icon76);
        iconsList.add(R.drawable.icon77);
        iconsList.add(R.drawable.icon78);
        iconsList.add(R.drawable.icon80);
        iconsList.add(R.drawable.icon81);
        iconsList.add(R.drawable.icon82);
        iconsList.add(R.drawable.icon83);


    }*/

    protected void setChampList() {
        champList.add(new Champ(R.drawable.aatrox, R.raw.aatrox, "Aatrox", "M"));
        champList.add(new Champ(R.drawable.ahri, R.raw.ahri, "Ahri", "R"));
        champList.add(new Champ(R.drawable.akali, R.raw.akali, "Akali", "M"));
        champList.add(new Champ(R.drawable.alistar, R.raw.alistar, "Alistar", "M"));
        champList.add(new Champ(R.drawable.amumu, R.raw.amumu, "Amumu", "M"));
        champList.add(new Champ(R.drawable.anivia, R.raw.anivia, "Anivia", "R"));
        champList.add(new Champ(R.drawable.annie, R.raw.annie, "Annie", "R"));
        champList.add(new Champ(R.drawable.ashe, R.raw.ashe, "Ashe", "R"));
        champList.add(new Champ(R.drawable.azir, R.raw.azir, "Azir", "R"));
        champList.add(new Champ(R.drawable.aurelionsol, R.raw.aurelionsol, "Aurelionsol", "R"));
        champList.add(new Champ(R.drawable.bard, R.raw.bard, "Bard", "R"));
        champList.add(new Champ(R.drawable.blitzcrank, R.raw.blitzcrank, "Blitzcrank", "M"));
        champList.add(new Champ(R.drawable.brand, R.raw.brand, "Brand", "R"));
        champList.add(new Champ(R.drawable.braum, R.raw.braum, "Braum", "M"));
        champList.add(new Champ(R.drawable.caitlyn, R.raw.caitlyn, "Caitlyn", "R"));
        champList.add(new Champ(R.drawable.camille, R.raw.camille, "Camille", "M"));
        champList.add(new Champ(R.drawable.cassiopia, R.raw.cassiopeia, "Cassiopeia", "R"));
        champList.add(new Champ(R.drawable.chogath, R.raw.chogath, "Chogath", "M"));
        champList.add(new Champ(R.drawable.corki, R.raw.corki, "Corki", "R"));
        champList.add(new Champ(R.drawable.darius, R.raw.darius, "Darius", "M"));
        champList.add(new Champ(R.drawable.dianna, R.raw.dianna, "Dianna", "M"));
        champList.add(new Champ(R.drawable.mundo, R.raw.mundo, "Dr.Mundo", "M"));
        champList.add(new Champ(R.drawable.draven, R.raw.draven, "Draven", "R"));
        champList.add(new Champ(R.drawable.ekko, R.raw.ekko, "Ekko", "M"));
        champList.add(new Champ(R.drawable.elise, R.raw.elise, "Elise", "B"));
        champList.add(new Champ(R.drawable.evelynn, R.raw.eveylynn, "Evelynn", "M"));
        champList.add(new Champ(R.drawable.ezreal, R.raw.ezreal, "Ezreal", "R"));
        champList.add(new Champ(R.drawable.fiddlestick, R.raw.fiddlestick, "FiddleStick", "R"));
        champList.add(new Champ(R.drawable.fiora, R.raw.fiora, "Fiora", "M"));
        champList.add(new Champ(R.drawable.fizz, R.raw.fizz, "Fizz", "M"));
        champList.add(new Champ(R.drawable.galio, R.raw.galio, "Galio", "M"));
        champList.add(new Champ(R.drawable.gangplank, R.raw.gangplank, "Grangplank", "M"));
        champList.add(new Champ(R.drawable.garen, R.raw.garen, "Garen", "M"));
        champList.add(new Champ(R.drawable.gragas, R.raw.gragas, "Gragas", "M"));
        champList.add(new Champ(R.drawable.graves, R.raw.graves, "Graves", "R"));
        champList.add(new Champ(R.drawable.gnar, R.raw.gnar, "Gnar", "B"));
        champList.add(new Champ(R.drawable.hecarim, R.raw.hecarim, "Hecarim", "M"));
        champList.add(new Champ(R.drawable.heimerdinge, R.raw.heimerdinger, "Heimerdinger", "R"));
        champList.add(new Champ(R.drawable.illaoi, R.raw.illaoi, "Illaoi", "M"));
        champList.add(new Champ(R.drawable.irelia, R.raw.irelia, "Irelia", "M"));
        champList.add(new Champ(R.drawable.ivern, R.raw.ivern, "Ivern", "B"));
        champList.add(new Champ(R.drawable.janna, R.raw.janna, "Janna", "R"));
        champList.add(new Champ(R.drawable.jarvan, R.raw.jarvan, "Jarvan", "M"));
        champList.add(new Champ(R.drawable.jax, R.raw.jax, "Jax", "M"));
        champList.add(new Champ(R.drawable.jayce, R.raw.jayce, "Jayce", "B"));
        champList.add(new Champ(R.drawable.jhin, R.raw.jhin, "Jhin", "R"));
        champList.add(new Champ(R.drawable.jinx, R.raw.jinx, "Jinx", "R"));
        champList.add(new Champ(R.drawable.kalista, R.raw.kalista, "Kalista", "R"));
        champList.add(new Champ(R.drawable.karma, R.raw.karma, "Karma", "R"));
        champList.add(new Champ(R.drawable.karthus, R.raw.karthus, "Karthus", "R"));
        champList.add(new Champ(R.drawable.kassaidin, R.raw.kassadin, "Kassdin", "M"));
        champList.add(new Champ(R.drawable.katarina, R.raw.katarina, "Katarina", "M"));
        champList.add(new Champ(R.drawable.kayle, R.raw.kayle, "Kayle", "B"));
        champList.add(new Champ(R.drawable.kayn,R.raw.kayn,"Kayn","M"));
        champList.add(new Champ(R.drawable.kennen, R.raw.kennen, "Kennen", "R"));
        champList.add(new Champ(R.drawable.kindred, R.raw.kindred, "Kindred", "R"));
        champList.add(new Champ(R.drawable.khazix, R.raw.khazix, "Khazix", "M"));
        champList.add(new Champ(R.drawable.kled, R.raw.kled, "Kled", "M"));
        champList.add(new Champ(R.drawable.kogmow, R.raw.kogmow, "Kogmow", "R"));
        champList.add(new Champ(R.drawable.leblanc, R.raw.leblanc, "Leblanc", "R"));
        champList.add(new Champ(R.drawable.leesin, R.raw.leesin, "Lee Sin", "M"));
        champList.add(new Champ(R.drawable.leona, R.raw.leona, "Leonna", "M"));
        champList.add(new Champ(R.drawable.lissandra, R.raw.lissandra, "Lissandra", "R"));
        champList.add(new Champ(R.drawable.lucian, R.raw.lucian, "Lucian", "R"));
        champList.add(new Champ(R.drawable.lulu, R.raw.lulu, "Lulu", "R"));
        champList.add(new Champ(R.drawable.lux, R.raw.lux, "Lux", "R"));
        champList.add(new Champ(R.drawable.malphite, R.raw.malphite, "Malphite", "M"));
        champList.add(new Champ(R.drawable.malzahar, R.raw.malzahar, "Malzahar", "R"));
        champList.add(new Champ(R.drawable.maokai, R.raw.maokai, "Maokai", "M"));
        champList.add(new Champ(R.drawable.masteryi, R.raw.masteryi, "Master Yi", "M"));
        champList.add(new Champ(R.drawable.missfortune, R.raw.missfortune, "Miss Fortune", "R"));
        champList.add(new Champ(R.drawable.mordekiesar, R.raw.mord, "Mordekiesar", "M"));
        champList.add(new Champ(R.drawable.morganna, R.raw.morganna, "Morganna", "R"));
        champList.add(new Champ(R.drawable.nami, R.raw.nami, "Nami", "R"));
        champList.add(new Champ(R.drawable.nasus, R.raw.nasus, "Nasus", "M"));
        champList.add(new Champ(R.drawable.nautilus, R.raw.nautilus, "Nautilus", "M"));
        champList.add(new Champ(R.drawable.noctune, R.raw.noctune, "Noctune", "M"));
        champList.add(new Champ(R.drawable.nidaleee, R.raw.nidalee, "Nidalee", "B"));
        champList.add(new Champ(R.drawable.nunu, R.raw.nunu, "Nunu", "M"));
        champList.add(new Champ(R.drawable.olaf, R.raw.olaf, "Olaf", "M"));
        champList.add(new Champ(R.drawable.orianna, R.raw.orianna, "Orianna", "R"));
        champList.add(new Champ(R.drawable.pantheon, R.raw.pantheon, "Pantheon", "M"));
        champList.add(new Champ(R.drawable.poppy, R.raw.poppy, "Poppy", "M"));
        champList.add(new Champ(R.drawable.quinn, R.raw.quinn, "Quinn", "R"));
        champList.add(new Champ(R.drawable.ranmus, R.raw.rammus, "Rammus", "M"));
        champList.add(new Champ(R.drawable.rakan, R.raw.rakan, "Rakan", "M"));
        champList.add(new Champ(R.drawable.reksai, R.raw.reksai, "Reksai", "M"));
        champList.add(new Champ(R.drawable.renekton, R.raw.renekton, "Renekton", "R"));
        champList.add(new Champ(R.drawable.rengar, R.raw.rengar, "Rengar", "M"));
        champList.add(new Champ(R.drawable.riven, R.raw.riven, "Riven", "M"));
        champList.add(new Champ(R.drawable.rumble, R.raw.rumble, "Rumble", "M"));
        champList.add(new Champ(R.drawable.ryze, R.raw.ryze, "Ryze", "R"));
        champList.add(new Champ(R.drawable.sejuani, R.raw.sejuani, "Sejuani", "M"));
        champList.add(new Champ(R.drawable.shaco, R.raw.shaco, "Shaco", "M"));
        champList.add(new Champ(R.drawable.shen, R.raw.shen, "Shen", "M"));
        champList.add(new Champ(R.drawable.shyvanna, R.raw.shyvana, "Shyvanna", "M"));
        champList.add(new Champ(R.drawable.singed, R.raw.singed, "Singed", "M"));
        champList.add(new Champ(R.drawable.sion, R.raw.sion, "Sion", "M"));
        champList.add(new Champ(R.drawable.sivir, R.raw.sivir, "Sivir", "R"));
        champList.add(new Champ(R.drawable.skarner, R.raw.skarner, "Skarner", "M"));
        champList.add(new Champ(R.drawable.sona, R.raw.sona, "Sona", "R"));
        champList.add(new Champ(R.drawable.soraka, R.raw.soraka, "Soraka", "R"));
        champList.add(new Champ(R.drawable.swain, R.raw.swain, "Swain", "R"));
        champList.add(new Champ(R.drawable.syndra, R.raw.syndra, "Syndra", "R"));
        champList.add(new Champ(R.drawable.tahmkench, R.raw.tahmkench, "Tahm Kench", "M"));
        champList.add(new Champ(R.drawable.taliya, R.raw.taliyah, "Taliyah", "R"));
        champList.add(new Champ(R.drawable.teemo, R.raw.teemo, "Teemo", "R"));
        champList.add(new Champ(R.drawable.talon, R.raw.talon, "Talon", "M"));
        champList.add(new Champ(R.drawable.taric, R.raw.taric, "Taric", "M"));
        champList.add(new Champ(R.drawable.thresh, R.raw.thresh, "Thresh", "M"));
        champList.add(new Champ(R.drawable.tristina, R.raw.tristinna, "Tristinna", "R"));
        champList.add(new Champ(R.drawable.trundle, R.raw.trundle, "Trundle", "M"));
        champList.add(new Champ(R.drawable.tryndamare, R.raw.tryndamere, "Tryndamere", "M"));
        champList.add(new Champ(R.drawable.twistedfate, R.raw.twistedfate, "Twisted Fate", "R"));
        champList.add(new Champ(R.drawable.twitch, R.raw.twitch, "Twitch", "R"));
        champList.add(new Champ(R.drawable.udyr, R.raw.udyr, "Udyr", "M"));
        champList.add(new Champ(R.drawable.urgot, R.raw.urgot, "Urgot", "R"));
        champList.add(new Champ(R.drawable.varus, R.raw.varus, "Varus", "R"));
        champList.add(new Champ(R.drawable.vayne, R.raw.vayne, "Vayne", "R"));
        champList.add(new Champ(R.drawable.veigar, R.raw.veigar, "Veigar", "R"));
        champList.add(new Champ(R.drawable.velkoz, R.raw.velkoz, "Velkoz", "R"));
        champList.add(new Champ(R.drawable.vi, R.raw.vi, "Vi", "M"));
        champList.add(new Champ(R.drawable.viktor, R.raw.viktor, "Viktor", "R"));
        champList.add(new Champ(R.drawable.vladimir, R.raw.vladimir, "Vladimir", "R"));
        champList.add(new Champ(R.drawable.volibear, R.raw.volibear, "Volibear", "M"));
        champList.add(new Champ(R.drawable.warwick, R.raw.warwick, "Warwick", "M"));
        champList.add(new Champ(R.drawable.wukong, R.raw.wukong, "Wukong", "M"));
        champList.add(new Champ(R.drawable.xayah, R.raw.xayah, "Xayah", "M"));
        champList.add(new Champ(R.drawable.xerath, R.raw.xerath, "Xerath", "R"));
        champList.add(new Champ(R.drawable.xinzhao, R.raw.xinzhao, "Xin Zhao", "M"));
        champList.add(new Champ(R.drawable.yasuo, R.raw.yasuo, "Yasuo", "M"));
        champList.add(new Champ(R.drawable.yorick, R.raw.yorick, "Yorick", "M"));
        champList.add(new Champ(R.drawable.zac, R.raw.zac, "Zac", "M"));
        champList.add(new Champ(R.drawable.zed, R.raw.zed, "Zed", "M"));
        champList.add(new Champ(R.drawable.ziggs, R.raw.ziggs, "Ziggs", "R"));
        champList.add(new Champ(R.drawable.zilean, R.raw.zilean, "Zilean", "R"));
        champList.add(new Champ(R.drawable.zyra, R.raw.zyra, "Zyra", "R"));


    }

    protected void setmeleeList() {
        for (Champ x : champList) {
            if (x.role.equals("M")) {
                meleeList.add(x);
            }
        }

    }

    protected void setrangeList() {

        for (Champ x : champList) {
            if (x.role.equals("R")) {
                rangeList.add(x);
            }
        }
    }

    protected void setbothList() {
        for (Champ x : champList) {
            if (x.role.equals("B")) {
                bothList.add(x);
            }
        }
    }

    protected void setjgList() {
        jgList.add(R.drawable.icon2);
        jgList.add(R.drawable.icon3);
        jgList.add(R.drawable.icon4);
        jgList.add(R.drawable.icon5);
        jgList.add(R.drawable.icon6);
        jgList.add(R.drawable.icon7);
        jgList.add(R.drawable.icon9);
        jgList.add(R.drawable.icon15);
        jgList.add(R.drawable.icon17);
        jgList.add(R.drawable.icon50);
        jgList.add(R.drawable.icon60);
        jgList.add(R.drawable.icon73);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    class myAsyntask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {

            setChampList();
            setSpellList();
            setKeyStoneList();
            setnonjgItemList();
            setrangeItemList();
            setmeleeItemList();
            setrangeList();
            setmeleeList();
            setbothList();
            setDroplist();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            champdrop.setAdapter(myadapter);

        }
    }

    class myAsyntask2 extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {
            setnonjgItemList();
            setrangeItemList();
            setmeleeItemList();

            return null;

        }


    }


}






