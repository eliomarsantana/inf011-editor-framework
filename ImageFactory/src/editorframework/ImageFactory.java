/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.IEditor;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IVerifier;
import java.util.ArrayList;

/**
 *
 * @author Eliomar Santana
 */
public class ImageFactory implements IAbstractFactory{

    @Override
    public IEditor createEditor() {
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
    public String supportedExtensions() {  
        return "jpg|png|gif";
    }

    @Override
    public String supportedType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
