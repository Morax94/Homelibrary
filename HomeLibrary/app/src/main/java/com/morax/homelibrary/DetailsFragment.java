package com.morax.homelibrary;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.morax.homelibrary.R.id.image;
import static com.morax.homelibrary.R.id.toolbar;

public class DetailsFragment extends Fragment {
    TextView _Title_editText_Details, _author_editText_Details, _publisher_editText_Details, _date_editText_Details, _page_editText_Details, _description_editText_Details;
    ImageButton _imageButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.content_details, container, false);
        _Title_editText_Details = (TextView) view.findViewById(R.id.Title_editText_Details);
        _author_editText_Details = (TextView) view.findViewById(R.id.author_editText_Details);
        _publisher_editText_Details = (TextView) view.findViewById(R.id.publisher_editText_Details);
        _date_editText_Details = (TextView) view.findViewById(R.id.date_editText_Details);
        _page_editText_Details = (TextView) view.findViewById(R.id.page_editText_Details);
        _description_editText_Details = (TextView) view.findViewById(R.id.description_editText_Details);
        _imageButton = (ImageButton) view.findViewById(R.id.imageButton);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            try {
                _Title_editText_Details.setText(bundle.getString("title"));
                _author_editText_Details.setText(bundle.getString("author"));
                _publisher_editText_Details.setText(bundle.getString("publisher"));
                _date_editText_Details.setText(bundle.getString("date"));
                _page_editText_Details.setText(bundle.getString("page"));
                _description_editText_Details.setText(bundle.getString("description"));
                _imageButton.setImageURI(Uri.parse(bundle.getString("image")));
            } catch (NullPointerException e) {
            }
        }
        return view;
    }

    public static DetailsFragment newInstance() {
        DetailsFragment fragment = new DetailsFragment();
        return fragment;
    }


}
