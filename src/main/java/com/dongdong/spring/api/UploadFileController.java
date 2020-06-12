package com.dongdong.spring.api;

import com.dongdong.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Date: 2020/3/16  10:03
 * @Author: dongdong
 */
@Controller
@RequestMapping("/test")
public class UploadFileController {
   @Autowired
   private IUserService userService;
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam(value="file",required=false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String  result=userService.readExcelFile(file);
        return result;
    }

}
