package com.ecovacs.baselibrary.bindView;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.ecovacs.baselibrary.base.GlideApp;


/**
 * Created by liang.liu on 2018/3/13.
 */

public class ImageViewBind {

    @BindingAdapter({"uri"})
    public static void setImageUri(ImageView imageView, String uri) {
        if (!TextUtils.isEmpty(uri)) {
            imageView.setImageURI(Uri.parse(uri));
        }
    }


    @BindingAdapter(value = {"url", "placeholderImageRes", "failedImageRes",
            "request_width", "request_height"},
            requireAll = false)
    public static void loadImage(ImageView imageView, String url,
                                 @DrawableRes int placeholderImageRes,
                                 @DrawableRes int failedImageRes,
                                 int width, int height) {

        RequestOptions options = new RequestOptions()
                .placeholder(placeholderImageRes)
                .error(failedImageRes)
                .fallback(failedImageRes)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .priority(Priority.HIGH)
                .override(width, height)
                .centerCrop();

        GlideApp.with(imageView.getContext())
                .load(url)
                .apply(options)
                .into(imageView);

//        **清除缓存**:
////清理磁盘缓存 需要在子线程中执行
//        Glide.get(this).clearDiskCache();
////清理内存缓存 可以在UI主线程中进行
//        Glide.get(this).clearMemory();
    }
}
