package com.xdja.jwt.jgts.utils.gprsutils.parser;

/**
 * Created by gouhao on 3/24/2017.
 */

public interface IXmlParserAdapter<T> {
    void onStartParse();

    void onTextTag(String tagName, String tagText);

    void onEndTag(String tagName);

    T getObject();
}
