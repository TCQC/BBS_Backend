package com.tcqc.bbs.entity;

import java.math.BigInteger;

public class Message {

    private BigInteger id;
    private BigInteger senderId;
    private BigInteger receiverId;
    private String content;
    private int status;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getSenderId() {
        return senderId;
    }

    public void setSenderId(BigInteger senderId) {
        this.senderId = senderId;
    }

    public BigInteger getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(BigInteger receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}
