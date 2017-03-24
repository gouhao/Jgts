package com.xdja.jwt.jgts.bean;

import com.xdja.jwt.jgts.utils.gprsutils.parser.IXmlParserAdapter;

/**
 * Created by gouhao on 3/24/2017.
 */

public class SocketResultXmlParserAdapter implements IXmlParserAdapter<SocketResult> {
    private SocketResult socketResult;
    private static final String TAG_APP_CODE = "appcode";

    private static final String TAG_DATA_BUFFER = "databuffer";

    private static final String TAG_RESULT_LIST = "resultlist";

    public SocketResultXmlParserAdapter() {
        this.socketResult = new SocketResult();
    }

    @Override
    public void onStartParse() {

    }

    @Override
    public void onTextTag(String tagName, String tagText) {
        if(tagText == null) return;
        if(tagName.equals(TAG_APP_CODE)) {
            this.socketResult.setAppCode(Integer.parseInt(tagText));
        } else if(tagName.equals(TAG_DATA_BUFFER)){
            this.socketResult.setDataBuffer(tagText);
        } else if(tagName.equals(TAG_RESULT_LIST)) {
            this.socketResult.setResultList(Integer.parseInt(tagText));
        }
    }

    @Override
    public void onEndTag(String tagName) {

    }

    @Override
    public SocketResult getObject() {
        return this.socketResult;
    }
}
