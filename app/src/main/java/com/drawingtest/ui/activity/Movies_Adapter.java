package com.drawingtest.ui.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.drawingtest.R;
import com.google.android.material.snackbar.Snackbar;

public class Movies_Adapter  extends RecyclerView.Adapter<Movies_Adapter.ViewHolder> {


    private String[] titles = {"Shrek",
            "Toy Story",
            "Avengers",
            "Family Guy",
            "IT"};

    private String[] details = {"Comedy",
            "Cartoon", "Action",
            "Cartoon", "Horror",
            };

    private int[] images = { R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};
    public int currentItem;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cardTitle;
        public ImageView cardImage;
        public TextView cardDetail;
        public int currentItem;

        public ViewHolder(View itemView) {
            super(itemView);
            cardImage= itemView.findViewById(R.id.cardimage);
            cardTitle=  itemView.findViewById(R.id.card_title);
            cardDetail = itemView.findViewById(R.id.card_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, titles[position],
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.activity_cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.cardTitle.setText(titles[position]);
        holder.cardDetail.setText(details[position]);
        holder.cardImage.setImageResource(images[position]);
    }



    @Override
    public int getItemCount() {
        return titles.length;
    }


}
