package com.yamba.bankonet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class BankonetApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void shoul_be_true() {
        assertTrue(true);
    }

}
