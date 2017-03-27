package com.xdja.jwt.jgts;

import com.xdja.jwt.jgts.bean.LoginRequest;
import com.xdja.jwt.jgts.utils.xml.SimpleXmlSerializer;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gouhao on 3/27/2017.
 */

public class SimpleSmlSerializerTest {
    private static final String TAG = SimpleSmlSerializerTest.class.getSimpleName();

    @Test
    public void testSerializerSimpleBean(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setSystem(1);
        loginRequest.setVersion("1.0");
        loginRequest.setUsername("gouhao");
        loginRequest.setPassword("gouhao");
        String result = SimpleXmlSerializer.serializer(loginRequest, LoginRequest.class, "login");
        Assert.assertNotNull(result);
        Assert.assertTrue(isFind(result, "<login>.*</login>"));
        Assert.assertTrue(isFind(result, "<system>1</system>"));
        Assert.assertTrue(isFind(result, "<version>1.0</version>"));
        Assert.assertTrue(isFind(result, "<username>gouhao</username>"));
        Assert.assertTrue(isFind(result, "<password>gouhao</password>"));
    }

    private boolean isFind(String src, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        return matcher.find();
    }

    @Test
    public void testEmptyBean(){
        String result = SimpleXmlSerializer.serializer(new LoginRequest(), LoginRequest.class, "login");
        Assert.assertNotNull(result);
    }

    @Test
    public void testBeanNull(){
        String result = SimpleXmlSerializer.serializer(null, LoginRequest.class, "login");
        Assert.assertNull(result);
    }

    @Test
    public void testClassNull(){
        String result = SimpleXmlSerializer.serializer(new LoginRequest(), null, "login");
        Assert.assertNull(result);
    }

    @Test
    public void testRootNull(){
        String result = SimpleXmlSerializer.serializer(new LoginRequest(), LoginRequest.class, null);
        Assert.assertNull(result);
    }

    @Test
    public void testAllNull(){
        String result = SimpleXmlSerializer.serializer(null, null, null);
        Assert.assertNull(result);
    }

    @Test
    public void testAnnotation(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setSystem(1);
        loginRequest.setVersion("1.0");
        loginRequest.setUsername("gouhao");
        loginRequest.setPassword("gouhao");
        String result = SimpleXmlSerializer.serializer(loginRequest, LoginRequest.class, "login");
        Assert.assertNotNull(result);
        Assert.assertTrue(isFind(result, "<login>.*</login>"));
        Assert.assertTrue(isFind(result, "<sys>1</sys>"));
        Assert.assertTrue(isFind(result, "<ver>1.0</ver>"));
        Assert.assertTrue(isFind(result, "<user>gouhao</user>"));
        Assert.assertTrue(isFind(result, "<pwd>gouhao</pwd>"));
    }
}
