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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SCENE_CONTROLLER_CONF</b> version <b>1</b>.
 * <p>
 * Command Class Scene Controller Conf
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x2D.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSceneControllerConfV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSceneControllerConfV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SCENE_CONTROLLER_CONF
     */
    public final static int COMMAND_CLASS_KEY = 0x2D;

    /**
     * Scene Controller Conf Set Command Constant
     */
    public final static int SCENE_CONTROLLER_CONF_SET = 0x01;
    /**
     * Scene Controller Conf Get Command Constant
     */
    public final static int SCENE_CONTROLLER_CONF_GET = 0x02;
    /**
     * Scene Controller Conf Report Command Constant
     */
    public final static int SCENE_CONTROLLER_CONF_REPORT = 0x03;


    /**
     * Map holding constants for SceneControllerConfSetDimmingDuration
     */
    private static Map<Integer, String> constantSceneControllerConfSetDimmingDuration = new HashMap<Integer, String>();

    /**
     * Map holding constants for SceneControllerConfReportDimmingDuration
     */
    private static Map<Integer, String> constantSceneControllerConfReportDimmingDuration = new HashMap<Integer, String>();
    static {

        // Constants for SceneControllerConfSetDimmingDuration
        constantSceneControllerConfSetDimmingDuration.put(0x00, "INSTANTLY");
        constantSceneControllerConfSetDimmingDuration.put(0xFF, "FACTORY_DEFAULT");

        // Constants for SceneControllerConfReportDimmingDuration
        constantSceneControllerConfReportDimmingDuration.put(0x00, "INSTANTLY");
    }

    /**
     * Creates a new message with the SCENE_CONTROLLER_CONF_SET command.
     * <p>
     * Scene Controller Conf Set
     *
     * @param groupId {@link Integer}
     * @param sceneId {@link Integer}
     * @param dimmingDuration {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>INSTANTLY
     *            <li>FACTORY_DEFAULT
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSceneControllerConfSet(Integer groupId, Integer sceneId, String dimmingDuration) {
        logger.debug("Creating command message SCENE_CONTROLLER_CONF_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCENE_CONTROLLER_CONF_SET);

        // Process 'Group ID'
        outputData.write(groupId);

        // Process 'Scene ID'
        outputData.write(sceneId);

        // Process 'Dimming Duration'
        boolean foundDimmingDuration = false;
        for (Integer entry : constantSceneControllerConfSetDimmingDuration.keySet()) {
            if (constantSceneControllerConfSetDimmingDuration.get(entry).equals(dimmingDuration)) {
                outputData.write(entry);
                foundDimmingDuration = true;
                break;
            }
        }
        if (!foundDimmingDuration) {
            throw new IllegalArgumentException("Unknown constant value '" + dimmingDuration + "' for dimmingDuration");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCENE_CONTROLLER_CONF_SET command.
     * <p>
     * Scene Controller Conf Set
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>GROUP_ID {@link Integer}
     * <li>SCENE_ID {@link Integer}
     * <li>DIMMING_DURATION {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSceneControllerConfSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Group ID'
        response.put("GROUP_ID", Integer.valueOf(payload[2]));

        // Process 'Scene ID'
        response.put("SCENE_ID", Integer.valueOf(payload[3]));

        // Process 'Dimming Duration'
        response.put("DIMMING_DURATION", constantSceneControllerConfSetDimmingDuration.get(payload[4] & 0xff));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SCENE_CONTROLLER_CONF_GET command.
     * <p>
     * Scene Controller Conf Get
     *
     * @param groupId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSceneControllerConfGet(Integer groupId) {
        logger.debug("Creating command message SCENE_CONTROLLER_CONF_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCENE_CONTROLLER_CONF_GET);

        // Process 'Group ID'
        outputData.write(groupId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCENE_CONTROLLER_CONF_GET command.
     * <p>
     * Scene Controller Conf Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>GROUP_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSceneControllerConfGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Group ID'
        response.put("GROUP_ID", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the SCENE_CONTROLLER_CONF_REPORT command.
     * <p>
     * Scene Controller Conf Report
     *
     * @param groupId {@link Integer}
     * @param sceneId {@link Integer}
     * @param dimmingDuration {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>INSTANTLY
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSceneControllerConfReport(Integer groupId, Integer sceneId, String dimmingDuration) {
        logger.debug("Creating command message SCENE_CONTROLLER_CONF_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCENE_CONTROLLER_CONF_REPORT);

        // Process 'Group ID'
        outputData.write(groupId);

        // Process 'Scene ID'
        outputData.write(sceneId);

        // Process 'Dimming Duration'
        boolean foundDimmingDuration = false;
        for (Integer entry : constantSceneControllerConfReportDimmingDuration.keySet()) {
            if (constantSceneControllerConfReportDimmingDuration.get(entry).equals(dimmingDuration)) {
                outputData.write(entry);
                foundDimmingDuration = true;
                break;
            }
        }
        if (!foundDimmingDuration) {
            throw new IllegalArgumentException("Unknown constant value '" + dimmingDuration + "' for dimmingDuration");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCENE_CONTROLLER_CONF_REPORT command.
     * <p>
     * Scene Controller Conf Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>GROUP_ID {@link Integer}
     * <li>SCENE_ID {@link Integer}
     * <li>DIMMING_DURATION {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSceneControllerConfReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Group ID'
        response.put("GROUP_ID", Integer.valueOf(payload[2]));

        // Process 'Scene ID'
        response.put("SCENE_ID", Integer.valueOf(payload[3]));

        // Process 'Dimming Duration'
        response.put("DIMMING_DURATION", constantSceneControllerConfReportDimmingDuration.get(payload[4] & 0xff));

        // Return the map of processed response data;
        return response;
    }

}
