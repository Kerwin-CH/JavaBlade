package com.huruwo.demo.controller;

import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.huruwo.demo.bean.Notes;
import com.huruwo.demo.response.ARestResponse;

import java.util.List;

@Path(value = "note")
public class NoteController {

    @PostRoute("list")
    @JSON
    public ARestResponse register(@Param int uid) {

        try {


            //fields 表示取出特定的数据
            //List<Notes> list =new Notes().findAll(Fields.of("content"));

            List<Notes> list = new Notes().where("uid", uid).findAll();

            return ARestResponse.ok(list);
        } catch (Exception e) {
            return ARestResponse.fail(e.getMessage());
        }

    }

    @PostRoute("add")
    @JSON
    public ARestResponse addNote(@Param int uid, @Param String content) {

        try {

            if (uid == 0) {
                return ARestResponse.fail("请正确填写id");
            }

            if (content == null) {
                return ARestResponse.fail("内容不能为空");
            }

            Notes notes = new Notes();
            notes.setUid(uid);
            notes.setContent(content);
            notes.save();

            return ARestResponse.ok();
        } catch (Exception e) {
            return ARestResponse.fail(e.getMessage());
        }

    }

}
