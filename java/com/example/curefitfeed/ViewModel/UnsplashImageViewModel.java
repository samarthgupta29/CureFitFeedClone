package com.example.curefitfeed.ViewModel;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.curefitfeed.Model.CustomListItem;
import com.example.curefitfeed.Model.UnsplashImagePOJO;
import com.example.curefitfeed.Model.UnsplashImageResult;
import com.example.curefitfeed.Repository.InputStreamHelper;
import com.example.curefitfeed.Repository.UnsplashImageRepository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UnsplashImageViewModel extends ViewModel {

    private MutableLiveData<List<UnsplashImagePOJO>> unsplashImagePOJOMutableLiveData;
    private UnsplashImageRepository unsplashImageRepository;
    private ArrayList<CustomListItem> listItems;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void init(InputStreamHelper inputStreamHelper) {
        if (unsplashImagePOJOMutableLiveData != null) {
            return;
        }
        unsplashImageRepository = UnsplashImageRepository.getInstance(inputStreamHelper);
        //unsplashImagePOJOMutableLiveData = unsplashImageRepository.getImages();
        //listItems=unsplashImageRepository.getCultFeed();
    }

    public LiveData<List<UnsplashImagePOJO>> getUnsplashImageRepository() {
        return unsplashImagePOJOMutableLiveData;
    }

    public List<CustomListItem> getEatFeed(){
        return unsplashImageRepository.getEatFeed();
    }

    public List<CustomListItem> getMindFeed(){
        return unsplashImageRepository.getMindFeed();
    }

    /*public List<CustomListItem> getCultFeed(){
        return unsplashImageRepository.getCultFeed();
    }*/

}
