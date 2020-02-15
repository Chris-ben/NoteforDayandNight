package com.chris_ben.notefordayandnight.android;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NotebooksFragment extends Fragment{

    private Notebook[] notebooks = {new Notebook("日",R.drawable.sun),new Notebook("月",R.drawable.moon)};
    private List<Notebook> notebookList = new ArrayList<>();
    private NotebookAdapter notebooks_adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNotebooks();
    }

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notebooks, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(MyApplication.getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        notebooks_adapter = new NotebookAdapter(notebookList);
        recyclerView.setAdapter(notebooks_adapter);
        return view;

    }

    public void initNotebooks(){
        notebookList.clear();
        for(int i=0;i<10;i++){
            Random random = new Random();
            int index = random.nextInt(notebooks.length);
            notebookList.add(notebooks[index]);
        }
    }
}

