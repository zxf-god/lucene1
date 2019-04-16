package com.zxf;

import com.zxf.util.MyRealm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.zxf.dao")
public class Lucene1Application {
    public static void main(String[] args) {
        SpringApplication.run(Lucene1Application.class, args);
    }

}

