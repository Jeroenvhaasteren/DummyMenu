package org.bts.atry.dummymenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ActionMode.Callback, View.OnLongClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageViewIcon = (ImageView) findViewById(R.id.image_view_main_activity);
        final ImageView imageViewStar = (ImageView) findViewById(R.id.image_view_star_icon_main_activity);
        this.registerForContextMenu(imageViewIcon);
        imageViewStar.setOnLongClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.item_add:
                Log.i(MainActivity.TAG, "Add item btn");
                break;
            case R.id.item_like:
                Log.i(MainActivity.TAG, "Like item btn");
                break;
            case R.id.item_dislike:
                Log.i(MainActivity.TAG, "Dislike item btn");
                break;
            default:
                Log.w(MainActivity.TAG, "No btn decleared");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.item_add:
                Log.i(MainActivity.TAG, "Add Context item btn");
                break;
            case R.id.item_like:
                Log.i(MainActivity.TAG, "Like Context item btn");
                break;
            case R.id.item_dislike:
                Log.i(MainActivity.TAG, "Dislike Context item btn");
                break;
            default:
                Log.w(MainActivity.TAG, "No Context btn decleared");
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    @Override
    public boolean onLongClick(View v) {

        switch(v.getId()) {
            case R.id.image_view_star_icon_main_activity:
                Log.i(MainActivity.TAG, "Star is clicked");
                this.startSupportActionMode(this);
                break;
            default:
                Log.i(MainActivity.TAG, "btn not registered");
                break;

        }

        return false;
    }
}
