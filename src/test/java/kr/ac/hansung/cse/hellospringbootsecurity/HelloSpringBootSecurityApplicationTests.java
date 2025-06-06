package kr.ac.hansung.cse.hw2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class hw2ApplicationTests {


    @Autowired
    private PasswordEncoder encoder;

    @Test
    void contextLoads() {
    }

    @Test
    void generateHashedPassword() {
        String pwd = encoder.encode("alicepw");
        System.out.println(pwd);
    }


}
