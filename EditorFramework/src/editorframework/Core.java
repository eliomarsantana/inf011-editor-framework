package editorframework;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.IPluginController;
import editorframework.interfaces.IProjectController;
import editorframework.interfaces.IUIController;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Core implements ICore {
    public Core() throws Exception {
        
        pluginController = new PluginController();
        pluginController.initialize(this);
        uiController = new UIController(this);
        uiController.loadCombobox(this);
        projectController = new ProjectController();
        projectController.initialize(this);
        documentController = new DocumentController();
    }
    
    public static Core getInstance(){
        if(instance == null) try {
            instance = new Core();
        } catch (Exception ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
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
    
    @Override
    public IProjectController getProjectController() {
        return projectController;
    }
    
    private IUIController uiController;
    private IDocumentController documentController;
    private IPluginController pluginController;
    private IProjectController projectController;
    private static Core instance = null;
}
