package gui;

import static com.googlecode.totallylazy.Xml.document;
import static com.googlecode.totallylazy.Xml.selectContents;

public final class OperationParser {

    private static String xpath;

    private OperationParser() {}

    public static String parse(String response) {
        xpath = "/operation/result";
        return selectContents(document(response), xpath);
    }

    public static String parsedXpath() {
        return xpath;
    }
}
