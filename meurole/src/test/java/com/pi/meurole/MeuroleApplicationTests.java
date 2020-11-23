package com.pi.meurole;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MeuroleApplicationTests {

    @MockBean
    DataSource dataSource;

    @Test
    void contextLoads() {
    }

}
