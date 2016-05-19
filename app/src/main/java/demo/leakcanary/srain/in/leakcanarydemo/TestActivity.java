package demo.leakcanary.srain.in.leakcanarydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class TestActivity extends Activity {

    boolean isClearReferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();
        isClearReferences = intent.getBooleanExtra("isClearReferences", false);

        TextView textView = (TextView) findViewById(R.id.test_text_view);
        textView.setText(isClearReferences ? R.string.warn_with_clear_references : R.string.warn_without_clear_references);
        textView.setText(textView.getText().toString().toUpperCase());

        TestDataModel.getInstance().setRetainedTextView(textView);
    }

    protected  void onDestroy() {
        if(isClearReferences) {
            TestDataModel.getInstance().clearReferences();
        }
        super.onDestroy();
    }
}