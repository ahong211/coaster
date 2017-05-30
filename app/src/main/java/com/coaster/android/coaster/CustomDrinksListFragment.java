package com.coaster.android.coaster;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomDrinksListFragment extends Fragment {

    // TODO: 5/29/2017 Make custom drinks pull from and save to local storage
    // TODO: 5/29/2017 Create methods that store file read from storage inside custom drink object
    // TODO: 5/29/2017 Create list of custom drink files read from external storage on device
    // TODO: 5/29/2017 Create recycler view that displays list of custom drink files

    public CustomDrinksListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_custom_drinks_list, container, false);
    }

    // Need to check if media is still available because it could have been moved or deleted by user
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}