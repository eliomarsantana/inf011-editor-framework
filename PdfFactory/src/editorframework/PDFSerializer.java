/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.ISerializer;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author Eliomar Santana
 */
public class PDFSerializer implements ISerializer{

    @Override
    public IDocumentController load(String fileName) {
        File pdfFile = new File(fileName);
        PDDocument pdfDocument = null;
        try {
            pdfDocument = PDDocument.load(pdfFile);
        } catch (IOException ex) {
            Logger.getLogger(PDFSerializer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new PDFDocument(pdfDocument);
    }

    @Override
    public boolean save(IDocumentController doc, String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
