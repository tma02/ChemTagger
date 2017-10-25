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
import java.io.*;
import java.util.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;





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
        
       String text = "AFM and TEM Images. AFM images were acquired with a Dimension 3100 SPM (Veeco Instruments Inc., Woodbury, NY) operated in tapping mode with an OTESPA tip. Substrates were prepared specifically for AFM imaging and were prepared in the exact manner described below for OSC fabrication. To image the bulk morphology of the PEI series, 10 wt % solutions of the polymers in 2-methoxyethanol were drop cast onto TEM grids (Electron Microscopy Sciences, Hatfield, PA) and then dried in an 80 °C oven overnight in order to evaporate the solvent. This provided thin films approximately 40−60 nm thick. The instrument used was an FEI Tecnai G2 F20 TEM operated at an accelerating voltage of 200 kV and in bright-field mode. Standard exposure (0.1 s) and  acquisition times (2 s) were used.\n" +
"	Photoelectron Spectroscopy Measurements. Substrates were prepared specifically for XPS and UPS analysis in the exact manner described below for OSC fabrication. Measurements were conducted with a Kratos Axis Ultra DLD with an angle of photoelectron emission normal to the surface. XPS measurements were conducted using a monochromatized Al X-ray source operated at 10 mA and 15 kV with a spectrometer pass energy of 80 eV, a hybrid lens, and a slot aperture. UPS was conducted using a He lamp (hν = 21.22 eV) operated at 20 W, with a spectrometer pass energy of 5 eV, a hybrid lens, and a 110 μm aperture.\n" +
"	OPV and SCLC Device Fabrication. ITO-coated substrates (15 Ω □−1, Shanghai B. Tree Tech, Shanghai, China) were cleaned by ultrasonication in acetone, deionized water, and isopropyl alcohol for 30 min each, followed by 60 s of plasma cleaning. The ZnO precursor solution was spin coated on the cleaned ITO substrates at 5000 rpm for 40 s, followed by thermal annealing at 250 °C for 1 h. PEI and PEIE solutions were prepared by dissolving each polymer in 2-methoxyethanol to achieve the desired concentration. Each PEI or PEIE solution was spin coated on the ITO/ZnO substrate at 5000 rpm for 40 s and then thermally annealed at 110 °C for 10 min.";
              
              
                    // Calling ChemistryPOSTagger
      POSContainer posContainer = ChemistryPOSTagger.getDefaultInstance().runTaggers(text);

      // Returns a string of TAG TOKEN format (e.g.: DT The NN cat VB sat IN on DT the NN matt)
      // Call ChemistrySentenceParser either by passing the POSContainer or by InputStream
      ChemistrySentenceParser chemistrySentenceParser = new ChemistrySentenceParser(posContainer);

      // Create a parseTree of the tagged input
      chemistrySentenceParser.parseTags();

      // Return an XMLDoc
      Document doc = chemistrySentenceParser.makeXMLDocument();

      Utils.writeXMLToFile(doc,"./file3.xml");           
    }
    
}



