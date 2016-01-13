/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IEditor;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IVerifier;
import java.util.ArrayList;

/**
 *
 * @author Eliomar Santana
 */
public class TextFactory implements IPlugin, IAbstractFactory{

    @Override
    public void initialize(ICore core) {
        
    }
    
    @Override
    public IEditor createEditor() {
        return new TextEditor();
    }

    @Override
    public ISerializer createSerializer() {
        return new TextSerializer();
    }

    @Override
    public IToolbox createToolbox() {
        return new TextToolbox();
    }

    @Override
    public IVerifier createVerifier() {
        return new TextVerifier();
    }

    @Override
    public String supportedExtensions() {
        return "txt";
    }

    @Override
    public String supportedType() {
        return "Text Files";
    }
}
