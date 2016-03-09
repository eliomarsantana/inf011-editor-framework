/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.Editor;
import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IDocument;
import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IProjectController;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IToolkitTheme;
import editorframework.interfaces.IUIController;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author eliomar
 */
public class ProjectController implements IProjectController{

    @Override
    public void initialize(final ICore core) {
        
        IUIController uiController = core.getUIController();
        
        String nameTheme = "";
            
                IPlugin p = null;
                ArrayList<IPlugin> themes = core.getPluginController().loadedPlugins();
                Iterator i = themes.iterator();
                while (i.hasNext()) {
                    p = (IPlugin) i.next();
                    if (p instanceof IToolkitTheme) {
                        IToolkitTheme theme = (IToolkitTheme) p;
                        nameTheme = (theme.getClass().getName()).split("\\.")[1];
                        combobox.addItem(nameTheme);
                    }
                }
     
            combobox.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        try {
                            String itemCombobox = (String)(combobox.getSelectedItem());
                            Class t = Class.forName("editorframework." + itemCombobox);
                            IToolkitTheme theme = (IToolkitTheme) t.newInstance();  
                            setTheme(theme, core);
                            }catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                                    Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                    }
            });
 
        uiController.addToolBarItem(combobox);
        
        javax.swing.JMenuItem newItem = uiController.addMenuItem("File", "Open");
                if (newItem != null)
                    newItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            fileOpen(core);
                        }
                    });    
    }

    @Override
    public void fileOpen(ICore core) {
        IPlugin plugin = null;
        ArrayList<IPlugin> loadedPlugins = core.getPluginController().loadedPlugins();
        Iterator i = loadedPlugins.iterator();
        JFileChooser jfc = new JFileChooser();
	jfc.setDialogTitle("Open Document");
	jfc.setDialogType(JFileChooser.OPEN_DIALOG);
        while (i.hasNext()) {
            plugin = (IPlugin) i.next();
            if (plugin instanceof IAbstractFactory) {
                IAbstractFactory factoryPlugin = (IAbstractFactory) plugin;
                FactoryFilter ff = new FactoryFilter(factoryPlugin.supportedType(), factoryPlugin.supportedExtensions());
                jfc.addChoosableFileFilter(ff);
            }
        }
        if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION)
        {
            File documentFile = jfc.getSelectedFile();
            String[] documentFileName = documentFile.getName().split("\\.");
            factory = core.getPluginController().getFactoryPluginBySupportedExtension(documentFileName[documentFileName.length-1]);
            if (factory != null) {
                Editor editor = factory.createEditor();
                factory.createToolbox().loadToolBox(core);
                ISerializer serializer = factory.createSerializer();
                JOptionPane.showMessageDialog(null, "ExtensÃ£o " + documentFileName[documentFileName.length-1] + " aberta pelo plugin " + plugin.getClass().getSimpleName());
                IDocumentController documentController = core.getDocumentController();
                documentController.setSerializer(serializer);
                IDocument document = documentController.openDocument(documentFile.getAbsolutePath());
                editor.setDocument(document);                 
                core.getUIController().setEditor(editor);
            }
        }
    }
    
    public void setTheme(IToolkitTheme theme, ICore core)
    {
        if (theme == null) 
            javax.swing.JOptionPane.showMessageDialog(null, "Plugin de thema não implantado!", "Aviso !", JOptionPane.INFORMATION_MESSAGE); 
        factory.createToolbox().setTheme(theme); 
    }
 
    JComboBox combobox = new JComboBox();
    private IAbstractFactory factory;
}
