package com.greymatter.msscbreweryclient.web.client;

import com.greymatter.msscbreweryclient.web.model.BeerDto;
import com.greymatter.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById(){
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer(){
        BeerDto dto = BeerDto.builder().beerName("HEINEKEN").build();
        URI uri = client.saveNewBeer(dto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpadteBeer(){
        BeerDto dto = BeerDto.builder().beerName("HEINEKEN").build();
        client.updateBeer(UUID.randomUUID(),dto);
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById(){
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer(){
        CustomerDto dto = CustomerDto.builder().name("Jorge").build();
        URI uri = client.saveNewCustomer(dto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpadteCustomer(){
        CustomerDto dto = CustomerDto.builder().name("COCO").build();
        client.saveNewCustomer(dto);
    }

    @Test
    void testDeleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }




}