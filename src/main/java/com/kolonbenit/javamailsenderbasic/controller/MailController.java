package com.kolonbenit.javamailsenderbasic.controller;

import com.kolonbenit.javamailsenderbasic.dto.MailDto;
import com.kolonbenit.javamailsenderbasic.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @GetMapping("/mail")
    public String writeMail() {
        return "mail";
    }

    @PostMapping("/mail")
    public void sendMail(MailDto mailDto) {
        mailService.sendMimeMail(mailDto);
    }
}
