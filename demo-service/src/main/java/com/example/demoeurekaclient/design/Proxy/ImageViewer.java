package com.example.demoeurekaclient.design.Proxy;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 代理设计模式
 *
 * 控制对其它对象的访问。
 *
 * 案列：以下是一个虚拟代理的实现，模拟了图片延迟加载的情况下使用与图片大小相等的临时内容去替换原始图片，直到图片加载完成才将图片显示出来。
 *
 *
 * @author zhanglirui
 * @date 2020/11/17 11:53 上午
 */
public class ImageViewer {

    public static void main(String[] args) throws Exception {
        String image = "http://image.jpg";
        URL url = new URL(image);
        HighResolutionImage highResolutionImage = new HighResolutionImage(url);
        ImageProxy imageProxy = new ImageProxy(highResolutionImage);
        imageProxy.showImage();
    }
}
