/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPSEN3.service;

import java.util.Properties;
import nl.IPSEN3.model.MailType;
import nl.ipsen3.model.Mail;
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
}
