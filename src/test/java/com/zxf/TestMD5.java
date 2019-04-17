package com.zxf;


import org.apache.shiro.crypto.hash.Md5Hash;

public class TestMD5 {
        public static void main(String []args) {
            //密码   盐值  排列次数
            Md5Hash md5 = new Md5Hash("admin");
            String s = md5.toHex();
            System.out.println(s);
        }
//admin                    21232f297a57a5a743894a0e4a801fc3
//admin    abcd            50317b958ee25a1e14449aeb95db5245
//admin    abcd    1024    9898247bfac3a524680145b3b5e203d3
}
