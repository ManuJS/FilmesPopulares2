package com.manu.projeto.filmespopulares.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.manu.projeto.filmespopulares.R;
import com.manu.projeto.filmespopulares.models.Filme;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by emanu on 01/11/2016.
 */

public class GridViewAdapter extends BaseAdapter {
    private final Context mContext;


    private final Filme mLock = new Filme();

    private List<Filme> mObjects;
    private final LayoutInflater mInflater;

    public GridViewAdapter(Context context, List<Filme> objects) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mObjects = objects;
    }

    public Context getContext() {
        return mContext;
    }

    public void add(Filme object) {
        synchronized (mLock) {
            mObjects.add(object);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        synchronized (mLock) {
            mObjects.clear();
        }
        notifyDataSetChanged();
    }

    public void setData(List<Filme> data) {
        clear();
        for (Filme filme : data) {
            add(filme);
        }
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public Filme getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = mInflater.inflate(R.layout.item_grid_view, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        final Filme filme = getItem(position);

        String image_url = "http://image.tmdb.org/t/p/w185" + filme.getImage();

        viewHolder = (ViewHolder) view.getTag();

        Picasso.with(getContext()).load(image_url).into(viewHolder.imageView);
        viewHolder.titleView.setText(filme.getTituloFilme());
        return view;
    }

    public static class ViewHolder {
        public final ImageView imageView;
        public final TextView titleView;


        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.grid_item_image);
            titleView = (TextView) view.findViewById(R.id.grid_item_title);

        }
    }

}
