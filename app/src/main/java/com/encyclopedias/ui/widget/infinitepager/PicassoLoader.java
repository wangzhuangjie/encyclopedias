package com.encyclopedias.ui.widget.infinitepager;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by lightsky on 16/1/28.
 */

public class PicassoLoader implements ImageLoader {

    public PicassoLoader getImageLoader(Context context) {
        return new PicassoLoader();
    }

    @Override
    public void initLoader(Context context) {

    }

    @Override
    public void load(Context context, ImageView targetView, Object res) {
//        if (res == null) {
//            return;
//        }
//
//        Picasso picasso = Picasso.with(context);
//        RequestCreator requestCreator = null;
//
//        if (res instanceof String) {
//            requestCreator = picasso.load((String) res);
//        } else if (res instanceof File) {
//            requestCreator = picasso.load((File) res);
//        } else if (res instanceof Integer) {
//            requestCreator = picasso.load((Integer) res);
//        }
//        requestCreator
//                .centerCrop()
//                .resize(targetView.getWidth(), targetView.getHeight())
//                .tag(context)
//                .into(targetView);
    }

}
