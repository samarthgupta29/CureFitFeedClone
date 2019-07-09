package com.example.curefitfeed.View;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curefitfeed.Adapter.EatAdapter;
import com.example.curefitfeed.R;
import com.example.curefitfeed.Repository.InputStreamHelper;
import com.example.curefitfeed.ViewModel.UnsplashImageViewModel;

import java.io.IOException;
import java.io.InputStream;

public class MindFragment extends Fragment {
    private UnsplashImageViewModel unsplashImageViewModel;
    private RecyclerView mindRv;
    private EatAdapter eatAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unsplashImageViewModel = ViewModelProviders.of(getActivity()).get(UnsplashImageViewModel.class);
        unsplashImageViewModel.init(new InputStreamHelper() {

            @Override
            public InputStream getInputStream(String file) {
                try {
                    if(getActivity()!=null){
                        return getActivity().getAssets().open(file);
                    } else {
                        return null;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mind_fragment,null);
        mindRv = view.findViewById(R.id.mindRv);
        mindRv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        mindRv.setLayoutManager(layoutManager);
        eatAdapter = new EatAdapter(getActivity(),unsplashImageViewModel.getMindFeed());
        mindRv.setAdapter(eatAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //System.out.println(unsplashImageViewModel.getMindFeed());
    }
}
