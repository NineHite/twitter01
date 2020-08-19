package com.hitenine.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 元数据的更新与插入
 * @author Hitenine
 */
@Component
public class MyMpMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        this.fillStrategy(metaObject, "createTime", date);
        this.fillStrategy(metaObject, "updateTime", date);
        this.fillStrategy(metaObject, "status", 0);
        // this.setFieldValByName("createTime", new Date(), metaObject);
        // this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "updateTime", new Date());
        // this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
