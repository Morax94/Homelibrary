package com.morax.homelibrary;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
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
    TextView _Title_editText_Add, _author_editText_Add, _publisher_editText_Add, _date_editText_Add, _page_editText_Add, _description_editText_Add;
    ImageButton _imageButtonAdd;
    Button _AddButton;
    Realm realm;
    String realPath;

    public static AddFragment newInstance() {
        AddFragment fragment = new AddFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        _Title_editText_Add = (TextView) view.findViewById(R.id.Title_editText_Add);
        _author_editText_Add = (TextView) view.findViewById(R.id.author_editText_Add);
        _publisher_editText_Add = (TextView) view.findViewById(R.id.publisher_editText_Add);
        _date_editText_Add = (TextView) view.findViewById(R.id.date_editText_Add);
        _page_editText_Add = (TextView) view.findViewById(R.id.page_editText_Add);
        _description_editText_Add = (TextView) view.findViewById(R.id.description_editText_Add);
        _imageButtonAdd = (ImageButton) view.findViewById(R.id.imageButtonAdd);
        _AddButton = (Button) view.findViewById(R.id.AddButton);
        _imageButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 0);
            }
        });
        _AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_Title_editText_Add.getText() != null && _author_editText_Add.getText() != null && _publisher_editText_Add.getText() != null && _date_editText_Add.getText() != null && _page_editText_Add.getText() != null && _description_editText_Add.getText() != null) {
                    BookRealm book = new BookRealm();
                    book.setTitle(_Title_editText_Add.toString());
                    book.setAuthor(_author_editText_Add.toString());
                    book.setPublisher(_publisher_editText_Add.toString());
                    book.setDate(_date_editText_Add.toString());
                    book.setPage(_page_editText_Add.toString());
                    book.setDescription(_description_editText_Add.toString());
                    //book.setImage(realPath);
                    realm.init(getContext());
                    realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    realm.copyToRealm(book);
                    realm.commitTransaction();
                    Class fragmentClass = HomeFragment.class;
                    Fragment fragment = null;
                    try {
                        fragment = (Fragment)fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.CotentFragment, fragment).commit();



                } else {
                    Toast toast = Toast.makeText(getContext(), "Wypełnij wszystkie pola", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        return view;
    }

    public void onActivityResult(int reqCode, int resCode, Intent data) {
        if (resCode == getActivity().RESULT_OK && data != null) {
            // SDK < API11
            if (Build.VERSION.SDK_INT < 11)
                realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(getContext(), data.getData());

                // SDK >= 11 && SDK < 19
            else if (Build.VERSION.SDK_INT < 19)
                realPath = RealPathUtil.getRealPathFromURI_API11to18(getContext(), data.getData());

                // SDK > 19 (Android 4.4)
            else
                realPath = RealPathUtil.getRealPathFromURI_API19(getContext(), data.getData());
        }
    }
}