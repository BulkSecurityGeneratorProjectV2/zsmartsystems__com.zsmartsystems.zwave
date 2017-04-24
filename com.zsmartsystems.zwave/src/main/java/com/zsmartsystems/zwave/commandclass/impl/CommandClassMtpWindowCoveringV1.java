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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_MTP_WINDOW_COVERING</b> version <b>1</b>.
 * <p>
 * Command Class Mtp Window Covering
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x51.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassMtpWindowCoveringV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassMtpWindowCoveringV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_MTP_WINDOW_COVERING
     */
    public final static int COMMAND_CLASS_KEY = 0x51;

    /**
     * Move To Position Set Command Constant
     */
    public final static int MOVE_TO_POSITION_SET = 0x01;
    /**
     * Move To Position Get Command Constant
     */
    public final static int MOVE_TO_POSITION_GET = 0x02;
    /**
     * Move To Position Report Command Constant
     */
    public final static int MOVE_TO_POSITION_REPORT = 0x03;


    /**
     * Map holding constants for MoveToPositionSetValue
     */
    private static Map<Integer, String> constantMoveToPositionSetValue = new HashMap<Integer, String>();

    /**
     * Map holding constants for MoveToPositionReportValue
     */
    private static Map<Integer, String> constantMoveToPositionReportValue = new HashMap<Integer, String>();
    static {

        // Constants for MoveToPositionSetValue
        constantMoveToPositionSetValue.put(0x00, "CLOSE");
        constantMoveToPositionSetValue.put(0xFF, "OPEN");

        // Constants for MoveToPositionReportValue
        constantMoveToPositionReportValue.put(0x00, "CLOSE");
        constantMoveToPositionReportValue.put(0xFF, "OPEN");
    }

    /**
     * Creates a new message with the MOVE_TO_POSITION_SET command.
     * <p>
     * Move To Position Set
     *
     * @param value {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>CLOSE
     *            <li>OPEN
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMoveToPositionSet(String value) {
        logger.debug("Creating command message MOVE_TO_POSITION_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MOVE_TO_POSITION_SET);

        // Process 'Value'
        boolean foundValue = false;
        for (Integer entry : constantMoveToPositionSetValue.keySet()) {
            if (constantMoveToPositionSetValue.get(entry).equals(value)) {
                outputData.write(entry);
                foundValue = true;
                break;
            }
        }
        if (!foundValue) {
            throw new IllegalArgumentException("Unknown constant value '" + value + "' for value");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MOVE_TO_POSITION_SET command.
     * <p>
     * Move To Position Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>VALUE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMoveToPositionSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Value'
        response.put("VALUE", constantMoveToPositionSetValue.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MOVE_TO_POSITION_GET command.
     * <p>
     * Move To Position Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMoveToPositionGet() {
        logger.debug("Creating command message MOVE_TO_POSITION_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MOVE_TO_POSITION_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MOVE_TO_POSITION_GET command.
     * <p>
     * Move To Position Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMoveToPositionGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the MOVE_TO_POSITION_REPORT command.
     * <p>
     * Move To Position Report
     *
     * @param value {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>CLOSE
     *            <li>OPEN
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMoveToPositionReport(String value) {
        logger.debug("Creating command message MOVE_TO_POSITION_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(MOVE_TO_POSITION_REPORT);

        // Process 'Value'
        boolean foundValue = false;
        for (Integer entry : constantMoveToPositionReportValue.keySet()) {
            if (constantMoveToPositionReportValue.get(entry).equals(value)) {
                outputData.write(entry);
                foundValue = true;
                break;
            }
        }
        if (!foundValue) {
            throw new IllegalArgumentException("Unknown constant value '" + value + "' for value");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the MOVE_TO_POSITION_REPORT command.
     * <p>
     * Move To Position Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>VALUE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMoveToPositionReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Value'
        response.put("VALUE", constantMoveToPositionReportValue.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }

}
