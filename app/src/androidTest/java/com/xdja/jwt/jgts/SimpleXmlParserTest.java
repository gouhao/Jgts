package com.xdja.jwt.jgts;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.xdja.jwt.jgts.bean.SocketResult;
import com.xdja.jwt.jgts.bean.SocketResultXmlParserAdapter;
import com.xdja.jwt.jgts.utils.xml.SimpleXmlParser;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;

/**
 * Created by gouhao on 3/24/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SimpleXmlParserTest {
    /**
     * 测试空字符串
     */
    @Test
    public void testEmpty(){
        String xml = "";
        SocketResult result = (SocketResult) SimpleXmlParser.parse(xml, SocketResult.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.getAppCode());
        Assert.assertEquals(null, result.getDataBuffer());
        Assert.assertEquals(0, result.getResultList());
    }

    /**
     * 测试空xml文档，只有头部
     */
    @Test
    public void testParseEmpty(){
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        SocketResult result = (SocketResult) SimpleXmlParser.parse(xml, SocketResult.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.getAppCode());
        Assert.assertEquals(null, result.getDataBuffer());
        Assert.assertEquals(0, result.getResultList());
    }

    /**
     * 测试正常xml解析
     */
    @Test
    public void testParse(){
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><result><appcode>1</appcode><databuffer>1234567sdfsdfsdfsdfsdfsdfsdf</databuffer><resultlist>123</resultlist></result>";
        SocketResult result = (SocketResult) SimpleXmlParser.parse(xml, SocketResult.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getAppCode());
        Assert.assertEquals("1234567sdfsdfsdfsdfsdfsdfsdf", result.getDataBuffer());
        Assert.assertEquals(123, result.getResultList());
    }

    /**
     * 测试xml中的tag，比目标类中定义的成员多
     */
    @Test
    public void testParseXmlMore(){
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><result><appcode>1</appcode><databuffer>1234567sdfsdfsdfsdfsdfsdfsdf</databuffer><resultlist>123</resultlist><test>fuck</test></result>";
        SocketResult result = (SocketResult) SimpleXmlParser.parse(xml, SocketResult.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getAppCode());
        Assert.assertEquals("1234567sdfsdfsdfsdfsdfsdfsdf", result.getDataBuffer());
        Assert.assertEquals(123, result.getResultList());
    }

    /**
     * 测试xml为流的方式解析
     */
    @Test
    public void tetParseXmlInputStream(){
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><result><appcode>1</appcode><databuffer>1234567sdfsdfsdfsdfsdfsdfsdf</databuffer><resultlist>123</resultlist><test>fuck</test></result>";
        SocketResult result = (SocketResult) SimpleXmlParser.parse(new ByteArrayInputStream(xml.getBytes()), SocketResult.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getAppCode());
        Assert.assertEquals("1234567sdfsdfsdfsdfsdfsdfsdf", result.getDataBuffer());
        Assert.assertEquals(123, result.getResultList());
    }

    /**
     * 测试解析类型解析错误，用例中的appcode是String类型，但类成员需要的是int型
     */
    @Test
    @Ignore
    public void testParseErrorXml(){
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><result><appcode>1sdfsd</appcode><databuffer>1234567sdfsdfsdfsdfsdfsdfsdf</databuffer><resultlist>123</resultlist><test>fuck</test></result>";
        SocketResult result = (SocketResult) SimpleXmlParser.parse(new ByteArrayInputStream(xml.getBytes()), SocketResult.class);
        Assert.assertNull(result);
    }

    @Test
    public void testParseWithAdapter(){
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><result><appcode>1</appcode><databuffer>1234567sdfsdfsdfsdfsdfsdfsdf</databuffer><resultlist>123</resultlist><test>fuck</test></result>";
        SocketResult result = SimpleXmlParser.parse(new ByteArrayInputStream(xml.getBytes()), new SocketResultXmlParserAdapter());
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getAppCode());
        Assert.assertEquals("1234567sdfsdfsdfsdfsdfsdfsdf", result.getDataBuffer());
        Assert.assertEquals(123, result.getResultList());
    }
}
