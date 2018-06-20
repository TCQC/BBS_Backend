package com.tcqc.bbs.controller;

import com.tcqc.bbs.util.format.FormatResult;
import com.tcqc.bbs.util.format.FormatResultGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 上传图片 头像部分使用
 */
@RestController
@RequestMapping("upload")
public class ImgController {
    private String ip = "192.168.43.217";
    @RequestMapping(value = "/avatar",method = RequestMethod.POST)
    public FormatResult<String> uploadAvatar(@RequestParam(value = "name") String name, @RequestParam(value="file")MultipartFile file) {
//        name = System.currentTimeMillis() + "";
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File( "upload/avatar/" + name + ".jpg")));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                String error =  "error," + e.getMessage();
                return FormatResultGenerator.genErrorResult(error);
            } catch (IOException e) {
                e.printStackTrace();
                String error =  "error," + e.getMessage();
                return FormatResultGenerator.genErrorResult(error);
            }
            String result =  "http://" + ip + ":8080/img/avatar/" + name + ".jpg";
            return FormatResultGenerator.genSuccessResult(result);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/block",method = RequestMethod.POST)
    public FormatResult<String> uploadBlockIcon(@RequestParam(value="file")MultipartFile file) {
        String name = System.currentTimeMillis() + "";
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File( "upload/block/" + name + ".jpg")));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                String error =  "error," + e.getMessage();
                return FormatResultGenerator.genErrorResult(error);
            } catch (IOException e) {
                e.printStackTrace();
                String error =  "error," + e.getMessage();
                return FormatResultGenerator.genErrorResult(error);
            }
            String result =  "http://" + ip + ":8080/img/block/" + name + ".jpg";

            return FormatResultGenerator.genSuccessResult(result);
        } else {
            return null;
        }
    }

}
