package cn.com.woong.projectinit.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.woong.projectinit.R;

/**
 * @author wong
 */
public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    private View mRootView, mErrorView, mEmptyView;
    private KProgressHUD mKProgressHUD;

    protected abstract int getLayoutId();

    protected abstract void initView(View view);

    protected abstract void initData();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflaterView(inflater, container);
        unbinder = ButterKnife.bind(this, mRootView);
        initView(mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!NetworkUtils.isConnected()) {
            showNoNet();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void showLoading() {
        mKProgressHUD = KProgressHUD.create(getActivity());
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

    public void showSuccess() {}

    public void showFailed() {
        ToastUtils.showShort(R.string.request_api_failed);
    }

    public void showNoNet() {
        ToastUtils.showShort(R.string.network_connect_error);
    }

    public void onRetry() {
        ToastUtils.showShort("onRetry");
    }

    /**
     * 设置View
     *
     * @param inflater
     * @param container
     */
    private void inflaterView(LayoutInflater inflater, @Nullable ViewGroup container) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
        }
    }

}
