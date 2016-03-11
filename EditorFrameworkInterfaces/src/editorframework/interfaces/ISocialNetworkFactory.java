/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

/**
 *
 * @author eliomar
 */
public interface ISocialNetworkFactory {
    public abstract ISocialNetwork create(String nome);

    public abstract boolean register(SocialNetworkCreator socialNetworkCreator,String nome);

    public abstract boolean unregister(String nome);
}
