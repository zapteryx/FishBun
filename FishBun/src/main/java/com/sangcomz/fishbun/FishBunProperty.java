package com.sangcomz.fishbun;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.util.ArrayList;

public interface FishBunProperty {
    FishBunProperty setSelectedImages(ArrayList<Uri> arrayPaths);


    FishBunProperty setMaxCount(int count);

    FishBunProperty setMinCount(int count);

    FishBunProperty setRequestCode(int RequestCode);

    FishBunProperty setReachLimitAutomaticClose(boolean isAutomaticClose);

    FishBunProperty exceptGif(boolean isExcept);

    void startAlbum();

    //custom
    FishBunProperty setAlbumThumbnailSize(int size);

    FishBunProperty setPickerSpanCount(int spanCount);

    FishBunProperty setActionBarColor(int actionbarColor);

    FishBunProperty setActionBarTitleColor(int actionbarTitleColor);

    FishBunProperty setActionBarColor(int actionbarColor, int statusBarColor);

    FishBunProperty setActionBarColor(int actionbarColor, int statusBarColor, boolean isStatusBarLight);

    FishBunProperty setCamera(boolean isCamera);

    FishBunProperty textOnNothingSelected(String message);

    FishBunProperty textOnImagesSelectionLimitReached(String message);

    FishBunProperty setButtonInAlbumActivity(boolean isButton);

    FishBunProperty setAlbumSpanCount(int portraitSpanCount, int landscapeSpanCount);

    FishBunProperty setAlbumSpanCountOnlyLandscape(int landscapeSpanCount);

    FishBunProperty setAlbumSpanCountOnlPortrait(int portraitSpanCount);

    FishBunProperty setAllViewTitle(String allViewTitle);

    FishBunProperty setActionBarTitle(String actionBarTitle);

    FishBunProperty setHomeAsUpIndicatorDrawable(Drawable icon);

    FishBunProperty setOkButtonDrawable(Drawable icon);

    FishBunProperty setMenuText(String text);

    FishBunProperty setMenuTextColor(int color);

    FishBunProperty setIsUseDetailView(boolean isUse);

    FishBunProperty setIsShowCount(boolean isShow);
}
