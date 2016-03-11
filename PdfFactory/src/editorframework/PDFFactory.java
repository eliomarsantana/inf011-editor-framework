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
public class PDFFactory implements IPlugin, IAbstractFactory{

    @Override
    public Editor createEditor() {
        return new PDFEditor();
    }

    @Override
    public ISerializer createSerializer() {
        return new PDFSerializer();
    }

    @Override
    public IToolbox createToolbox() {
        return new PDFToolbox();
    }

    @Override
    public IVerifier createVerifier() {
        return new PDFVerifier();
    }

    @Override
    public ArrayList<String> supportedExtensions() {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("pdf");
        return lista;
    }

    @Override
    public String supportedType() {
        return "Pdf Files";
    }

    @Override
    public void initialize(ICore core) {

    }
    
}
