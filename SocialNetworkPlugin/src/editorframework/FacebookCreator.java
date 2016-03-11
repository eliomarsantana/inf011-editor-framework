/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.ISocialNetwork;
import editorframework.interfaces.SocialNetworkCreator;

/**
 *
 * @author eliomar
 */
public class FacebookCreator extends SocialNetworkCreator{

    @Override
    public ISocialNetwork createSocialNetwork() {
        return new FacebookSocialNetwork();
    }
    
}
