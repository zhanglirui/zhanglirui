package com.example.demoeurekaclient.design.Command;

import com.example.demoeurekaclient.design.Command.Command;
import com.example.demoeurekaclient.design.Command.Invoker;
import com.example.demoeurekaclient.design.Command.Light;
import com.example.demoeurekaclient.design.Command.LightOffCommand;
import com.example.demoeurekaclient.design.Command.LightOnCommand;

/**
 * 命令设计模式
 * @author zhanglirui
 * @date 2020/11/16 10:35 上午
 */
public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        invoker.setOnCommand(lightOnCommand, 0);
        invoker.setOffCommand(lightOffCommand, 0);
        invoker.onButtonWasPushed(0);
        invoker.offButtonWasPushed(0);
    }
}
