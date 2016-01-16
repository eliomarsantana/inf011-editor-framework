/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IDocumentController;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author Eliomar Santana
 */
public class PDFDocument implements IDocumentController{
    
    PDFDocument(PDDocument pdfDocument) {
        this.pdDocument = pdfDocument;
    }
    
    public PDDocument getPDDocument() {
        return pdDocument;
    }
    
    private PDDocument pdDocument;
}
