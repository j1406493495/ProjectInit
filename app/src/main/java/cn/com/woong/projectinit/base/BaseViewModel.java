package cn.com.woong.projectinit.base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Pair;

import cn.com.woong.projectinit.App;
import cn.com.woong.projectinit.domain.RxSchedulers;
import cn.com.woong.projectinit.domain.apiservice.ApiService;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author Woong on 2020/5/28
 * @website http://woong.cn
 */
public class BaseViewModel extends ViewModel {
    protected final String TAG = getClass().getSimpleName();

//    private CompositeDisposable compositeDisposable = new CompositeDisposable();
//
//    public MutableLiveData<Pair<Integer, LoginResp>> loginResult = new MutableLiveData<>();
//
//    public void login(final String username, final String password) {
//        Disposable loginDisposable = App.apiService(ApiService.class)
//                .apiLogin(username, password)
//                .compose(RxSchedulers.<LoginResp>io_main())
//                .subscribe(new Consumer<LoginResp>() {
//                    @Override
//                    public void accept(LoginResp resp) throws Exception {
//                        if (resp != null) {
//                            loginResult.setValue(new Pair(1, resp));
//                        }
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        loginResult.setValue(new Pair(-1, null));
//                    }
//                });
//        compositeDisposable.add(loginDisposable);
//    }
//
//    @Override
//    protected void onCleared() {
//        super.onCleared();
//        compositeDisposable.clear();
//    }
}

