package com.xzsd.app.TencentUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author Embrace
 * @date 2020/3/29 18:01
 */
@Controller
public class CosController {

    /**
     * 把文件上传到腾讯云存储服务器
     * @param multfile
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadImage")
    //, Map<String,Object> map
    public static String upload(@RequestParam("file") MultipartFile multfile)throws Exception{
        // 获取文件名
        String fileName = multfile.getOriginalFilename();
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        final File excelFile = File.createTempFile("imagesFile-"+System.currentTimeMillis(), prefix);
        // 将MultipartFile转为File
        multfile.transferTo(excelFile);
        //调用腾讯云工具上传文件
         fileName = TencentCOS.uploadfile(excelFile);
        //程序结束时，删除临时文件
        deleteFile(excelFile);
        //存入图片名称，用于网页显示
//        map.put("imageName",fileName);
        String j="图片上传完成";
        //返回图片名称
        System.out.println(fileName);
        //https://test-1300625833.cos.ap-guangzhou.myqcloud.com/https%3A/test-1300625833.cos.ap-guangzhou.myqcloud.com/93651585819843957.jpg
        return fileName;
    }

    /**
     * 删除临时文件
     * @param files
     */
    public static void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
