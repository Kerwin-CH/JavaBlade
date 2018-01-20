package com.huruwo.demo.controller;

import com.blade.jdbc.core.Fields;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.huruwo.demo.bean.Notes;
import com.huruwo.demo.bean.Users;
import com.huruwo.demo.response.ARestResponse;

import java.util.List;

@Path(value = "note")
public class NoteController {

    @PostRoute("list")
    @JSON
    public ARestResponse register(@Param int uid){

        try {


            //fields 表示取出特定的数据
            //List<Notes> list =new Notes().findAll(Fields.of("content"));

            List<Notes> list=new Notes().where("uid",uid).findAll();

            return ARestResponse.ok(list);
        }
        catch (Exception e){
            return ARestResponse.fail(e.getMessage());
        }

    }

    @PostRoute("add")
    @JSON
    public ARestResponse addNote(@Param int uid,@Param String content){

        try {

            Notes notes=new Notes();
            notes.setUid(uid);
            notes.setContent(content);
            notes.save();

            return ARestResponse.ok();
        }
        catch (Exception e){
            return ARestResponse.fail(e.getMessage());
        }

    }

}
