/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import  uk.ac.cam.ch.wwmm.chemicaltagger.POSContainer;
import  uk.ac.cam.ch.wwmm.chemicaltagger.ChemistryPOSTagger;
import  uk.ac.cam.ch.wwmm.chemicaltagger.ChemistrySentenceParser;
import  uk.ac.cam.ch.wwmm.chemicaltagger.Utils;
import  nu.xom.Document;

/**
 *
 * @author leilu
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
              String text = "To a stirred solution of 4-hydroxypiperidine (0.97 g, 9.60 mmol) in anhydrous dimethylformamide (20 mL) at 0°C was added 1-(bromomethyl)-4-methoxybenzene (1.93 g, 9.60 mmol) and triethylamine (2.16 g, 21.4 mmol). The reaction mixture was then warmed to room temperature and stirred overnight. After this time the mixture was concentrated under reduced pressure and the resulting residue was dissolved in ethyl acetate (40 mL), washed with water (20 mL) and brine (20 mL) before being dried over sodium sulfate. The drying agent was filtered off and the filtrate concentrated under reduced pressure. The residue obtained was purified by flash chromatography (silica gel, 0-5% methanol/methylene chloride) to afford 1-(4-methoxybenzyl)piperidin-4-ol as a brown oil (1.70 g, 80%).";
              
              
                    // Calling ChemistryPOSTagger
      POSContainer posContainer = ChemistryPOSTagger.getDefaultInstance().runTaggers(text);

      // Returns a string of TAG TOKEN format (e.g.: DT The NN cat VB sat IN on DT the NN matt)
      // Call ChemistrySentenceParser either by passing the POSContainer or by InputStream
      ChemistrySentenceParser chemistrySentenceParser = new ChemistrySentenceParser(posContainer);

      // Create a parseTree of the tagged input
      chemistrySentenceParser.parseTags();

      // Return an XMLDoc
      Document doc = chemistrySentenceParser.makeXMLDocument();

      Utils.writeXMLToFile(doc,"F:/LLNL/file1.xml");
        
    }
    
}
