package com.nace.DBNace.controller;

import com.nace.DBNace.dto.NaceDTO;
import com.nace.DBNace.entity.NaceEntity;
import com.nace.DBNace.service.NaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class NaceController {

    @Autowired
    private Environment environment;

    @Autowired
    private NaceService naceService;

    @PostMapping(value = "/saveAllNaceDetails")
    public void putNaceDetails() {
        naceService.saveAllNaceDetails(environment.getProperty("nace.path"));
    }

    @GetMapping(value = "/getNaceDetails/{naceId}")
    public NaceEntity getNaceDetails(@PathVariable Long naceId) {
        Optional<NaceEntity> optNaceDetail = naceService.getNaceDetails(naceId);
        if (optNaceDetail.isPresent()) {
            return optNaceDetail.get();
        } else {
            return null;
        }
    }

    @PostMapping(value = "/saveNaceDetails")
    public ResponseEntity<NaceEntity> putNaceDetailsIndividually(@RequestBody NaceDTO naceDTO) {
        NaceEntity naceEntity = naceService.saveNaceDetails(naceDTO);
        return new ResponseEntity<NaceEntity>(naceEntity, HttpStatus.OK);
    }

}
