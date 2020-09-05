package com.example.form_keluhan;

import android.view.View;

import java.util.List;

import at.lukle.clickableareasimage.ImageUtils;
import uk.co.senab.photoview.PhotoViewAttacher;

public class ClickableAreasImage implements PhotoViewAttacher.OnPhotoTapListener{


}

    @Override
    public void onPhotoTap(View view, float x, float y) {
        PixelPosition pixel = ImageUtils.getPixelPosition(x, y, imageWidthInPx, imageHeightInPx);
        List<ClickableArea> clickableAreas = getClickAbleAreas(pixel.getX(), pixel.getY());
        for(ClickableArea ca : clickableAreas){
            listener.onClickableAreaTouched(ca.getItem());

    }
}
