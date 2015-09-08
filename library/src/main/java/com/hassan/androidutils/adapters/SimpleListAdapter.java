package com.hassan.androidutils.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * BaseListAdapter
 *
 * @author Appostrophic
 * @since 3/12/13
 */
public class SimpleListAdapter<ITEM> extends BaseAdapter {

    private Activity ctx;
    ListItemBinder<ITEM> binder;

    public SimpleListAdapter (Activity activity, ListItemBinder<ITEM> binder) {
        this.ctx = activity;
        this.binder = binder;
    }

    @Override
    public int getCount () {
        return binder.getSize();
    }

    @Override
    public ITEM getItem (int position) {
        return binder.getItem( position );
    }

    @Override
    public long getItemId (int position) {
        return position;
    }

    @Override
    public View getView (int position, View view, ViewGroup parent) {
        binder.setPosition( position );
        final BaseHolder holder;
        if ( view == null ) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            view = binder.createView( inflater );
            view.setTag( holder = binder.createHolder( view ) );
        } else {
            holder = (BaseHolder) view.getTag();
        }
        final ITEM item = getItem( position );
        binder.decorateView( ctx, holder, view, item );
        binder.setData( ctx, holder, item );
        return view;
    }

    public void setItems (List<ITEM> newItems) {
        binder.setItems( newItems );
        notifyDataSetChanged();
    }

    public void addItem (ITEM newItem) {
        binder.addItem( newItem );
        notifyDataSetChanged();
    }
}
