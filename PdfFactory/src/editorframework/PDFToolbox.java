/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IToolkitTheme;
import editorframework.interfaces.IUIController;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Eliomar Santana
 */
public class PDFToolbox implements IToolbox{
    
    @Override
    public void initialize(ICore core) {
        
            IUIController uiController = core.getUIController();
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
            uiController.addToolBarItem(combobox);
            combobox.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        String itemCombobox = (String)(combobox.getSelectedItem());
                        Class t = Class.forName("editorframework." + itemCombobox);
                        IToolkitTheme theme = (IToolkitTheme) t.newInstance();
                        setTheme(theme, combobox);               
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                        Logger.getLogger(PDFToolbox.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               
            });
            
            uiController.addToolBarItem(newButton);
            if (newButton != null) {
                newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Button 1 PDFFactory !", "PDFFactory !", JOptionPane.INFORMATION_MESSAGE);
                }
            });}  

            if (newButton2 != null) {
                newButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Button 2 PDFFactory !", "PDFFactory !", JOptionPane.INFORMATION_MESSAGE);
                }
            });} 
            uiController.addToolBarItem(newButton2);
    }
    @Override
    public void setTheme(IToolkitTheme theme, Component c) {
       theme.paint(c);
    }   
    JComboBox combobox = new JComboBox();
    JButton newButton = new JButton();
    JButton newButton2 = new JButton();   
}
