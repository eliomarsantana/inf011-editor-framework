/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.IEditor;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.apache.pdfbox.pdfviewer.PDFPagePanel;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author Eliomar Santana
 */
public class PDFEditor implements IEditor{

    public PDFEditor() {
        try {
            this.pdfPagePanel = new PDFPagePanel();
        } catch (IOException ex) {
            Logger.getLogger(PDFEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setDocument(IDocumentController doc) {
        List<PDPage> pdfPages = ((PDFDocument) doc).getPDDocument().getDocumentCatalog().getAllPages();
        pdfPagePanel.setPage(pdfPages.get(0));
    }

    @Override
    public JPanel getPanel() {
        return pdfPagePanel;
    }
    
    private PDFPagePanel pdfPagePanel;
    
}
