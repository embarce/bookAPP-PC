package com.xzsd.pc.TencentUtil;

import com.neusoft.core.restful.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Embrace
 * @date 2020/4/16 9:14
 */
@RestController
@RequestMapping("/image")
public class UploadImage {
    private static final Logger logger = LoggerFactory.getLogger(UploadImage.class);
    @PostMapping("uploadImage")
    public AppResponse uploadImage(@RequestParam("file") MultipartFile multfile)throws Exception{
        String filePath=CosController.upload(multfile);
        if(filePath==null){
            return AppResponse.bizError("上传失败");
        }else {
            return AppResponse.success("上传成功",filePath);
        }
    }
}
