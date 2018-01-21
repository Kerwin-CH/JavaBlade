package com.huruwo.restfulapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huruwo.restfulapp.api.AppAplication;
import com.huruwo.restfulapp.api.AppDataRepository;
import com.huruwo.restfulapp.api.bean.NoteBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NoteListActivity extends AppCompatActivity {

    private RecyclerView noteList;
    private FloatingActionButton fab;

    private NoteAdapter noteAdapter;

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        noteList = (RecyclerView) findViewById(R.id.note_list);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        noteAdapter = new NoteAdapter(null);
        noteAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(NoteListActivity.this,NoteAddActivity.class);
                intent.putExtra("content",((NoteBean.DataBean)adapter.getData().get(position)).getContent());
                startActivity(intent);
            }
        });

        noteList.setLayoutManager(new LinearLayoutManager(this));
        noteList.setAdapter(noteAdapter);
        //noteList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoteListActivity.this,NoteAddActivity.class));
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getData();
    }

    public void getData(){
        AppDataRepository.getNoteListRepository(AppAplication.uid).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NoteBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(NoteBean value) {
                        Log.i("danxx", "setValue------>");
                        noteAdapter.setNewData(value.getData());
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
}



