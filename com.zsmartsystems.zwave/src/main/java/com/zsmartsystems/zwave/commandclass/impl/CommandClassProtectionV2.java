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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_PROTECTION</b> version <b>2</b>.<br>
 * <p>
 * Command Class Protection<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassProtectionV2 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassProtectionV2.class);

    /**
     * Integer command class key for COMMAND_CLASS_PROTECTION
     */
    public final static int COMMAND_CLASS_KEY = 0x75;

    /**
     * Protection Set Command Constant
     */
    public final static int PROTECTION_SET = 0x01;
    /**
     * Protection Get Command Constant
     */
    public final static int PROTECTION_GET = 0x02;
    /**
     * Protection Report Command Constant
     */
    public final static int PROTECTION_REPORT = 0x03;
    /**
     * Protection Supported Get Command Constant
     */
    public final static int PROTECTION_SUPPORTED_GET = 0x04;
    /**
     * Protection Supported Report Command Constant
     */
    public final static int PROTECTION_SUPPORTED_REPORT = 0x05;
    /**
     * Protection Ec Set Command Constant
     */
    public final static int PROTECTION_EC_SET = 0x06;
    /**
     * Protection Ec Get Command Constant
     */
    public final static int PROTECTION_EC_GET = 0x07;
    /**
     * Protection Ec Report Command Constant
     */
    public final static int PROTECTION_EC_REPORT = 0x08;
    /**
     * Protection Timeout Set Command Constant
     */
    public final static int PROTECTION_TIMEOUT_SET = 0x09;
    /**
     * Protection Timeout Get Command Constant
     */
    public final static int PROTECTION_TIMEOUT_GET = 0x0A;
    /**
     * Protection Timeout Report Command Constant
     */
    public final static int PROTECTION_TIMEOUT_REPORT = 0x0B;

    /**
     * Creates a new message with the PROTECTION_SET command.<br>
     * <p>
     * Protection Set<br>
     *
     * @param localProtectionState {@link Integer}
     * @param rfProtectionState {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionSet(Integer localProtectionState, Integer rfProtectionState) {
        logger.debug("Creating command message PROTECTION_SET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_SET);

        // Process 'Level'
        outputData.write(localProtectionState & 0x0F);

        // Process 'Level2'
        outputData.write(rfProtectionState & 0x0F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_SET command<br>
     * <p>
     * Protection Set<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>LOCAL_PROTECTION_STATE {@link Integer}
     * <li>RF_PROTECTION_STATE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        response.put("LOCAL_PROTECTION_STATE", Integer.valueOf(payload[2] & 0x0F));

        // Process 'Level2'
        response.put("RF_PROTECTION_STATE", Integer.valueOf(payload[3] & 0x0F));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_GET command.<br>
     * <p>
     * Protection Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionGet() {
        logger.debug("Creating command message PROTECTION_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_GET command<br>
     * <p>
     * Protection Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_REPORT command.<br>
     * <p>
     * Protection Report<br>
     *
     * @param localProtectionState {@link Integer}
     * @param rfProtectionState {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionReport(Integer localProtectionState, Integer rfProtectionState) {
        logger.debug("Creating command message PROTECTION_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_REPORT);

        // Process 'Level'
        outputData.write(localProtectionState & 0x0F);

        // Process 'Level2'
        outputData.write(rfProtectionState & 0x0F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_REPORT command<br>
     * <p>
     * Protection Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>LOCAL_PROTECTION_STATE {@link Integer}
     * <li>RF_PROTECTION_STATE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        response.put("LOCAL_PROTECTION_STATE", Integer.valueOf(payload[2] & 0x0F));

        // Process 'Level2'
        response.put("RF_PROTECTION_STATE", Integer.valueOf(payload[3] & 0x0F));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_SUPPORTED_GET command.<br>
     * <p>
     * Protection Supported Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionSupportedGet() {
        logger.debug("Creating command message PROTECTION_SUPPORTED_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_SUPPORTED_GET command<br>
     * <p>
     * Protection Supported Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_SUPPORTED_REPORT command.<br>
     * <p>
     * Protection Supported Report<br>
     *
     * @param timeout {@link Boolean}
     * @param exclusiveControl {@link Boolean}
     * @param localProtectionState {@link Integer}
     * @param rfProtectionState {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionSupportedReport(Boolean timeout, Boolean exclusiveControl,
            Integer localProtectionState, Integer rfProtectionState) {
        logger.debug("Creating command message PROTECTION_SUPPORTED_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_SUPPORTED_REPORT);

        // Process 'Level'
        int valLevel = 0;
        valLevel |= timeout ? 0x01 : 0;
        valLevel |= exclusiveControl ? 0x02 : 0;
        outputData.write(valLevel);

        // Process 'Local Protection State'
        outputData.write((localProtectionState >> 8) & 0xff);
        outputData.write(localProtectionState & 0xff);

        // Process 'RF Protection State'
        outputData.write((rfProtectionState >> 8) & 0xff);
        outputData.write(rfProtectionState & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_SUPPORTED_REPORT command<br>
     * <p>
     * Protection Supported Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>TIMEOUT {@link Boolean}
     * <li>EXCLUSIVE_CONTROL {@link Boolean}
     * <li>LOCAL_PROTECTION_STATE {@link Integer}
     * <li>RF_PROTECTION_STATE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        response.put("TIMEOUT", Boolean.valueOf((payload[2] & 0x01) != 0));
        response.put("EXCLUSIVE_CONTROL", Boolean.valueOf((payload[2] & 0x02) != 0));

        // Process 'Local Protection State'
        response.put("LOCAL_PROTECTION_STATE", Integer.valueOf(payload[3] << 8 + payload[4]));

        // Process 'RF Protection State'
        response.put("RF_PROTECTION_STATE", Integer.valueOf(payload[5] << 8 + payload[6]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_EC_SET command.<br>
     * <p>
     * Protection Ec Set<br>
     *
     * @param nodeId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionEcSet(Integer nodeId) {
        logger.debug("Creating command message PROTECTION_EC_SET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_EC_SET);

        // Process 'Node ID'
        // Check the node number boundary
        if (nodeId < 1 || nodeId > 232) {
            logger.debug("Node number is out of bounds {}", nodeId);
            return null;
        }
        outputData.write(nodeId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_EC_SET command<br>
     * <p>
     * Protection Ec Set<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>NODE_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionEcSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Node ID'
        response.put("NODE_ID", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_EC_GET command.<br>
     * <p>
     * Protection Ec Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionEcGet() {
        logger.debug("Creating command message PROTECTION_EC_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_EC_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_EC_GET command<br>
     * <p>
     * Protection Ec Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionEcGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_EC_REPORT command.<br>
     * <p>
     * Protection Ec Report<br>
     *
     * @param nodeId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionEcReport(Integer nodeId) {
        logger.debug("Creating command message PROTECTION_EC_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_EC_REPORT);

        // Process 'Node ID'
        // Check the node number boundary
        if (nodeId < 1 || nodeId > 232) {
            logger.debug("Node number is out of bounds {}", nodeId);
            return null;
        }
        outputData.write(nodeId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_EC_REPORT command<br>
     * <p>
     * Protection Ec Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>NODE_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionEcReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Node ID'
        response.put("NODE_ID", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_TIMEOUT_SET command.<br>
     * <p>
     * Protection Timeout Set<br>
     *
     * @param timeout {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionTimeoutSet(Integer timeout) {
        logger.debug("Creating command message PROTECTION_TIMEOUT_SET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_TIMEOUT_SET);

        // Process 'Timeout'
        outputData.write(timeout);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_TIMEOUT_SET command<br>
     * <p>
     * Protection Timeout Set<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>TIMEOUT {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionTimeoutSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Timeout'
        switch (payload[2] & 0xff) {
            case 0x00:
                response.put("TIMEOUT", "NO_TIMER_IS_SET");
                break;
            case 0xFF:
                response.put("TIMEOUT", "NO_TIMEOUT");
                break;
            default:
                response.put("TIMEOUT", String.format("%02X", payload[2] & 0xff));
                logger.debug("Unknown value {}", payload[2] & 0xff);
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_TIMEOUT_GET command.<br>
     * <p>
     * Protection Timeout Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionTimeoutGet() {
        logger.debug("Creating command message PROTECTION_TIMEOUT_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_TIMEOUT_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_TIMEOUT_GET command<br>
     * <p>
     * Protection Timeout Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionTimeoutGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_TIMEOUT_REPORT command.<br>
     * <p>
     * Protection Timeout Report<br>
     *
     * @param timeout {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionTimeoutReport(Integer timeout) {
        logger.debug("Creating command message PROTECTION_TIMEOUT_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_TIMEOUT_REPORT);

        // Process 'Timeout'
        outputData.write(timeout);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_TIMEOUT_REPORT command<br>
     * <p>
     * Protection Timeout Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>TIMEOUT {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionTimeoutReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Timeout'
        switch (payload[2] & 0xff) {
            case 0x00:
                response.put("TIMEOUT", "NO_TIMER_IS_SET");
                break;
            case 0xFF:
                response.put("TIMEOUT", "NO_TIMEOUT_IS_SET");
                break;
            default:
                response.put("TIMEOUT", String.format("%02X", payload[2] & 0xff));
                logger.debug("Unknown value {}", payload[2] & 0xff);
                break;
        }

        // Return the map of processed response data;
        return response;
    }

}
