package com.morax.homelibrary;

import android.graphics.drawable.Drawable;
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

public class DetailsFragment extends Fragment
{
    EditText _Title_editText_Details,_author_editText_Details, _publisher_editText_Details,_date_editText_Details,_page_editText_Details,_description_editText_Details;
    ImageButton _imageButton;

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            View view = inflater.inflate(R.layout.content_details, container, false);
           _Title_editText_Details  = (EditText)view.findViewById(R.id.Title_editText_Details);
           _author_editText_Details = (EditText)view.findViewById(R.id.author_editText_Details);
          _publisher_editText_Details = (EditText)view.findViewById(R.id.publisher_editText_Details);
          _date_editText_Details = (EditText)view.findViewById(R.id.date_editText_Details);
          _page_editText_Details = (EditText)view.findViewById(R.id.page_editText_Details);
            _description_editText_Details = (EditText)view.findViewById(R.id.description_editText_Details);
          _imageButton = (ImageButton)view.findViewById(R.id.imageButton);
       Bundle bundle = this.getArguments();
           if(bundle!=null)
            {
                try {
                _Title_editText_Details.setText(bundle.get("title").toString());
                _author_editText_Details.setText(bundle.get("author").toString());
                _publisher_editText_Details.setText(bundle.get("publisher").toString());
                _date_editText_Details.setText(bundle.get("date").toString());
               _page_editText_Details.setText(bundle.get("page").toString());
               _description_editText_Details.setText(bundle.get("description").toString());
                    _imageButton.setImageResource((int)bundle.get("image"));
                }catch (NullPointerException e){}
           }
            return view;
        }

        public static DetailsFragment newInstance()
        {
            DetailsFragment fragment = new DetailsFragment();
            return fragment;
        }


}
