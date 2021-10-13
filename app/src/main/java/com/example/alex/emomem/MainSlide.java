package com.example.alex.emomem;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;

import static java.lang.String.valueOf;
//import java.util.Date;
//import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainSlide extends android.support.v4.app.Fragment {

    /*Long tsLong = System.currentTimeMillis()/1000;
    String ts = tsLong.toString();*/
    //Date currentDate = Calendar.getInstance().getTime();

    // Attach event listener interface to this activity
    MyEventListener el;
    //boolean bActionMoveDetected;
    TransitionDrawable tdBackground;

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        if(activity instanceof MyEventListener) {
            el = (MyEventListener)activity;

        } else {
            // Throw an error!

        }
    }

    ExternalStorageHelper esh;

    public MainSlide() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        esh = new ExternalStorageHelper();

        //bActionMoveDetected = false;

        el.setUserCount(5);

        //System.out.println("Current user number: " + el.getCurrentUserNumber());

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_slide, container, false);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        // Define background as TransitionDrawable
        //final TransitionDrawable td = (TransitionDrawable) getActivity().findViewById(R.id.masterFrame).getBackground();
        //TransitionDrawable tdBackground;
        //td.setCrossFadeEnabled(true);

        // Define ImageButtons
        ImageButton pleasureButton = getActivity().findViewById(R.id.pleasureButton);
        ImageButton sadnessButton = getActivity().findViewById(R.id.sadnessButton);
        ImageButton fearButton = getActivity().findViewById(R.id.fearButton);
        ImageButton angerButton = getActivity().findViewById(R.id.angerButton);
        ImageButton interestButton = getActivity().findViewById(R.id.interestButton);
        final Button userButton = getActivity().findViewById(R.id.userButton);

        userButton.setText(valueOf(el.getCurrentUserNumber()));

        //System.out.println("Parent activity: " + getActivity());

        //  Define value holders for the scale animation
//        PropertyValuesHolder pvhScaleXPos = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.5f);
//        PropertyValuesHolder pvhScaleYPos = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.5f);
//        PropertyValuesHolder pvhScaleXNeg = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.75f);
//        PropertyValuesHolder pvhScaleYNeg = PropertyValuesHolder.ofFloat("scaleY", 1f, 0.75f);

        PropertyValuesHolder pvhScaleXPosFull = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.5f, 1f);
        PropertyValuesHolder pvhScaleYPosFull = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.5f, 1f);
        PropertyValuesHolder pvhScaleXNegFull = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.75f, 1f);
        PropertyValuesHolder pvhScaleYNegFull = PropertyValuesHolder.ofFloat("scaleY", 1f, 0.75f, 1f);

        //PropertyValuesHolder pvhChangeBg = PropertyValuesHolder.ofInt("android:background", R.drawable.ic_emomem_bg_filled, R.drawable.ic_emomem_bg_filled_topright);

