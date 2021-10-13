//package com.example.alex.emomem;
//
//import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentStatePagerAdapter;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager;
////import android.support.wearable.activity.WearableActivity;
////import android.widget.TextView;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//
//public class ScreenSlidePageControllerActivity extends FragmentActivity {
//    /**
//     * The number of pages (wizard steps) to show in this demo.
//     */
//    private static final int NUM_PAGES = 2;
//
//    /**
//     * The pager widget, which handles animation and allows swiping horizontally to access previous
//     * and next wizard steps.
//     */
//    private ViewPager mPager;
//
//    /**
//     * The pager adapter, which provides the pages to the view pager widget.
//     */
//    private PagerAdapter mPagerAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_screen_slide); // Empty screen slider screen...
//
//        // Instantiate a ViewPager and a PagerAdapter.
//        mPager = findViewById(R.id.pager);
//        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
//        mPager.setAdapter(mPagerAdapter);
//
//        System.out.println("Fragments" + getSupportFragmentManager().getFragments());
//    }
//
//    // Add fragments to adapter
//   /* mPagerAdapter.addFragment(new ScreenSlidePageSettings(), "Settings 1");
//    mPagerAdapter.addFragment(new ScreenSlidePageSettings2(), "Settings 2");*/
//
//    @Override
//    public void onBackPressed() {
//        if (mPager.getCurrentItem() == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed();
//
//        } else {
//            // Otherwise, select the previous step.
//            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//
//        }
//    }
//
//    /**
//     * A simple pager adapter that represents NUM_PAGES ScreenSlidePageFragment objects, in
//     * sequence.
//     */
//    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
//        public ScreenSlidePagerAdapter(FragmentManager fm) {
//            super(fm);
//
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return new ScreenSlidePageFragment();
//            //return getSupportFragmentManager().getFragments().get(position);
//
//        }
//
//        @Override
//        public int getCount() {
//            return NUM_PAGES;
//
//        }
//
//    }
//
//}