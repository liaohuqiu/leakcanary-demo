package demo.leakcanary.srain.in.leakcanarydemo;

import android.util.Log;
import android.widget.TextView;

public class TestDataModel {

    private static TestDataModel sInstance;
    private TextView mRetainedTextView;

    public static TestDataModel getInstance() {
        if (sInstance == null) {
            sInstance = new TestDataModel();
            Log.i("TestDataModel", "init for null");
        }
        return sInstance;
    }

    public void setRetainedTextView(TextView textView) {
        mRetainedTextView = textView;
    }

    public void clearReferences() {
        mRetainedTextView = null;
        sInstance = null;
    }
}