//        final ObjectAnimator imageButtonAnimatorPleasure = ObjectAnimator.ofPropertyValuesHolder(pleasureButton, pvhScaleXPos, pvhScaleYPos).setDuration(50);
//        final ObjectAnimator imageButtonAnimatorSadness = ObjectAnimator.ofPropertyValuesHolder(sadnessButton, pvhScaleXPos, pvhScaleYPos).setDuration(50);
//        final ObjectAnimator imageButtonAnimatorFear = ObjectAnimator.ofPropertyValuesHolder(fearButton, pvhScaleXPos, pvhScaleYPos).setDuration(50);
//        final ObjectAnimator imageButtonAnimatorAnger = ObjectAnimator.ofPropertyValuesHolder(angerButton, pvhScaleXPos, pvhScaleYPos).setDuration(50);
//        final ObjectAnimator imageButtonAnimatorInterest = ObjectAnimator.ofPropertyValuesHolder(interestButton, pvhScaleXPos, pvhScaleYPos).setDuration(50);
//        final ObjectAnimator imageButtonAnimatorUser = ObjectAnimator.ofPropertyValuesHolder(userButton, pvhScaleXNeg, pvhScaleYNeg).setDuration(50);

        final ObjectAnimator imageButtonAnimatorPleasureFull = ObjectAnimator.ofPropertyValuesHolder(pleasureButton, pvhScaleXPosFull, pvhScaleYPosFull).setDuration(200);
        final ObjectAnimator imageButtonAnimatorSadnessFull = ObjectAnimator.ofPropertyValuesHolder(sadnessButton, pvhScaleXPosFull, pvhScaleYPosFull).setDuration(200);
        final ObjectAnimator imageButtonAnimatorFearFull = ObjectAnimator.ofPropertyValuesHolder(fearButton, pvhScaleXPosFull, pvhScaleYPosFull).setDuration(200);
        final ObjectAnimator imageButtonAnimatorAngerFull = ObjectAnimator.ofPropertyValuesHolder(angerButton, pvhScaleXPosFull, pvhScaleYPosFull).setDuration(200);
        final ObjectAnimator imageButtonAnimatorInterestFull = ObjectAnimator.ofPropertyValuesHolder(interestButton, pvhScaleXPosFull, pvhScaleYPosFull).setDuration(200);
        final ObjectAnimator imageButtonAnimatorUserFull = ObjectAnimator.ofPropertyValuesHolder(userButton, pvhScaleXNegFull, pvhScaleYNegFull).setDuration(200);

        //final ObjectAnimator imageButtonAnimatorSadnessChangeBg = ObjectAnimator.ofPropertyValuesHolder(getActivity().findViewById(R.id.masterFrame), pvhChangeBg).setDuration(200);

        // Set OnTouchListeners to ImageButtons and start the animations
        pleasureButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    // "pressed"
                    case MotionEvent.ACTION_DOWN:
                        //anim.start();
                        //imageButtonAnimatorPleasure.start();
                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_top);
                        //findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_center);

                        return true;

                    // "released"
                    case MotionEvent.ACTION_UP:
                        //v.performClick();
                        //imageButtonAnimatorPleasure.reverse();
                        imageButtonAnimatorPleasureFull.start();

                        //findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_center);

                        /*try {
                            wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/

                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);

                        getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.td_emomem_bg_filled_top);
                        tdBackground = (TransitionDrawable) getActivity().findViewById(R.id.masterFrame).getBackground();
                        tdBackground.startTransition(100);
                        tdBackground.reverseTransition(100);

                        esh.appendEntryToFile("emotionLog.csv", System.currentTimeMillis() + ";" + Calendar.getInstance().getTime().toString() + ";UserNo" + valueOf(el.getCurrentUserNumber()) + ";pleasure;");

                        Toast.makeText(getContext(), "Logged!", Toast.LENGTH_SHORT).show();

                        return true;

                }

                return false;
            }
        });

        sadnessButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    // "pressed"
                    case MotionEvent.ACTION_DOWN:

                        //imageButtonAnimatorSadness.start();

                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_topright);

                        //imageButtonAnimatorSadnessChangeBg.start();

                        return true;

                    // "released"
                    case MotionEvent.ACTION_UP:

                        //imageButtonAnimatorSadness.reverse();
                        imageButtonAnimatorSadnessFull.start();
                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);

                        getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.td_emomem_bg_filled_topright);
                        tdBackground = (TransitionDrawable) getActivity().findViewById(R.id.masterFrame).getBackground();
                        tdBackground.startTransition(100);
                        tdBackground.reverseTransition(100);

                        esh.appendEntryToFile("emotionLog.csv", System.currentTimeMillis() + ";" + Calendar.getInstance().getTime().toString() + ";UserNo" + valueOf(el.getCurrentUserNumber()) + ";sadness;");

                        Toast.makeText(getContext(), "Logged!", Toast.LENGTH_SHORT).show();

                        return true;

                    //case MotionEvent.ACTION_MOVE: System.out.println("Move event detected"); return true;
                    //case MotionEvent.ACTION_SCROLL: System.out.println("Scroll event detected"); return true;

                }

                return false;
            }
        });

        fearButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    // "pressed"
                    case MotionEvent.ACTION_DOWN:
                        //imageButtonAnimatorFear.start();
                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_bottomright);

                        return true;

                    // "released"
                    case MotionEvent.ACTION_UP:
                        //imageButtonAnimatorFear.reverse();
                        imageButtonAnimatorFearFull.start();
                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);

                        getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.td_emomem_bg_filled_bottomright);
                        tdBackground = (TransitionDrawable) getActivity().findViewById(R.id.masterFrame).getBackground();
                        tdBackground.startTransition(100);
                        tdBackground.reverseTransition(100);

                        esh.appendEntryToFile("emotionLog.csv", System.currentTimeMillis() + ";" + Calendar.getInstance().getTime().toString() + ";UserNo" + valueOf(el.getCurrentUserNumber()) + ";fear;");

                        Toast.makeText(getContext(), "Logged!", Toast.LENGTH_SHORT).show();

                        return true;

                }

                return false;
            }
        });

        angerButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    // "pressed"
                    case MotionEvent.ACTION_DOWN:
                        //imageButtonAnimatorAnger.start();
                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_bottomleft);

                        return true;

                    // "released"
                    case MotionEvent.ACTION_UP:
                        //imageButtonAnimatorAnger.reverse();
                        imageButtonAnimatorAngerFull.start();
                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);

                        getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.td_emomem_bg_filled_bottomleft);
                        tdBackground = (TransitionDrawable) getActivity().findViewById(R.id.masterFrame).getBackground();
                        tdBackground.startTransition(100);
                        tdBackground.reverseTransition(100);

                        esh.appendEntryToFile("emotionLog.csv", System.currentTimeMillis() + ";" + Calendar.getInstance().getTime().toString() + ";UserNo" + valueOf(el.getCurrentUserNumber()) + ";anger;");

                        Toast.makeText(getContext(), "Logged!", Toast.LENGTH_SHORT).show();

                        return true;

                }

                return false;
            }
        });

        interestButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    // "pressed"
                    case MotionEvent.ACTION_DOWN:
                        //imageButtonAnimatorInterest.start();
                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_topleft);

                        return true;

                    // "released"
                    case MotionEvent.ACTION_UP:
                        //imageButtonAnimatorInterest.reverse();
                        imageButtonAnimatorInterestFull.start();
                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);

                        getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.td_emomem_bg_filled_topleft);
                        tdBackground = (TransitionDrawable) getActivity().findViewById(R.id.masterFrame).getBackground();
                        tdBackground.startTransition(100);
                        tdBackground.reverseTransition(100);

                        esh.appendEntryToFile("emotionLog.csv", System.currentTimeMillis() + ";" + Calendar.getInstance().getTime().toString() + ";UserNo" + valueOf(el.getCurrentUserNumber()) + ";interest;");

                        Toast.makeText(getContext(), "Logged!", Toast.LENGTH_SHORT).show();

                        return true;

                }

                return false;
            }
        });

        userButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    // "pressed"
                    case MotionEvent.ACTION_DOWN:
                        //imageButtonAnimatorUser.start();
                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled_center);

                        return true;

                    // "released"
                    case MotionEvent.ACTION_UP:
                        //imageButtonAnimatorUser.reverse();
                        imageButtonAnimatorUserFull.start();

                        //getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.ic_emomem_bg_filled);

                        getActivity().findViewById(R.id.masterFrame).setBackgroundResource(R.drawable.td_emomem_bg_filled_center);
                        tdBackground = (TransitionDrawable) getActivity().findViewById(R.id.masterFrame).getBackground();
                        tdBackground.startTransition(100);
                        tdBackground.reverseTransition(100);

                        el.cycleCurrentUserNumber();
                        userButton.setText(valueOf(el.getCurrentUserNumber()));

                        return true;

                }

                return false;
            }
        });

    }

}

/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
        tv.setText(getArguments().getString("msg"));

        return v;
    }

    public static FirstFragment newInstance(String text) {

        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}*/
