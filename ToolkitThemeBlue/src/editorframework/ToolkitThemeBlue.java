/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IToolkitTheme;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;

/**
 *
 * @author Eliomar Santana
 */
public class ToolkitThemeBlue implements IPlugin, IToolkitTheme {

    @Override
    public void paint(JButton b) {
        //b.setBackground(new Color(000, 191, 255));
        System.out.println("Aplicando tema azul");
    }   

    @Override
    public void initialize(ICore core) {
        
    }
}
