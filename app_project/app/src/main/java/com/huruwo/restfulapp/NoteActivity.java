package com.huruwo.restfulapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.huruwo.restfulapp.api.AppDataRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NoteActivity extends AppCompatActivity {


    private RecyclerView noteList;
    private NoteAdapter noteAdapter;

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        noteList = (RecyclerView) findViewById(R.id.note_list);

        noteAdapter=new NoteAdapter(null);

        noteList.setLayoutManager(new LinearLayoutManager(this));
        noteList.setAdapter(noteAdapter);



        AppDataRepository.getNoteListRepository(2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
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



