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
import javax.swing.JButton;

/**
 *
 * @author Eliomar Santana
 */
public class ToolkitThemeBlack implements IPlugin, IToolkitTheme{

    @Override
    public void paint(JButton b) {
        //b.setBackground(new Color(000, 000, 000));  
        System.out.println("Aplicando tema preto");
    }   

    @Override
    public void initialize(ICore core) {
        
    }
    
}
