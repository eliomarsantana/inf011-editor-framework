/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.ISocialNetwork;
import editorframework.interfaces.ISocialNetworkFactory;
import editorframework.interfaces.SocialNetworkCreator;
import java.util.HashMap;

/**
 *
 * @author eliomar
 */
public class SocialNetworkFactory implements ISocialNetworkFactory{

    @Override
    public ISocialNetwork create(String nome) {
        ISocialNetwork selected = networks.get(nome);
        return selected;
    }

    @Override
    public boolean register(SocialNetworkCreator socialNetworkCreator, String nome) {
        if (networks.containsKey(nome)) return false;
        networks.put(nome, socialNetworkCreator.createSocialNetwork());
        return true;
    }

    @Override
    public boolean unregister(String nome) {
        if (!networks.containsKey(nome)) return false;
        networks.remove(nome);
        return true;
    }
    public HashMap<String, ISocialNetwork> networks = new HashMap<>();
}
