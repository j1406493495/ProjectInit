package cn.com.woong.projectinit;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.facebook.stetho.Stetho;
import com.tencent.bugly.Bugly;

import butterknife.ButterKnife;
import cn.com.woong.projectinit.domain.ApiManager;

/**
 * @author wong
 */
public class App extends Application {
    private static App mInstance;
    private ApiManager mApiManager = null;

    public static App getInstance() {
        return mInstance;
    }

    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }

    public static <T> T apiService(Class<T> clz) {
        return getInstance().mApiManager.getService(clz);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mApiManager = new ApiManager();
        Utils.init(mInstance);
        Stetho.initializeWithDefaults(this);
        ButterKnife.setDebug(true);
        Bugly.init(getApplicationContext(), "aee572880a", true);
    }

    public <T> void addApiService(Class<T> clz) {
        getInstance().mApiManager.addService(clz);
    }
}
