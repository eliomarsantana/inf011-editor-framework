package editorframework;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.IPluginController;
import editorframework.interfaces.IUIController;
import org.apache.pdfbox.pdmodel.PDDocument;


public class Core implements ICore {
    public Core() throws Exception {
        uiController = new UIController();
        uiController.createMenuItemFileOpen(this);
        documentController = new DocumentController(pdfDocument);
        pluginController = new PluginController();
        pluginController.initialize(this);
    }

    @Override
    public IUIController getUIController() {
        return uiController;
    }

    @Override
    public IDocumentController getDocumentController() {
        return documentController;
    }

    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
    private IUIController uiController;
    private IDocumentController documentController;
    private IPluginController pluginController;
    private PDDocument pdfDocument;
}
