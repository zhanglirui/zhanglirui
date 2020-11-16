package com.example.demoeurekaclient.design.Command;

/**
 * @author zhanglirui
 * @date 2020/11/16 10:32 上午
 */
public class LightOffCommand implements Command {

    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
