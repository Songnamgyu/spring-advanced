 package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {

    @Test
    public void begin_end() throws Exception {
        //given
        HelloTraceV2 trace = new HelloTraceV2();
        //when
        TraceStatus status1  = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.end(status2);
        trace.end(status1);
        //then
    }

    @Test
    public void begin_exception () throws Exception {

        //given
        HelloTraceV2 trace = new HelloTraceV2();
        //when
        TraceStatus status1 = trace.begin("hello1_e");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(),"hello2_e");
        trace.exception(status2, new IllegalArgumentException());
        trace.exception(status1,new IllegalArgumentException());

        //then
    }

}