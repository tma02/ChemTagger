/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author ray
 */
public class ChemExtractor {
    
    
public static void main(String[] args) {

      try {
          
         File inputFile = new File("./file3.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         NodeList nList = doc.getElementsByTagName("Sentence");
         System.out.println("Chemicals Demo");
         System.out.println("--------------------------------------------------");

         
         // For each sentence
         for (int sts_id = 0; sts_id < nList.getLength(); sts_id++) {
             
            
            // Each sentence node
            Node nNode = nList.item(sts_id);
            
                
            // NodeList in the sentence
            Element eElement = (Element) nNode;
            NodeList nodes = eElement.getChildNodes();


            List<String> molecules = new LinkedList<String>();
                
            for(int node_id = 0; node_id < nodes.getLength(); node_id++){
                    
                    
                getContent(nodes.item(node_id), molecules);
            }

            // Non duplicate molecules stored in molecule
            for (String molecule : molecules) {
                System.out.println(molecule);
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
    
    
    public static void getContent(Node node, List<String> molecules){
        if(node.getNodeName().equals("MOLECULE")){
            //System.out.println(node.getTextContent());
            if (!molecules.contains(node.getTextContent())) {
                molecules.add(node.getTextContent());
            }
        }
        
        if(node.getChildNodes().getLength() != 0){

            for(int i = 0; i < node.getChildNodes().getLength(); i++){
                getContent(node.getChildNodes().item(i), molecules);
            }          
        }
    }
    
}
