/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IDocument;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author Eliomar Santana
 */
public class PDFDocument implements IDocument{

    @Override
    public boolean open(String fileName) {
        File pdfFile = new File(fileName);
        
        try {
            pdDocument = PDDocument.load(pdfFile);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(PDFSerializer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public PDDocument getPDDocument() {
        return pdDocument;
    }
    
    private PDDocument pdDocument;
}
