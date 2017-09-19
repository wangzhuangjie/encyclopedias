package com.encyclopedias.ui.widget.infinitepager;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by lightsky on 16/1/31.
 */
public class GlideLoader implements ImageLoader {

    @Override
    public void initLoader(Context context) {

    }

    @Override
    public void load(Context context, ImageView targetView, Object res) {

        if (res instanceof String) {
            Glide.with(context)
                    .load((String) res)
                    .centerCrop()
//                    .placeholder(R.mipmap.bg_spotlight_default).diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .error(R.mipmap.bg_spotlight_default)
                    .crossFade()
                    .into(targetView);
        }
    }
}
