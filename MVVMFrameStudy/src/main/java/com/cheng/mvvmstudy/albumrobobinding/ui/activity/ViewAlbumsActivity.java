package com.cheng.mvvmstudy.albumrobobinding.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.cheng.mvvmstudy.R;
import com.cheng.mvvmstudy.albumrobobinding.base.BaseAbstractUi;
import com.cheng.mvvmstudy.albumrobobinding.viewmodel.ViewAlbumsPresentationModel;
import com.cheng.mvvmstudy.albumrobobinding.ui.i.IViewAlbumsView;

/**
 * @author Robert Taylor
 * @version $Revision: 1.0 $
 * @since 1.0
 */
public class ViewAlbumsActivity extends BaseAbstractUi implements IViewAlbumsView {
    protected ViewAlbumsPresentationModel presentationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presentationModel = new ViewAlbumsPresentationModel(this, getAlbumStore());
        initializeContentView(R.layout.activity_viewalbums, presentationModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presentationModel.refreshAlbums();
    }

    @Override
    public void createAlbum() {
        startActivity(new Intent(this, CreateEditAlbumActivity.class));
    }

    @Override
    public void viewAlbum(long albumId) {
        Intent intent = new Intent(this, ViewAlbumActivity.class);
        intent.putExtra(ViewAlbumActivity.ALBUM_ID, albumId);
        startActivity(intent);
    }
}