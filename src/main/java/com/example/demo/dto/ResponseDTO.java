package com.example.demo.dto;


@Data
@JsonInclude(Include.NON_DEFAULT)
import com.example.demo.exception.CustomException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;;

public class Response<T> {
    private Metadata metadata;
    private T payload;
    private CustomException exception;

    public Response() {
    }

    public Response(Metadata metadata, T payload) {
        this.metadata = metadata;
        this.payload = payload;
    }

    public Response(Metadata metadata, CustomException exception) {
        this.metadata = metadata;
        this.exception = exception;
    }

    public Metadata getMetadata() {
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

    public CustomException getException() {
        return exception;
    }

    public void setException(CustomException exception) {
        this.exception = exception;
    }
}

