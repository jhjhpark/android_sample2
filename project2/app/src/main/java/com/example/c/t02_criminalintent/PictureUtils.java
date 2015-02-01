package com.example.c.t02_criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.widget.ImageView;

/**
 * Created by c on 2015-02-01.
 */
public class PictureUtils {
    public static BitmapDrawable getScaledDrawable(Activity a, String path){
        Display dispaly = a.getWindowManager().getDefaultDisplay();
        float destWidth = dispaly.getWidth();
        float destHeight = dispaly.getHeight();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        int inSmapleSize = 1;
        if(srcHeight > destHeight || srcWidth > destWidth){
            if(srcWidth > srcHeight){
                inSmapleSize = Math.round(srcHeight/destHeight);
            }else{
                inSmapleSize = Math.round(srcWidth / destWidth);
            }
        }
        options = new BitmapFactory.Options();
        options.inSampleSize = inSmapleSize;

        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        return new BitmapDrawable(a.getResources(), bitmap);
    }

    public static void cleanImageView(ImageView imageView){
        if( !(imageView.getDrawable() instanceof BitmapDrawable ))
            return;

        BitmapDrawable b= (BitmapDrawable)imageView.getDrawable();
        b.getBitmap().recycle();
        imageView.setImageDrawable(null);
    }
}













