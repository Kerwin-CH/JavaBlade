package com.huruwo.restfulapp;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

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
//        helper.addOnClickListener(R.id.img_big).addOnClickListener(R.id.tv_look).addOnClickListener(R.id.tv_delete);
//
//        if (item.getPath() != null) {
//            ImageLoaderUtils.loadImageViewPath(item.getPath(), (ImageView) helper.getView(R.id.img_big));
//        } else {
//            ((ImageView) helper.getView(R.id.img_big)).setImageResource(R.drawable.ic_transparent);
//        }
//
//
//        NiceSpinner niceZhuangtai = (NiceSpinner) helper.getView(R.id.nice_zhuangtai);
//
//        if (item.getType() == 1) {
//            item.setBookstype(1);
//            final List<String> dataset = new LinkedList<>(Arrays.asList("本科", "大专","中专"));
//            niceZhuangtai.attachDataSource(dataset);
//            niceZhuangtai.addOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    item.setBookstype(position+1);
//                }
//            });
//        } else if (item.getType() == 2) {
//            item.setBookstype(0);
//            niceZhuangtai.setVisibility(View.GONE);
//            item.setBookstype(0);
//        } else if (item.getType() == 3) {
//            item.setBookstype(0);
//            niceZhuangtai.setVisibility(View.GONE);
//        } else if (item.getType() == 4) {
//            item.setBookstype(4);
//            final List<String> dataset = new LinkedList<>(Arrays.asList("省一级", "地级别","县级别"));
//            niceZhuangtai.attachDataSource(dataset);
//            niceZhuangtai.addOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    item.setBookstype(position+4);
//                }
//            });
//        } else if (item.getType() == 5) {
//            niceZhuangtai.setVisibility(View.GONE);
//        } else {
//            niceZhuangtai.setVisibility(View.GONE);
//        }
    }
}
