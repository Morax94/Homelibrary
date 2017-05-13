package com.morax.homelibrary;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;

import io.realm.Realm;


public class AddFragment extends Fragment {
    TextView _Title_editText_Add,_author_editText_Add, _publisher_editText_Add,_date_editText_Add,_page_editText_Add,_description_editText_Add;
    ImageButton _imageButtonAdd;
    Button _AddButton;
    public static AddFragment newInstance() {
        AddFragment fragment = new AddFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        _Title_editText_Add  = (TextView) view.findViewById(R.id.Title_editText_Add);
        _author_editText_Add = (TextView) view.findViewById(R.id.author_editText_Add);
        _publisher_editText_Add = (TextView) view.findViewById(R.id.publisher_editText_Add);
        _date_editText_Add = (TextView) view.findViewById(R.id.date_editText_Add);
        _page_editText_Add = (TextView) view.findViewById(R.id.page_editText_Add);
        _description_editText_Add = (TextView) view.findViewById(R.id.description_editText_Add);
        _imageButtonAdd = (ImageButton)view.findViewById(R.id.imageButtonAdd);
        _AddButton = (Button)view.findViewById(R.id.AddButton);
        _AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_Title_editText_Add != null && _author_editText_Add != null &&_publisher_editText_Add!=null && _date_editText_Add !=null &&_page_editText_Add!= null && _description_editText_Add!=null)
                {
                    BookRealm book = new BookRealm();
                    book.setTitle(_Title_editText_Add.toString());
                    book.setAuthor(_author_editText_Add.toString());
                    book.setPublisher(_publisher_editText_Add.toString());
                    book.setDate(Date.valueOf(_date_editText_Add.toString()));
                    book.setPage(Double.valueOf(_page_editText_Add.toString()));
                    book.setDescription(_description_editText_Add.toString());
                    Realm.init(getContext());
                    //Realm realm = new Realm.getDefaultInstance();



                }
                else{
                    Toast toast = Toast.makeText(getContext(), "Wypełnij wszystkie pola", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        return view;
    }

}
