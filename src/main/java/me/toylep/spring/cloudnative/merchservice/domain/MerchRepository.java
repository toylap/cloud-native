package me.toylep.spring.cloudnative.merchservice.domain;

import java.util.Optional;

public interface MerchRepository {
    Iterable<Merch> findAll();
    Optional<Merch> findByIsMn(String isMn);
    boolean existsByIsMn(String isMn);
    Merch save(Merch merch);
    void deleteByIsMn(String isMn);
}
