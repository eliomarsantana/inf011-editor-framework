/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IPluginController;
import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class PluginController implements IPluginController {
    public PluginController(){
        allPlugins = new ArrayList<IPlugin>();
    }

    @Override
    public void initialize(ICore core) throws MalformedURLException{
    // Encontra a pasta plugins
        File currentDir = new File("./plugins");
        // Obtem todos os arquivos dentro desta pasta
        String[] plugins = currentDir.list();
        // Criar um array de URL do mesmo tamanho do anterior
        System.out.println("Found " + plugins.length + " plugins !");
        URL[] jars = new URL[plugins.length];
        // Loop para popular o array jars
        for (int i = 0; i < plugins.length; i++)
            jars[i] = (new File("./plugins/" + plugins[i])).toURI().toURL();
        // Adiciona todos os jars (plugins) no CLASSPATH
        URLClassLoader ulc = new URLClassLoader(jars);
        // Loop para inicialicao dos plugins
        IPlugin iplugin = null;
        String pluginName;
        for (String plugin : plugins) {
            if (plugin.endsWith(".jar")) {
                pluginName = plugin.split("\\.")[0];
                try {
                    iplugin = (IPlugin) Class.forName("editorframework." + pluginName, true, ulc).newInstance();
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (iplugin != null)
                    System.out.println("Initializing plugin " + pluginName);
                    iplugin.initialize(core);
                    allPlugins.add(iplugin);
            }
        }
    }
    @Override
    public ArrayList<IPlugin> loadedPlugins() {
        return allPlugins;
    }
    
    @Override
    public IAbstractFactory getFactoryPluginBySupportedExtension(String extension) {
        ArrayList<IPlugin> loadedPlugins = loadedPlugins();
        for (IPlugin plugin : loadedPlugins) {
            if (plugin instanceof IAbstractFactory) {
                IAbstractFactory factory = (IAbstractFactory) plugin;
                if (factory.supportedExtensions().contains(extension))
                    return factory;
            }
        }
        return null;
    }
    
    private ArrayList<IPlugin> allPlugins;
}
