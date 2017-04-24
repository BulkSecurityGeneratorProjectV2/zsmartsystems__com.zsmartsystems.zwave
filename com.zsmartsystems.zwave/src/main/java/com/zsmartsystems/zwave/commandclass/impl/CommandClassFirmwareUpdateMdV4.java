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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_FIRMWARE_UPDATE_MD</b> version <b>4</b>.
 * <p>
 * Command Class Firmware Update Md
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x7A.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassFirmwareUpdateMdV4 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassFirmwareUpdateMdV4.class);

    /**
     * Integer command class key for COMMAND_CLASS_FIRMWARE_UPDATE_MD
     */
    public final static int COMMAND_CLASS_KEY = 0x7A;

    /**
     * Firmware Md Get Command Constant
     */
    public final static int FIRMWARE_MD_GET = 0x01;
    /**
     * Firmware Md Report Command Constant
     */
    public final static int FIRMWARE_MD_REPORT = 0x02;
    /**
     * Firmware Update Md Request Get Command Constant
     */
    public final static int FIRMWARE_UPDATE_MD_REQUEST_GET = 0x03;
    /**
     * Firmware Update Md Request Report Command Constant
     */
    public final static int FIRMWARE_UPDATE_MD_REQUEST_REPORT = 0x04;
    /**
     * Firmware Update Md Get Command Constant
     */
    public final static int FIRMWARE_UPDATE_MD_GET = 0x05;
    /**
     * Firmware Update Md Report Command Constant
     */
    public final static int FIRMWARE_UPDATE_MD_REPORT = 0x06;
    /**
     * Firmware Update Md Status Report Command Constant
     */
    public final static int FIRMWARE_UPDATE_MD_STATUS_REPORT = 0x07;
    /**
     * Firmware Update Activation Set Command Command Constant
     */
    public final static int FIRMWARE_UPDATE_ACTIVATION_SET = 0x08;
    /**
     * Firmware Update Activation Status Report Command Constant
     */
    public final static int FIRMWARE_UPDATE_ACTIVATION_STATUS_REPORT = 0x09;


    /**
     * Map holding constants for FirmwareUpdateMdStatusReportStatus
     */
    private static Map<Integer, String> constantFirmwareUpdateMdStatusReportStatus = new HashMap<Integer, String>();

    /**
     * Map holding constants for FirmwareUpdateMdRequestReportStatus
     */
    private static Map<Integer, String> constantFirmwareUpdateMdRequestReportStatus = new HashMap<Integer, String>();

    /**
     * Map holding constants for FirmwareUpdateMdRequestGetProperties1
     */
    private static Map<Integer, String> constantFirmwareUpdateMdRequestGetProperties1 = new HashMap<Integer, String>();

    /**
     * Map holding constants for FirmwareUpdateActivationStatusReportFirmwareUpdateStatus
     */
    private static Map<Integer, String> constantFirmwareUpdateActivationStatusReportFirmwareUpdateStatus = new HashMap<Integer, String>();

    /**
     * Map holding constants for FirmwareUpdateMdReportProperties1
     */
    private static Map<Integer, String> constantFirmwareUpdateMdReportProperties1 = new HashMap<Integer, String>();

    /**
     * Map holding constants for FirmwareUpdateMdGetProperties1
     */
    private static Map<Integer, String> constantFirmwareUpdateMdGetProperties1 = new HashMap<Integer, String>();
    static {

        // Constants for FirmwareUpdateMdStatusReportStatus
        constantFirmwareUpdateMdStatusReportStatus.put(0xFE, "SUCCESSFULLY_STORED");
        constantFirmwareUpdateMdStatusReportStatus.put(0x00, "UNABLE_TO_RECEIVE_WITHOUT_CHECKSUM_ERROR");
        constantFirmwareUpdateMdStatusReportStatus.put(0xFF, "SUCCESSFULLY");
        constantFirmwareUpdateMdStatusReportStatus.put(0x01, "UNABLE_TO_RECEIVE");
        constantFirmwareUpdateMdStatusReportStatus.put(0x02, "DOES_NOT_MATCH_THE_MANUFACTURER_ID");
        constantFirmwareUpdateMdStatusReportStatus.put(0xFD, "SUCCESSFULLY_WAITING_FOR_ACTIVATION");
        constantFirmwareUpdateMdStatusReportStatus.put(0x03, "DOES_NOT_MATCH_THE_FIRMWARE_ID");
        constantFirmwareUpdateMdStatusReportStatus.put(0x04, "DOES_NOT_MATCH_THE_FIRMWARE_TARGET");
        constantFirmwareUpdateMdStatusReportStatus.put(0x05, "INVALID_FILE_HEADER_INFORMATION");
        constantFirmwareUpdateMdStatusReportStatus.put(0x06, "INVALID_FILE_HEADER_FORMAT");
        constantFirmwareUpdateMdStatusReportStatus.put(0x07, "INSUFFICIENT_MEMORY");

        // Constants for FirmwareUpdateMdRequestReportStatus
        constantFirmwareUpdateMdRequestReportStatus.put(0x00, "INVALID_COMBINATION");
        constantFirmwareUpdateMdRequestReportStatus.put(0xFF, "VALID_COMBINATION");
        constantFirmwareUpdateMdRequestReportStatus.put(0x01, "REQUIRES_AUTHENTICATION");
        constantFirmwareUpdateMdRequestReportStatus.put(0x02, "INVALID_FRAGMENT_SIZE");
        constantFirmwareUpdateMdRequestReportStatus.put(0x03, "NOT_UPGRADABLE");

        // Constants for FirmwareUpdateMdRequestGetProperties1
        constantFirmwareUpdateMdRequestGetProperties1.put(0x01, "ACTIVATION");

        // Constants for FirmwareUpdateActivationStatusReportFirmwareUpdateStatus
        constantFirmwareUpdateActivationStatusReportFirmwareUpdateStatus.put(0x00, "INVALID_COMBINATION");
        constantFirmwareUpdateActivationStatusReportFirmwareUpdateStatus.put(0xFF, "FIRMWARE_UPDATE_COMPLETED_SUCCESSFULLY");
        constantFirmwareUpdateActivationStatusReportFirmwareUpdateStatus.put(0x01, "ERROR_ACTIVATING_THE_FIRMWARE");

        // Constants for FirmwareUpdateMdReportProperties1
        constantFirmwareUpdateMdReportProperties1.put(0x80, "LAST");

        // Constants for FirmwareUpdateMdGetProperties1
        constantFirmwareUpdateMdGetProperties1.put(0x80, "ZERO");
    }

    /**
     * Creates a new message with the FIRMWARE_MD_GET command.
     * <p>
     * Firmware Md Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFirmwareMdGet() {
        logger.debug("Creating command message FIRMWARE_MD_GET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FIRMWARE_MD_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FIRMWARE_MD_GET command.
     * <p>
     * Firmware Md Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFirmwareMdGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the FIRMWARE_MD_REPORT command.
     * <p>
     * Firmware Md Report
     *
     * @param manufacturerId {@link Integer}
     * @param firmware0Id {@link Integer}
     * @param firmware0Checksum {@link Integer}
     * @param firmwareUpgradable {@link Integer}
     * @param numberOfFirmwareTargets {@link Integer}
     * @param maxFragmentSize {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFirmwareMdReport(Integer manufacturerId, Integer firmware0Id, Integer firmware0Checksum,
            Integer firmwareUpgradable, Integer numberOfFirmwareTargets, Integer maxFragmentSize) {
        logger.debug("Creating command message FIRMWARE_MD_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FIRMWARE_MD_REPORT);

        // Process 'Manufacturer ID'
        outputData.write((manufacturerId >> 8) & 0xff);
        outputData.write(manufacturerId & 0xff);

        // Process 'Firmware 0 ID'
        outputData.write((firmware0Id >> 8) & 0xff);
        outputData.write(firmware0Id & 0xff);

        // Process 'Firmware 0 Checksum'
        outputData.write((firmware0Checksum >> 8) & 0xff);
        outputData.write(firmware0Checksum & 0xff);

        // Process 'Firmware Upgradable'
        outputData.write(firmwareUpgradable);

        // Process 'Number of Firmware Targets'
        outputData.write(numberOfFirmwareTargets);

        // Process 'Max Fragment Size '
        outputData.write((maxFragmentSize >> 8) & 0xff);
        outputData.write(maxFragmentSize & 0xff);

        // Process 'vg1'

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FIRMWARE_MD_REPORT command.
     * <p>
     * Firmware Md Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>MANUFACTURER_ID {@link Integer}
     * <li>FIRMWARE_0_ID {@link Integer}
     * <li>FIRMWARE_0_CHECKSUM {@link Integer}
     * <li>FIRMWARE_UPGRADABLE {@link Integer}
     * <li>NUMBER_OF_FIRMWARE_TARGETS {@link Integer}
     * <li>MAX_FRAGMENT_SIZE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFirmwareMdReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Manufacturer ID'
        response.put("MANUFACTURER_ID", Integer.valueOf(((payload[2] & 0xff) << 8) + (payload[3] & 0xff)));

        // Process 'Firmware 0 ID'
        response.put("FIRMWARE_0_ID", Integer.valueOf(((payload[4] & 0xff) << 8) + (payload[5] & 0xff)));

        // Process 'Firmware 0 Checksum'
        response.put("FIRMWARE_0_CHECKSUM", Integer.valueOf(((payload[6] & 0xff) << 8) + (payload[7] & 0xff)));

        // Process 'Firmware Upgradable'
        response.put("FIRMWARE_UPGRADABLE", Integer.valueOf(payload[8]));

        // Process 'Number of Firmware Targets'
        response.put("NUMBER_OF_FIRMWARE_TARGETS", Integer.valueOf(payload[9]));

        // Process 'Max Fragment Size '
        response.put("MAX_FRAGMENT_SIZE", Integer.valueOf(((payload[10] & 0xff) << 8) + (payload[11] & 0xff)));

        // Process 'vg1'

        // Create a list to hold the group vg1
        List<Map<String, Object>> variantList = new ArrayList<Map<String, Object>>();

        int offset = 12;
        while (offset < payload.length) {
            // Create a map to hold the members of this variant
            Map<String, Object> variant = new HashMap<String, Object>();

            // Process 'Firmware ID'
            variant.put("FIRMWARE_ID", Integer.valueOf(((payload[12] & 0xff) << 8) + (payload[13] & 0xff)));

            // Add to the list
            variantList.add(variant);

            // Add the length of this variant
            offset += (payload[offset + 4] & 0xFF) >> 0;
        }

        // Add the variant list to the response
        response.put("VG1", variantList);

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the FIRMWARE_UPDATE_MD_REQUEST_GET command.
     * <p>
     * Firmware Update Md Request Get
     *
     * @param manufacturerId {@link Integer}
     * @param firmwareId {@link Integer}
     * @param checksum {@link Integer}
     * @param firmwareTarget {@link Integer}
     * @param fragmentSize {@link Integer}
     * @param activation {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFirmwareUpdateMdRequestGet(Integer manufacturerId, Integer firmwareId, Integer checksum,
            Integer firmwareTarget, Integer fragmentSize, Boolean activation) {
        logger.debug("Creating command message FIRMWARE_UPDATE_MD_REQUEST_GET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FIRMWARE_UPDATE_MD_REQUEST_GET);

        // Process 'Manufacturer ID'
        outputData.write((manufacturerId >> 8) & 0xff);
        outputData.write(manufacturerId & 0xff);

        // Process 'Firmware ID'
        outputData.write((firmwareId >> 8) & 0xff);
        outputData.write(firmwareId & 0xff);

        // Process 'Checksum'
        outputData.write((checksum >> 8) & 0xff);
        outputData.write(checksum & 0xff);

        // Process 'Firmware Target'
        outputData.write(firmwareTarget);

        // Process 'Fragment Size'
        outputData.write((fragmentSize >> 8) & 0xff);
        outputData.write(fragmentSize & 0xff);

        // Process 'Properties1'
        outputData.write(activation ? 0x01 : 0);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FIRMWARE_UPDATE_MD_REQUEST_GET command.
     * <p>
     * Firmware Update Md Request Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>MANUFACTURER_ID {@link Integer}
     * <li>FIRMWARE_ID {@link Integer}
     * <li>CHECKSUM {@link Integer}
     * <li>FIRMWARE_TARGET {@link Integer}
     * <li>FRAGMENT_SIZE {@link Integer}
     * <li>ACTIVATION {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFirmwareUpdateMdRequestGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Manufacturer ID'
        response.put("MANUFACTURER_ID", Integer.valueOf(((payload[2] & 0xff) << 8) + (payload[3] & 0xff)));

        // Process 'Firmware ID'
        response.put("FIRMWARE_ID", Integer.valueOf(((payload[4] & 0xff) << 8) + (payload[5] & 0xff)));

        // Process 'Checksum'
        response.put("CHECKSUM", Integer.valueOf(((payload[6] & 0xff) << 8) + (payload[7] & 0xff)));

        // Process 'Firmware Target'
        response.put("FIRMWARE_TARGET", Integer.valueOf(payload[8]));

        // Process 'Fragment Size'
        response.put("FRAGMENT_SIZE", Integer.valueOf(((payload[9] & 0xff) << 8) + (payload[10] & 0xff)));

        // Process 'Properties1'
        response.put("ACTIVATION", Boolean.valueOf((payload[11] & 0x01) != 0));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the FIRMWARE_UPDATE_MD_REQUEST_REPORT command.
     * <p>
     * Firmware Update Md Request Report
     *
     * @param status {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>INVALID_COMBINATION
     *            <li>VALID_COMBINATION
     *            <li>REQUIRES_AUTHENTICATION
     *            <li>INVALID_FRAGMENT_SIZE
     *            <li>NOT_UPGRADABLE
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFirmwareUpdateMdRequestReport(String status) {
        logger.debug("Creating command message FIRMWARE_UPDATE_MD_REQUEST_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FIRMWARE_UPDATE_MD_REQUEST_REPORT);

        // Process 'Status'
        boolean foundStatus = false;
        for (Integer entry : constantFirmwareUpdateMdRequestReportStatus.keySet()) {
            if (constantFirmwareUpdateMdRequestReportStatus.get(entry).equals(status)) {
                outputData.write(entry);
                foundStatus = true;
                break;
            }
        }
        if (!foundStatus) {
            throw new IllegalArgumentException("Unknown constant value '" + status + "' for status");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FIRMWARE_UPDATE_MD_REQUEST_REPORT command.
     * <p>
     * Firmware Update Md Request Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>STATUS {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFirmwareUpdateMdRequestReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Status'
        response.put("STATUS", constantFirmwareUpdateMdRequestReportStatus.get(payload[2] & 0xff));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the FIRMWARE_UPDATE_MD_GET command.
     * <p>
     * Firmware Update Md Get
     *
     * @param numberOfReports {@link Integer}
     * @param reportNumber1 {@link Integer}
     * @param zero {@link Boolean}
     * @param reportNumber2 {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFirmwareUpdateMdGet(Integer numberOfReports, Integer reportNumber1, Boolean zero,
            Integer reportNumber2) {
        logger.debug("Creating command message FIRMWARE_UPDATE_MD_GET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FIRMWARE_UPDATE_MD_GET);

        // Process 'Number of Reports'
        outputData.write(numberOfReports);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= reportNumber1 & 0x7F;
        valProperties1 |= zero ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Report number 2'
        outputData.write(reportNumber2);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FIRMWARE_UPDATE_MD_GET command.
     * <p>
     * Firmware Update Md Get
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>NUMBER_OF_REPORTS {@link Integer}
     * <li>REPORT_NUMBER_1 {@link Integer}
     * <li>ZERO {@link Boolean}
     * <li>REPORT_NUMBER_2 {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFirmwareUpdateMdGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Number of Reports'
        response.put("NUMBER_OF_REPORTS", Integer.valueOf(payload[2]));

        // Process 'Properties1'
        response.put("REPORT_NUMBER_1", Integer.valueOf(payload[3] & 0x7F));
        response.put("ZERO", Boolean.valueOf((payload[3] & 0x80) != 0));

        // Process 'Report number 2'
        response.put("REPORT_NUMBER_2", Integer.valueOf(payload[4]));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the FIRMWARE_UPDATE_MD_REPORT command.
     * <p>
     * Firmware Update Md Report
     *
     * @param reportNumber1 {@link Integer}
     * @param last {@link Boolean}
     * @param reportNumber2 {@link Integer}
     * @param data {@link byte[]}
     * @param checksum {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFirmwareUpdateMdReport(Integer reportNumber1, Boolean last, Integer reportNumber2,
            byte[] data, Integer checksum) {
        logger.debug("Creating command message FIRMWARE_UPDATE_MD_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FIRMWARE_UPDATE_MD_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= reportNumber1 & 0x7F;
        valProperties1 |= last ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Report number 2'
        outputData.write(reportNumber2);

        // Process 'Data'
        if (data != null) {
            try {
                outputData.write(data);
            } catch (IOException e) {
            }
        }

        // Process 'Checksum'
        outputData.write((checksum >> 8) & 0xff);
        outputData.write(checksum & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FIRMWARE_UPDATE_MD_REPORT command.
     * <p>
     * Firmware Update Md Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>REPORT_NUMBER_1 {@link Integer}
     * <li>LAST {@link Boolean}
     * <li>REPORT_NUMBER_2 {@link Integer}
     * <li>DATA {@link byte[]}
     * <li>CHECKSUM {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFirmwareUpdateMdReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("REPORT_NUMBER_1", Integer.valueOf(payload[msgOffset] & 0x7F));
        response.put("LAST", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Report number 2'
        response.put("REPORT_NUMBER_2", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Data'
        ByteArrayOutputStream valData = new ByteArrayOutputStream();
        while (msgOffset < payload.length - 2) {
            valData.write(payload[msgOffset]);
            msgOffset++;
        }
        response.put("DATA", valData);

        // Process 'Checksum'
        response.put("CHECKSUM", Integer.valueOf(((payload[msgOffset] & 0xff) << 8) + (payload[msgOffset + 1] & 0xff)));
        msgOffset += 2;

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the FIRMWARE_UPDATE_MD_STATUS_REPORT command.
     * <p>
     * Firmware Update Md Status Report
     *
     * @param status {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>SUCCESSFULLY_STORED
     *            <li>UNABLE_TO_RECEIVE_WITHOUT_CHECKSUM_ERROR
     *            <li>SUCCESSFULLY
     *            <li>UNABLE_TO_RECEIVE
     *            <li>DOES_NOT_MATCH_THE_MANUFACTURER_ID
     *            <li>SUCCESSFULLY_WAITING_FOR_ACTIVATION
     *            <li>DOES_NOT_MATCH_THE_FIRMWARE_ID
     *            <li>DOES_NOT_MATCH_THE_FIRMWARE_TARGET
     *            <li>INVALID_FILE_HEADER_INFORMATION
     *            <li>INVALID_FILE_HEADER_FORMAT
     *            <li>INSUFFICIENT_MEMORY
     *            </ul>
     * @param waittime {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFirmwareUpdateMdStatusReport(String status, Integer waittime) {
        logger.debug("Creating command message FIRMWARE_UPDATE_MD_STATUS_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FIRMWARE_UPDATE_MD_STATUS_REPORT);

        // Process 'Status'
        boolean foundStatus = false;
        for (Integer entry : constantFirmwareUpdateMdStatusReportStatus.keySet()) {
            if (constantFirmwareUpdateMdStatusReportStatus.get(entry).equals(status)) {
                outputData.write(entry);
                foundStatus = true;
                break;
            }
        }
        if (!foundStatus) {
            throw new IllegalArgumentException("Unknown constant value '" + status + "' for status");
        }

        // Process 'WaitTime'
        outputData.write((waittime >> 8) & 0xff);
        outputData.write(waittime & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FIRMWARE_UPDATE_MD_STATUS_REPORT command.
     * <p>
     * Firmware Update Md Status Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>STATUS {@link String}
     * <li>WAITTIME {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFirmwareUpdateMdStatusReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Status'
        response.put("STATUS", constantFirmwareUpdateMdStatusReportStatus.get(payload[2] & 0xff));

        // Process 'WaitTime'
        response.put("WAITTIME", Integer.valueOf(((payload[3] & 0xff) << 8) + (payload[4] & 0xff)));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the FIRMWARE_UPDATE_ACTIVATION_SET command.
     * <p>
     * Firmware Update Activation Set Command
     *
     * @param manufacturerId {@link Integer}
     * @param firmwareId {@link Integer}
     * @param checksum {@link Integer}
     * @param firmwareTarget {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFirmwareUpdateActivationSet(Integer manufacturerId, Integer firmwareId, Integer checksum,
            Integer firmwareTarget) {
        logger.debug("Creating command message FIRMWARE_UPDATE_ACTIVATION_SET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FIRMWARE_UPDATE_ACTIVATION_SET);

        // Process 'Manufacturer ID'
        outputData.write((manufacturerId >> 8) & 0xff);
        outputData.write(manufacturerId & 0xff);

        // Process 'Firmware ID'
        outputData.write((firmwareId >> 8) & 0xff);
        outputData.write(firmwareId & 0xff);

        // Process 'Checksum'
        outputData.write((checksum >> 8) & 0xff);
        outputData.write(checksum & 0xff);

        // Process 'Firmware Target'
        outputData.write(firmwareTarget);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FIRMWARE_UPDATE_ACTIVATION_SET command.
     * <p>
     * Firmware Update Activation Set Command
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>MANUFACTURER_ID {@link Integer}
     * <li>FIRMWARE_ID {@link Integer}
     * <li>CHECKSUM {@link Integer}
     * <li>FIRMWARE_TARGET {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFirmwareUpdateActivationSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Manufacturer ID'
        response.put("MANUFACTURER_ID", Integer.valueOf(((payload[2] & 0xff) << 8) + (payload[3] & 0xff)));

        // Process 'Firmware ID'
        response.put("FIRMWARE_ID", Integer.valueOf(((payload[4] & 0xff) << 8) + (payload[5] & 0xff)));

        // Process 'Checksum'
        response.put("CHECKSUM", Integer.valueOf(((payload[6] & 0xff) << 8) + (payload[7] & 0xff)));

        // Process 'Firmware Target'
        response.put("FIRMWARE_TARGET", Integer.valueOf(payload[8]));

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the FIRMWARE_UPDATE_ACTIVATION_STATUS_REPORT command.
     * <p>
     * Firmware Update Activation Status Report
     *
     * @param manufacturerId {@link Integer}
     * @param firmwareId {@link Integer}
     * @param checksum {@link Integer}
     * @param firmwareTarget {@link Integer}
     * @param firmwareUpdateStatus {@link String}
     *            Can be one of the following -:
     *            <ul>
     *            <li>INVALID_COMBINATION
     *            <li>FIRMWARE_UPDATE_COMPLETED_SUCCESSFULLY
     *            <li>ERROR_ACTIVATING_THE_FIRMWARE
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getFirmwareUpdateActivationStatusReport(Integer manufacturerId, Integer firmwareId,
            Integer checksum, Integer firmwareTarget, String firmwareUpdateStatus) {
        logger.debug("Creating command message FIRMWARE_UPDATE_ACTIVATION_STATUS_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(FIRMWARE_UPDATE_ACTIVATION_STATUS_REPORT);

        // Process 'Manufacturer ID'
        outputData.write((manufacturerId >> 8) & 0xff);
        outputData.write(manufacturerId & 0xff);

        // Process 'Firmware ID'
        outputData.write(firmwareId);

        // Process 'Checksum'
        outputData.write((checksum >> 8) & 0xff);
        outputData.write(checksum & 0xff);

        // Process 'Firmware Target'
        outputData.write(firmwareTarget);

        // Process 'Firmware Update Status'
        boolean foundFirmwareUpdateStatus = false;
        for (Integer entry : constantFirmwareUpdateActivationStatusReportFirmwareUpdateStatus.keySet()) {
            if (constantFirmwareUpdateActivationStatusReportFirmwareUpdateStatus.get(entry).equals(firmwareUpdateStatus)) {
                outputData.write(entry);
                foundFirmwareUpdateStatus = true;
                break;
            }
        }
        if (!foundFirmwareUpdateStatus) {
            throw new IllegalArgumentException("Unknown constant value '" + firmwareUpdateStatus + "' for firmwareUpdateStatus");
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the FIRMWARE_UPDATE_ACTIVATION_STATUS_REPORT command.
     * <p>
     * Firmware Update Activation Status Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>MANUFACTURER_ID {@link Integer}
     * <li>FIRMWARE_ID {@link Integer}
     * <li>CHECKSUM {@link Integer}
     * <li>FIRMWARE_TARGET {@link Integer}
     * <li>FIRMWARE_UPDATE_STATUS {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleFirmwareUpdateActivationStatusReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Manufacturer ID'
        response.put("MANUFACTURER_ID", Integer.valueOf(((payload[2] & 0xff) << 8) + (payload[3] & 0xff)));

        // Process 'Firmware ID'
        response.put("FIRMWARE_ID", Integer.valueOf(payload[4]));

        // Process 'Checksum'
        response.put("CHECKSUM", Integer.valueOf(((payload[5] & 0xff) << 8) + (payload[6] & 0xff)));

        // Process 'Firmware Target'
        response.put("FIRMWARE_TARGET", Integer.valueOf(payload[7]));

        // Process 'Firmware Update Status'
        response.put("FIRMWARE_UPDATE_STATUS", constantFirmwareUpdateActivationStatusReportFirmwareUpdateStatus.get(payload[8] & 0xff));

        // Return the map of processed response data;
        return response;
    }

}
