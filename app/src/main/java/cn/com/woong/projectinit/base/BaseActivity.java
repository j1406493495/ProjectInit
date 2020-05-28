package cn.com.woong.projectinit.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.woong.projectinit.R;

/**
 * @author wong
 */
public abstract class BaseActivity extends AppCompatActivity {
    KProgressHUD mKProgressHUD;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        setContentView(layoutId);
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onResume() {
        super.onResume();
        if (!NetworkUtils.isConnected()) {
            showNoNet();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void showLoading() {
        mKProgressHUD = KProgressHUD.create(this);
        mKProgressHUD.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
    }

    public void hideLoading() {
        if (mKProgressHUD != null) {
            mKProgressHUD.dismiss();
        }
    }

    public void showSuccess() {
    }

    public void showFailed() {
        ToastUtils.showShort(R.string.request_api_failed);
    }

    public void showNoNet() {
        ToastUtils.showShort(R.string.network_connect_error);
    }

    public void onRetry() {
    }

}
