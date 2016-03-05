    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.ipsen3.View;

/**
 *
 * @author Jamie
 */
public class Mail {
    
    @JsonView(View.Public.class)
    private String recipient, content, subject, attachment;
    
    @JsonView(View.Public.class)
    private int id;
    
    /**
     *
     * @param recipient recipient of the mail
     * @param content content of the mail
     * @param subject subject of the mail
     */
    public Mail(String recipient, String content, String subject) {
        this.recipient = recipient;
        this.content = content;
        this.subject = subject;
    }
    
    /**
     *
     * @param recipient recipient of the mail
     * @param content content of the mail
     * @param subject subject of the mail
     * @param attachment path to the file
     */
    public Mail(String recipient, String content, String subject, String attachment) {
        this.recipient = recipient;
        this.content = content;
        this.subject = subject;
        this.attachment = attachment;
    }

    /**
     * new instance of mail
     */
    public Mail() {
        
    }

    /**
     *
     * @return gets the recipient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     *
     * @return gets the content
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @return gets the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @return gets the attachment
     */
    public String getAttachment() {
        return attachment;
    }

    /**
     *
     * @return gets the id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param recipient sets the recipient
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     *
     * @param content sets the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     * @param subject sets the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @param attachment sets the attachment
     */
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    /**
     *
     * @param id sets the id
     */
    public void setId(int id) {
        this.id = id;
    }
}
