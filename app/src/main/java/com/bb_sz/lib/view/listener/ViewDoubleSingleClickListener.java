package com.bb_sz.lib.view.listener;

import android.util.Log;
import android.view.View;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/3/15.
 */

public class ViewDoubleSingleClickListener implements View.OnClickListener {
    private static final String TAG = "SkyViewDSCL";
    private static final long DOUBLE_CLICK_TIME = 250;
    private static ExecutorService pool;

    private View itemView;
    private int position;

    private long curClickTime = 0;

    public ViewDoubleSingleClickListener(View itemView, int position) {
        this.itemView = itemView;
        this.position = position;
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (!v.isEnabled()) return;
//        ((ViewGroup) v)
//                .setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        if (curClickTime == 0) {
            curClickTime = System.currentTimeMillis();
            if (null == pool) {
                pool = Executors.newCachedThreadPool();
            }
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(DOUBLE_CLICK_TIME);
                        if (curClickTime != 0 && System.currentTimeMillis() - curClickTime >= DOUBLE_CLICK_TIME) {
                            curClickTime = 0;
                            singleClick(itemView, position);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        curClickTime = 0;
                    }
                }
            });
        } else if (((System.currentTimeMillis() - curClickTime) > 0
                && ((System.currentTimeMillis() - curClickTime) < DOUBLE_CLICK_TIME))) {
            curClickTime = 0;
            doubleClick(itemView, position);
        }
    }

    protected void singleClick(View itemView, int position) {
//        //TODO in sub class
//        if (com.bb_sz.lib.BuildConfig.LogSwitch) L.d(TAG, "singleClick position = " + position);

        Log.d(TAG, "singleClick position = " + position);
    }

    protected void doubleClick(View itemView, int position) {
//        //TODO in sub class
//        if (com.bb_sz.lib.BuildConfig.LogSwitch) L.d(TAG, "doubleClick position = " + position);
        Log.d(TAG, "doubleClick position = " + position);
    }
}
