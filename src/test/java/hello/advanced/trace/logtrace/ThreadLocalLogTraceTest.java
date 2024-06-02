package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

   ThreadLocalLogTrace trace  = new ThreadLocalLogTrace();

    @Test
    public void begin_end_level() throws Exception {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status1);
        trace.end(status2);
    }

    @Test
    public void hello_begin_exception() throws Exception {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status1, new RuntimeException());
        trace.exception(status2, new IllegalArgumentException());
    }

}