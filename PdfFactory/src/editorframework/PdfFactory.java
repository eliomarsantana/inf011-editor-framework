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
public class PdfFactory implements IAbstractFactory{

    @Override
    public IEditor createEditor() {
        return new PdfEditor();
    }

    @Override
    public ISerializer createSerializer() {
        return new PdfSerializer();
    }

    @Override
    public IToolbox createToolbox() {
        return new PdfToolbox();
    }

    @Override
    public IVerifier createVerifier() {
        return new PdfVerifier();
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
    
}
