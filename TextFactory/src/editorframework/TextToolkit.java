/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IToolkit;
import editorframework.interfaces.IToolkitTheme;

/**
 *
 * @author Eliomar Santana
 */
public class TextToolkit implements IToolkit{

    @Override
    public void setTheme(IToolkitTheme theme) {
        theme.paint();
    }
}
