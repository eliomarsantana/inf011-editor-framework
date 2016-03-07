package editorframework;

import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.Editor;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IToolkitTheme;
import editorframework.interfaces.IUIController;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class UIController implements IUIController {

    public UIController(ICore core) {
        this.core = core;
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);       
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
    public void loadCombobox(final ICore core){
            String nameTheme = "";
            IPlugin plugin = null;
            
            ArrayList<IPlugin> themes = core.getPluginController().loadedPlugins();
            Iterator i = themes.iterator();
            while (i.hasNext()) {
                plugin = (IPlugin) i.next();
                if (plugin instanceof IToolkitTheme) {
                    nameTheme = (plugin.getClass().getName()).split("\\.")[1];
                    combobox.addItem(nameTheme);
                }
                
            }
            addToolBarItem(combobox);
            combobox.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    IPlugin p = null;
                    try {
                        String itemCombobox = (String)(combobox.getSelectedItem());
                        Class t = Class.forName("editorframework." + itemCombobox);
                        IToolkitTheme theme = (IToolkitTheme) t.newInstance();
                        ArrayList<IPlugin> pFabrica = core.getPluginController().loadedPlugins();//setTheme(theme, combobox);
                        Iterator i = pFabrica.iterator();
                            while (i.hasNext()) {
                                p = (IPlugin) i.next();
                                if (p instanceof IAbstractFactory) {
                                    IAbstractFactory factoryPlugin = (IAbstractFactory) p;
                                    factoryPlugin.createToolbox().setTheme(theme, core);
                                }
                
                            }
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                        Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               
            });
    }
     
    @Override
    public void addToolBarItem(Component component) { 
        mainFrame.getToolBar().add(component);
    }
    
    @Override
    public void setEditor(Editor editor) {
        JComponent view = editor.getView();
        mainFrame.getContentPane().add(view);
        mainFrame.pack();
    }
 
    private MainFrame mainFrame;
    private ICore core;
    JComboBox combobox = new JComboBox();
}
