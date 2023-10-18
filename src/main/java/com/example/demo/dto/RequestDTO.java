package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_DEFAULT)
public class RequestDTO<M, T> {
    private Metadata metadata;
    private T payload;

    public RequestDTO(Metadata metadata, T payload) {
    	super();
        this.metadata = metadata;
        this.payload = payload;
    }
    
    public RequestDTO(M metadata, T payload) {
    	super();
        this.metadata = metadata;
        this.payload = payload;
    }

    public Metadata getRequestMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
