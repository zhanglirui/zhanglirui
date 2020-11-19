package com.example.demoeurekaclient.design.Singleton;

/**
 * 双重校验锁-线程安全
 *
 * 双重校验锁先判断 uniqueInstance 是否已经被实例化，如果没有被实例化，那么才对实例化语句进行加锁。
 *
 * @author zhanglirui
 * @date 2020/11/17 2:03 下午
 */
public class LazySafeSingleton {

    private volatile static LazySafeSingleton uniqueInstance;

    private LazySafeSingleton() {
    }

    public static LazySafeSingleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new LazySafeSingleton();
                }
            }
        }
        return uniqueInstance;
    }

}
