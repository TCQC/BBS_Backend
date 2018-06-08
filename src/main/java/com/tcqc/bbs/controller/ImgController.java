package com.tcqc.bbs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 上传图片 头像部分使用
 */
@RestController
@RequestMapping("upload")
public class ImgController {

    @RequestMapping(value = "/avatar",method = RequestMethod.POST)
    public String testImg(@RequestParam(value = "name") String name,@RequestParam(value="file")MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File( "upload/avatar/" + name + ".jpg")));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "error," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "error," + e.getMessage();
            }
            return "localhost:8080/img/avatar/" + name + ".jpg";
        } else {
            return "file is empty";
        }
    }
}
