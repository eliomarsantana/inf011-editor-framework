package editorframework;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.IPluginController;
import editorframework.interfaces.IUIController;


public class Core implements ICore {
    public Core() throws Exception {
        uiController = new UIController();
        uiController.createMenuItemFileOpen(this);
        documentController = new DocumentController();
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
}
