package com.example.demoeurekaclient.design.Command;

/**
 * @author zhanglirui
 * @date 2020/11/16 10:30 上午
 */
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.on();
    }
}
