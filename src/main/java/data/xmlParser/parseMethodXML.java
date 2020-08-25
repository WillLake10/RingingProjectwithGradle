package data.xmlParser;


import data.dto.Method;
import data.xmlParser.dto.PropertiesDto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static data.xmlParser.XmlUtil.asList;

public class parseMethodXML {
    public static void main() {
        try {
            File importFile = new File("src/main/resources/CCCBR_methods.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(importFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root: " + doc.getDocumentElement().getNodeName());
            NodeList n1List = doc.getElementsByTagName("methodSet");
            int methodNo = 0;
            for (int i = 0; i < n1List.getLength(); i++) {
                Node n1Node = n1List.item(i);
                if (n1Node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) n1Node;
                    String notes = element.getElementsByTagName("notes").item(0).getTextContent();
                    NodeList n2List = doc.getElementsByTagName("properties");
                    Node n2Node = n2List.item(i);
                    PropertiesDto propertiesDto = getProperties(n2Node);
                    //System.out.println(propertiesDto.toString());
                    //System.out.println(notes);
                    NodeList methods = ((Element)n1Node).getElementsByTagName("method");
                    for(Node methodNode: asList(methods)) {
                        methodNo++;
                        Method method = getMethod(methodNode, propertiesDto, notes);
                        System.out.println(method.toString());
                    }
                }
            }
            System.out.println(methodNo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static PropertiesDto getProperties(Node propertiesNode) {
        PropertiesDto propertiesDto = new PropertiesDto();
        if (propertiesNode.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) propertiesNode;
            try {
                propertiesDto.setClassification(element.getElementsByTagName("classification").item(0).getTextContent());
            } catch (Exception e) {
            }
            try {
                propertiesDto.setStage(Integer.parseInt(element.getElementsByTagName("stage").item(0).getTextContent()));
            } catch (Exception e) {
            }
            try {
                propertiesDto.setLengthOfLead(Integer.parseInt(element.getElementsByTagName("lengthOfLead").item(0).getTextContent()));
            } catch (Exception e) {
            }
            try {
                propertiesDto.setNumberOfHunts(Integer.parseInt(element.getElementsByTagName("numberOfHunts").item(0).getTextContent()));
            } catch (Exception e) {
            }
            try {
                propertiesDto.setLeadHead(element.getElementsByTagName("leadHead").item(0).getTextContent());
            } catch (Exception e) {
            }
            try {
                propertiesDto.setLeadHeadCode(element.getElementsByTagName("leadHeadCode").item(0).getTextContent());
            } catch (Exception e) {
            }
            try {
                propertiesDto.setSymmetry(element.getElementsByTagName("symmetry").item(0).getTextContent());
            } catch (Exception e) {
            }
        }
        return propertiesDto;
    }

    public static Method getMethod(Node methodsNode, PropertiesDto propertiesDto, String notes) {
        Method method = new Method();
        if (methodsNode.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) methodsNode;
            try {
                method.setClassification(element.getElementsByTagName("classification").item(0).getTextContent());
            } catch (Exception e) {
                try {
                    method.setClassification(propertiesDto.getClassification());
                } catch (Exception f) {
                }
            }
            try {
                method.setStage(Integer.parseInt(element.getElementsByTagName("stage").item(0).getTextContent()));
            } catch (Exception e) {
                try {
                    method.setStage(propertiesDto.getStage());
                } catch (Exception f) {
                }
            }
            try {
                method.setLengthOfLead(Integer.parseInt(element.getElementsByTagName("lengthOfLead").item(0).getTextContent()));
            } catch (Exception e) {
                try {
                    method.setLengthOfLead(propertiesDto.getLengthOfLead());
                } catch (Exception f) {
                }
            }
            try {
                method.setNumberOfHunts(Integer.parseInt(element.getElementsByTagName("numberOfHunts").item(0).getTextContent()));
            } catch (Exception e) {
                try {
                    method.setNumberOfHunts(propertiesDto.getNumberOfHunts());
                } catch (Exception f) {
                }
            }
            try {
                method.setLeadHead(element.getElementsByTagName("leadHead").item(0).getTextContent());
            } catch (Exception e) {
                try {
                    method.setLeadHead(propertiesDto.getLeadHead());
                } catch (Exception f) {
                }
            }
            try {
                method.setLeadHeadCode(element.getElementsByTagName("leadHeadCode").item(0).getTextContent());
            } catch (Exception e) {
                try {
                    method.setLeadHeadCode(propertiesDto.getLeadHeadCode());
                } catch (Exception f) {
                }
            }
            try {
                method.setSymmetry(element.getElementsByTagName("symmetry").item(0).getTextContent());
            } catch (Exception e) {
                try {
                    method.setSymmetry(propertiesDto.getSymmetry());
                } catch (Exception f) {
                }
            }
            try {
                method.setName(element.getElementsByTagName("name").item(0).getTextContent());
            } catch (Exception e) {
            }
            try {
                method.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
            } catch (Exception e) {
            }
            try {
                method.setNotation(element.getElementsByTagName("notation").item(0).getTextContent());
            } catch (Exception e) {
            }
            try {
                method.setID(element.getAttribute("id"));
            } catch (Exception e) {
            }
            method.setNotes(notes);
        }
        return method;
    }
}
