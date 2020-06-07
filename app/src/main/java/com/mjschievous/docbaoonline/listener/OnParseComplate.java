package com.mjschievous.docbaoonline.listener;

import com.mjschievous.docbaoonline.model.Item;

import java.util.List;

public interface OnParseComplate {
    void onComplate(List<Item> items);
    void onFailure(String error);
}
