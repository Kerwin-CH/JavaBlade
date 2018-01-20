package com.huruwo.restfulapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.huruwo.restfulapp.api.AppDataRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private final CompositeDisposable mDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDataRepository.getFuliDataRepository("", "").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<LoginBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                mDisposable.add(d);
                            }

                            @Override
                            public void onNext(LoginBean value) {
                                Log.i("danxx", "setValue------>");
                                if(value.getData()!=null)
                                Toast.makeText(getBaseContext(),value.getData().getEmail(), Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(MainActivity.this,NoteActivity.class));
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("danxx", "onError------>");
                                e.printStackTrace();
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
