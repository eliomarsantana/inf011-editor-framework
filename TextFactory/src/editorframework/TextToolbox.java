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
    public void setTheme(IToolkitTheme theme, ICore core) {
         //->http://shdo.com.br/blog/online/tabela-de-cores-rgb/
        JButton newButton = new JButton();
        IUIController uiController = core.getUIController();
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javax.swing.JOptionPane.showMessageDialog(null, "Funcionou o botão !", "Opa 2 !", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        theme.paint(newButton);
        uiController.addToolBarItem(newButton);
    }
}

