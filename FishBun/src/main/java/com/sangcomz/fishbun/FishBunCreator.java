package com.sangcomz.fishbun;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * Created by sangcomz on 17/05/2017.
 */

final class FishBunCreator implements FishBunProperty {

    private FishBun fishBun;
    private Fishton fishton;

    private int requestCode = 27;


    FishBunCreator(FishBun fishBun) {
        this.fishBun = fishBun;
        this.fishton = Fishton.getInstance();
    }

    public FishBunProperty setSelectedImages(ArrayList<Uri> selectedImages) {
        fishton.selectedImages = selectedImages;
        return this;
    }

    public FishBunProperty setAlbumThumbnailSize(int size) {
        fishton.albumThumbnailSize = size;
        return this;
    }

    @Override
    public FishBunProperty setPickerSpanCount(int spanCount) {
        if (spanCount <= 0)
            spanCount = 3;

        fishton.photoSpanCount = spanCount;
        return this;

    }

    @Override
    public FishBunProperty setMaxCount(int count) {
        if (count <= 0)
            count = 1;

        fishton.maxCount = count;
        return this;
    }

    @Override
    public FishBunProperty setMinCount(int count) {
        if (count <= 0)
            count = 1;
        fishton.minCount = count;
        return this;
    }

    @Override
    public FishBunProperty setActionBarColor(int actionbarColor) {
        fishton.colorActionBar = actionbarColor;
        return this;
    }

    @Override
    public FishBunProperty setActionBarTitleColor(int actionbarTitleColor) {
        fishton.colorActionBarTitle = actionbarTitleColor;
        return this;
    }

    @Override
    public FishBunProperty setActionBarColor(int actionbarColor, int statusBarColor) {
        fishton.colorActionBar = actionbarColor;
        fishton.colorStatusBar = statusBarColor;
        return this;
    }

    @Override
    public FishBunProperty setActionBarColor(int actionbarColor, int statusBarColor, boolean isStatusBarLight) {
        fishton.colorActionBar = actionbarColor;
        fishton.colorStatusBar = statusBarColor;
        fishton.isStatusBarLight = isStatusBarLight;
        return this;
    }

    @Override
    public FishBunProperty setCamera(boolean isCamera) {
        fishton.isCamera = isCamera;
        return this;
    }

    @Override
    public FishBunProperty setRequestCode(int requestCode) {
        this.requestCode = requestCode;
        return this;
    }

    @Override
    public FishBunProperty textOnNothingSelected(String message) {
        fishton.messageNothingSelected = message;
        return this;
    }

    @Override
    public FishBunProperty textOnImagesSelectionLimitReached(String message) {
        fishton.messageLimitReached = message;
        return this;
    }

    @Override
    public FishBunProperty setButtonInAlbumActivity(boolean isButton) {
        fishton.isButton = isButton;
        return this;
    }

    @Override
    public FishBunProperty setReachLimitAutomaticClose(boolean isAutomaticClose) {
        fishton.isAutomaticClose = isAutomaticClose;
        return this;
    }

    @Override
    public FishBunProperty setAlbumSpanCount(int portraitSpanCount, int landscapeSpanCount) {
        fishton.albumPortraitSpanCount = portraitSpanCount;
        fishton.albumLandscapeSpanCount = landscapeSpanCount;
        return this;
    }

    @Override
    public FishBunProperty setAlbumSpanCountOnlyLandscape(int landscapeSpanCount) {
        fishton.albumLandscapeSpanCount = landscapeSpanCount;
        return this;
    }

    @Override
    public FishBunProperty setAlbumSpanCountOnlPortrait(int portraitSpanCount) {
        fishton.albumPortraitSpanCount = portraitSpanCount;
        return this;
    }

    @Override
    public FishBunProperty setAllViewTitle(String allViewTitle) {
        fishton.titleAlbumAllView = allViewTitle;
        return this;
    }

    @Override
    public FishBunProperty setActionBarTitle(String actionBarTitle) {
        fishton.titleActionBar = actionBarTitle;
        return this;
    }

    @Override
    public FishBunProperty setHomeAsUpIndicatorDrawable(Drawable icon) {
        fishton.drawableHomeAsUpIndicator = icon;
        return this;
    }

    @Override
    public FishBunProperty setOkButtonDrawable(Drawable icon) {
        fishton.drawableOkButton = icon;
        return this;
    }

    @Override
    public FishBunProperty exceptGif(boolean isExcept) {
        fishton.isExceptGif = isExcept;
        return this;
    }

    @Override
    public FishBunProperty setMenuText(String text) {
        fishton.strTextMenu = text;
        return this;
    }

    @Override
    public FishBunProperty setMenuTextColor(int textColor) {
        fishton.colorTextMenu = textColor;
        return this;
    }

    @Override
    public FishBunProperty setIsUseDetailView(boolean isUse) {
        fishton.isUseDetailView = isUse;
        return this;
    }

    @Override
    public FishBunProperty setIsShowCount(boolean isShow) {
        fishton.isShowCount = isShow;
        return this;
    }

    @Override
    public void startAlbum() {
        Context context = null;
        Activity activity = fishBun.activity.get();
        Fragment fragment = fishBun.fragment.get();
        if (activity != null)
            context = activity;
        else if (fragment != null)
            context = fragment.getActivity();
        else
            try {
                throw new NullPointerException("Activity or Fragment Null");
            } catch (Exception e) {
                e.printStackTrace();
            }

        if (fishton.imageAdapter == null)
            throw new NullPointerException("ImageAdapter is Null");

        fishton.setDefaultMessage(context);
        fishton.setMenuTextColor();
        fishton.setDefaultDimen(context);

        Intent i = new Intent(context, AlbumActivity.class);
        if (activity != null) activity.startActivityForResult(i, requestCode);
        else if (fragment != null) fragment.startActivityForResult(i, requestCode);

    }
}