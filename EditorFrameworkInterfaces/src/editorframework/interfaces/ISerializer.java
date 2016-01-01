/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

/**
 *
 * @author Eliomar Santana
 */
public interface ISerializer {
    public abstract IDocumentController load(String fileName);
    public abstract boolean save(IDocumentController doc, String fileName);
}
