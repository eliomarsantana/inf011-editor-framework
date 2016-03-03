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
public class ToolkitThemeBlack implements IPlugin, IToolkitTheme{

    @Override
    public void initialize(ICore core) {

    }

    @Override
    public void paint() {
        System.out.println("pintando tela de preto");
    }
    
}
