package com.huruwo.demo.bean;

import com.blade.jdbc.annotation.Table;
import com.blade.jdbc.core.ActiveRecord;
import lombok.Data;

@Data
@Table(value = "t_notes", pk = "noteid")
public class Notes extends ActiveRecord {

    //注意不能用Integer
    private Integer noteid;
    private Integer uid;
    private String content;
}
