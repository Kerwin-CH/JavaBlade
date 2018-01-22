package com.huruwo.restfulapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huruwo.restfulapp.api.AppAplication;
import com.huruwo.restfulapp.api.AppDataRepository;
import com.huruwo.restfulapp.api.AppException;
import com.huruwo.restfulapp.api.bean.BaseBean;
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
                intent.putExtra("noteid",((NoteBean.DataBean)adapter.getData().get(position)).getNoteid());
                startActivity(intent);
            }
        });


        noteAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final BaseQuickAdapter adapter, View view, final int position) {

                new AlertDialog.Builder(NoteListActivity.this).setTitle("确认删除").setMessage("删除该条记事").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AppDataRepository.deleteNoteRepository(AppAplication.uid,((NoteBean.DataBean)adapter.getData().get(position)).getNoteid()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<BaseBean>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {
                                        mDisposable.add(d);
                                    }

                                    @Override
                                    public void onNext(BaseBean value) {
                                        if(value.getSuccess()==0){
                                             onError(new AppException(value.getMsg()));
                                        }else {
                                            Toast.makeText(getBaseContext(), "删除成功", Toast.LENGTH_SHORT).show();

                                        }

                                        //刷新
                                        adapter.remove(position);
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
                    }
                }).create().show();


                return false;
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



