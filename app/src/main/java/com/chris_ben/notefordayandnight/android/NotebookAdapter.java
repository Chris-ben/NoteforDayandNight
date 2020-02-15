package com.chris_ben.notefordayandnight.android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NotebookAdapter extends RecyclerView.Adapter<NotebookAdapter.ViewHolder> {
    private Context mContext;
    private List<Notebook> mNotebookList;

    static  class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView notebookImage;
        TextView notebookName;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView)view;
            notebookImage = (ImageView)view.findViewById(R.id.notebook_image);
            notebookName = (TextView)view.findViewById(R.id.notebook_name);
        }
    }

    public NotebookAdapter(List<Notebook> notebookList){
        mNotebookList = notebookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.notebook_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Notebook notebook = mNotebookList.get(position);
        holder.notebookName.setText(notebook.getName());
        holder.notebookImage.setImageResource(notebook.getImageId());
    }

    @Override
    public int getItemCount() {
        return mNotebookList.size();
    }
}
