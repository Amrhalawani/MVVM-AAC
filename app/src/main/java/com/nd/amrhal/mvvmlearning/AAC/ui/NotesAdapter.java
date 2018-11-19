package com.nd.amrhal.mvvmlearning.AAC.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nd.amrhal.mvvmlearning.AAC.data.note;
import com.nd.amrhal.mvvmlearning.R;

import java.util.List;

/**
 * Created by amr on 19.11.2018.
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.BindingHolder> {

    private List<note> mNotes;
    private Context mContext;
    LayoutInflater layoutInflater;

    public NotesAdapter(List<note> mNotes, Context mContext) {
        this.mNotes = mNotes;
        this.mContext = mContext;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_note, parent, false);

        BindingHolder myViewholder = new BindingHolder(view);

        return myViewholder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {

        if (mNotes != null) {
            note current = mNotes.get(position);
            holder.title.setText(current.getTitle());
            holder.body.setText(current.getBody());
        } else {
            // Covers the case of data not being ready yet.
            holder.title.setText("No title");
            holder.body.setText("No body");

        }

    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        TextView title, body;

        public BindingHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);


        }
    }
}
