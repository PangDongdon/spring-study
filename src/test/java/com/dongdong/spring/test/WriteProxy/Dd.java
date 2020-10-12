package com.dongdong.spring.test.WriteProxy;

import com.google.gson.Gson;
import lombok.Data;
import org.springframework.boot.test.json.GsonTester;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/4/23  19:54
 * @Author: dongdong
 */
@Data
public class Dd {
	 private String name;
	 private int age;
	 private List<String> dd;

	public Dd(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Dd(){

	}

	public  static  void  main(String[] args){
		Dd  d=new Dd("22",11);
		Gson gson=new Gson();
		List<String> sss=new ArrayList<>();
		sss.add("dddd");
	/*	sss.add(d);
		sss.add(d);*/
		Dd cc=new Dd();
		cc.setAge(99);
		cc.setName("vv");
		cc.setDd(sss);
		/*cc.setDd(sss);*/
 	    String ss=	gson.toJson(cc);
	    System.out.println(ss);
	}
}
