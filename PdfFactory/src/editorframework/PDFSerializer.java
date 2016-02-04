/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IDocument;
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
    public IDocument openDocument(String fileName) {
        IDocument document = new PDFDocument();
        document.open(fileName);
        return document;
    }
    
}
