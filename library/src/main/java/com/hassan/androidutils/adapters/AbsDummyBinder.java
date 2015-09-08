package com.hassan.androidutils.adapters;

import java.util.ArrayList;

/**
 * AbsDummyBinder
 *
 * @author Hassan Jawed
 * @since 9/17/13
 */
public abstract class AbsDummyBinder extends ListItemBinder<String> {

    private final int size;

    protected AbsDummyBinder (int size) {
        super( new ArrayList<String>( size ) );
        this.size = size;
    }

    @Override
    public int getSize () {
        return size;
    }

    @Override
    public String getItem (int position) {
        return "Item " + (position + 1);
    }
}
