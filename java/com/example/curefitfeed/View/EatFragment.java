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

public class EatFragment extends Fragment {

    private RecyclerView eatRv;
    private EatAdapter eatAdapter;
    private LinearLayoutManager linearLayoutManager;
    private UnsplashImageViewModel unsplashImageViewModel;

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eat_fragment, null);
        eatRv = view.findViewById(R.id.eatFragmentRv);
        eatRv.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        eatRv.setLayoutManager(linearLayoutManager);
        //eatRv.scrollToPosition(eatAdapter.geti);
        eatAdapter = new EatAdapter(getActivity(), unsplashImageViewModel.getEatFeed());
        eatRv.setAdapter(eatAdapter);
        //System.out.println(unsplashImageViewModel.getEatFeed());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
