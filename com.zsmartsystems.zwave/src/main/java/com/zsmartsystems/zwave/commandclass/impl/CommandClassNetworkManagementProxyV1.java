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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_NETWORK_MANAGEMENT_PROXY</b> version <b>1</b>.<br>
 * <p>
 * Command Class Network Management Proxy<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassNetworkManagementProxyV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassNetworkManagementProxyV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_NETWORK_MANAGEMENT_PROXY
     */
    public final static int COMMAND_CLASS_KEY = 0x52;

    /**
     * Node List Get Command Constant
     */
    public final static int NODE_LIST_GET = 0x01;
    /**
     * Node List Report Command Constant
     */
    public final static int NODE_LIST_REPORT = 0x02;
    /**
     * Node Info Cached Get Command Constant
     */
    public final static int NODE_INFO_CACHED_GET = 0x03;
    /**
     * Node Info Cached Report Command Constant
     */
    public final static int NODE_INFO_CACHED_REPORT = 0x04;

    /**
     * Creates a new message with the NODE_LIST_GET command.<br>
     * <p>
     * Node List Get<br>
     *
     * @param seqNo {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getNodeListGet(Integer seqNo) {
        logger.debug("Creating command message NODE_LIST_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(NODE_LIST_GET);

        // Process 'Seq. No'
        outputData.write(seqNo);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the NODE_LIST_GET command<br>
     * <p>
     * Node List Get<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SEQ_NO {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleNodeListGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Seq. No'
        response.put("SEQ_NO", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the NODE_LIST_REPORT command.<br>
     * <p>
     * Node List Report<br>
     *
     * @param seqNo {@link Integer}
     * @param status {@link Integer}
     * @param nodeListControllerId {@link Integer}
     * @param nodeListData {@link List<Integer>}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getNodeListReport(Integer seqNo, Integer status, Integer nodeListControllerId,
            List<Integer> nodeListData) {
        logger.debug("Creating command message NODE_LIST_REPORT version 1");

        Collections.sort(nodeListData);
        int lenNodeListData = (nodeListData.get(nodeListData.size() - 1) / 8) + 1;

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(NODE_LIST_REPORT);

        // Process 'Seq. No'
        outputData.write(seqNo);

        // Process 'Status'
        outputData.write(status);

        // Process 'Node List Controller ID'
        outputData.write(nodeListControllerId);

        // Process 'Node List Data'
        int valNodeListData = 0;
        for (int cntNodeListData = 1 ; cntNodeListData < lenNodeListData * 8 ; cntNodeListData++) {
            valNodeListData |= nodeListData.contains(valNodeListData) ? (1 << cntNodeListData % 8) : 0;
            if (cntNodeListData % 8 == 0) {
                outputData.write(valNodeListData);
                valNodeListData = 0;
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the NODE_LIST_REPORT command<br>
     * <p>
     * Node List Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SEQ_NO {@link Integer}
     * <li>STATUS {@link Integer}
     * <li>NODE_LIST_CONTROLLER_ID {@link Integer}
     * <li>NODE_LIST_DATA {@link List}<{@link Integer}>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleNodeListReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Seq. No'
        response.put("SEQ_NO", Integer.valueOf(payload[2]));

        // Process 'Status'
        switch (payload[3] & 0xff) {
            case 0x00:
                response.put("STATUS", "LATEST");
                break;
            case 0x01:
                response.put("STATUS", "MAY_NOT_BE_THE_LATEST");
                break;
            default:
                response.put("STATUS", String.format("%02X", payload[3] & 0xff));
                logger.debug("Unknown value {}", payload[3] & 0xff);
                break;
        }

        // Process 'Node List Controller ID'
        response.put("NODE_LIST_CONTROLLER_ID", Integer.valueOf(payload[4]));

        // Process 'Node List Data'
        List<Integer> responseNodeListData = new ArrayList<Integer>();
        int cntNodeListData = 0;
        while (cntNodeListData < payload.length - 5) {
            if ((payload[5 + (cntNodeListData / 8)] & cntNodeListData % 8) == 0) {
                continue;
            }
            responseNodeListData.add(cntNodeListData);
        }
        response.put("NODE_LIST_DATA", responseNodeListData);

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the NODE_INFO_CACHED_GET command.<br>
     * <p>
     * Node Info Cached Get<br>
     *
     * @param seqNo {@link Integer}
     * @param maxAge {@link Integer}
     * @param nodeId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getNodeInfoCachedGet(Integer seqNo, Integer maxAge, Integer nodeId) {
        logger.debug("Creating command message NODE_INFO_CACHED_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(NODE_INFO_CACHED_GET);

        // Process 'Seq. No'
        outputData.write(seqNo);

        // Process 'Properties1'
        outputData.write(maxAge & 0x0F);

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
     * Processes a received frame with the NODE_INFO_CACHED_GET command<br>
     * <p>
     * Node Info Cached Get<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SEQ_NO {@link Integer}
     * <li>MAX_AGE {@link Integer}
     * <li>NODE_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleNodeInfoCachedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Seq. No'
        response.put("SEQ_NO", Integer.valueOf(payload[2]));

        // Process 'Properties1'
        response.put("MAX_AGE", Integer.valueOf(payload[3] & 0x0F));

        // Process 'Node ID'
        response.put("NODE_ID", Integer.valueOf(payload[4]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the NODE_INFO_CACHED_REPORT command.<br>
     * <p>
     * Node Info Cached Report<br>
     *
     * @param seqNo {@link Integer}
     * @param age {@link Integer}
     * @param status {@link String}
     * @param capability {@link Integer}
     * @param listening {@link Boolean}
     * @param security {@link Integer}
     * @param sensor {@link Integer}
     * @param opt {@link Boolean}
     * @param basicDeviceClass {@link Integer}
     * @param genericDeviceClass {@link Integer}
     * @param specificDeviceClass {@link Integer}
     * @param nonSecureCommandClass {@link byte[]}
     * @param securityScheme0CommandClass {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getNodeInfoCachedReport(Integer seqNo, Integer age, String status, Integer capability,
            Boolean listening, Integer security, Integer sensor, Boolean opt, Integer basicDeviceClass,
            Integer genericDeviceClass, Integer specificDeviceClass, byte[] nonSecureCommandClass,
            byte[] securityScheme0CommandClass) {
        logger.debug("Creating command message NODE_INFO_CACHED_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(NODE_INFO_CACHED_REPORT);

        // Process 'Seq. No'
        outputData.write(seqNo);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= age & 0x0F;
        int valstatus;
        switch (status) {
            case "STATUS_OK":
                valstatus = 0;
                break;
            case "STATUS_NOT_RESPONDING":
                valstatus = 1;
                break;
            case "STATUS_UNKNOWN":
                valstatus = 2;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for status: " + status);
        }
        valProperties1 |= valstatus >> 4 & 0xF0;
        outputData.write(valProperties1);

        // Process 'Properties2'
        int valProperties2 = 0;
        valProperties2 |= capability & 0x7F;
        valProperties2 |= listening ? 0x80 : 0;
        outputData.write(valProperties2);

        // Process 'Properties3'
        int valProperties3 = 0;
        valProperties3 |= security & 0x0F;
        valProperties3 |= ((sensor << 4) & 0x70);
        valProperties3 |= opt ? 0x80 : 0;
        outputData.write(valProperties3);

        // Process 'Reserved'
        // Process 'Basic Device Class'
        outputData.write(basicDeviceClass);

        // Process 'Generic Device Class'
        outputData.write(genericDeviceClass);

        // Process 'Specific Device Class'
        outputData.write(specificDeviceClass);

        // Process 'Non-Secure Command Class'
        try {
            outputData.write(nonSecureCommandClass);
        } catch (IOException e) {
        }

        // Process 'Security Scheme 0 MARK'
        outputData.write(0xF1);

        // Process 'Security Scheme 0 Command Class'
        try {
            outputData.write(securityScheme0CommandClass);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the NODE_INFO_CACHED_REPORT command<br>
     * <p>
     * Node Info Cached Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SEQ_NO {@link Integer}
     * <li>AGE {@link Integer}
     * <li>STATUS {@link String}
     * <li>CAPABILITY {@link Integer}
     * <li>LISTENING {@link Boolean}
     * <li>SECURITY {@link Integer}
     * <li>SENSOR {@link Integer}
     * <li>OPT {@link Boolean}
     * <li>BASIC_DEVICE_CLASS {@link Integer}
     * <li>GENERIC_DEVICE_CLASS {@link Integer}
     * <li>SPECIFIC_DEVICE_CLASS {@link Integer}
     * <li>NON_SECURE_COMMAND_CLASS {@link byte[]}
     * <li>SECURITY_SCHEME_0_COMMAND_CLASS {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleNodeInfoCachedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Seq. No'
        response.put("SEQ_NO", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Properties1'
        response.put("AGE", Integer.valueOf(payload[msgOffset] & 0x0F));
        switch ((payload[msgOffset] & 0xF0) >> 4) {
            case 0x00:
                response.put("STATUS", "STATUS_OK");
                break;
            case 0x01:
                response.put("STATUS", "STATUS_NOT_RESPONDING");
                break;
            case 0x02:
                response.put("STATUS", "STATUS_UNKNOWN");
                break;
            default:
                logger.debug("Unknown enum value {} for STATUS", String.format("0x%02X", msgOffset));
        }
        msgOffset += 1;

        // Process 'Properties2'
        response.put("CAPABILITY", Integer.valueOf(payload[msgOffset] & 0x7F));
        response.put("LISTENING", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Properties3'
        response.put("SECURITY", Integer.valueOf(payload[msgOffset] & 0x0F));
        response.put("SENSOR", Integer.valueOf((payload[msgOffset] & 0x70 >> 4)));
        response.put("OPT", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        msgOffset += 1;

        // Process 'Basic Device Class'
        response.put("BASIC_DEVICE_CLASS", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Generic Device Class'
        response.put("GENERIC_DEVICE_CLASS", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Specific Device Class'
        response.put("SPECIFIC_DEVICE_CLASS", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Non-Secure Command Class'
        ByteArrayOutputStream valNonSecureCommandClass = new ByteArrayOutputStream();
        while (msgOffset < payload.length) {
            // Detect the marker
            if (((payload[msgOffset] & 0xFF) == 0xF1) && ((payload[msgOffset + 1] & 0xFF) == 0x00)) {
                break;
            }
            valNonSecureCommandClass.write(payload[msgOffset]);
            msgOffset++;
        }
        response.put("NON_SECURE_COMMAND_CLASS", valNonSecureCommandClass);

        // Process 'Security Scheme 0 MARK'
        // Adjust position to account for the marker
        msgOffset += 2;

        // Process 'Security Scheme 0 Command Class'
        ByteArrayOutputStream valSecurityScheme0CommandClass = new ByteArrayOutputStream();
        while (msgOffset < payload.length) {
            valSecurityScheme0CommandClass.write(payload[msgOffset]);
            msgOffset++;
        }
        response.put("SECURITY_SCHEME_0_COMMAND_CLASS", valSecurityScheme0CommandClass);

        // Return the map of processed response data;
        return response;
    }

}
