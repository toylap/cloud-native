package me.toylep.spring.cloudnative.merchservice.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MerchService {
    private final MerchRepository merchRepository;

    public Iterable<Merch> viewMerchList(){
        return merchRepository.findAll();
    }

    public Merch viewMerchDetails(String isMn){
        return merchRepository.findByIsMn(isMn)
                .orElseThrow(()-> new MerchNotFoundException((isMn)));
    }

    public Merch addMerchToCatalog(Merch merch){
        if(merchRepository.existsByIsMn(merch.isMn())){
            throw new MerchAlreadyExistsException(merch.isMn());
        }
        return merchRepository.save(merch);
    }

    public void removeMerchFromCatalog(String isMn){
        merchRepository.deleteByIsMn(isMn);
    }

    public Merch editMerchDetail(String isMn, Merch merch){
        return merchRepository.findByIsMn(isMn)
                .map(existringMerch ->{
                    var merchToUpdate = new Merch(
                            existringMerch.isMn(),
                            merch.title(),
                            merch.price(),
                            merch.author());
                    return merchRepository.save(merchToUpdate);
                })
                .orElseGet(() -> addMerchToCatalog (merch));
    }

}
