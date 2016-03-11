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
public abstract class SocialNetworkCreator {
    public boolean post(IDocument document)
    {
        ISocialNetwork socialNetwork = createSocialNetwork();
        return socialNetwork.post(document);
    }
    public abstract ISocialNetwork createSocialNetwork();
    
}
