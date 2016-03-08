/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IToolkitTheme;
import editorframework.interfaces.IUIController;
import editorframework.interfaces.ICore;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Eliomar Santana
 */
public class TextToolbox implements IToolbox{

    @Override
    public void loadToolBox(ICore core) {
        
        newButton = new javax.swing.JButton();
        newButton2 = new javax.swing.JButton();
        
        IUIController uiController = core.getUIController();
        newButton = uiController.addButtonToolBarItem("Button 1");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javax.swing.JOptionPane.showMessageDialog(null, "Button 2 TextFactory !", "TextFactory !", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        }
        
        newButton2 = uiController.addButtonToolBarItem("Button 2");
        if (newButton2 != null) {
            newButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javax.swing.JOptionPane.showMessageDialog(null, "Button 2 TextFactory !", "TextFactory !", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        }

        
    }
    
    @Override
    public void setTheme(IToolkitTheme theme) {    
          
        theme.paint(newButton);
        theme.paint(newButton2);

    }

    private javax.swing.JButton newButton;
    private javax.swing.JButton newButton2;
    
}

