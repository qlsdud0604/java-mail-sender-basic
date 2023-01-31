package com.kolonbenit.javamailsenderbasic.service;

import com.kolonbenit.javamailsenderbasic.controller.MailController;
import com.kolonbenit.javamailsenderbasic.dto.MailDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private static final String FROM_ADDRESS = "qlsdud960604@gmail.com";

    private final JavaMailSender mailSender;

    public void sendMail(MailDto mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress());
        message.setFrom(FROM_ADDRESS);
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getContent());

        mailSender.send(message);
    }
}
