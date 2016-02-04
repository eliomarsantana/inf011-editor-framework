
package editorframework;

import editorframework.interfaces.Editor;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import org.apache.pdfbox.pdfviewer.PDFPagePanel;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author Eliomar Santana
 */
public class PDFEditor extends Editor{

    public PDFEditor() {
        try {
            this.pdfPagePanel = new PDFPagePanel();
        } catch (IOException ex) {
            Logger.getLogger(PDFEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public JComponent getView() {
         List<PDPage> pdfPages = ((PDFDocument) document).getPDDocument().getDocumentCatalog().getAllPages();
         pdfPagePanel.setPage(pdfPages.get(0));
         return pdfPagePanel;
    }
    private PDFPagePanel pdfPagePanel;
}
