package com.huruwo.restfulapp;

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

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NoteAddActivity extends AppCompatActivity {

    private EditText edNote;
    private Button button;
    private int noteid;
    private String content;
    private final CompositeDisposable mDisposable = new CompositeDisposable();
    private boolean isEdit=false;//是否进入编辑


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);
        edNote = (EditText) findViewById(R.id.ed_note);
        button = (Button) findViewById(R.id.button);

        noteid=getIntent().getIntExtra("noteid",0);
        content=getIntent().getStringExtra("content");

        if(noteid>0) {
            edNote.setText(content);
            isEdit=true;
        }



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                content=edNote.getText().toString().trim();

                if (edNote.getText().toString().trim().length() > 0) {

                    if(isEdit){
                        AppDataRepository.updateNoteRepository(AppAplication.uid,noteid,content).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BaseBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                mDisposable.add(d);
                            }

                            @Override
                            public void onNext(BaseBean value) {
                                Log.i("danxx", "setValue------>");
                                if (value.getSuccess() == 0) {
                                    onError(new AppException(value.getMsg()));
                                } else {
                                    Toast.makeText(getBaseContext(), "修改成功", Toast.LENGTH_SHORT).show();
                                    finish();
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
                        });;
                    }
                    else {
                        AppDataRepository.addNoteRepository(AppAplication.uid, content).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<BaseBean>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {
                                        mDisposable.add(d);
                                    }

                                    @Override
                                    public void onNext(BaseBean value) {
                                        Log.i("danxx", "setValue------>");
                                        if (value.getSuccess() == 0) {
                                            onError(new AppException(value.getMsg()));
                                        } else {
                                            Toast.makeText(getBaseContext(), "添加成功", Toast.LENGTH_SHORT).show();
                                            finish();
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
                }
                else {Toast.makeText(getBaseContext(),"你还没写东西呢!!!", Toast.LENGTH_SHORT).show();}
            }
        });
    }
}
