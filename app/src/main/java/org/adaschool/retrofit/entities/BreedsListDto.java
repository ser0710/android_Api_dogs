package org.adaschool.retrofit.entities;

import java.util.Map;

public class BreedsListDto {
    private String status;
    private String[] message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getMessage() {
        return message;
    }
//
//    public void setMessage(Map<String, String[]> message) {
//        this.message = message;
//    }
}

