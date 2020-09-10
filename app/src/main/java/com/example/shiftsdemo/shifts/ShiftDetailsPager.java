package com.example.shiftsdemo.shifts;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.shiftsdemo.R;

public class ShiftDetailsPager extends FragmentPagerAdapter
{

    private final String TAG = "PatientDetailsPager";
    private Context mContext;

    public ShiftDetailsPager(Context aContext, @NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mContext = aContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "getItem: position "+ position);
        switch (position) {
            case 0:
                return new OpenFragment();
            case 1:
                return new AppliedFragment();
            case 2:
                return new AcceptedFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getResources().getString(R.string.open);
        } else if (position == 1) {
            return mContext.getResources().getString(R.string.applied);
        } else if (position == 2) {
            return mContext.getResources().getString(R.string.accepted);
        }
        return null;
    }

}

