package com.ohgiraffers.semiproject.member.emailsender;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class EmailSender {

    public void sendEmail(String to, String from, String host, String subject, String text) {
        // SMTP 서버 설정
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");


        // 인증 정보 설정
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("lees8485", "penqoytsdahudarz");
            }
        });

        try {
            // 이메일 메시지 생성
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);
            System.out.println("EmailSender 클래스 : " + to);
            System.out.println("EmailSender 클래스 : " + text);
            // 메시지 전송
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public boolean emailSend(String to, String pwdKey) {
        // 이메일 발신자, 수신자, SMTP 호스트 및 메시지 내용 설정 to는 수신자
        String from = "lees8485@gmail.com"; // 발신자 이메일 주소
        String host = "smtp.gmail.com"; // SMTP 서버 주소
        String subject = "CloudFooding 이메일 인증 번호"; // 이메일 제목
        try {
            sendEmail(to, from, host, subject, pwdKey);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendUserId(String to, String userId) {
        String from = "lees8485@gmail.com"; // 발신자 이메일 주소
        String host = "smtp.gmail.com"; // SMTP 서버 주소
        String subject = "Your User ID"; // 이메일 제목
        String text = "Your User ID is: " + userId; // 이메일 내용
        try {
            sendEmail(to, from, host, subject, text);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }




    public boolean sendEmail(String to, String text1, String subject1) {
        String from = "lees8485@gmail.com"; // 발신자 이메일 주소
        String host = "smtp.gmail.com"; // SMTP 서버 주소
        String subject = text1 ; // 이메일 제목
        String text = subject1; // 이메일 내용

        try {
            sendEmail(to, from, host, subject, text); // 이미 구현된 메서드 호출
            System.out.println("인증번호 발송 성공");
            return true;
        } catch (Exception e) {
            System.out.println("인증번호 발송 실패");
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendEmail1(String to, String tempPassword, String s) {

        String from = "lees8485@gmail.com"; // 발신자 이메일 주소
        String host = "smtp.gmail.com"; // SMTP 서버 주소
        String subject = tempPassword; // 이메일 제목
        String text = s; // 이메일 내용

        try {
            sendEmail(to, from, host, subject, text); // 이미 구현된 메서드 호출
            System.out.println("임시 비밀번호 발송 성공");
            return true;
        } catch (Exception e) {
            System.out.println("임시 비밀번호 발송 실패");
            e.printStackTrace();
            return false;
        }
    }
}
