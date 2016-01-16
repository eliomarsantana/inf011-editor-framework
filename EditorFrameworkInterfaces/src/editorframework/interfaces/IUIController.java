/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public interface IUIController {
    JMenuItem addMenuItem(String menu, String menuItem);
    public abstract void createMenuItemFileOpen(ICore core);
    public void fileOpen(ICore core);
    public abstract void setCentralWidget(JPanel panel);
}