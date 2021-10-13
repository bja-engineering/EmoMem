package com.example.alex.emomem;

//import android.animation.ObjectAnimator;
//import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
//import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
//import android.support.wearable.activity.WearableActivity;
import android.support.wear.ambient.AmbientModeSupport;
import android.view.WindowManager;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageButton;

//import android.graphics.drawable.AnimationDrawable;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.view.animation.AccelerateDecelerateInterpolator;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.view.animation.TranslateAnimation;
//import android.widget.TextView;
//import android.view.animation.AnimationUtils;

//public class MainActivity extends WearableActivity implements View.OnClickListener {
public class MainActivity extends FragmentActivity implements AmbientModeSupport.AmbientCallbackProvider, MyEventListener {
//public class MainActivity extends FragmentActivity implements MyEventListener {

    // Define ambient mode support reference
    private AmbientModeSupport.AmbientController mAmbientController;

    @Override
    public AmbientModeSupport.AmbientCallback getAmbientCallback() {
        return new MyAmbientCallback();

    }

    //private TextView mTextView;

//    // Load animation
//    Animation fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);

    // Define user number - set it later in onCreate method
    int userCount;
    int currentUserNumber = 1;

    // Define shared preferences reference;
    SharedPreferences sharedPrefs;

    // Event listener methods
    // Getters and setters for userCount and userNumber and shared preferences
    public void setUserCount(int newCount) { userCount = newCount; }

    public int getCurrentUserNumber() { return currentUserNumber; }

    public void setCurrentUserNumber(int newCurrentUserNumber) { currentUserNumber = newCurrentUserNumber; }

    public void cycleCurrentUserNumber() {

        if(currentUserNumber < userCount)
            currentUserNumber+=1;

        else currentUserNumber = 1;

    }

    public SharedPreferences getSharedPreferences() {
        return sharedPrefs;

    }

    // XML alternative: <xxx ... android:keepScreenOn="true" />
    public void enableKeepScreenOn() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //System.out.println("Keep screen on enabled");

    }

    public void disableKeepScreenOn() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //System.out.println("Keep screen on disabled");

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the screen to "always on"
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        // The main activity basically hosts the viewpager...
        ViewPager pager = findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        userCount = 5;
        currentUserNumber = 1;

        // Set up shared preferences and its listener
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor spe = sharedPrefs.edit();

        // Use instance field for listener
        // It will not be gc'd as long as this instance is kept referenced
        SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences sharedPrefs, String key) {
                // Implementation

                //System.out.println("Changed preference: " + key);

                //if(key == "PREF_USERCOUNT")
                    //userCount = getSharedPreferences().getInt("PREF_USERCOUNT", 0)+1;

//                System.out.println("Changed preference: " + key);
//                System.out.println("User count set to: " + getSharedPreferences().getInt("PREF_USERCOUNT", 0)+1);

            }
        };

        sharedPrefs.registerOnSharedPreferenceChangeListener(listener);

        // Attach ambient controller to this activity
        //mAmbientController = AmbientModeSupport.attach(this);

        //mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        //setAmbientEnabled();

        /*Intent intent = new Intent(this, ScreenSlidePageControllerActivity.class);
        startActivity(intent);*/

        //findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_center_yellow_lessbright);

/*        // Set OnClickListeners to ImageButtons
        ImageButton pleasureButton = (ImageButton) findViewById(R.id.pleasureButton);
        pleasureButton.setOnClickListener(this); // calling onClick() method

        ImageButton sadnessButton = (ImageButton) findViewById(R.id.sadnessButton);
        sadnessButton.setOnClickListener(this);

        ImageButton fearButton = (ImageButton) findViewById(R.id.fearButton);
        fearButton.setOnClickListener(this);

        ImageButton angerButton = (ImageButton) findViewById(R.id.angerButton);
        angerButton.setOnClickListener(this); // calling onClick() method

        ImageButton interestButton = (ImageButton) findViewById(R.id.interestButton);
        interestButton.setOnClickListener(this);

        ImageButton userButton = (ImageButton) findViewById(R.id.userButton);
        userButton.setOnClickListener(this);*/

        //final Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
        //findViewById(R.id.masterFrame).setAnimation(anim);

        //AnimationDrawable animationDrawable = getDrawable(R.drawable.ic_emomem_bg);
        //animationDrawable.setOneShot(true);
        //animationDrawable.start();

        /*Animation animation = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in);
        findViewById(R.id.masterFrame).setAnimation(animation);
        findViewById(R.id.pleasureButton).setAnimation(animation);
        //animation.start();

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Animation fadeOut = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_out);
                findViewById(R.id.masterFrame).startAnimation(fadeOut);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });*/

        /** zis worked start */

