package cn.wntime.jpa.test;

public class ThreadRuntime {
    private static final ThreadLocal<ThreadRuntime> LOCAL = new ThreadLocal<>();
    private String name;

    public ThreadRuntime() {
    }

}
