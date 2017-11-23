package com.webtest.mail;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

    public void setemail() throws Exception {
        
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.smtp.port", "587");
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、连上邮件服务器
        ts.connect("smtp.qq.com", "759108470@qq.com", "smyqokcppxtsbfjj");
        //4、创建邮件
        Message message = createAttachMail(session);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
    

    public MimeMessage createAttachMail(Session session) throws Exception{
        MimeMessage message = new MimeMessage(session);
        
        //设置邮件的基本信息
        //发件人
        message.setFrom(new InternetAddress("759108470@qq.com"));
        //收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("13315115057@163.com"));
        //邮件标题
        message.setSubject("测试用例执行情况");
        
        //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("TestNG测试报告", "text/html;charset=UTF-8");
        
        //创建邮件附件
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("E:\\xueli-2017-jyn\\Pear\\test-output\\index.html"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());  //
        
        //创建容器描述数据关系
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
        mp.addBodyPart(attach);
        mp.setSubType("mixed");
        
        message.setContent(mp);
        message.saveChanges();
        //将创建的Email写入到E盘存储
        message.writeTo(new FileOutputStream("E:\\attachMail.eml"));
        //返回生成的邮件
        return message;
    }
}