package de.spqrinfo.jee.jdbc.web;

import de.spqrinfo.jee.jdbc.backend.MessageBean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class IndexBacking {

    @EJB
    private MessageBean messageBean;

    private String messageText;

    public int getCountOfMessages() {
        return this.messageBean.size();
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(final String s) {
        this.messageText = s;
    }

    public String addMessage() {
        this.messageBean.addMessage(this.messageText);
        return "";
    }

    public List<String> getRecentMessages() {
        return this.messageBean.getRecentMessages();
    }
}
