package tasks.task3.menu.action;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tasks.task3.api.IAction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.DataOutputStream;
import java.io.File;

public class ViewDeeds extends IAction {
    protected DataOutputStream out;

    public ViewDeeds(DataOutputStream out) {
        this.out = out;
        name="- View all Deeds";
    }

    @Override
    public void action() {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            File file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task3//archive", "archive.xml");
            //read
            Document document = documentBuilder.parse(file);
            XPathFactory xfact = XPathFactory.newInstance();
            XPath xpath = xfact.newXPath();
            NodeList empty = (NodeList) xpath.evaluate("//text()[normalize-space(.) = '']", document, XPathConstants.NODESET);
            for (int i = 0; i < empty.getLength(); i++) {
                Node node = empty.item(i);
                node.getParentNode().removeChild(node);
            }
            //view
            Node root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node deed = nodeList.item(i);
                if (deed.getNodeType() != Node.TEXT_NODE) {
                    NodeList deedProps = deed.getChildNodes();
                    out.writeUTF("Num: " + i);
                    for (int j = 0; j < deedProps.getLength(); j++) {
                        Node deedProp = deedProps.item(j);
                        if (deedProp.getNodeType() != Node.TEXT_NODE) {

                            out.writeUTF(deedProp.getNodeName() + " " + deedProp.getChildNodes().item(0).getTextContent());
                        }


                    }
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
