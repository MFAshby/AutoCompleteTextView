package com.autocompletetextview;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.widget.AppCompatAutoCompleteTextView;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactAutoCompleteTextView extends AppCompatAutoCompleteTextView  {
    public ReactAutoCompleteTextView(Context context) {
        super(context);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);

        WritableMap event = Arguments.createMap();
        event.putString("text", text.toString());
        ReactContext cx = findReactContext();
        if (cx != null) {
            cx.getJSModule(RCTEventEmitter.class).receiveEvent(getId(), "topChange", event);
        }
    }

    private ReactContext findReactContext() {
        Context cx = getContext();
        while (cx != null
                && !(cx instanceof ReactContext)
                && cx instanceof ContextWrapper) {
            cx = ((ContextWrapper)cx).getBaseContext();
        }
        return cx instanceof ReactContext ? (ReactContext)cx : null;
    }
}
