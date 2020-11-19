package com.example.demoeurekaclient.design.Singleton;

/**
 * 懒汉式——线程不安全的单列设计模式
 *
 * @author zhanglirui
 * @date 2020/11/17 1:57 下午
 */
public class Singleton {

    // 饿汉式-线程安全
    //private static Singleton uniqueInstance = new Singleton();

    private static Singleton uniqueInstance;

    private Singleton() { }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    /**
     * 只需要对 getUniqueInstance() 方法加锁，那么在一个时间点只能有一个线程能够进入该方法，从而避免了实例化多次 uniqueInstance。
     *
     * 但是当一个线程进入该方法之后，其它试图进入该方法的线程都必须等待，即使 uniqueInstance 已经被实例化了。这会让线程阻塞时间过长，因此该方法有性能问题，不推荐使用。
     * @return
     */
    public static synchronized Singleton getUniqueInstance1() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    /**
     * 静态内部类的实现规则
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getUniqueInstance2() {
        return SingletonHolder.INSTANCE;
    }




}