//        // Define ImageButtons
//        ImageButton pleasureButton = findViewById(R.id.pleasureButton);
//        ImageButton sadnessButton = findViewById(R.id.sadnessButton);
//        ImageButton fearButton = findViewById(R.id.fearButton);
//        ImageButton angerButton = findViewById(R.id.angerButton);
//        ImageButton interestButton = findViewById(R.id.interestButton);
//        Button userButton = findViewById(R.id.userButton);

        /** zis worked end */

        //System.out.println("Button TRUE?: " + pleasureButton);

/*        // Define ImageButton reference array
        ImageButton[] emoMemButtonsArray = {
                findViewById(R.id.pleasureButton),
                findViewById(R.id.sadnessButton),
                findViewById(R.id.fearButton),
                findViewById(R.id.angerButton),
                findViewById(R.id.interestButton),
                findViewById(R.id.userButton)
        };*/

        //ImageButton animatedImageButtonPleasure = pleasureButton;

        //final ObjectAnimator imageButtonAnimator = ObjectAnimator.ofFloat(animatedImageButtonPleasure, "translationY",0f,500f);
        //final ObjectAnimator imageButtonAnimatorPleasure = ObjectAnimator.ofFloat(animatedImageButtonPleasure, "scaleX", 1f, 1.5f);
        //imageButtonAnimator.setDuration(2000);
        /*PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.5f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.5f);
        final ObjectAnimator imageButtonAnimatorPleasure = ObjectAnimator.ofPropertyValuesHolder(pleasureButton, pvhX, pvhY);
        imageButtonAnimatorPleasure.setDuration(50);
        imageButtonAnimatorPleasure.setInterpolator(new AccelerateDecelerateInterpolator());*/

        /** zis worked start */

//        //  Define value holders for the scale animation
//        PropertyValuesHolder pvhScaleXPos = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.5f);
//        PropertyValuesHolder pvhScaleYPos = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.5f);
//        PropertyValuesHolder pvhScaleXNeg = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.75f);
//        PropertyValuesHolder pvhScaleYNeg = PropertyValuesHolder.ofFloat("scaleY", 1f, 0.75f);
//
//        final ObjectAnimator imageButtonAnimatorPleasure = ObjectAnimator.ofPropertyValuesHolder(pleasureButton, pvhScaleXPos, pvhScaleYPos).setDuration(50);
//        final ObjectAnimator imageButtonAnimatorSadness = ObjectAnimator.ofPropertyValuesHolder(sadnessButton, pvhScaleXPos, pvhScaleYPos).setDuration(50);
//        final ObjectAnimator imageButtonAnimatorFear = ObjectAnimator.ofPropertyValuesHolder(fearButton, pvhScaleXPos, pvhScaleYPos).setDuration(50);
//        final ObjectAnimator imageButtonAnimatorAnger = ObjectAnimator.ofPropertyValuesHolder(angerButton, pvhScaleXPos, pvhScaleYPos).setDuration(50);
//        final ObjectAnimator imageButtonAnimatorInterest = ObjectAnimator.ofPropertyValuesHolder(interestButton, pvhScaleXPos, pvhScaleYPos).setDuration(50);
//        final ObjectAnimator imageButtonAnimatorUser = ObjectAnimator.ofPropertyValuesHolder(userButton, pvhScaleXNeg, pvhScaleYNeg).setDuration(50);

        /** zis worked end */

