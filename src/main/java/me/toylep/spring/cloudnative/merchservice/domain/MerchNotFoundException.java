package me.toylep.spring.cloudnative.merchservice.domain;

public class MerchNotFoundException extends RuntimeException {
    public MerchNotFoundException(String isMn) {
        super("A Merch with ISMN " + isMn + " was not found." );
    }
}
