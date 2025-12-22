package me.toylep.spring.cloudnative.merchservice.domain;

public class MerchAlreadyExistsException extends RuntimeException{
    public MerchAlreadyExistsException(String isMn){
        super("A Merch with ISMN " + isMn + " already exists." );
    }
}
