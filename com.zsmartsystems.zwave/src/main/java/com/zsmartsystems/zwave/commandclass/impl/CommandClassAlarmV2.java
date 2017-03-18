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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_ALARM</b> version <b>2</b>.<br>
 * <p>
 * Command Class Alarm<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassAlarmV2 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassAlarmV2.class);

    /**
     * Integer command class key for COMMAND_CLASS_ALARM
     */
    public final static int COMMAND_CLASS_KEY = 0x71;

    /**
     * Alarm Get Command Constant
     */
    public final static int ALARM_GET = 0x04;
    /**
     * Alarm Report Command Constant
     */
    public final static int ALARM_REPORT = 0x05;
    /**
     * Alarm Set Command Constant
     */
    public final static int ALARM_SET = 0x06;
    /**
     * Alarm Type Supported Get Command Constant
     */
    public final static int ALARM_TYPE_SUPPORTED_GET = 0x07;
    /**
     * Alarm Type Supported Report Command Constant
     */
    public final static int ALARM_TYPE_SUPPORTED_REPORT = 0x08;

    // Constants for ZWave Alarm Type
    private static Map<Integer, String> constantZwaveAlarmType = new HashMap<Integer, String>();

    static {
        // Constants for ZWave Alarm Type
        constantZwaveAlarmType.put(0x01, "SMOKE");
        constantZwaveAlarmType.put(0x02, "CO");
        constantZwaveAlarmType.put(0x03, "CO2");
        constantZwaveAlarmType.put(0x04, "HEAT");
        constantZwaveAlarmType.put(0x05, "WATER");
        constantZwaveAlarmType.put(0x06, "ACCESS_CONTROL");
        constantZwaveAlarmType.put(0x07, "BURGLAR");
        constantZwaveAlarmType.put(0x08, "POWER_MANAGEMENT");
        constantZwaveAlarmType.put(0x09, "SYSTEM");
        constantZwaveAlarmType.put(0x0A, "EMERGENCY");
        constantZwaveAlarmType.put(0x0B, "CLOCK");
    }

    /**
     * Creates a new message with the ALARM_GET command.<br>
     * <p>
     * Alarm Get<br>
     *
     * @param alarmType {@link Integer}
     * @param zwaveAlarmType {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAlarmGet(Integer alarmType, String zwaveAlarmType) {
        logger.debug("Creating command message ALARM_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ALARM_GET);

        // Process 'Alarm Type'
        outputData.write(alarmType);

        // Process 'ZWave Alarm Type'
        for (Integer entry : constantZwaveAlarmType.keySet()) {
            if (constantZwaveAlarmType.get(entry).equals(zwaveAlarmType)) {
                outputData.write(entry);
                break;
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ALARM_GET command<br>
     * <p>
     * Alarm Get<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ALARM_TYPE {@link Integer}
     * <li>ZWAVE_ALARM_TYPE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAlarmGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Alarm Type'
        response.put("ALARM_TYPE", Integer.valueOf(payload[2]));

        // Process 'ZWave Alarm Type'
        response.put("ZWAVE_ALARM_TYPE", constantZwaveAlarmType.get(payload[3] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ALARM_REPORT command.<br>
     * <p>
     * Alarm Report<br>
     *
     * @param alarmType {@link Integer}
     * @param alarmLevel {@link Integer}
     * @param zensorNetSourceNodeId {@link Integer}
     * @param zwaveAlarmStatus {@link Integer}
     * @param zwaveAlarmType {@link String}
     * @param zwaveAlarmEvent {@link Integer}
     * @param numberOfEventParameters {@link Integer}
     * @param eventParameter {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAlarmReport(Integer alarmType, Integer alarmLevel, Integer zensorNetSourceNodeId,
            Integer zwaveAlarmStatus, String zwaveAlarmType, Integer zwaveAlarmEvent, Integer numberOfEventParameters,
            byte[] eventParameter) {
        logger.debug("Creating command message ALARM_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ALARM_REPORT);

        // Process 'Alarm Type'
        outputData.write(alarmType);

        // Process 'Alarm Level'
        outputData.write(alarmLevel);

        // Process 'Zensor Net Source Node ID'
        // Check the node number boundary
        if (zensorNetSourceNodeId < 1 || zensorNetSourceNodeId > 232) {
            logger.debug("Node number is out of bounds {}", zensorNetSourceNodeId);
            return null;
        }
        outputData.write(zensorNetSourceNodeId);

        // Process 'ZWave Alarm Status'
        outputData.write(zwaveAlarmStatus);

        // Process 'ZWave Alarm Type'
        for (Integer entry : constantZwaveAlarmType.keySet()) {
            if (constantZwaveAlarmType.get(entry).equals(zwaveAlarmType)) {
                outputData.write(entry);
                break;
            }
        }

        // Process 'ZWave Alarm Event'
        outputData.write(zwaveAlarmEvent);

        // Process 'Number of Event Parameters'
        outputData.write(numberOfEventParameters);

        // Process 'Event Parameter'
        try {
            outputData.write(eventParameter);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ALARM_REPORT command<br>
     * <p>
     * Alarm Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ALARM_TYPE {@link Integer}
     * <li>ALARM_LEVEL {@link Integer}
     * <li>ZENSOR_NET_SOURCE_NODE_ID {@link Integer}
     * <li>ZWAVE_ALARM_STATUS {@link Integer}
     * <li>ZWAVE_ALARM_TYPE {@link String}
     * <li>ZWAVE_ALARM_EVENT {@link Integer}
     * <li>NUMBER_OF_EVENT_PARAMETERS {@link Integer}
     * <li>EVENT_PARAMETER {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAlarmReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Alarm Type'
        response.put("ALARM_TYPE", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Alarm Level'
        response.put("ALARM_LEVEL", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Zensor Net Source Node ID'
        response.put("ZENSOR_NET_SOURCE_NODE_ID", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'ZWave Alarm Status'
        switch (payload[msgOffset] & 0xff) {
            case 0x00:
                response.put("ZWAVE_ALARM_STATUS", "OFF");
                break;
            case 0xFF:
                response.put("ZWAVE_ALARM_STATUS", "ON");
                break;
            default:
                response.put("ZWAVE_ALARM_STATUS", String.format("%02X", payload[msgOffset] & 0xff));
                logger.debug("Unknown value {}", payload[msgOffset] & 0xff);
                break;
        }
        msgOffset += 1;

        // Process 'ZWave Alarm Type'
        response.put("ZWAVE_ALARM_TYPE", constantZwaveAlarmType.get(payload[msgOffset] & 0xff));
        msgOffset += 1;

        // Process 'ZWave Alarm Event'
        response.put("ZWAVE_ALARM_EVENT", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Number of Event Parameters'
        response.put("NUMBER_OF_EVENT_PARAMETERS", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Event Parameter'
        int valEventParameter = 0;
        int lenEventParameter = payload[3];
        for (int cntEventParameter = 0; cntEventParameter < lenEventParameter; cntEventParameter++) {
            valEventParameter = (valEventParameter << 8) + payload[msgOffset + cntEventParameter];
        }
        response.put("EVENT_PARAMETER", valEventParameter);
        msgOffset += lenEventParameter;

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ALARM_SET command.<br>
     * <p>
     * Alarm Set<br>
     *
     * @param zwaveAlarmType {@link String}
     * @param zwaveAlarmStatus {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAlarmSet(String zwaveAlarmType, Integer zwaveAlarmStatus) {
        logger.debug("Creating command message ALARM_SET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ALARM_SET);

        // Process 'ZWave Alarm Type'
        for (Integer entry : constantZwaveAlarmType.keySet()) {
            if (constantZwaveAlarmType.get(entry).equals(zwaveAlarmType)) {
                outputData.write(entry);
                break;
            }
        }

        // Process 'ZWave Alarm Status'
        outputData.write(zwaveAlarmStatus);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ALARM_SET command<br>
     * <p>
     * Alarm Set<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>ZWAVE_ALARM_TYPE {@link String}
     * <li>ZWAVE_ALARM_STATUS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAlarmSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'ZWave Alarm Type'
        response.put("ZWAVE_ALARM_TYPE", constantZwaveAlarmType.get(payload[2] & 0xff));

        // Process 'ZWave Alarm Status'
        switch (payload[3] & 0xff) {
            case 0x00:
                response.put("ZWAVE_ALARM_STATUS", "OFF");
                break;
            case 0xFF:
                response.put("ZWAVE_ALARM_STATUS", "ON");
                break;
            default:
                response.put("ZWAVE_ALARM_STATUS", String.format("%02X", payload[3] & 0xff));
                logger.debug("Unknown value {}", payload[3] & 0xff);
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ALARM_TYPE_SUPPORTED_GET command.<br>
     * <p>
     * Alarm Type Supported Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAlarmTypeSupportedGet() {
        logger.debug("Creating command message ALARM_TYPE_SUPPORTED_GET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ALARM_TYPE_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ALARM_TYPE_SUPPORTED_GET command<br>
     * <p>
     * Alarm Type Supported Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAlarmTypeSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ALARM_TYPE_SUPPORTED_REPORT command.<br>
     * <p>
     * Alarm Type Supported Report<br>
     *
     * @param v1Alarm {@link Boolean}
     * @param bitMask {@link List<String>}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getAlarmTypeSupportedReport(Boolean v1Alarm, List<String> bitMask) {
        logger.debug("Creating command message ALARM_TYPE_SUPPORTED_REPORT version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ALARM_TYPE_SUPPORTED_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= 4;
        valProperties1 |= v1Alarm ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Bit Mask'
        int valBitMask = 0;
        valBitMask |= (bitMask.contains("SMOKE") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("CO") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("CO2") ? 0x08 : 0);
        valBitMask |= (bitMask.contains("HEAT") ? 0x10 : 0);
        valBitMask |= (bitMask.contains("WATER") ? 0x20 : 0);
        valBitMask |= (bitMask.contains("ACCESS_CONTROL") ? 0x40 : 0);
        valBitMask |= (bitMask.contains("BURGLAR") ? 0x80 : 0);
        outputData.write(valBitMask);
        valBitMask = 0;
        valBitMask |= (bitMask.contains("POWER_MANAGEMENT") ? 0x01 : 0);
        valBitMask |= (bitMask.contains("SYSTEM") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("EMERGENCY") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("CLOCK") ? 0x08 : 0);
        outputData.write(valBitMask);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ALARM_TYPE_SUPPORTED_REPORT command<br>
     * <p>
     * Alarm Type Supported Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>V1_ALARM {@link Boolean}
     * <li>BIT_MASK {@link List}<{@link String}>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleAlarmTypeSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("V1_ALARM", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'Bit Mask'
        List<String> responseBitMask = new ArrayList<String>();
        int lenBitMask = (payload[2] & 0x1F) * 8;
        for (int cntBitMask = 0; cntBitMask < lenBitMask; cntBitMask++) {
            if ((payload[3 + (cntBitMask / 8)] & cntBitMask % 8) == 0) {
                continue;
            }
            switch (cntBitMask) {
                case 0x01:
                    responseBitMask.add("SMOKE");
                    break;
                case 0x02:
                    responseBitMask.add("CO");
                    break;
                case 0x03:
                    responseBitMask.add("CO2");
                    break;
                case 0x04:
                    responseBitMask.add("HEAT");
                    break;
                case 0x05:
                    responseBitMask.add("WATER");
                    break;
                case 0x06:
                    responseBitMask.add("ACCESS_CONTROL");
                    break;
                case 0x07:
                    responseBitMask.add("BURGLAR");
                    break;
                case 0x08:
                    responseBitMask.add("POWER_MANAGEMENT");
                    break;
                case 0x09:
                    responseBitMask.add("SYSTEM");
                    break;
                case 0x0A:
                    responseBitMask.add("EMERGENCY");
                    break;
                case 0x0B:
                    responseBitMask.add("CLOCK");
                    break;
                default:
                    responseBitMask.add("BITMASK_" + cntBitMask);
                    break;
            }
        }
        response.put("BIT_MASK", responseBitMask);

        // Return the map of processed response data;
        return response;
    }

}
