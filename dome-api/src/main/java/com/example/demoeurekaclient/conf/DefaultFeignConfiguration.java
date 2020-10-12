package com.example.demoeurekaclient.conf;

import java.io.IOException;
import java.lang.reflect.Type;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanglirui
 * @date 2020/9/24 10:37 上午
 */
@Configuration
public class DefaultFeignConfiguration {

    @Bean
    public Decoder decoder(){
        return new DefaultDecoder();
    }

    // 静太内部类够一次调用就好了
    public static class DefaultDecoder implements Decoder{

        @Override
        public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
            return "Decoder 的重写成功了——————————"+Util.toString(response.body().asReader());
        }
    }
}
