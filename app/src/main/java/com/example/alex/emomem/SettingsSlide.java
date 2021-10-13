package com.example.alex.emomem;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
//import android.preference.PreferenceFragment;
//import android.support.v4.preference.PreferenceFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

import static java.lang.String.valueOf;
//import android.support.v7.preference.PreferenceFragmentCompat;
//import com.example.alex.emomem.R;

/**
 * A simple {@link Fragment} subclass.
 */
//public class SettingsSlide extends android.support.v4.app.Fragment {
//public class SettingsSlide extends PreferenceFragmentCompat {
//public class SettingsSlide extends android.preference.PreferenceFragment {
//public class SettingsSlide extends MyPreferenceFragment {
public class SettingsSlide extends android.support.v4.app.Fragment {

    // Attach event listener interface to this activity
    MyEventListener el;
    ExternalStorageHelper esh;
    //ViewOverlay vo;
    //AlertDialogTest adt;
    AlertDialogAbout adAbout;
    AlertDialogDeleteLog adDeleteLog;

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

    public SettingsSlide() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        esh = new ExternalStorageHelper();
        //vo = new ViewOverlay();
        //adt = new AlertDialogTest();
        adAbout = new AlertDialogAbout();
        adDeleteLog = new AlertDialogDeleteLog();

        //addPreferencesFromResource(R.xml.preferences);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings_slide, container, false);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        // Link spinner with preferences
        final Spinner userCountSpinner = getActivity().findViewById(R.id.userNumberSpinner);

        // Set initial userCountSpinner state
        userCountSpinner.setSelection(el.getSharedPreferences().getInt("PREF_USERCOUNT", 0));

        //userCountSpinner.setAdapter(mySpinnerAdapter);

        userCountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * Called when a new item is selected (in the Spinner)
             */
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                el.getSharedPreferences().edit().putInt("PREF_USERCOUNT", position).commit();

                // Write selected user count to the internal preferences
                el.setUserCount(el.getSharedPreferences().getInt("PREF_USERCOUNT", 0)+1);

                Toast.makeText(getContext(), "User count set to " + valueOf(el.getSharedPreferences().getInt("PREF_USERCOUNT", 0)+1), Toast.LENGTH_SHORT).show();

                // Reset current user number
                //el.setCurrentUserNumber(1);

                // Inflate layout in order to access and change user button text to 1
                /*View inflatedMainSlideView = getLayoutInflater().inflate(R.layout.fragment_main_slide, null);
                Button userButton = inflatedMainSlideView.findViewById(R.id.userButton);
                userButton.setText("1");*/
                //userButton.setText(valueOf(el.getCurrentUserNumber()));

                // Replace the fragment in order to update MainSlide
/*                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.masterFrame, MainSlide);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/

                //getActivity().findViewById(R.id.userButton).setText(valueOf(el.getCurrentUserNumber()));

                //System.out.println(el.getSharedPreferences().getInt("PREF_USERCOUNT", 0));

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing.

            }
        }); // (optional)

        /*//UPDATE - When you are using a button onCLick()
        // to set the spinner selection:
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                spinner.setSelection(mPrefs.getInt("PREF_SPINNER", 0));

            }
        });*/

        /*//UPDATE - When you are using a button onCLick()
        // to set the spinner selection:
        userCountSpinner.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(View v) {
                userCountSpinner.setSelection(el.getSharedPreferences().getInt("PREF_SPINNER", 0));

            }
        });*/

        // Define switch(es) and their listeners
        Switch wakeLockSwitch = getActivity().findViewById(R.id.wakeLockSwitch);

        // Set initial wakeLockSwitch state
        wakeLockSwitch.setChecked(el.getSharedPreferences().getBoolean("PREF_WAKELOCK", false));

        wakeLockSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                el.getSharedPreferences().edit().putBoolean("PREF_WAKELOCK", b).commit();

                //System.out.println("Wakelock state: " + el.getSharedPreferences().getBoolean("PREF_WAKELOCK", false));

                if (el.getSharedPreferences().getBoolean("PREF_WAKELOCK", false) == true) el.enableKeepScreenOn();
                if (el.getSharedPreferences().getBoolean("PREF_WAKELOCK", false) == false) el.disableKeepScreenOn();

            }
        });

        // Define buttons and their listeners
        Button deleteLogButton = getActivity().findViewById(R.id.deleteLogButton);
        Button aboutButton = getActivity().findViewById(R.id.aboutButton);

        deleteLogButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    // "pressed"
                    case MotionEvent.ACTION_DOWN:

                        //esh.deleteFile("emotionLog.csv");
                        //Toast.makeText(getContext(), "Log file deleted", Toast.LENGTH_SHORT).show();

                        //adDeleteLog.show(getFragmentManager(), "Delete emotion log");

                        return true;

                    // "released"
                    case MotionEvent.ACTION_UP:

                        adDeleteLog.show(getFragmentManager(), "Delete emotion log");

                        return true;

                }

                return false;
            }
        });

        aboutButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    // "pressed"
                    case MotionEvent.ACTION_DOWN:

                        //vo.add(getResources().getDrawable(R.id.viewAbout));

                        //adt.show(getFragmentManager(), "Missiles?");

                        //adAbout.show(getFragmentManager(), "About EmoMem");

                        return true;

                    // "released"
                    case MotionEvent.ACTION_UP:

                        adAbout.show(getFragmentManager(), "About EmoMem");

                        return true;

                }

                return false;
            }
        });

    }

}
