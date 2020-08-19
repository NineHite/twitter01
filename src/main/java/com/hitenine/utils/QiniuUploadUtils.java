package com.hitenine.utils;

import com.google.gson.Gson;
import com.qiniu.common.Region;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Hitenine
 */
@ConfigurationProperties(prefix = "qiniu.config")
@Component
@Data
public class QiniuUploadUtils {

    // private static final String accessKey = "Jzv_bSB4SBqGUT7t_BNg6Re-T3Irri7mWsfoqM2l";
    // private static final String secretKey = "5t55NHRvKXqkk4GHWF549kNKWRvwwWUMBbTYnMsn";
    // private static final String bucket = "personal-test01";
    // private static final String prix = "http://q5qt6ysbg.bkt.clouddn.com/";

    private String accessKey;
    private String secretKey;
    private String bucket;
    private String prix;

    private UploadManager manager;


    public QiniuUploadUtils() {
        //初始化基本配置,构造一个带指定 Region 对象的配置类  注意地区配置
        Configuration cfg = new Configuration(Region.region2());
        //创建上传管理器
        manager = new UploadManager(cfg);
    }

    //覆盖
    //文件名 = key
    //文件的byte数组
    public String upload(String imgName, byte[] bytes) {
        //身份认证
        Auth auth = Auth.create(accessKey, secretKey);
        //指定覆盖上传
        String upToken = auth.uploadToken(bucket, imgName);
        try {
            Response response = manager.put(bytes, imgName, upToken);
            //上传
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

            //返回请求地址  缓存原因加上后缀
            return prix + putRet.key + "?t=" + System.currentTimeMillis();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
