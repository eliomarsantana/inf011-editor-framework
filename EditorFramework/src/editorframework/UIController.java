/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.IEditor;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IUIController;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public class UIController implements IUIController {

    public UIController() {
        (mainFrame = new MainFrame()).setVisible(true);
    }
    @Override
    public JMenuItem addMenuItem(String menu, String menuItem) {
        JMenuBar menuBar = mainFrame.getJMenuBar();
        int menuCount = menuBar.getMenuCount();
        JMenu targetMenu = null;
        for (int i = 0; i < menuCount; i++)
            if (menuBar.getMenu(i).getText().equals(menu))
                targetMenu = menuBar.getMenu(i);
        if (targetMenu == null) {
            targetMenu = new JMenu(menu);
            menuBar.add(targetMenu);
        }
        int itemCount = targetMenu.getItemCount();
        for (int i = 0; i < itemCount; i++)
            if (targetMenu.getItem(i).getText().equals(menuItem))
                return null;
        JMenuItem targetMenuItem = new JMenuItem(menuItem);
        targetMenu.add(targetMenuItem);
        return targetMenuItem;
    }
    
    @Override
    public void createMenuItemFileOpen(final ICore core) {
        JMenuItem newItem = this.addMenuItem("File", "Open");
        if (newItem != null)
            newItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fileOpen(core);
                }
            });
    }
    
    @Override
    public void setCentralWidget(JPanel panel)
    {
        mainFrame.getContentPane().add(panel);
        mainFrame.pack();
    }
    
    @Override
    public void fileOpen(ICore core){
        ArrayList<IPlugin> loadedPlugins = core.getPluginController().loadedPlugins();
        Iterator i = loadedPlugins.iterator();
        JFileChooser jfc = new JFileChooser();
	jfc.setDialogTitle("Open Document");
	jfc.setDialogType(JFileChooser.OPEN_DIALOG);
        while (i.hasNext()) {
            IPlugin plugin = (IPlugin) i.next();
            if (plugin instanceof IAbstractFactory) {
                IAbstractFactory factoryPlugin = (IAbstractFactory) plugin;
                FactoryFilter ff = new FactoryFilter(factoryPlugin.supportedType(), factoryPlugin.supportedExtensions());
                jfc.addChoosableFileFilter(ff);
            }
        }
        if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION)
        {
            /*File documentFile = jfc.getSelectedFile();
            String[] documentFileName = documentFile.getName().split("\\.");
            IAbstractFactory factory = core.getPluginController().getFactoryPluginBySupportedExtension(documentFileName[documentFileName.length-1]);
            if (factory != null) {
                ISerializer serializer = factory.createSerializer();
                IDocumentController document = serializer.load(documentFile.getAbsolutePath());
                IEditor editor = factory.createEditor();
                editor.setDocument(document);
                this.setCentralWidget(editor.getPanel());
            }*/
        }
    }
    
    private MainFrame mainFrame;
}
