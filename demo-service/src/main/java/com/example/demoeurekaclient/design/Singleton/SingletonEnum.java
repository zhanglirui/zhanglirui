package com.example.demoeurekaclient.design.Singleton;

import java.lang.reflect.Method;

/**
 * @author zhanglirui
 * @date 2020/11/17 2:20 下午
 */
public enum SingletonEnum {

    /**
     *
     */
    INSTANCE;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        SingletonEnum firstSingleton = SingletonEnum.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());

        SingletonEnum secondSingleton = SingletonEnum.INSTANCE;
        secondSingleton.setObjName("secondName");
        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());

        SingletonEnum[] enumConstants = SingletonEnum.class.getEnumConstants();
        for (SingletonEnum enumConstant : enumConstants) {
            System.out.println(enumConstant.getObjName());
        }

        Method[] declaredMethods = SingletonEnum.class.getDeclaredMethods();

        Method[] methods = SingletonEnum.class.getMethods();
    }

}
