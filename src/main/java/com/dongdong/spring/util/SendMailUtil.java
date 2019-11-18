package com.dongdong.spring.util;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * 邮件工具
 * @Description:
 * @Date: 2019/11/5  9:25
 * @Author: dongdong
 */
public class SendMailUtil {

/**
 * 发送邮件到指定邮箱
 *
 * */

public static void  send(String fromAddress,String toAddress) throws  Exception{
  //1.创建session
    Properties props=new Properties();
    //指定传输协议且验证通过
    props.setProperty("mail.transport.protocol", "smtp");
    props.setProperty("mail.smtp.auth","true");
    Session session=Session.getDefaultInstance(props);
    //开启调试模式
    session.setDebug(true);

  //2.编辑邮件内容
    Message message=new MimeMessage(session);
    //设置邮件消息头
    message.setFrom(new InternetAddress(fromAddress));
    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toAddress));
    message.setSubject("JavaMail 邮件测试");
    // 设置邮件消息内容包含附件
    Multipart msgPart=new MimeMultipart();
    message.setContent(msgPart);

    MimeBodyPart body=new MimeBodyPart();//正文
    MimeBodyPart attach=new MimeBodyPart();//附件

    msgPart.addBodyPart(body);
    msgPart.addBodyPart(attach);

    //设置正文内容
    body.setContent("JavaMail功能测试","text/html;charset=utf-8");
    //设置邮件内容
    attach.setDataHandler(new DataHandler(new FileDataSource("E:\\TestClass.java")));
    attach.setFileName("测试文件.java");
    message.saveChanges();

    //3.发送邮件
    Transport trans=session.getTransport();
    trans.connect("smtp.163.com","18721926709","pdd123456");
    trans.sendMessage(message,message.getAllRecipients());

}
  public static void main(String[] args) throws  Exception{
    SendMailUtil.send("18721926709@163.com","pangdongdong@51zhaoyou.com");
  }


}
