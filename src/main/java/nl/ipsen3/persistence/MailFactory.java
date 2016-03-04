/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPSEN3.persistence;

import generators.InvoiceGenerator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nl.IPSEN3.model.MailType;
import nl.ipsen3.model.Mail;
import nl.ipsen3.model.User;
import nl.ipsen3.persistence.OrderDAO;

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
    
    public Mail generate(MailType mailType) throws IOException {
        
        switch(mailType) {
            case INVOICE:
                return new Mail(this.receiver.getEmail(), "Uw factuur - Lions Club", "Beste meneer " + this.receiver.getLastName() + ",\n\n Uw factuur vindt u in de bijlage.\n\nLions Club", 
                this.getInvoice(receiver.getOrder().getId()).getAbsolutePath());
                
                
            case REGISTRATION:
                return new Mail(this.receiver.getEmail(), "Uw factuur - Lions Club", "Beste " + this.receiver.getFirstName() + " " + this.receiver.getLastName() + ",\n\nBedankt voor uw registratie bij de Lions Club!");
                
            default:
                break;
        }
        
        return new Mail();
    }
    
    private File getInvoice(int orderId) throws IOException {
        OrderDAO dao = new OrderDAO(); 
        Path directory = Paths.get(System.getProperty("user.dir") + "/src/main/java/nl/ipsen3/invoice/");
        if(!(directory.toString().contains(" " + orderId + ".pdf"))) {
            try {
                new InvoiceGenerator().generate(dao.get(orderId));
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        
        try {
            Files.walk(directory).forEach(
                    fileDirectory -> {
                        if ((fileDirectory).toString().contains(" " + orderId + ".pdf")) {
                            file = fileDirectory.toFile();
                        }
                        });
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return file;
    }
}
