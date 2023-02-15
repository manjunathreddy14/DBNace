package com.nace.DBNace.service;

import com.nace.DBNace.dao.NaceDAO;
import com.nace.DBNace.dto.NaceDTO;
import com.nace.DBNace.entity.NaceEntity;
import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NaceService {

    private Logger logger = LoggerFactory.getLogger(NaceService.class);

    @Autowired
    private NaceDAO naceDAO;

    public void saveAllNaceDetails(String filePath) {
        List<NaceEntity> listOfAllNaceDetails = new ArrayList<>();
        NaceEntity naceEntity = null;
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] record = null;
            csvReader.readNext(); // skip the First row from CSV
            while ((record = csvReader.readNext()) != null) {
                naceEntity = convertRecordToNaceEntity(record);
                listOfAllNaceDetails.add(naceEntity);
            }
        } catch (Exception ex) {
            logger.error("Could not Persist all NaceDetails..!!" + ex.getMessage());
            logger.info(String.valueOf(naceEntity));
        }
        naceDAO.saveAll(listOfAllNaceDetails);
    }

    private NaceEntity convertRecordToNaceEntity(String[] record) {
        NaceEntity naceEntity = new NaceEntity();
        naceEntity.setNaceId(Long.valueOf(record[0]));
        naceEntity.setLevel(record[1]);
        naceEntity.setCode(record[2]);
        naceEntity.setParent(record[3]);
        naceEntity.setDescription(record[4]);
        naceEntity.setItemIncludes(record[5]);
        naceEntity.setItemAlsoIncludes(record[6]);
        naceEntity.setRulings(record[7]);
        naceEntity.setItemExcludes(record[8]);
        naceEntity.setRefToISIC(record[9]);
        return naceEntity;
    }

    @Cacheable(cacheNames = "cacheNace", key = "#naceId")
    public Optional<NaceEntity> getNaceDetails(Long naceId) {
        return naceDAO.findById(naceId);
    }

    public NaceEntity saveNaceDetails(NaceDTO naceDTO) {
        NaceEntity naceEntity = new NaceEntity();
        naceEntity.setLevel(naceDTO.getLevel());
        naceEntity.setCode(naceDTO.getCode());
        naceEntity.setParent(naceDTO.getParent());
        naceEntity.setDescription(naceDTO.getDescription());
        naceEntity.setItemIncludes(naceDTO.getItemIncludes());
        naceEntity.setItemAlsoIncludes(naceDTO.getItemAlsoIncludes());
        naceEntity.setRulings(naceDTO.getRulings());
        naceEntity.setItemExcludes(naceDTO.getItemExcludes());
        naceEntity.setRefToISIC(naceDTO.getRefToISIC());
        return naceDAO.save(naceEntity);
    }
}
