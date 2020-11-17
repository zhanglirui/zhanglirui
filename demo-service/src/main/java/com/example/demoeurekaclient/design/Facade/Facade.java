package com.example.demoeurekaclient.design.Facade;

/**
 * @author zhanglirui
 * @date 2020/11/17 11:35 上午
 */
public class Facade {

    private SubSystem subSystem = new SubSystem();

    public void watchMovie() {
        subSystem.turnOnTV();
        subSystem.setCD("a movie");
        subSystem.startWatching();
    }


}
