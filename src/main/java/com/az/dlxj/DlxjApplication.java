package com.az.dlxj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 扫描Mybatis Mapper接口
@MapperScan("com.az.dlxj.*.dao")
@SpringBootApplication
public class DlxjApplication {

    public static void main(String[] args) {
        SpringApplication.run(DlxjApplication.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    bootdo启动成功      ヾ(◍°∇°◍)ﾉﾞ\n" +
                " ______                    _   ______            \n" +
                "|_   _ \\                  / |_|_   _ `.          \n" +
                "  | |_) |   .--.    .--. `| |-' | | `. \\  .--.   \n" +
                "  |  __'. / .'`\\ \\/ .'`\\ \\| |   | |  | |/ .'`\\ \\ \n" +
                " _| |__) || \\__. || \\__. || |, _| |_.' /| \\__. | \n" +
                "|_______/  '.__.'  '.__.' \\__/|______.'  '.__.'  ");

    }
}
