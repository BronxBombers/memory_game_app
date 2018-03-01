package com.example.zach.memorygame;

import android.app.ActionBar;
import android.app.Fragment;
import android.media.MediaPlayer;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;

public class level_select extends FragmentActivity{

    ViewPager pager;

    SharedPreferences sharedPref;

    MediaPlayer backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_select_pager);
        pager = (ViewPager)findViewById(R.id.pager);
        level_select_pager pag = new level_select_pager(getSupportFragmentManager());
        pager.setAdapter(pag);
        pager.setPageTransformer(true, new StackTransformer());
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        pager.setCurrentItem(sharedPref.getInt(getString(R.string.store_current_stage_pager),0));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sharedPref.getBoolean(getString(R.string.isMuted_key),false)) {
            backgroundMusic = MediaPlayer.create(getApplicationContext(), R.raw.backgroundmusic);
            backgroundMusic.setLooping(true);
            backgroundMusic.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (backgroundMusic != null){
            backgroundMusic.release();
        }
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.store_current_stage_pager), pager.getCurrentItem());
        editor.apply();
    }

}