/*        // Fill ObjectAnimatorArray with ImageButtons from ImageButton reference array
        final ObjectAnimator[] emoMemObjAnimatorArray = {};
        for (ImageButton ib : emoMemButtonsArray) {
            int i = 0;
            emoMemObjAnimatorArray[i] = ObjectAnimator.ofPropertyValuesHolder(ib, pvhScaleX, pvhScaleY).setDuration(50);
            i++;
        }*/

        /** zis worked start */

        // Set OnTouchListeners to ImageButtons and start the animations
//        pleasureButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch(event.getAction()) {
//                    // "pressed"
//                    case MotionEvent.ACTION_DOWN:
//                        //anim.start();
//                        imageButtonAnimatorPleasure.start();
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_top);
//                        //findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_center);
//                        return true;
//
//                    // "released"
//                    case MotionEvent.ACTION_UP:
//                        //v.performClick();
//                        imageButtonAnimatorPleasure.reverse();
//
//                        //findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_center);
//
//                        /*try {
//                            wait(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }*/
//
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);
//                        return true;
//
//                }
//
//                return false;
//            }
//        });
//
//        sadnessButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch(event.getAction()) {
//                    // "pressed"
//                    case MotionEvent.ACTION_DOWN:
//                        imageButtonAnimatorSadness.start();
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_topright);
//                        return true;
//
//                    // "released"
//                    case MotionEvent.ACTION_UP:
//                        imageButtonAnimatorSadness.reverse();
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);
//                        return true;
//
//                }
//
//                return false;
//            }
//        });
//
//        fearButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch(event.getAction()) {
//                    // "pressed"
//                    case MotionEvent.ACTION_DOWN:
//                        imageButtonAnimatorFear.start();
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_bottomright);
//                        return true;
//
//                    // "released"
//                    case MotionEvent.ACTION_UP:
//                        imageButtonAnimatorFear.reverse();
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);
//                        return true;
//
//                }
//
//                return false;
//            }
//        });
//
//        angerButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch(event.getAction()) {
//                    // "pressed"
//                    case MotionEvent.ACTION_DOWN:
//                        imageButtonAnimatorAnger.start();
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_bottomleft);
//                        return true;
//
//                    // "released"
//                    case MotionEvent.ACTION_UP:
//                        imageButtonAnimatorAnger.reverse();
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);
//                        return true;
//
//                }
//
//                return false;
//            }
//        });
//
//        interestButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch(event.getAction()) {
//                    // "pressed"
//                    case MotionEvent.ACTION_DOWN:
//                        imageButtonAnimatorInterest.start();
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_topleft);
//                        return true;
//
//                    // "released"
//                    case MotionEvent.ACTION_UP:
//                        imageButtonAnimatorInterest.reverse();
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);
//                        return true;
//
//                }
//
//                return false;
//            }
//        });
//
//       userButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch(event.getAction()) {
//                    // "pressed"
//                    case MotionEvent.ACTION_DOWN:
//                        imageButtonAnimatorUser.start();
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_center);
//                        return true;
//
//                    // "released"
//                    case MotionEvent.ACTION_UP:
//                        imageButtonAnimatorUser.reverse();
//                        findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);
//                        return true;
//
//                }
//
//                return false;
//            }
//        });

        /** zis worked end */

    /*fadeIn.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Animation fadeOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);
            findViewById(R.id.masterFrame).startAnimation(fadeOut);

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    });*/

    /*// Handle clicks on (Image)Buttons
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.pleasureButton:
//                findViewById(R.id.masterFrame).startAnimation(fadeIn);
                findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_top);
                break;

            case R.id.sadnessButton:
                findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_topright);
                break;

            case R.id.fearButton:
                findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_bottomright);
                break;

            case R.id.angerButton:
                findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_bottomleft);
                break;

            case R.id.interestButton:
                findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_topleft);
                break;

            case R.id.userButton:
                findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_center);
                break;

            default:
                break;
        }*/

    }

}