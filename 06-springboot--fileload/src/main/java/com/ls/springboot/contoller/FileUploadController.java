package com.ls.springboot.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Springboot文件上传
 */
@RestController
//该注解表示该类下的所有方法的返回值会自动做json格式的转换
public class FileUploadController {

    @RequestMapping("/fileUploadController")
    public Map<String,Object> fileUpload(MultipartFile filename) throws IOException {
        System.out.println(filename.getOriginalFilename());

        filename.transferTo(new File("e:/"+filename.getOriginalFilename()));
        Map<String,Object> map = new HashMap<>();
        map.put("msg","ok");

        return map;
    }
}
