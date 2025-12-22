package me.toylep.spring.cloudnative.merchservice.web;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.toylep.spring.cloudnative.merchservice.domain.Merch;
import me.toylep.spring.cloudnative.merchservice.domain.MerchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("merchs")
@RequiredArgsConstructor
@Tag(name="merch", description = "굿즈 API")
public class MerchContorller {
    private final MerchService merchService;

    @GetMapping()
    public Iterable<Merch> get(){
        return merchService.viewMerchList();
    }

    @GetMapping("{isMn}")
    public Merch getByIsmn(@PathVariable String isMn){
        return merchService.viewMerchDetails(isMn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Merch post(@RequestBody Merch merch){
        return merchService.addMerchToCatalog(merch);
    }

    @DeleteMapping("{isMn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String isMn){
        merchService.removeMerchFromCatalog(isMn);
    }

    @PutMapping("{isMn}")
    public Merch put(@PathVariable String isMn, @RequestBody Merch merch){
        return merchService.editMerchDetail(isMn, merch);
    }
}
