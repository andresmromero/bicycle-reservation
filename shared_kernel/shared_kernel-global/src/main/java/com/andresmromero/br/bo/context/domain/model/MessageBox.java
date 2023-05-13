package com.andresmromero.br.bo.context.domain.model;

import java.util.List;

public class MessageBox {

    private List<MessageBoxItem> messageBoxItems;

    public MessageBox(List<MessageBoxItem> messageBoxItems) {

        this.messageBoxItems = messageBoxItems;
    }

    public List<MessageBoxItem> getMessageBoxItems() {

        return messageBoxItems;
    }

    public void setMessageBoxItems(List<MessageBoxItem> messageBoxItems) {

        this.messageBoxItems = messageBoxItems;
    }

}
