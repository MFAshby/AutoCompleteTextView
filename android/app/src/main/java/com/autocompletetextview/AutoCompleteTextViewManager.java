package com.autocompletetextview;

import android.widget.ArrayAdapter;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.ArrayList;

public class AutoCompleteTextViewManager extends SimpleViewManager<ReactAutoCompleteTextView> {
    @Override
    public String getName() {
        return "RCTAutoCompleteTextView";
    }

    @Override
    protected ReactAutoCompleteTextView createViewInstance(ThemedReactContext reactContext) {
        return new ReactAutoCompleteTextView(reactContext);
    }

    @ReactProp(name="listData")
    public void setListData(ReactAutoCompleteTextView textView, ReadableArray listData) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < listData.size(); i++) {
            arrayList.add(listData.getString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(textView.getContext(), android.R.layout.simple_dropdown_item_1line, arrayList);
        textView.setAdapter(adapter);
    }
}
