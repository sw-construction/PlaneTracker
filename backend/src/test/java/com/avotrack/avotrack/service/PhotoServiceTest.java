package com.avotrack.avotrack.service;

import com.avotrack.avotrack.services.PhotoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PhotoServiceTest {

    @Autowired
    PhotoService photoService;


//    @Test
//    void testRequestingPhotoEmpty() {
//        Assertions.assertEquals(0, photoService.getPhoto("a70356").length);
//    }
//    @Test
//    void testRequestingPhotoFull() {
//        Assertions.assertNotEquals(0, photoService.getPhoto("aa4195").length);
//    }
}
