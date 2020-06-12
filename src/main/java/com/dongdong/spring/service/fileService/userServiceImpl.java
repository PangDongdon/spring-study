package com.dongdong.spring.service.fileService;

import com.dongdong.spring.service.IUserService;
import com.dongdong.spring.util.ReadExcel;
import com.dongdong.spring.util.UserTest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description:
 * @Date: 2020/3/16  10:31
 * @Author: dongdong
 */
@Service
public class userServiceImpl implements IUserService {

    @Override
    public String readExcelFile(MultipartFile file) {
         String result="";
        ReadExcel readExcel=new ReadExcel();

        List<UserTest> userList=readExcel.getExcelInfo(file);

        if(userList !=null && !userList.isEmpty()){
            result="ddd";
        }else{
            result="d";
        }
        return result;
    }
}
