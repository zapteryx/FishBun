package com.sangcomz.fishbun;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.sangcomz.fishbun.adapter.ImageAdapter;

import java.util.ArrayList;

/**
 * Created by seokwon.jeong on 04/01/2018.
 */

class Fishton {
    ImageAdapter imageAdapter;
    Uri[] pickerImages;

    //BaseParams
    int maxCount;
    int minCount;
    boolean isExceptGif;
    ArrayList<Uri> selectedImages = new ArrayList<>();


    //CustomizationParams
    int photoSpanCount;
    int albumPortraitSpanCount;
    int albumLandscapeSpanCount;

    boolean isAutomaticClose;
    boolean isButton;

    int colorActionBar;
    int colorActionBarTitle;
    int colorStatusBar;

    boolean isStatusBarLight;
    boolean isCamera;

    int albumThumbnailSize;

    String messageNothingSelected;
    String messageLimitReached;
    String titleAlbumAllView;
    String titleActionBar;

    Drawable drawableHomeAsUpIndicator;
    Drawable drawableOkButton;

    String strTextMenu;

    int colorTextMenu;

    boolean isUseDetailView;

    boolean isShowCount;


    private Fishton() {
        init();
    }

    static Fishton getInstance() {
        return FishtonHolder.INSTANCE;
    }

    private static class FishtonHolder {
        static final Fishton INSTANCE = new Fishton();
    }

    void refresh() {
        init();
    }

    private void init() {
        //Adapter
        imageAdapter = null;

        //BaseParams
        maxCount = 10;
        minCount = 1;
        isExceptGif = true;
        selectedImages = new ArrayList<>();

        //CustomizationParams
        photoSpanCount = 3;
        albumPortraitSpanCount = 1;
        albumLandscapeSpanCount = 2;

        isAutomaticClose = false;
        isButton = false;

        colorActionBar = Color.parseColor("#3F51B5");
        colorActionBarTitle = Color.parseColor("#ffffff");
        colorStatusBar = Color.parseColor("#303F9F");

        isStatusBarLight = false;
        isCamera = false;

        albumThumbnailSize = Integer.MAX_VALUE;

        messageNothingSelected = null;
        messageLimitReached = null;
        titleAlbumAllView = null;
        titleActionBar = null;

        drawableHomeAsUpIndicator = null;
        drawableOkButton = null;

        strTextMenu = null;


        colorTextMenu = Integer.MAX_VALUE;

        isUseDetailView = true;
        isShowCount = true;
    }

    void setDefaultMessage(Context context) {
        if (messageNothingSelected == null)
            messageNothingSelected = context.getResources().getString(R.string.msg_no_selected);

        if (messageLimitReached == null)
            messageLimitReached = context.getResources().getString(R.string.msg_full_image);

        if (titleAlbumAllView == null)
            titleAlbumAllView = context.getResources().getString(R.string.str_all_view);

        if (titleActionBar == null)
            titleActionBar = context.getResources().getString(R.string.album);
    }

    void setMenuTextColor() {
        if (drawableOkButton != null
                || strTextMenu == null
                || colorTextMenu != Integer.MAX_VALUE)
            return;

        if (isStatusBarLight)
            colorTextMenu = Color.BLACK;
        else
            colorTextMenu = Color.WHITE;
    }

    void setDefaultDimen(Context context) {
        if (albumThumbnailSize == Integer.MAX_VALUE)
            albumThumbnailSize = (int) context.getResources().getDimension(R.dimen.album_thum_size);
    }
}
