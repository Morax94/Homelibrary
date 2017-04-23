package com.morax.homelibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment
{
    private TextView _author_textView, _publisher_textView, _date_textView, _page_textView, _description_textView;
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            View view = inflater.inflate(R.layout.content_details, container, false);
            _author_textView=(TextView)view.findViewById(R.id.author_textView_Details);
            return view;
        }

        public static DetailsFragment newInstance()
        {
            Bundle args = new Bundle();
            DetailsFragment fragment = new DetailsFragment();
            fragment.setArguments(args);
            return fragment;
        }


}
