/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import java.awt.Component;
import javax.swing.JMenuItem;

/**
 *
 * @author aluno
 */
public interface IUIController {
    JMenuItem addMenuItem(String menu, String menuItem);
    public void setEditor(Editor editor);
    public abstract void addToolBarItem(Component component);
    public void loadCombobox(ICore core);
}