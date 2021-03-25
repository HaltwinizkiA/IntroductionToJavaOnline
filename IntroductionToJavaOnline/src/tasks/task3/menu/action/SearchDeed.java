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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;

public class SearchDeed extends IAction {
    protected DataInputStream in;
    protected DataOutputStream out;

    public SearchDeed(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
        name="- Search Deed";
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
            //search
            Node root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            out.writeUTF("Enter searched name");
            String enter = in.readUTF();
            boolean search = false;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = document.getElementsByTagName("Name").item(i);
                String nodeContent = node.getTextContent();

                if (nodeContent.equals(enter)) {
                    String name = document.getElementsByTagName("Name").item(i).getTextContent();
                    String course = document.getElementsByTagName("Course").item(i).getTextContent();
                    String specialty = document.getElementsByTagName("Specialty").item(i).getTextContent();
                    String yearOfBirth = document.getElementsByTagName("YearOfBirth").item(i).getTextContent();
                    String registration = document.getElementsByTagName("Registration").item(i).getTextContent();
                    out.writeUTF("Name: " + name + "\nCourse: " + course + "\nSpecialty: " + specialty + "\nYear Of Birth: " + yearOfBirth + "\nRegistration:" + registration);
                    search = true;
                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
