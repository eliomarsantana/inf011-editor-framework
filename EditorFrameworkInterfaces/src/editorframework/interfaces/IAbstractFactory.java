/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import java.util.ArrayList;

/**
 *
 * @author Eliomar Santana
 */
public interface IAbstractFactory {
  
    public abstract Editor createEditor();
    public abstract ISerializer createSerializer();
    public abstract IToolbox createToolbox();
    public abstract IVerifier createVerifier();
    public abstract ArrayList<String> supportedExtensions();
    public abstract String supportedType();
}
