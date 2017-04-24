/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_LANGUAGE</b> version <b>1</b>.
 * <p>
 * Command Class Language
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x89.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassLanguageV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassLanguageV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_LANGUAGE
     */
    public final static int COMMAND_CLASS_KEY = 0x89;

    /**
     * Language Set Command Constant
     */
    public final static int LANGUAGE_SET = 0x01;
    /**
     * Language Get Command Constant
     */
    public final static int LANGUAGE_GET = 0x02;
    /**
     * Language Report Command Constant
     */
    public final static int LANGUAGE_REPORT = 0x03;


    /**
     * Creates a new message with the LANGUAGE_SET command.
     * <p>
     * Language Set
     *
     * @param country {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getLanguageSet(Integer country) {
        logger.debug("Creating command message LANGUAGE_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(LANGUAGE_SET);

        // Process 'Language'

        // Process 'Country'
        outputData.write((country >> 8) & 0xff);
        outputData.write(country & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the LANGUAGE_SET command.
     * <p>
     * Language Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>COUNTRY {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleLanguageSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Language'

        // Process 'Country'
        response.put("COUNTRY", Integer.valueOf(((payload[5] & 0xff) << 8) + (payload[6] & 0xff)));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the LANGUAGE_GET command.
     * <p>
     * Language Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getLanguageGet() {
        logger.debug("Creating command message LANGUAGE_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(LANGUAGE_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the LANGUAGE_GET command.
     * <p>
     * Language Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleLanguageGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the LANGUAGE_REPORT command.
     * <p>
     * Language Report
     *
     * @param country {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getLanguageReport(Integer country) {
        logger.debug("Creating command message LANGUAGE_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(LANGUAGE_REPORT);

        // Process 'Language'

        // Process 'Country'
        outputData.write((country >> 8) & 0xff);
        outputData.write(country & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the LANGUAGE_REPORT command.
     * <p>
     * Language Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>COUNTRY {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleLanguageReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Language'

        // Process 'Country'
        response.put("COUNTRY", Integer.valueOf(((payload[5] & 0xff) << 8) + (payload[6] & 0xff)));

        // Return the map of processed response data;
        return response;
    }

}
