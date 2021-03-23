package tasks.task3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Archive {
    private static final int port = 4004;
    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static DataOutputStream out;
    private static DataInputStream in;
    private final Scanner scanner;
    private final File archive;
    private final File accounts;
    private DocumentBuilder documentBuilder;
    private Document document;

    public Archive() {
        scanner = new Scanner(System.in);
        archive = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task3", "archive.xml");
        accounts = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task3", "accounts.txt");
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            read();
            startWindows();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server is on");
            clientSocket = server.accept();
            System.out.println("User is connected");
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            Archive archive = new Archive();


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                in.close();
                out.close();
                clientSocket.close();
                System.out.println("Server closed");
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }


    private void startWindows() throws IOException {
        out.writeUTF("Welcome to the archive Select Login or Registration: 1-login 2-reg 3-disconnect");


        int select = select(1, 3);
        switch (select) {
            case 1:
                menu(authentication());
                break;
            case 2:
                registration();
                menu(authentication());
                break;
            case 3:
                out.writeUTF("disconnect");
                break;
        }

    }

    private int select(int min, int max) throws IOException {

        int select = 0;
        while (true) {
            try {

                select = Integer.parseInt(in.readUTF());
                System.out.println(select);
                if (select >= min & select <= max) {
                    break;
                }
            } catch (Exception e) {

                out.writeUTF("ERROR wrong input");

            }
            out.writeUTF("wrong num  pls enter " + min + " - " + max);
        }
        return select;

    }

    private void registration() throws IOException {
        out.writeUTF("Enter Login");
        String login = loginPassValidator();
        out.writeUTF("Enter Password");
        String password = loginPassValidator();
        String newAcc = login + "/" + password + "/0";
        List<String> listAccount = new ArrayList<String>();
        FileReader file = new FileReader(accounts);
        BufferedReader bufferedReader = new BufferedReader(file);

        String line = bufferedReader.readLine();
        while (line != null) {
            listAccount.add(line);

            line = bufferedReader.readLine();
        }
        listAccount.add(newAcc);
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(accounts));
        for (String acc : listAccount) {
            outputWriter.write(acc + "\n");
        }
        outputWriter.flush();
        outputWriter.close();


    }

    private void menu(int auth) throws IOException {
        if (auth == 0) {
            userMenu();
        }
        if (auth == 1) {
            adminMenu();
        }
        if (auth == 2) {
            out.writeUTF("no such account found\n");
            try {
                startWindows();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String loginPassValidator() throws IOException {
        String enters;
        while (true) {
            enters = in.readUTF();
            Matcher matcher = Pattern.compile("\\W").matcher(enters);
            if (matcher.find()) {
                out.writeUTF("wrong enters\n get rid of symbols symbols: !@#$%^&*()");
                continue;
            }
            break;
        }
        return enters;
    }

    private int authentication() throws IOException {

        out.writeUTF("Enter your account:\nlogin:");
        String login = loginPassValidator();
        out.writeUTF("password:");
        String password = loginPassValidator();
        int select = 2;
        FileReader reader = null;
        try {
            reader = new FileReader(accounts);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            line = bufferedReader.readLine();
            while (line != null) {
                String[] account = line.split("/");
                if (login.equals(account[0])) {
                    if (password.equals(account[1])) {
                        select = Integer.parseInt(account[2]);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return select;
    }


    private void adminMenu() throws IOException {
        out.writeUTF("You permission admin");

        while (true) {
            out.writeUTF("\nMenu:\n1-view\n2-search\n3-modify\n4-add Deed\n5-logout");
            int select = select(1, 5);
            switch (select) {
                case 1 -> viewDeed();
                case 2 -> searchDeed();
                case 3 -> modifyDeeds();
                case 4 -> addDeed();
                case 5 -> startWindows();


            }
        }


    }

    private void userMenu() throws IOException {
        out.writeUTF("You permission User");
        while (true) {
            out.writeUTF("\nMenu:\n1-view\n2-search\n3-logout");
            int select = select(1, 3);
            switch (select) {
                case 1 -> viewDeed();
                case 2 -> searchDeed();
                case 3 -> startWindows();

            }
        }


    }

    private void read() {
        try {

            document = documentBuilder.parse(archive);
            XPathFactory xfact = XPathFactory.newInstance();
            XPath xpath = xfact.newXPath();
            Node root = document.getDocumentElement();
            NodeList nods = root.getChildNodes();
            try {
                NodeList empty = (NodeList) xpath.evaluate("//text()[normalize-space(.) = '']", document, XPathConstants.NODESET);
                for (int i = 0; i < empty.getLength(); i++) {
                    Node node = empty.item(i);
                    node.getParentNode().removeChild(node);
                }
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }


        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    private void write() {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            FileOutputStream out = new FileOutputStream(archive);
            StreamResult result = new StreamResult(out);
            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private void addDeed() throws IOException {

        Node root = document.getDocumentElement();
        Element deed = document.createElement("Deed");
        Element name = document.createElement("Name");
        setTextContent(name);
        Element course = document.createElement("Course");
        setTextContent(course);
        Element specialty = document.createElement("Specialty");
        setTextContent(specialty);
        Element year = document.createElement("YearOfBirth");
        setTextContent(year);
        Element registration = document.createElement("Registration");
        setTextContent(registration);
        deed.appendChild(name);
        deed.appendChild(course);
        deed.appendChild(specialty);
        deed.appendChild(year);
        deed.appendChild(registration);
        root.appendChild(deed);
        write();


    }

    private void modifyDeeds() throws IOException {
        Node root = document.getDocumentElement();
        NodeList deeds = root.getChildNodes();
        out.writeUTF("Select deed number 0-" + deeds.getLength());
        int deed = select(0, deeds.getLength() - 1);
        while (true) {
            out.writeUTF("Select change: \n1-Name\n2-Course\n3-Specialty\n4-YearOfBirth\n5-Registration\n6-stop");
            int select = select(1, 6);
            switch (select) {
                case 1:
                    Node name = document.getElementsByTagName("Name").item(deed);
                    setTextContent(name);
                    continue;
                case 2:
                    Node course = document.getElementsByTagName("Course").item(deed);
                    setTextContent(course);
                    continue;
                case 3:
                    Node specialty = document.getElementsByTagName("Specialty").item(deed);
                    setTextContent(specialty);
                    continue;
                case 4:
                    Node yearOfBirth = document.getElementsByTagName("YearOfBirth").item(deed);
                    setTextContent(yearOfBirth);
                    continue;
                case 5:
                    Node registration = document.getElementsByTagName("Registration").item(deed);
                    setTextContent(registration);
                    continue;
                case 6:
                    break;
            }
            break;
        }
        write();

    }


    private void setTextContent(Element element) throws IOException {
        String s = "";
        while (true) {
            out.writeUTF("enter " + element.getNodeName());
            try {
                s = in.readUTF();
                element.setTextContent(s);
                break;
            } catch (Exception e) {
                out.writeUTF("Wrong symbol");
            }

        }
    }

    private void setTextContent(Node node) throws IOException {
        String s = "";
        while (true) {
            out.writeUTF("enter " + node.getNodeName());
            try {
                s = in.readUTF();


                node.setTextContent(s);
                break;
            } catch (Exception e) {
                out.writeUTF("Wrong symbol");


            }

        }
    }

    private void searchDeed() throws IOException {
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
        if (!search) {
            out.writeUTF("not searched");
        }


    }

    private void viewDeed() throws IOException {
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
                        server.setSoTimeout(100);
                        out.writeUTF(deedProp.getNodeName() + " " + deedProp.getChildNodes().item(0).getTextContent());
                    }


                }
            }
        }
    }
}


//Попробуйте решить данную задачу хотя бы на 50%.
//Задание 3: создайте клиент-серверное приложение “Архив”.
//Общие требования к заданию:
//• В архиве хранятся Дела (например, студентов). Архив находится на сервере.
//• Клиент, в зависимости от прав, может запросить дело на просмотр, внести в
//него изменения, или создать новое дело.
//Требования к коду лабораторной работы:
//• Для реализации сетевого соединения используйте сокеты.
//• Формат хранения данных на сервере – xml-файлы.
