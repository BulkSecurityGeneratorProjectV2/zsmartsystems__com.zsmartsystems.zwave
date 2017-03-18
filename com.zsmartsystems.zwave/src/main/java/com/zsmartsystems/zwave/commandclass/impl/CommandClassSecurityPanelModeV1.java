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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SECURITY_PANEL_MODE</b> version <b>1</b>.<br>
 * <p>
 * Command Class Security Panel Mode<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSecurityPanelModeV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSecurityPanelModeV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SECURITY_PANEL_MODE
     */
    public final static int COMMAND_CLASS_KEY = 0x24;

    /**
     * Security Panel Mode Supported Get Command Constant
     */
    public final static int SECURITY_PANEL_MODE_SUPPORTED_GET = 0x01;
    /**
     * Security Panel Mode Supported Report Command Constant
     */
    public final static int SECURITY_PANEL_MODE_SUPPORTED_REPORT = 0x02;
    /**
     * Security Panel Mode Get Command Constant
     */
    public final static int SECURITY_PANEL_MODE_GET = 0x03;
    /**
     * Security Panel Mode Report Command Constant
     */
    public final static int SECURITY_PANEL_MODE_REPORT = 0x04;
    /**
     * Security Panel Mode Set Command Constant
     */
    public final static int SECURITY_PANEL_MODE_SET = 0x05;

    /**
     * Creates a new message with the SECURITY_PANEL_MODE_SUPPORTED_GET command.<br>
     * <p>
     * Security Panel Mode Supported Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSecurityPanelModeSupportedGet() {
        logger.debug("Creating command message SECURITY_PANEL_MODE_SUPPORTED_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SECURITY_PANEL_MODE_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SECURITY_PANEL_MODE_SUPPORTED_GET command<br>
     * <p>
     * Security Panel Mode Supported Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSecurityPanelModeSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SECURITY_PANEL_MODE_SUPPORTED_REPORT command.<br>
     * <p>
     * Security Panel Mode Supported Report<br>
     *
     * @param supportedModeBitMask {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSecurityPanelModeSupportedReport(Integer supportedModeBitMask) {
        logger.debug("Creating command message SECURITY_PANEL_MODE_SUPPORTED_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SECURITY_PANEL_MODE_SUPPORTED_REPORT);

        // Process 'Supported Mode Bit Mask'
        outputData.write((supportedModeBitMask >> 8) & 0xff);
        outputData.write(supportedModeBitMask & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SECURITY_PANEL_MODE_SUPPORTED_REPORT command<br>
     * <p>
     * Security Panel Mode Supported Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SUPPORTED_MODE_BIT_MASK {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSecurityPanelModeSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Supported Mode Bit Mask'
        response.put("SUPPORTED_MODE_BIT_MASK", Integer.valueOf(payload[2] << 8 + payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SECURITY_PANEL_MODE_GET command.<br>
     * <p>
     * Security Panel Mode Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSecurityPanelModeGet() {
        logger.debug("Creating command message SECURITY_PANEL_MODE_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SECURITY_PANEL_MODE_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SECURITY_PANEL_MODE_GET command<br>
     * <p>
     * Security Panel Mode Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSecurityPanelModeGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SECURITY_PANEL_MODE_REPORT command.<br>
     * <p>
     * Security Panel Mode Report<br>
     *
     * @param mode {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSecurityPanelModeReport(Integer mode) {
        logger.debug("Creating command message SECURITY_PANEL_MODE_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SECURITY_PANEL_MODE_REPORT);

        // Process 'MODE'
        outputData.write(mode);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SECURITY_PANEL_MODE_REPORT command<br>
     * <p>
     * Security Panel Mode Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>MODE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSecurityPanelModeReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'MODE'
        switch (payload[2] & 0xff) {
            case 0x01:
                response.put("MODE", "ARM_HOME");
                break;
            case 0x02:
                response.put("MODE", "ARM_AWAY,_NO_DELAY");
                break;
            case 0x03:
                response.put("MODE", "ARM_AWAY,_DELAYED");
                break;
            case 0x04:
                response.put("MODE", "DISARM");
                break;
            case 0x05:
                response.put("MODE", "ALARM_TRIGGER");
                break;
            default:
                response.put("MODE", String.format("%02X", payload[2] & 0xff));
                logger.debug("Unknown value {}", payload[2] & 0xff);
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SECURITY_PANEL_MODE_SET command.<br>
     * <p>
     * Security Panel Mode Set<br>
     *
     * @param mode {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSecurityPanelModeSet(Integer mode) {
        logger.debug("Creating command message SECURITY_PANEL_MODE_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SECURITY_PANEL_MODE_SET);

        // Process 'MODE'
        outputData.write(mode);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SECURITY_PANEL_MODE_SET command<br>
     * <p>
     * Security Panel Mode Set<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>MODE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSecurityPanelModeSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'MODE'
        switch (payload[2] & 0xff) {
            case 0x01:
                response.put("MODE", "ARM_HOME");
                break;
            case 0x02:
                response.put("MODE", "ARM_AWAY,_NO_DELAY");
                break;
            case 0x03:
                response.put("MODE", "ARM_AWAY,_DELAYED");
                break;
            case 0x04:
                response.put("MODE", "DISARM");
                break;
            case 0x05:
                response.put("MODE", "ALARM_TRIGGER");
                break;
            default:
                response.put("MODE", String.format("%02X", payload[2] & 0xff));
                logger.debug("Unknown value {}", payload[2] & 0xff);
                break;
        }

        // Return the map of processed response data;
        return response;
    }

}
