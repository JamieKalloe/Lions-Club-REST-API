/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPSEN3.persistence;

import java.io.File;
import nl.IPSEN3.model.MailType;
import nl.ipsen3.model.Mail;
import nl.ipsen3.model.User;

/**
 *
 * @author Jamie
 */
public class MailFactory {
    
    private File file;
    private User receiver;
    
    public MailFactory(User user) {
        this.receiver = user;
    }
    
    public Mail generate(MailType mailType) {
        
        switch(mailType) {
            case INVOICE:
                return new Mail(this.receiver.getEmail(), "Uw factuur - Lions Club", "Beste meneer " + this.receiver.getLastName() + ",\n\n Uw factuur vindt u in de bijlage.\n\nLions Club", "");
                
            default:
                break;
        }
        
        return new Mail();
    }
}
