package demo.leakcanary.srain.in.leakcanarydemo;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class ExampleApplication extends Application {

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        mRefWatcher = LeakCanary.install(this);
    }

}
