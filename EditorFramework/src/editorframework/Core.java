package editorframework;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.IPluginController;
import editorframework.interfaces.IUIController;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Core implements ICore {
    public Core() throws Exception {
        uiController = new UIController(this);
        uiController.createMenuItemFileOpen(this);
        documentController = new DocumentController();
        pluginController = new PluginController();
        pluginController.initialize(this);
    }

    public static Core getInstance() {
        try {
            if(core == null)
                core = new Core();
            
        } catch (Exception ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }
        return core;
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
    private static Core core;
}
