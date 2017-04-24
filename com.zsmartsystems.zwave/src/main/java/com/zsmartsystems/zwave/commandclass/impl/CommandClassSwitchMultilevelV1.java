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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SWITCH_MULTILEVEL</b> version <b>1</b>.
 * <p>
 * Command Class Switch Multilevel
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x26.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSwitchMultilevelV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSwitchMultilevelV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SWITCH_MULTILEVEL
     */
    public final static int COMMAND_CLASS_KEY = 0x26;

    /**
     * Switch Multilevel Set Command Constant
     */
    public final static int SWITCH_MULTILEVEL_SET = 0x01;
    /**
     * Switch Multilevel Get Command Constant
     */
    public final static int SWITCH_MULTILEVEL_GET = 0x02;
    /**
     * Switch Multilevel Report Command Constant
     */
    public final static int SWITCH_MULTILEVEL_REPORT = 0x03;
    /**
     * Switch Multilevel Start Level Change Command Constant
     */
    public final static int SWITCH_MULTILEVEL_START_LEVEL_CHANGE = 0x04;
    /**
     * Switch Multilevel Stop Level Change Command Constant
     */
    public final static int SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE = 0x05;


    /**
     * Map holding constants for SwitchMultilevelStartLevelChangeLevel
     */
    private static Map<Integer, String> constantSwitchMultilevelStartLevelChangeLevel = new HashMap<Integer, String>();

    /**
     * Map holding constants for SwitchMultilevelSetValue
     */
    private static Map<Integer, String> constantSwitchMultilevelSetValue = new HashMap<Integer, String>();

    /**
     * Map holding constants for SwitchMultilevelReportValue
     */
    private static Map<Integer, String> constantSwitchMultilevelReportValue = new HashMap<Integer, String>();
    static {

        // Constants for SwitchMultilevelStartLevelChangeLevel
        constantSwitchMultilevelStartLevelChangeLevel.put(0x20, "IGNORE_START_LEVEL");
        constantSwitchMultilevelStartLevelChangeLevel.put(0x40, "UP_DOWN");

        // Constants for SwitchMultilevelSetValue
        constantSwitchMultilevelSetValue.put(0x00, "OFF_DISABLE");
        constantSwitchMultilevelSetValue.put(0xFF, "ON_ENABLE");

        // Constants for SwitchMultilevelReportValue
        constantSwitchMultilevelReportValue.put(0x00, "OFF_DISABLE");
        constantSwitchMultilevelReportValue.put(0xFF, "ON_ENABLE");
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_SET command.
     * <p>
     * Switch Multilevel Set
     *
     * @param value {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>OFF_DISABLE
     *            <li>ON_ENABLE
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelSet(String value) {
        logger.debug("Creating command message SWITCH_MULTILEVEL_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_SET);

        // Process 'Value'
        boolean foundValue = false;
        for (Integer entry : constantSwitchMultilevelSetValue.keySet()) {
            if (constantSwitchMultilevelSetValue.get(entry).equals(value)) {
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
     * Processes a received frame with the SWITCH_MULTILEVEL_SET command.
     * <p>
     * Switch Multilevel Set
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
    public static Map<String, Object> handleSwitchMultilevelSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Value'
        response.put("VALUE", constantSwitchMultilevelSetValue.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SWITCH_MULTILEVEL_GET command.
     * <p>
     * Switch Multilevel Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelGet() {
        logger.debug("Creating command message SWITCH_MULTILEVEL_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_GET command.
     * <p>
     * Switch Multilevel Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SWITCH_MULTILEVEL_REPORT command.
     * <p>
     * Switch Multilevel Report
     *
     * @param value {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>OFF_DISABLE
     *            <li>ON_ENABLE
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelReport(String value) {
        logger.debug("Creating command message SWITCH_MULTILEVEL_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_REPORT);

        // Process 'Value'
        boolean foundValue = false;
        for (Integer entry : constantSwitchMultilevelReportValue.keySet()) {
            if (constantSwitchMultilevelReportValue.get(entry).equals(value)) {
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
     * Processes a received frame with the SWITCH_MULTILEVEL_REPORT command.
     * <p>
     * Switch Multilevel Report
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
    public static Map<String, Object> handleSwitchMultilevelReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Value'
        response.put("VALUE", constantSwitchMultilevelReportValue.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SWITCH_MULTILEVEL_START_LEVEL_CHANGE command.
     * <p>
     * Switch Multilevel Start Level Change
     *
     * @param ignoreStartLevel {@link Boolean}
     * @param upDown {@link Boolean}
     * @param startLevel {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelStartLevelChange(Boolean ignoreStartLevel, Boolean upDown,
            Integer startLevel) {
        logger.debug("Creating command message SWITCH_MULTILEVEL_START_LEVEL_CHANGE version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_START_LEVEL_CHANGE);

        // Process 'Level'
        int valLevel = 0;
        valLevel |= ignoreStartLevel ? 0x20 : 0;
        valLevel |= upDown ? 0x40 : 0;
        outputData.write(valLevel);

        // Process 'Start Level'
        outputData.write(startLevel);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_START_LEVEL_CHANGE command.
     * <p>
     * Switch Multilevel Start Level Change
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>IGNORE_START_LEVEL {@link Boolean}
     * <li>UP_DOWN {@link Boolean}
     * <li>START_LEVEL {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelStartLevelChange(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Level'
        response.put("IGNORE_START_LEVEL", Boolean.valueOf((payload[2] & 0x20) != 0));
        response.put("UP_DOWN", Boolean.valueOf((payload[2] & 0x40) != 0));

        // Process 'Start Level'
        response.put("START_LEVEL", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE command.
     * <p>
     * Switch Multilevel Stop Level Change
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelStopLevelChange() {
        logger.debug("Creating command message SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE command.
     * <p>
     * Switch Multilevel Stop Level Change
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelStopLevelChange(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

}
