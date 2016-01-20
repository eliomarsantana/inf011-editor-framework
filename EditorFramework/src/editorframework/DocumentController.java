package editorframework;

import editorframework.interfaces.IDocumentController;
import org.apache.pdfbox.pdmodel.PDDocument;


public class DocumentController implements IDocumentController {
    
    DocumentController(PDDocument pdfDocument) {
        this.pdDocument = pdfDocument;
    }
    
    public PDDocument getPDDocument() {
        return pdDocument;
    }
    
    private PDDocument pdDocument;
}
