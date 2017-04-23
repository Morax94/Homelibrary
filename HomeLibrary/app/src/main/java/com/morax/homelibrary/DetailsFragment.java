package com.morax.homelibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailsFragment extends Fragment
{

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            View view = inflater.inflate(R.layout.content_details, container, false);
            return view;
        }

        public static DetailsFragment newInstance()
        {
            DetailsFragment fragment = new DetailsFragment();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            return fragment;
        }



}
