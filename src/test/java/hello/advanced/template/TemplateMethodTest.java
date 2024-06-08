package hello.advanced.template;

import hello.advanced.template.code.AbstractTemplate;
import hello.advanced.template.code.SubClassLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    public void TemplateMethod0() throws  Exception {
        logic1();
        logic2();

    }

   private void  logic1() {
       long startTime = System.currentTimeMillis();
       //비즈니스 실행
       log.info("비즈니스 로직1 실행");
       //비즈니스 종료
       long endTime = System.currentTimeMillis();
       long resultTime = endTime - startTime;
       log.info("resultTime :: {}", resultTime);
   }

    private void  logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 실행
        log.info("비즈니스 로직2  실행");
        //비즈니스 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime :: {}", resultTime);
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic1();
        template2.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate(){

            @Override
            protected void call() {
                log.info("비즈니스 로직실행1");
            }
        };
        template1.execute();
        //

        AbstractTemplate template2 = new AbstractTemplate(){

            @Override
            protected void call() {
                log.info("비즈니스 로직실행22");
            }
        };
        template2.execute();
    }

}