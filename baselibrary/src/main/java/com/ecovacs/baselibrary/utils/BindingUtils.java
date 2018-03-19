package com.ecovacs.baselibrary.utils;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.ecovacs.baselibrary.base.GlideApp;

/**
 * Created by liang.liu on 2018/3/16.
 */

public class BindingUtils {
    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView imageView, String imageUrl
                                   ) {
//        RequestOptions options = new RequestOptions()
//                .priority(Priority.HIGH)
//                .centerCrop();
//
//        GlideApp.with(imageView.getContext())
//                .load(imageUrl)
//                .apply(options)
//                .into(imageView);

        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);

//        **清除缓存**:
////清理磁盘缓存 需要在子线程中执行
//        Glide.get(this).clearDiskCache();
////清理内存缓存 可以在UI主线程中进行
//        Glide.get(this).clearMemory();
    }
}
