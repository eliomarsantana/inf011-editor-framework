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
    
    public javax.swing.JButton addButtonToolBarItem(String buttonName){
        javax.swing.JButton newButton = new javax.swing.JButton();
        
        newButton.setText(buttonName);
        //newButton.setFocusable(true);
        //newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        //newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainFrame.getToolBar().add(newButton);
        return newButton;
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
    
}
