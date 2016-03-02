package editorframework;

import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.Editor;
import editorframework.interfaces.IDocument;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IToolkitTheme;
import editorframework.interfaces.IUIController;
import java.awt.Container;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class UIController implements IUIController {

    public UIController(ICore core) {
        this.core = core;
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);      
        createMenuItemFileOpen(core);
        
        
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
    public void fileOpen(ICore core){
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
            IAbstractFactory factory = core.getPluginController().getFactoryPluginBySupportedExtension(documentFileName[documentFileName.length-1]);
            if (factory != null) {
                Editor editor = factory.createEditor();
                ISerializer serializer = factory.createSerializer();
                JOptionPane.showMessageDialog(null, "ExtensÃ£o " + documentFileName[documentFileName.length-1] + " aberta pelo plugin " + plugin.getClass().getSimpleName());
                IDocumentController documentController = core.getDocumentController();
                documentController.setSerializer(serializer);
                IDocument document = documentController.openDocument(documentFile.getAbsolutePath());
                editor.setDocument(document);
                setEditor(editor);
                loadThemeCombobox(core);
            }
        }       
    }
    
    /*
    private void createToolBar() {
        
        JToolBar toolbar = new JToolBar();

        ImageIcon icon = new ImageIcon("exit.png");

        JButton exitButton = new JButton(icon);
        toolbar.add(exitButton);
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        add(toolbar, BorderLayout.NORTH);        
    }

    */
    
    @Override
    public void loadThemeCombobox(ICore core) {
            JToolBar toolbar = new JToolBar();
            JButton exitButton = new JButton("TESte");
            toolbar.add(exitButton);
            mainFrame.add(toolbar);
            //    JComboBox combobox = new JComboBox(new Object[]{"Item", "Item1", "Item2"});
            //   c.add(combobox)
          
            IPlugin plugin = null;
            
            ArrayList<IPlugin> themes = core.getPluginController().loadedPlugins();
            Iterator i = themes.iterator();
            while (i.hasNext()) {
                plugin = (IPlugin) i.next();
            if (plugin instanceof IToolkitTheme) {
                IToolkitTheme themePlugin = (IToolkitTheme) plugin;
                System.out.println(themePlugin.getClass().getName());
                
            }
                //combobox.addItem(plugin.getClass().getName());
                //mainFrame.add(combobox);
                //IToolkitTheme themePlugin = (IToolkitTheme) plugin;
                //themePlugin.paint();
            }
       
        
    }
    
    @Override
    public void setEditor(Editor editor) {
        JComponent view = editor.getView();
        mainFrame.getContentPane().add(view);
        mainFrame.pack();
    }
 
    private MainFrame mainFrame;
    private ICore core;
}
