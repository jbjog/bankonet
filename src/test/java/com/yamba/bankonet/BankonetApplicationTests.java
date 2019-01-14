package com.yamba.bankonet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BankonetApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void shouldBeTrue(){
        assertTrue(true);
    }
}
