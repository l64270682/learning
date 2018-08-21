package com.liyu;

import com.google.common.base.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearningApplicationTests {

    @Test
    public void contextLoads() {
        Integer i=null;
        Optional<Integer> of = Optional.of(i);
        boolean present = of.isPresent();
        System.out.println(present);
    }

}
