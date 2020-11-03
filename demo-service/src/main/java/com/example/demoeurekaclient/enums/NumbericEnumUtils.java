package com.example.demoeurekaclient.enums;

/**
 * @author zhanglirui
 * @date 2020/11/3 10:12 上午
 */
public class NumbericEnumUtils {

    public static <T extends Enum<T> & NumbericEnum,N extends Number> T parse(N value, T defaultValue, Class<T> clazz){
        if (value == null) {
            return defaultValue;
        }

        T[] values = clazz.getEnumConstants();
        for(T val:values){
            if(val.toNumericValue() == value.intValue()){
                return val;
            }
        }
        return defaultValue;
    }

    public static <E extends Enum> E nameOf(Class<E> enumClazz,String value) {
        E[] values = enumClazz.getEnumConstants();
        for (E val :values) {
            if(val.name().equalsIgnoreCase(value)){
                return val;
            }
        }
        return null;
    }
}
