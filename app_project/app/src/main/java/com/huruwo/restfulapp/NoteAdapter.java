package com.huruwo.restfulapp;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huruwo.restfulapp.api.bean.NoteBean;

import java.util.List;

/**
 * Author ZYB
 * Created Time 2017/12/14.
 * 添加证书
 */
public class NoteAdapter extends BaseQuickAdapter<NoteBean.DataBean, BaseViewHolder> {

    public NoteAdapter(List list) {
        super(R.layout.item_note, list);
    }

    @Override
    protected void convert(BaseViewHolder helper, final NoteBean.DataBean item) {

        if(item!=null){
            helper.setText(R.id.text,item.getContent());
        }
        helper.addOnClickListener(R.id.item_root);
    }
}
