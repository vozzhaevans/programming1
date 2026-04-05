package Lr10.Example2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CreateXMLFile {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("task_list");
            doc.appendChild(rootElement);

            Element task1 = doc.createElement("task");
            rootElement.appendChild(task1);

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Выполнить проект по опд"));
            task1.appendChild(title1);

            Element implementer1 = doc.createElement("implementer");
            implementer1.appendChild(doc.createTextNode("Надежда Возжаева"));
            task1.appendChild(implementer1);

            Element deadlines1 = doc.createElement("deadlines");
            deadlines1.appendChild(doc.createTextNode("2026.06.01"));
            task1.appendChild(deadlines1);

            Element task2 = doc.createElement("task");
            rootElement.appendChild(task2);

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Написать культовый роман"));
            task2.appendChild(title2);

            Element implementer2 = doc.createElement("implementer");
            implementer2.appendChild(doc.createTextNode("Михаил Булгаков"));
            task2.appendChild(implementer2);

            Element deadlines2 = doc.createElement("deadlines");
            deadlines2.appendChild(doc.createTextNode("1940"));
            task2.appendChild(deadlines2);

            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result =
                    new javax.xml.transform.stream.StreamResult(new File("src/Lr10/Example2/example_task.xml"));
            transformer.transform(source, result);

            System.out.println("XML-файл успешно создано!");
        } catch (Exception pc) {
            pc.printStackTrace();
        }
    }
}

