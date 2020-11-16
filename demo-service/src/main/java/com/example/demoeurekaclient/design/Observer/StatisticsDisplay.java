package com.example.demoeurekaclient.design.Observer;

/**
 * @author zhanglirui
 * @date 2020/11/16 3:33 下午
 */
public class StatisticsDisplay implements Observer {

    public StatisticsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("StatisticsDisplay.update: " + temp + " " + humidity + " " + pressure);
    }
}
