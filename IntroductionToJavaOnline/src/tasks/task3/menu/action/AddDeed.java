package tasks.task3.menu.action;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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

public class AddDeed extends IAction {
    protected DataInputStream in;
    protected DataOutputStream out;

    public AddDeed(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
        name="- Add Deed";
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
                node.getParentNode().removeChild(node);}
            //add
                Node root = document.getDocumentElement();
                Element deed = document.createElement("Deed");
                Element name = document.createElement("Name");
                out.writeUTF("Enter Name:");
                name.setTextContent(in.readUTF());
                Element course = document.createElement("Course");
            out.writeUTF("Enter Course:");
                course.setTextContent(in.readUTF());
                Element specialty = document.createElement("Specialty");
            out.writeUTF("Enter Specialty:");
                specialty.setTextContent(in.readUTF());
                Element year = document.createElement("YearOfBirth");
            out.writeUTF("Enter Year Of Birth:");
                year.setTextContent(in.readUTF());
                Element registration = document.createElement("Registration");
            out.writeUTF("Enter Registration:");
                registration.setTextContent(in.readUTF());
                deed.appendChild(name);
                deed.appendChild(course);
                deed.appendChild(specialty);
                deed.appendChild(year);
                deed.appendChild(registration);
                root.appendChild(deed);
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
