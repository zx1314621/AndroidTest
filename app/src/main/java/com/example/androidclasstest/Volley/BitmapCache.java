package com.example.androidclasstest.Volley;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by MECHREVO on 2018/4/15.
 */

public class BitmapCache implements ImageLoader.ImageCache {
    private LruCache<String ,Bitmap> mCache;

    public  BitmapCache(){
        int maxSize = 10 * 1024 *1024;
        mCache = new LruCache<String, Bitmap>(maxSize){
            protected  int sizeOf(String key,Bitmap bitmap){
                return  bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        mCache.put(s,bitmap);

    }
}

