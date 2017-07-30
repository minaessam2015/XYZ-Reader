package com.example.xyzreader.ui;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by mina essam on 30-Jul-17.
 */

public class FabBehavior extends FloatingActionButton.Behavior {

    public FabBehavior (Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        Log.d("ScrollEvent","Called");
        return nestedScrollAxes== ViewCompat.SCROLL_AXIS_VERTICAL||
                super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);

    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        if(dyConsumed>0&&child.getVisibility()==View.VISIBLE){
            child.hide();
        }else if(dyConsumed<0&&child.getVisibility()!=View.VISIBLE){
            child.show();
        }
    }
}
