package demo.leakcanary.srain.in.leakcanarydemo;

import android.widget.TextView;

public class TestDataModel {

    private static TestDataModel sInstance;
    private TextView mRetainedTextView;

    public static TestDataModel getInstance() {
        if (sInstance == null) {
            sInstance = new TestDataModel();
        }
        return sInstance;
    }

    public void setRetainedTextView(TextView textView) {
        mRetainedTextView = textView;
    }
}