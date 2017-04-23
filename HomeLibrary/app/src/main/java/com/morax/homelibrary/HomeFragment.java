package com.morax.homelibrary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public List<Book> books= new ArrayList<Book>(){
        {new Book("Pan Lodowego Ogrodu, tom1","Jarosław Grzedowicz","Fabryka Słów",638,"Książka Fantastyczna opowiadającz historię toczącąsię na innej planecie","", "@mipmap/ic_launcher");}
        {new Book("Pan Lodowego Ogrodu, tom2","Jarosław Grzedowicz","Fabryka Słów",538,"Książka Fantastyczna opowiadającz historię toczącąsię na innej planecie","", "@mipmap/ic_launcher");}
        {new Book("Pan Lodowego Ogrodu, tom3","Jarosław Grzedowicz","Fabryka Słów",738,"Książka Fantastyczna opowiadającz historię toczącąsię na innej planecie","", "@mipmap/ic_launcher");}
        {new Book("Pan Lodowego Ogrodu, tom4","Jarosław Grzedowicz","Fabryka Słów",580,"Książka Fantastyczna opowiadającz historię toczącąsię na innej planecie","", "@mipmap/ic_launcher");}
        {new Book("Pan Lodowego Ogrodu, tom1","Jarosław Grzedowicz","Fabryka Słów",638,"Książka Fantastyczna opowiadającz historię toczącąsię na innej planecie","", "@mipmap/ic_launcher");}
        {new Book("Lód","Jacek Dukaj","Wydawnictwo Literackie",1050,"Opowiada czasy gdy do pierwszej wojny światowej nie doszło","", "image");}
        {new Book("Red Rising, tom1","Pierce Brown","Drageus Publishing House",428,"O nie równości społecznej","", "@mipmap/ic_launcher");}
        {new Book("Red Rising, tom2","Pierce Brown","Drageus Publishing House",428,"O nie równości społecznej","", "@mipmap/ic_launcher");}
        {new Book("Red Rising, tom3","Pierce Brown","Drageus Publishing House",428,"O nie równości społecznej","", "@mipmap/ic_launcher");}
    };
    private RecyclerView recyclerView;
    private ListAdapter mAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.MRecyler);
        mAdapter = new ListAdapter(books);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        return view;
    }

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
