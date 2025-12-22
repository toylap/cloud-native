package me.toylep.spring.cloudnative.merchservice.persistence;

import me.toylep.spring.cloudnative.merchservice.domain.Merch;
import me.toylep.spring.cloudnative.merchservice.domain.MerchRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryMerchRepository implements MerchRepository {

    // 인메모리 맵 선언
    private static final Map<String, Merch> merchs = new ConcurrentHashMap<>();

    @Override
    public Iterable<Merch> findAll() {
        return merchs.values();
    }

    @Override
    public Optional<Merch> findByIsMn(String isMn) {
        return existsByIsMn(isMn) ? Optional.of(merchs.get(isMn)) :
                Optional.empty();
    }

    @Override
    public boolean existsByIsMn(String isMn) {
        return merchs.get(isMn) != null;
    }

    @Override
    public Merch save(Merch merch) {
        merchs.put(merch.isMn(), merch);
        return merch;
    }

    @Override
    public void deleteByIsMn(String isMn) {
        merchs.remove(isMn);
    }
}
