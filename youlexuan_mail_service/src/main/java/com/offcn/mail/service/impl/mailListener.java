package com.offcn.mail.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component("mailListener")
public class mailListener implements MessageListener {

    @Autowired
    JavaMailSenderImpl mailsend;

    @Override
    public void onMessage(Message message) {
        if(message instanceof MapMessage){
            MapMessage map=(MapMessage)message;
            try {
                System.out.println("收到邮件发送请求---》");
                //创建简单的邮件
                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setFrom("simonlee_java@163.com");
                msg.setTo("simonlee_java@163.com");
                msg.setSubject("注册通知");
                msg.setText("恭喜您成功注册优乐选商城！");
                //发送邮件
                mailsend.send(msg);

                System.out.println("send ok");



            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
