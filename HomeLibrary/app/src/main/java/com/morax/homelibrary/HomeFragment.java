package com.morax.homelibrary;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{
    public List<Book> books;
    private RecyclerView recyclerView;
    private ListAdapter mAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.MRecyler);
        fillBooks();
        mAdapter = new ListAdapter(books);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        Log.e("HomeFragment", String.valueOf(mAdapter.getItemCount()));
        Log.e("HomeFragment", String.valueOf(books.size()));
        mAdapter.notifyDataSetChanged();
        recyclerView.addOnItemTouchListener(new ListTouchListener(getContext(), recyclerView, new ListTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Book book = books.get(position);
                Toast.makeText(getContext(), book.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        FloatingActionButton _addButton =(FloatingActionButton)view.findViewById(R.id.floatingActionButton);
        _addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                Class fragmentClass = DetailsFragment.class;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.CotentFragment, fragment).commit();
            }});
        return view;
    }

    private void fillBooks() {
        books = new ArrayList<>();
        books.add(new Book("Pan Lodowego Ogrodu, tom1", "Jarosław Grzedowicz", "Fabryka Słów", 638, "Książka Fantastyczna opowiadającz historię toczącąsię na innej planecie", "2011", "@mipmap/ic_launcher"));
        books.add(new Book("Pan Lodowego Ogrodu, tom2", "Jarosław Grzedowicz", "Fabryka Słów", 538, "Książka Fantastyczna opowiadającz historię toczącąsię na innej planecie", "2011", "@mipmap/ic_launcher"));
        books.add(new Book("Pan Lodowego Ogrodu, tom3", "Jarosław Grzedowicz", "Fabryka Słów", 738, "Książka Fantastyczna opowiadającz historię toczącąsię na innej planecie", "2011", "@mipmap/ic_launcher"));
        books.add(new Book("Pan Lodowego Ogrodu, tom4", "Jarosław Grzedowicz", "Fabryka Słów", 580, "Książka Fantastyczna opowiadającz historię toczącąsię na innej planecie", "2001", "@mipmap/ic_launcher"));
        books.add(new Book("Pan Lodowego Ogrodu, tom1", "Jarosław Grzedowicz", "Fabryka Słów", 638, "Książka Fantastyczna opowiadającz historię toczącąsię na innej planecie", "2012", "@mipmap/ic_launcher"));
        books.add(new Book("Lód", "Jacek Dukaj", "Wydawnictwo Literackie", 1050, "Opowiada czasy gdy do pierwszej wojny światowej nie doszło", "2012", "image"));
        books.add(new Book("Red Rising, tom1", "Pierce Brown", "Drageus Publishing House", 428, "O nie równości społecznej", "2016", "@mipmap/ic_launcher"));
        books.add(new Book("Red Rising, tom2", "Pierce Brown", "Drageus Publishing House", 428, "O nie równości społecznej", "2017", "@mipmap/ic_launcher"));
        books.add(new Book("Red Rising, tom3", "Pierce Brown", "Drageus Publishing House", 428, "O nie równości społecznej", "2018", "@mipmap/ic_launcher"));
    }


    public static HomeFragment newInstance() {

        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
