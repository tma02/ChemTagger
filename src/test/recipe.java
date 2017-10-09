/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.io.File;
import static java.util.Collections.list;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author ray
 */
public class recipe {
    
public static void main(String[] args) {

      try {
          
         File inputFile = new File("./file1.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         NodeList nList = doc.getElementsByTagName("Sentence");
         
         StringBuilder textContent;
         
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;

              
              NodeList actions = eElement.getElementsByTagName("ActionPhrase");


              for(int j = 0; j < actions.getLength(); j++){
                    Element action_ele = (Element) actions.item(j);
                    textContent = new StringBuilder().append(j+1).append(". ");
                    //System.out.println("----------------------------");
                    
                  
                  
                    NodeList b = action_ele.getElementsByTagName("*");

                for(int i = 0; i < b.getLength(); i++){
                    String id = b.item(i).getNodeName();
                    if (!(id.equals("PrepPhrase") || id.equals("NounPhrase") || id.equals("ActionPhrase") || id.equals("MOLECULE") || id.equals("OSCAR-CM") || id.equals("QUANTITY") || id.equals("TempPhrase") || id.equals("VOLUME") || id.equals("MASS") || id.equals("AMOUNT") || id.equals("VerbPhrase") || id.equals("TimePhrase"))){
                    
                        String s = " " + b.item(i).getTextContent();
                        textContent.append(s);
                    }

              }
              System.out.println(textContent.toString());
                            
              }
              System.out.println("----------------------------");
              
              
              
              
              
              
            } 
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
    
}
