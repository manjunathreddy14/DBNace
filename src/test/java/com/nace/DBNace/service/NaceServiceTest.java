package com.nace.DBNace.service;

import com.nace.DBNace.dao.NaceDAO;
import com.nace.DBNace.entity.NaceEntity;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@ExtendWith(MockitoExtension.class)
public class NaceServiceTest {

    @InjectMocks
    private NaceService naceService;

    @Mock
    private NaceDAO naceDAO;

    @Mock
    private CSVReader csvReader;

    private List<NaceEntity> listOfNaceEntity = new ArrayList<NaceEntity>();

    @Test
    public void testSaveAllNaceDetails() {
        createListOfNaceEntity();
        when(naceDAO.saveAll(any())).thenReturn(listOfNaceEntity);
        naceService.saveAllNaceDetails("D://ProjRanga//DBNace//Nace.csv");
    }

    @Test
    public void testGetNaceDetails() {
        Optional<NaceEntity> naceEntity = getNaceEntity();
        when(naceDAO.findById(any())).thenReturn(naceEntity);
        Optional<NaceEntity> responseNaceEntity = naceService.getNaceDetails(123L);
        Assertions.assertEquals(123, responseNaceEntity.get().getNaceId());
        Assertions.assertEquals("CodeOne", responseNaceEntity.get().getCode());
        Assertions.assertEquals("LevelOne", responseNaceEntity.get().getLevel());
    }

    @Test
    public void testGetEmptyNaceDetails() {
        Optional<NaceEntity> naceEntity = Optional.empty();
        when(naceDAO.findById(any())).thenReturn(naceEntity);
        Optional<NaceEntity> responseNaceEntity = naceService.getNaceDetails(123L);
        Assertions.assertEquals(false, responseNaceEntity.isPresent());
    }

    public void createListOfNaceEntity() {
        NaceEntity naceEntityOne = new NaceEntity();
        naceEntityOne.setNaceId(Long.valueOf(1L));
        naceEntityOne.setLevel("LevelOne");
        naceEntityOne.setCode("CodeOne");
        naceEntityOne.setParent("ParentOne");
        naceEntityOne.setDescription("DescOne");
        naceEntityOne.setItemIncludes("ItemIncludesOne");
        naceEntityOne.setItemAlsoIncludes("ItemAlsoIncludes");
        naceEntityOne.setRulings("RulingsOne");
        naceEntityOne.setItemExcludes("ItemExcludesOne");
        naceEntityOne.setRefToISIC("RefToISICOne");


        NaceEntity naceEntityTwo = new NaceEntity();
        naceEntityTwo.setNaceId(Long.valueOf(1L));
        naceEntityTwo.setLevel("LevelTwo");
        naceEntityTwo.setCode("CodeTwo");
        naceEntityTwo.setParent("ParentTwo");
        naceEntityTwo.setDescription("DescTwo");
        naceEntityTwo.setItemIncludes("ItemIncludesTwo");
        naceEntityTwo.setItemAlsoIncludes("ItemAlsoIncludesTwo");
        naceEntityTwo.setRulings("RulingsTwo");
        naceEntityTwo.setItemExcludes("ItemExcludesTwo");
        naceEntityTwo.setRefToISIC("RefToISICTwo");

        listOfNaceEntity.add(naceEntityOne);
        listOfNaceEntity.add(naceEntityTwo);

    }

    public Optional<NaceEntity> getNaceEntity() {
        NaceEntity naceEntityOne = new NaceEntity();
        naceEntityOne.setNaceId(Long.valueOf(123L));
        naceEntityOne.setLevel("LevelOne");
        naceEntityOne.setCode("CodeOne");
        naceEntityOne.setParent("ParentOne");
        naceEntityOne.setDescription("DescOne");
        naceEntityOne.setItemIncludes("ItemIncludesOne");
        naceEntityOne.setItemAlsoIncludes("ItemAlsoIncludes");
        naceEntityOne.setRulings("RulingsOne");
        naceEntityOne.setItemExcludes("ItemExcludesOne");
        naceEntityOne.setRefToISIC("RefToISICOne");
        return Optional.of(naceEntityOne);
    }

}
