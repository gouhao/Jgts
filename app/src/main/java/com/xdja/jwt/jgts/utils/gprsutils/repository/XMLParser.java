package com.xdja.jwt.jgts.utils.gprsutils.repository;


import com.xdja.jwt.jgts.utils.gprsutils.entity.Page;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class XMLParser {

    private static final XMLParser INSTANCE = new XMLParser();

    private XMLParser() {
    }


    public static XMLResponse parse(String xml) {
        Document document = Jsoup.parse(xml);
        return buildResponse(document);
    }

    public static XMLResponse buildResponse(Document document) {
        XMLResponse response = new XMLResponse();
        response.setRows(parseRows(document));
        response.setPage(parsePage(document));
        response.relations = parseRelations(document);
        return response;
    }

    public static List<String> parseRelations(Document document) {
        Elements rowElements = document.getElementsByTag("Relation");
        if (rowElements == null) {
            return null;
        }
        List<String> tempLists = new ArrayList<>();
        Elements elements = document.select("RelNode Name");
        for (int rowIndex = 0; rowIndex < elements.size(); rowIndex++) {
            tempLists.add(elements.get(rowIndex).text());
        }
        return tempLists;
    }


    public static LinkedHashMap<Integer, LinkedHashMap<Integer, String>> parseRows(Document document) {
        Elements rowElements = document.getElementsByTag("Row");
        LinkedHashMap<Integer, LinkedHashMap<Integer, String>> rows = new LinkedHashMap<>();

        for (int rowIndex = 0; rowIndex < rowElements.size(); rowIndex++) {
            Elements dataElements = rowElements.get(rowIndex).getElementsByTag("Data");
            LinkedHashMap<Integer, String> data = new LinkedHashMap<>();
            for (int dataIndex = 0; dataIndex < dataElements.size(); dataIndex++) {
                data.put(dataIndex, dataElements.get(dataIndex).text());//预期Data标签下直接是需要的字符串
            }
            rows.put(rowIndex, data);
        }
        return rows;
    }

    public static Page parsePage(Document document) {
        Page page = new Page();
        page.setSize(Integer.parseInt(document.select("Page>Size").get(0).text()));
        page.setTotalLen(Integer.parseInt(document.select("Page>TotalLen").get(0).text()));
        page.setCurrentLen(Integer.parseInt(document.select("Page>CurrentLen").get(0).text()));
        page.setTotalPage(Integer.parseInt(document.select("Page>TotalPage").get(0).text()));
        page.setBeginNo(Integer.parseInt(document.select("Page>BeginNo").get(0).text()));
        page.setSourceCondition(document.select("Page>SourceCondition").get(0).text());
        page.setSourceDbSource(document.select("Page>SourceDbSource").get(0).text());
        return page;
    }
}
