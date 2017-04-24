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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_THERMOSTAT_FAN_MODE</b> version <b>2</b>.
 * <p>
 * Command Class Thermostat Fan Mode
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x44.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassThermostatFanModeV2 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassThermostatFanModeV2.class);

    /**
     * Integer command class key for COMMAND_CLASS_THERMOSTAT_FAN_MODE
     */
    public final static int COMMAND_CLASS_KEY = 0x44;

    /**
     * Thermostat Fan Mode Set Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_SET = 0x01;
    /**
     * Thermostat Fan Mode Get Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_GET = 0x02;
    /**
     * Thermostat Fan Mode Report Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_REPORT = 0x03;
    /**
     * Thermostat Fan Mode Supported Get Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_SUPPORTED_GET = 0x04;
    /**
     * Thermostat Fan Mode Supported Report Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_SUPPORTED_REPORT = 0x05;


    /**
     * Map holding constants for ThermostatFanModeSetLevel
     */
    private static Map<Integer, String> constantThermostatFanModeSetLevel = new HashMap<Integer, String>();

    /**
     * Map holding constants for ThermostatFanModeSupportedReportBitMask
     */
    private static Map<Integer, String> constantThermostatFanModeSupportedReportBitMask = new HashMap<Integer, String>();
    static {

        // Constants for ThermostatFanModeSetLevel
        constantThermostatFanModeSetLevel.put(0x80, "OFF");

        // Constants for ThermostatFanModeSupportedReportBitMask
        constantThermostatFanModeSupportedReportBitMask.put(0x00, "AUTO");
        constantThermostatFanModeSupportedReportBitMask.put(0x01, "LOW");
        constantThermostatFanModeSupportedReportBitMask.put(0x02, "AUTO_HIGH");
        constantThermostatFanModeSupportedReportBitMask.put(0x03, "HIGH");
        constantThermostatFanModeSupportedReportBitMask.put(0x04, "AUTO_MEDIUM");
        constantThermostatFanModeSupportedReportBitMask.put(0x05, "MEDIUM");
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_SET command.
     * <p>
     * Thermostat Fan Mode Set
     *
     * @param fanMode {@link String}
     * @param off {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeSet(String fanMode, Boolean off) {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_SET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_SET);

        // Process 'Level'
        int valLevel = 0;
        int valfanMode;
        switch (fanMode) {
            case "AUTO_LOW":
                valfanMode = 0;
                break;
            case "LOW":
                valfanMode = 1;
                break;
            case "AUTO_HIGH":
                valfanMode = 2;
                break;
            case "HIGH":
                valfanMode = 3;
                break;
            case "AUTO_MEDIUM":
                valfanMode = 4;
                break;
            case "MEDIUM":
                valfanMode = 5;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for fanMode: " + fanMode);
        }
        valLevel |= valfanMode & 0x0F;
        valLevel |= off ? 0x80 : 0;
        outputData.write(valLevel);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_SET command.
     * <p>
     * Thermostat Fan Mode Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>FAN_MODE {@link String}
     * <li>OFF {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        switch (payload[2] & 0x0F) {
            case 0x00:
                response.put("FAN_MODE", "AUTO_LOW");
                break;
            case 0x01:
                response.put("FAN_MODE", "LOW");
                break;
            case 0x02:
                response.put("FAN_MODE", "AUTO_HIGH");
                break;
            case 0x03:
                response.put("FAN_MODE", "HIGH");
                break;
            case 0x04:
                response.put("FAN_MODE", "AUTO_MEDIUM");
                break;
            case 0x05:
                response.put("FAN_MODE", "MEDIUM");
                break;
            default:
                logger.debug("Unknown enum value {} for FAN_MODE", String.format("0x%02X", 2));
        }
        response.put("OFF", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_GET command.
     * <p>
     * Thermostat Fan Mode Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeGet() {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_GET command.
     * <p>
     * Thermostat Fan Mode Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_REPORT command.
     * <p>
     * Thermostat Fan Mode Report
     *
     * @param fanMode {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeReport(String fanMode) {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_REPORT);

        // Process 'Level'
        int valfanMode;
        switch (fanMode) {
            case "AUTO_LOW":
                valfanMode = 0;
                break;
            case "LOW":
                valfanMode = 1;
                break;
            case "AUTO_HIGH":
                valfanMode = 2;
                break;
            case "HIGH":
                valfanMode = 3;
                break;
            case "AUTO_MEDIUM":
                valfanMode = 4;
                break;
            case "MEDIUM":
                valfanMode = 5;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for fanMode: " + fanMode);
        }
        outputData.write(valfanMode & 0x0F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_REPORT command.
     * <p>
     * Thermostat Fan Mode Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>FAN_MODE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        switch (payload[2] & 0x0F) {
            case 0x00:
                response.put("FAN_MODE", "AUTO_LOW");
                break;
            case 0x01:
                response.put("FAN_MODE", "LOW");
                break;
            case 0x02:
                response.put("FAN_MODE", "AUTO_HIGH");
                break;
            case 0x03:
                response.put("FAN_MODE", "HIGH");
                break;
            case 0x04:
                response.put("FAN_MODE", "AUTO_MEDIUM");
                break;
            case 0x05:
                response.put("FAN_MODE", "MEDIUM");
                break;
            default:
                logger.debug("Unknown enum value {} for FAN_MODE", String.format("0x%02X", 2));
        }

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_SUPPORTED_GET command.
     * <p>
     * Thermostat Fan Mode Supported Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeSupportedGet() {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_SUPPORTED_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_SUPPORTED_GET command.
     * <p>
     * Thermostat Fan Mode Supported Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_SUPPORTED_REPORT command.
     * <p>
     * Thermostat Fan Mode Supported Report
     *
     * @param bitMask {@link List<String>}
     *            Can be one of the following -:
     *            <ul>
     *            <li>AUTO
     *            <li>LOW
     *            <li>AUTO_HIGH
     *            <li>HIGH
     *            <li>AUTO_MEDIUM
     *            <li>MEDIUM
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeSupportedReport(List<String> bitMask) {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_SUPPORTED_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_SUPPORTED_REPORT);

        // Process 'Bit Mask'
        int valBitMask = 0;
        for (String value : bitMask) {
            boolean foundBitMask = false;
            for (Integer entry : constantThermostatFanModeSupportedReportBitMask.keySet()) {
                if (constantThermostatFanModeSupportedReportBitMask.get(entry).equals(value)) {
                    foundBitMask = true;
                    valBitMask += entry;
                    break;
                }
            }
            if (!foundBitMask) {
                throw new IllegalArgumentException("Unknown constant value '" + bitMask + "' for bitMask");
            }
        }
        outputData.write(valBitMask);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_SUPPORTED_REPORT command.
     * <p>
     * Thermostat Fan Mode Supported Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>BIT_MASK {@link List}<{@link String}>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Bit Mask'
        List<String> responseBitMask = new ArrayList<String>();
        for (int cntBitMask = 0; cntBitMask < (payload.length - 2) * 8; cntBitMask++) {
            if ((payload[2 + (cntBitMask / 8)] & (1 << cntBitMask % 8)) == 0) {
                continue;
            }
            responseBitMask.add(constantThermostatFanModeSupportedReportBitMask.get(cntBitMask));
        }
        response.put("BIT_MASK", responseBitMask);

        // Return the map of processed response data;
        return response;
    }

}
