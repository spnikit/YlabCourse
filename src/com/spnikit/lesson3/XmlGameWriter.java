package com.spnikit.lesson3;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

class XmlGameWriter {
    private XMLStreamWriter xmlsw;

    public XmlGameWriter(String filename) {
        try {
            xmlsw = XMLOutputFactory.newFactory().createXMLStreamWriter(new FileWriter(filename,
                    Charset.defaultCharset()));
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    public void startDocument() {
        try {
            xmlsw.writeStartDocument("UTF-8", "1.0");
            xmlsw.writeCharacters("\n");
            xmlsw.writeCharacters(" ");
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void endDocument() {
        try {
            xmlsw.writeEndDocument();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void writeChars(String chars){
        Objects.requireNonNull(chars, "Null provided as XML element body");

        try {
            xmlsw.writeCharacters(chars);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void writeElementWithAttributes(String elementName, Map<String, String> attributes, String... characters) {
        Objects.requireNonNull(elementName, "XML element name can't be Null");


        try {
            xmlsw.writeCharacters("  ");

            xmlsw.writeStartElement(elementName);

            if (attributes != null && attributes.size() > 0) {
                attributes.forEach((key, value) -> {
                    try {
                        xmlsw.writeAttribute(key, value);
                    } catch (XMLStreamException e) {
                        e.printStackTrace();
                    }
                });
            }

            if (characters.length > 0) {
                Arrays.stream(characters).forEach(value -> {
                    try {
                        xmlsw.writeCharacters(value);
                    } catch (XMLStreamException e) {
                        e.printStackTrace();
                    }
                });
            }

            xmlsw.writeEndElement();
            xmlsw.writeCharacters("\n");

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void writeStartElement(String elementName) {
        Objects.requireNonNull(elementName, "XML Element name can't be null");

        try {
            xmlsw.writeStartElement(elementName);
            xmlsw.writeCharacters("\n");

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }

    public void writeEndElement() {

        try {
            xmlsw.writeEndElement();
            xmlsw.writeCharacters("\n");

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void flushAndClose() {
        try {
            xmlsw.flush();
            xmlsw.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
