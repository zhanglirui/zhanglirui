package com.example.demoeurekaclient.converter;

import java.io.IOException;

import com.example.demoeurekaclient.converter.MyHttpMessageConverter.MyObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/9/24 11:54 上午
 */
@Component
public class MyHttpMessageConverter extends AbstractHttpMessageConverter<MyObj> {

    private final StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();

    public MyHttpMessageConverter() {
        super(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN);
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(MyObj.class);
    }

    @Override
    protected MyObj readInternal(Class<? extends MyObj> aClass, HttpInputMessage httpInputMessage)
        throws IOException, HttpMessageNotReadableException {
        String text = this.stringHttpMessageConverter.read(String.class, httpInputMessage);
        return new MyObj(text);
    }

    @Override
    protected void writeInternal(MyObj myObj, HttpOutputMessage httpOutputMessage)
        throws IOException, HttpMessageNotWritableException {
        this.stringHttpMessageConverter.write(myObj.getText(), MediaType.TEXT_PLAIN, httpOutputMessage);
    }


    public static class MyObj {

        private final String text;

        public MyObj(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
