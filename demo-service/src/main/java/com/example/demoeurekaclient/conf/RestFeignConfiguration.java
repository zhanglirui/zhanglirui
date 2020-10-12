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
 * @date 2020/9/24 10:48 上午
 */
// 在上面的HelloFeignConfiguration类中，我们没有标注@Configuration，特定Feign Client使用的配置信息可以不加配置类上加@Configuration，
// 也不建议加@Configuration。因为加了@Configuration，而其又在默认的bean扫描路径下，则其中的bean定义都会生效，则其将变为所有的Feign Client都共享的配置
//@Configuration
public class RestFeignConfiguration {

    @Bean
    public Decoder decoder(){
        return new DefaultDecoder();
    }

    // 静太内部类够一次调用就好了
    public static class DefaultDecoder implements Decoder{

        @Override
        public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
            return "独特的----Decoder 的重写成功了——————————"+ Util.toString(response.body().asReader());
        }
    }
}
