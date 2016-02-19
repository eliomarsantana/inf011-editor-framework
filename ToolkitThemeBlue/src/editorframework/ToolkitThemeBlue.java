/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IToolkitTheme;

/**
 *
 * @author Eliomar Santana
 */
public class ToolkitThemeBlue implements IToolkitTheme, IPlugin{

    @Override
    public void paint() {
        System.out.println("pintando tela de azul");
    }   

    @Override
    public void initialize(ICore core) {
        
    }
}
