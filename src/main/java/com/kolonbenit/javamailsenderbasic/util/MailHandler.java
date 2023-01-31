package com.kolonbenit.javamailsenderbasic.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

public class MailHandler {
    private JavaMailSender mailSender;
    private MimeMessage mimeMessage;
    private MimeMessageHelper messageHelper;

    public MailHandler(JavaMailSender mailSender) throws MessagingException {
        this.mailSender = mailSender;
        this.mimeMessage = mailSender.createMimeMessage();
        this.messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
    }

    /** 보내는 사람의 이메일 주소 설정 */
    public void setFrom(String fromAddress) throws MessagingException {
        messageHelper.setFrom(fromAddress);
    }

    /** 받는 사람의 이메일 주소 설정 */
    public void setTo(String toAddress) throws MessagingException {
        messageHelper.setTo(toAddress);
    }

    /** 이메일 제목 설정 */
    public void setSubject(String subject) throws MessagingException {
        messageHelper.setSubject(subject);
    }

    /** 이메일 내용 설정 */
    public void setText(String text, boolean useHtml) throws MessagingException {
        messageHelper.setText(text, useHtml);
    }

    /** 첨부 파일 설정 */
    public void setAttach(String fileName, String attachPath) throws MessagingException, IOException {
        File file = new ClassPathResource(attachPath).getFile();
        FileSystemResource systemResource = new FileSystemResource(file);
        messageHelper.addAttachment(fileName, systemResource);
    }

    /** 삽입 이미지 설정 */
    public void setInline(String contentId, String inlinePath) throws MessagingException, IOException {
        File file = new ClassPathResource(inlinePath).getFile();
        FileSystemResource systemResource = new FileSystemResource(file);
        messageHelper.addInline(contentId, systemResource);
    }

    /** 이메일 발송 */
    public void send() {
        try {
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
