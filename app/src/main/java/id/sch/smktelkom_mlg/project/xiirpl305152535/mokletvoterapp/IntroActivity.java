package id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;

/**
 * Created by microsoft on 30/11/2016.
 */
public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(SampleSlide.newInstance(R.layout.slide_1));
        addSlide(SampleSlide.newInstance(R.layout.slide_2));
        //addSlide(AppIntroFragment.newInstance("Slide Title", "Testtttt", R.drawable.vote,));

        setZoomAnimation();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        finish();
    }
}
