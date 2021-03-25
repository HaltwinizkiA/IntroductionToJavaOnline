package tasks.task3.menu.action;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tasks.task3.api.IAction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class ModifyDeed extends IAction {
    protected DataInputStream in;
    protected DataOutputStream out;

    public ModifyDeed(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
        name = "- Modify Deed";
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
            //modify
            Node root = document.getDocumentElement();
            NodeList deeds = root.getChildNodes();
            int numOfDeed;
            while (true){
            out.writeUTF("Select deed number 0-" + (deeds.getLength()-1));
            numOfDeed = Integer.parseInt(in.readUTF());
            if (numOfDeed<0&numOfDeed>deeds.getLength()-1){
                out.writeUTF("Wrong input");
            continue;
            }
            break;
            }

            while (true) {
                out.writeUTF("Select change: \n1-Name\n2-Course\n3-Specialty\n4-YearOfBirth\n5-Registration\n6-stop");

                  int select = Integer.parseInt(in.readUTF());

                switch (select) {
                    case 1:
                        Node name = document.getElementsByTagName("Name").item(numOfDeed);
                        name.setTextContent(in.readUTF());
                        continue;
                    case 2:
                        Node course = document.getElementsByTagName("Course").item(numOfDeed);
                        course.setTextContent(in.readUTF());
                        continue;
                    case 3:
                        Node specialty = document.getElementsByTagName("Specialty").item(numOfDeed);
                        specialty.setTextContent(in.readUTF());
                        continue;
                    case 4:
                        Node yearOfBirth = document.getElementsByTagName("YearOfBirth").item(numOfDeed);
                        yearOfBirth.setTextContent(in.readUTF());
                        continue;
                    case 5:
                        Node registration = document.getElementsByTagName("Registration").item(numOfDeed);
                        registration.setTextContent(in.readUTF());
                        continue;
                    case 6:
                        break;
                }
                break;
            }

                //write
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(document);
                FileOutputStream out = new FileOutputStream(file);
                StreamResult result = new StreamResult(out);
                transformer.transform(source, result);
            }
         catch (Exception e) {
            e.printStackTrace();
        }

    }
}
