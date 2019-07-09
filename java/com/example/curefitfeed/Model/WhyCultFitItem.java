package com.example.curefitfeed.Model;

import java.util.ArrayList;
import java.util.List;

public class WhyCultFitItem implements CustomListItem {

    String headerInfo1;
    ArrayList<WhycultfitDetail> detailList;

    public WhyCultFitItem(String headerInfo1, ArrayList<WhycultfitDetail> detailList) {
        this.headerInfo1 = headerInfo1;
        this.detailList = detailList;
    }

    public String getHeaderInfo1() {
        return headerInfo1;
    }

    public void setHeaderInfo1(String headerInfo1) {
        this.headerInfo1 = headerInfo1;
    }

    public ArrayList<WhycultfitDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(ArrayList<WhycultfitDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public int getType() {
        return CustomListItem.TYPE_WHYMINDFIT;
    }
}
