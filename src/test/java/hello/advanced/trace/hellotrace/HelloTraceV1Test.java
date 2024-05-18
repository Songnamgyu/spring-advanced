package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {

    @Test
    public void begin_end() throws Exception {
        //given
        HelloTraceV1 trace = new HelloTraceV1();
        //when
        TraceStatus status  = trace.begin("hello");
        trace.end(status);
        //then
    }

    @Test
    public void begin_exception () throws Exception {

        //given
        HelloTraceV1 trace = new HelloTraceV1();
        //when
        TraceStatus status = trace.begin("hello_");
        trace.exception(status,new IllegalArgumentException());

        //then
    }

}