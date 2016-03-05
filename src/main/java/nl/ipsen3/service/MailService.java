/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.service;

import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import nl.ipsen3.model.MailType;
import nl.ipsen3.model.Mail;
import nl.ipsen3.model.MailMessage;
import nl.ipsen3.service.UserService;

/**
 *
 * @author Jamie
 */
public class MailService {
    private final String propertyHost = "mail.smtp.host";
    private final String propertyPort = "mail.smtp.port";
    private final String propertyUser = "mail.smtp.user";
    private final String properyPass = "mail.smtp.pwd";
    private final String propertyAuth = "mail.smtp.auth";
    private final String propertyStartTls = "mail.smtp.starttls.enable";
    private final String propertySSL = "mail.smtp.EnableSSL.enable";
    private final String transportType = "smtp";
    
    private Properties mailProperties;
    private final String smtpHost = "smtp.live.com";
    private final String smtpUsername = "ipsen2groep1@hotmail.com";
    private final String smtpPassword = "hsLeiden";
    private final int smtpPort = 587;
    private Mail mail;
    private MailType mailType;
    private UserService userService;
    
    /**
     * creates a new instance of the mail service
     */
    public MailService() {
        this.mailProperties = new Properties();

        mailProperties.put(this.propertyHost, this.smtpHost);
        mailProperties.put(this.propertyPort, String.valueOf(this.smtpPort));
        mailProperties.put(this.propertyUser, this.smtpUsername);
        mailProperties.put(this.properyPass, this.smtpPassword);
        mailProperties.put(this.propertyAuth, "true");
        mailProperties.put(this.propertyStartTls, "true");
        mailProperties.put(this.propertySSL, "true");
    }
    
    /**
     *
     * @param mail mail to be sended
     * @throws Exception e
     */
    public void send(Mail mail) throws Exception {

        this.mail = mail;
        Session session = Session.getInstance(mailProperties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(smtpUsername, smtpPassword);
                    }
                });

        session.setDebug(true);

        MailMessage message;

        if(mail.getAttachment() == null || mail.getAttachment().isEmpty()) {
            message = new MailMessage(
                    session,
                    this.smtpUsername,
                    mail.getRecipient(),
                    mail.getSubject(),
                    mail.getContent()
            );
        } else {
            message = new MailMessage(
                    session,
                    this.smtpUsername,
                    mail.getRecipient(),
                    mail.getSubject(),
                    mail.getContent(),
                    mail.getAttachment()
            );
        }

        Transport transport = session.getTransport(this.transportType);
        transport.connect(this.smtpHost, this.smtpPort, this.smtpUsername, this.smtpPassword);
        transport.sendMessage(message, message.getAllRecipients());

        System.out.println("MailMessage was succesfuly sent.");
        transport.close();
    }
}
