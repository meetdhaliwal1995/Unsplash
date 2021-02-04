package com.example.slidepanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.MediaStoreSignature;

public class GitMapClass extends AsyncTask<Bitmap, Bitmap, Bitmap> {

    String url;
    AdapterSongs.ViewHolder holder;
    int position;
    Bitmap bitmapasset;
    private byte[] art;
    private Context context;
    MediaMetadataRetriever mediaMetadataRetriever;

    GitMapClass(Context context, String url, AdapterSongs.ViewHolder holder, int position) {
        this.url = url;
        this.holder = holder;
        this.position = position;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Glide.with(context).clear(holder.songArt);
        //holder.songArt.setImageDrawable(null);
    }

    @Override
    protected Bitmap doInBackground(Bitmap... bitmaps) {
        try {
            MediaMetadataRetriever metaRetriver = new MediaMetadataRetriever();
            metaRetriver.setDataSource(url);
            art = metaRetriver.getEmbeddedPicture();
            if (art != null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 4;
                return BitmapFactory.decodeByteArray(art, 0, art.length, options);
            } else {
                return bitmapasset;
            }
        } catch (Exception e) {
            return bitmapasset;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        Glide.with(context)
                .load(art)
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .skipMemoryCache(true)
                        .error(R.drawable.musicimg)
                        .override(150,150)
                        .signature(new MediaStoreSignature(String.valueOf(System.currentTimeMillis()), 0, 0)))
                .into(holder.albumArt);
    }
}