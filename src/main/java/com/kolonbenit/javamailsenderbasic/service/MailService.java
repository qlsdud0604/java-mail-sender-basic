package com.kolonbenit.javamailsenderbasic.service;

import com.kolonbenit.javamailsenderbasic.dto.MailDto;
import com.kolonbenit.javamailsenderbasic.util.MailHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private static final String FROM_ADDRESS = "qlsdud960604@gmail.com";

    private final JavaMailSender mailSender;

    public void sendTextMail(MailDto mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress());
        message.setFrom(FROM_ADDRESS);
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getContent());

        mailSender.send(message);
    }

    public void sendMimeMail(MailDto mailDto) {
        try {
            MailHandler mailHandler = new MailHandler(mailSender);
            // 받는 사람
            mailHandler.setTo(mailDto.getAddress());
            // 보내는 사람
            mailHandler.setFrom(FROM_ADDRESS);
            // 제목
            mailHandler.setSubject(mailDto.getTitle());
            // HTML layout
            String htmlContent = "<p>" + mailDto.getContent() +"<p> <img src='cid:test_image'>";
            mailHandler.setText(htmlContent, true);
            // 첨부 파일
            mailHandler.setAttach("test.txt", "static/test.txt");
            // 이미지 삽입
            mailHandler.setInline("test_image", "static/test_image.jpg");
            mailHandler.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
