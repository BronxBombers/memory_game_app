package com.example.zach.memorygame.LevelClasses;

import android.content.Intent;

import com.example.zach.memorygame.R;
import com.example.zach.memorygame.multi_page_level;

/**
 * Created by Zach on 2/3/2018.
 */

public class S5L2 extends multi_page_level {

    @Override
    protected void initializeGame() {
        goals = new String[]{getString(R.string.s5l2_gold_time), getString(R.string.s5l2_gold_moves),
                getString(R.string.s5l2_silver_time), getString(R.string.s5l2_silver_moves),
                getString(R.string.s5l2_bronze_time), getString(R.string.s5l2_bronze_moves)};
        cardFlipTimeUp = 1000;
        flipIntervals = 20;
        isMultiPage = true;
        int[] pageLayouts = new int[]{R.layout.s5l2_p1,R.layout.s5l2_p2};
        super.initializeMultiPageGame(true, pageLayouts, 20,"Stage 5 Level 2");
    }

    @Override
    protected Intent getNextLevelIntent(){
        return new Intent(this,S5L3.class);
    }

    @Override
    protected String getKey() {
        return getString(R.string.shared_pref_S5L2_key);
    }
}
