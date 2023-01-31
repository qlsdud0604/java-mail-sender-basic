package com.kolonbenit.javamailsenderbasic.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MailDto {
    private String address;

    private String title;

    private String content;
}
