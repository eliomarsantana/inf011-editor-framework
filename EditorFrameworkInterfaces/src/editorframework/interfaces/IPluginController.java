/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public interface IPluginController {
    public abstract ArrayList<IPlugin> loadedPlugins();
    public abstract ArrayList<IPlugin> getPluginsByType(String className);
    public abstract void initialize(ICore core) throws MalformedURLException;
    public abstract IAbstractFactory getFactoryPluginBySupportedExtension(String extension);
}
