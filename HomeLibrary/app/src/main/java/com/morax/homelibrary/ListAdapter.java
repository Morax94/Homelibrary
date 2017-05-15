package com.morax.homelibrary;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import android.support.v7.widget.RecyclerView;

import io.realm.BookRealmRealmProxy;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

        private List<BookRealm> booksList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView title, author, date;
            public ImageView image;
            public MyViewHolder(View view) {
                super(view);
                title = (TextView) view.findViewById(R.id.title_textView);
                author = (TextView) view.findViewById(R.id.author_textView);
                date = (TextView) view.findViewById(R.id.date_text_View);
                image = (ImageView)view.findViewById(R.id.book_imageView);

            }
        }


        public ListAdapter(List<BookRealm> booksList) {
            this.booksList = booksList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_book, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            BookRealm book = booksList.get(position);
            holder.title.setText(book.getTitle());
            holder.author.setText(book.getAuthor());
            holder.date.setText(book.getDate());
            if(book.getImage()!=null)
            holder.image.setImageURI(Uri.parse(book.getImage()));
        }

        @Override
        public int getItemCount() {
            return booksList.size();
        }
    }


