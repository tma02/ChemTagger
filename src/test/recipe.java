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

    StringBuilder textContent =  new StringBuilder("");
      try {
          
         File inputFile = new File("./file3.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         NodeList nList = doc.getElementsByTagName("Sentence");
         System.out.println("Recipe Demo");
         System.out.println("---------------------------------------------------");
         StringBuilder output = new StringBuilder("");
     //    String output;
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            System.out.println("-----------------------Sentence "+temp+"---------------------------");
            Node nNode = nList.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;

              NodeList nodes = eElement.getChildNodes();
              int a = nodes.getLength();
              String non_action="";
              for(int i=0; i<nodes.getLength();i++){
                //  System.out.println(nodes.item(i).getNodeName());
                  
                  // if it is non-action phrase  nodes.item(j).getNodeName().equals("NounPhrase")
                  int actionIndex = 0;
                  
                  
                  if(!nodes.item(i).getNodeName().equals("ActionPhrase")){
                    //  non_action = non_action + getContent(nodes.item(i),output);
                    getContent(nodes.item(i),output);
                    
                  }else{
                      //TODO: print action phrase
                      System.out.println(non_action);
                      non_action = "";
                      System.out.println("ACTION_PHRASE");
                  }
                  if(i==nodes.getLength()-1 && !non_action.equals("")){
                    System.out.println(output.toString());
                  }
                  
              }
              System.out.println(output.toString());
              output.delete(0, output.length()-1);
              
              
            /*
              NodeList actions = eElement.getElementsByTagName("ActionPhrase");


              for(int j = 0; j < actions.getLength(); j++){
                    Element action_ele = (Element) actions.item(j);
                    textContent = new StringBuilder().append(temp+1).append(".").append(j+1).append(". ");

                                                      
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
              System.out.println("---------------------------------------------------");
*/              
            } 
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }


public static void getContent(Node node, StringBuilder output){

        //NodeList elements = eElement.getElementsByTagName("*");
        
        if(node.getChildNodes().getLength() != 0){
       // output = node.getChildNodes().item(0).getTextContent();
       output.append(" "+node.getChildNodes().item(0).getTextContent());
       
     //  System.out.println(output.toString());           
        for(int i = 1; i < node.getChildNodes().getLength(); i++){

            
        //output = output + " " +getContent(node.getChildNodes().item(i),output);
        //    output = node.getChildNodes().item(i).getNodeName();
            getContent(node.getChildNodes().item(i),output);
                    
                        
        }          
        }
        
        

    
    
    
    

}
    
}
