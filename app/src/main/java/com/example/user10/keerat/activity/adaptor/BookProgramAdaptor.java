package com.example.user10.keerat.activity.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.user10.keerat.R;
import com.example.user10.keerat.activity.model.BookProgramModel;

import java.util.ArrayList;

/**
 * Created by designer on 11/25/2017.
 */

public class BookProgramAdaptor extends ArrayAdapter<BookProgramModel> implements View.OnClickListener {

    private ArrayList<BookProgramModel> bookprogramSet;
    Context mContext;


    // View lookup cache
    private static class ViewHolder {
        TextView tvavailble;
        TextView tvprovidername;
        ImageView ivimage;
        RatingBar rbrating;
    }

   public BookProgramAdaptor(ArrayList<BookProgramModel>data,Context context){
        super(context, R.layout.book_my_program_row);

       this.bookprogramSet = data;
       this.mContext=context;
   }


    @Override
    public void onClick(View view) {

    }
    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        BookProgramModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.book_my_program_row, parent, false);
            viewHolder.tvavailble = (TextView) convertView.findViewById(R.id.tv_availble);
            viewHolder.tvprovidername = (TextView) convertView.findViewById(R.id.tv_providername);
            viewHolder.rbrating = (RatingBar) convertView.findViewById(R.id.rb_rating);
            viewHolder.ivimage = (ImageView) convertView.findViewById(R.id.iv_bookprogram);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        lastPosition = position;

        viewHolder.tvavailble.setText(dataModel.getAvailable());
        viewHolder.tvprovidername.setText(dataModel.getProvidername());
//        viewHolder.rbrating.setMax(dataModel.getRating());
//        viewHolder.info.setOnClickListener(this);
//        viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
