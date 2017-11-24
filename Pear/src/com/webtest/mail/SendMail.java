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
        //ʹ��JavaMail�����ʼ���5������
        //1������session
        Session session = Session.getInstance(prop);
        //����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
        session.setDebug(true);
        //2��ͨ��session�õ�transport����
        Transport ts = session.getTransport();
        //3�������ʼ�������
        ts.connect("smtp.qq.com", "759108470@qq.com", "smyqokcppxtsbfjj");
        //4�������ʼ�
        Message message = createAttachMail(session);
        //5�������ʼ�
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
    

    public MimeMessage createAttachMail(Session session) throws Exception{
        MimeMessage message = new MimeMessage(session);
        
        //�����ʼ��Ļ�����Ϣ
        //������
        message.setFrom(new InternetAddress("759108470@qq.com"));
        //�ռ���
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("13315115057@163.com"));
        //�ʼ�����
        message.setSubject("��������ִ�����");
        
        //�����ʼ����ģ�Ϊ�˱����ʼ����������������⣬��Ҫʹ��charset=UTF-8ָ���ַ�����
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("TestNG���Ա���", "text/html;charset=UTF-8");
        
        //�����ʼ�����
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("E:\\xueli-2017-jyn\\Pear\\test-output\\index.html"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());  //
        
        //���������������ݹ�ϵ
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
        mp.addBodyPart(attach);
        mp.setSubType("mixed");
        
        message.setContent(mp);
        message.saveChanges();
        //��������Emailд�뵽E�̴洢
        message.writeTo(new FileOutputStream("E:\\attachMail.eml"));
        //�������ɵ��ʼ�
        return message;
    }
}