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

/**
 *
 * @author Eliomar Santana
 */
public class ToolkitThemeBlack implements IPlugin, IToolkitTheme{

    @Override
    public void paint(Component c) {
        c.setBackground(Color.BLACK);
        System.out.println("pintando tela de preta");
    }   

    @Override
    public void initialize(ICore core) {
        
    }
    
}
