/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IToolkitTheme;

/**
 *
 * @author Eliomar Santana
 */
public class TextToolbox implements IToolbox{
    @Override
    public void setTheme(IToolkitTheme theme) {
        theme.paint();
    }
}
