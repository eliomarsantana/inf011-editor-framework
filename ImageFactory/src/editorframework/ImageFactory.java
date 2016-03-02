/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.Editor;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IVerifier;
import java.util.ArrayList;

/**
 *
 * @author Eliomar Santana
 */
public class ImageFactory implements IPlugin, IAbstractFactory{

    @Override
    public Editor createEditor() {
        return new ImageEditor();
    }

    @Override
    public ISerializer createSerializer() {
        return new ImageSerializer();
    }

    @Override
    public IToolbox createToolbox() {
        return new ImageToolbox();
    }

    @Override
    public IVerifier createVerifier() {
        return new ImageVerifier();
    }

    @Override
    public ArrayList<String> supportedExtensions() {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("jpg");
        lista.add("png");
        lista.add("gif");
        return lista;
    }

    @Override
    public String supportedType() {
        return "Image Files";
    }

    @Override
    public void initialize(ICore core) {
        
    }  
}
