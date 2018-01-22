package com.huruwo.restfulapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.huruwo.restfulapp.api.AppAplication;
import com.huruwo.restfulapp.api.AppDataRepository;
import com.huruwo.restfulapp.api.AppException;
import com.huruwo.restfulapp.api.bean.BaseBean;
import com.huruwo.restfulapp.api.bean.LoginBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edPass;
    private Button button;
    private Button button2;



    private final CompositeDisposable mDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = (EditText) findViewById(R.id.ed_name);
        edPass = (EditText) findViewById(R.id.ed_pass);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDataRepository.userLoginRepository(edName.getText().toString().trim(), edPass.getText().toString().trim()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<LoginBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                mDisposable.add(d);
                            }

                            @Override
                            public void onNext(LoginBean value) {
                                Log.i("danxx", "setValue------>");

                                if(value.getSuccess()==1) {
                                    Toast.makeText(getBaseContext(), "登录成功", Toast.LENGTH_SHORT).show();
                                    AppAplication.uid=value.getData().getUid();
                                    startActivity(new Intent(LoginActivity.this, NoteListActivity.class));
                                    finish();
                                }else {
                                    onError(new AppException(value.getMsg()));
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("danxx", "onError------>");
                                e.printStackTrace();
                                Toast.makeText(getBaseContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onComplete() {
                                Log.i("danxx", "onComplete------>");
                            }
                        });
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataRepository.userRegisterRepository(edName.getText().toString().trim(), edPass.getText().toString().trim()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<BaseBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                mDisposable.add(d);
                            }

                            @Override
                            public void onNext(BaseBean value) {
                                Log.i("danxx", "setValue------>");

                                if(value.getSuccess()==1) {
                                    Toast.makeText(getBaseContext(), "注册成功，请登录", Toast.LENGTH_SHORT).show();
                                }else {
                                    onError(new AppException(value.getMsg()));
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("danxx", "onError------>");
                                e.printStackTrace();
                                Toast.makeText(getBaseContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onComplete() {
                                Log.i("danxx", "onComplete------>");
                            }
                        });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
    }
}
