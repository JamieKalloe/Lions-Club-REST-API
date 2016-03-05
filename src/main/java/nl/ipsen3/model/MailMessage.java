/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.model;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Jamie
 */
public class MailMessage extends MimeMessage {
    
    /**
     *
     * @param session session of the mail
     * @param sender sender of the mail
     * @param recipient recipient of the mail
     * @param subject subject of the mail
     * @param content content of the mail
     * @throws Exception
     */
    public MailMessage(Session session, String sender, String recipient, String subject, String content) throws Exception{
        super(session);

        this.setFrom(new InternetAddress(sender));
        this.setSubject(subject);
        this.setText(content);
        this.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
    }
    
    /**
     *
     * @param session session of the mail
     * @param sender sender of the mail
     * @param recipient recipient of the mail
     * @param subject subject of the mail
     * @param content content of the mail
     * @param attachment attachment of the mail
     * @throws Exception
     */
    public MailMessage(Session session, String sender, String recipient, String subject, String content, String attachment) throws Exception {
        super(session);

        this.setFrom(new InternetAddress(sender));
        this.setSubject(subject);
        this.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        BodyPart messageContent = new javax.mail.internet.MimeBodyPart();
        messageContent.setText(content);

        BodyPart messageAttachment = new javax.mail.internet.MimeBodyPart();
        DataSource fileSource = new FileDataSource(attachment);
        messageAttachment.setDataHandler(new DataHandler(fileSource));
        messageAttachment.setFileName(attachment);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageContent);
        multipart.addBodyPart(messageAttachment);

        this.setContent(multipart);
    }
    
}
