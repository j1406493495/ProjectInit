package cn.com.woong.projectinit;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;

/**
 * @author wong
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


//    loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
//    viewModelSubscribe();
//
//    loginViewModel.login("", "");
//
//    private void viewModelSubscribe() {
//        loginViewModel.loginResult.observe(this, new Observer<Pair<Integer, LoginResp>>() {
//            @Override
//            public void onChanged(@Nullable Pair<Integer, LoginResp> integerLoginRespPair) {
//                LogUtils.i(TAG, "resultCode == " + integerLoginRespPair.first + ", LoginResp == " + integerLoginRespPair.second);
//            }
//        });
//    }
