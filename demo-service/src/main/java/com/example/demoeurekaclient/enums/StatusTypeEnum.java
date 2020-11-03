package com.example.demoeurekaclient.enums;

/**
 * @author zhanglirui
 * @date 2020/11/3 10:00 上午
 */

public enum StatusTypeEnum implements NumbericEnum,DescedEnum{

    /**
     * 存在
     */
    EXIST(1,"存在"),

    /**
     * 删除
     */
    DELETE(2,"删除"),

    ;

    private Integer values;

    private String desc;

    StatusTypeEnum(Integer values, String desc) {
        this.values = values;
        this.desc = desc;
    }

    @Override
    public String desc() {
        return desc;
    }

    @Override
    public int toNumericValue() {
        return values;
    }

    public static StatusTypeEnum of(Integer values,StatusTypeEnum defaultValues){
        return NumbericEnumUtils.parse(values,defaultValues,StatusTypeEnum.class);
    }

    public static StatusTypeEnum nameOf(String desc) {
        return NumbericEnumUtils.nameOf(StatusTypeEnum.class,desc);
    }
}
