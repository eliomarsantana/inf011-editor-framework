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
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Eliomar Santana
 */
public class TextToolbox implements IToolbox{
   
    @Override
    public void loadToolBox(ICore core) {
  
        IUIController uiController = core.getUIController();
        javax.swing.JButton newButton = uiController.addButtonToolBarItem("Button 1 TEXT");
        if (newButton != null) {
            setButton(newButton);
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javax.swing.JOptionPane.showMessageDialog(null, "Button 1 TextFactory !", "TextFactory !", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        }
        
        newButton = uiController.addButtonToolBarItem("Button 2 TEXT");
        if (newButton != null) {
            setButton(newButton);
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javax.swing.JOptionPane.showMessageDialog(null, "Button 2 TextFactory !", "TextFactory !", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        }   
        
    }
    
    @Override
    public void setTheme(IToolkitTheme theme) {          
        theme.paint(getButton());
    }
    public void setButton(JButton btn){
        this.btn = btn;
    }
    
    public JButton getButton(){
        return btn;
    }
    private JButton btn;
}
    

