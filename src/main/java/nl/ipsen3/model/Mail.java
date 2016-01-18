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
    
    public Mail(String recipient, String content, String subject, String attachment) {
        this.recipient = recipient;
        this.content = content;
        this.subject = subject;
        this.attachment = attachment;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }

    public String getAttachment() {
        return attachment;
    }

    public int getId() {
        return id;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public void setId(int id) {
        this.id = id;
    }
}
