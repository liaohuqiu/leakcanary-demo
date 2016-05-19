package demo.leakcanary.srain.in.leakcanarydemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_go_to_test_with_clear_references).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTest(true);
            }
        });
        findViewById(R.id.btn_go_to_test_without_clear_references).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTest(false);
            }
        });
    }

    private void goToTest(boolean isClearReferences) {
        Intent intent = new Intent(this, TestActivity.class);
        intent.putExtra("isClearReferences", isClearReferences);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_go_to_test_with_clear_references) {
            goToTest(true);
            return true;
        }
        else if(id == R.id.action_go_to_test_without_clear_references) {
            goToTest(false);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
