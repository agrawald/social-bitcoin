package com.social.bitcoin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Brief description of the file
 * <p>
 * Copyright © Tabcorp Pty Ltd. All rights reserved. http://www.Tabcorp.com/
 * This code is copyrighted and is the exclusive property of Tabcorp Pty Ltd.
 * It may not be used, copied or redistributed without the written permission of Tabcorp.
 *
 * @author Dheeraj Agrawal <agrawald@tabcorp.com.au>
 */
@RestController
public class ApplicationController {
    @Autowired
    private Facebook facebook;
    @Autowired
    private ConnectionRepository connectionRepository;

    @RequestMapping("/home")
    public ResponseEntity<Map> login() throws IOException {
        //TODO we can have a DB integration here to fetch the data from the database for the use rlogged in
        //TODO the facebook id we can use from frontend and use it here
        Map<String, Object> map = new HashMap<>();
        map.put("bitcoins", BigInteger.TEN);
        return ResponseEntity.ok(map);
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> transfer(@RequestBody Map<String, Object> request) throws IOException {
        //TODO we can get the transfer address here and use to to transfer for the wallet
        Map<String, Object> map = new HashMap<>();
        map.put("success", "Transfer completed.");
        return ResponseEntity.ok(map);
    }
}
