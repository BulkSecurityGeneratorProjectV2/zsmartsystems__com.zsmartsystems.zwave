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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_BASIC_TARIFF_INFO</b> version <b>1</b>.
 * <p>
 * Command Class Basic Tariff Info
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x36.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassBasicTariffInfoV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassBasicTariffInfoV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_BASIC_TARIFF_INFO
     */
    public final static int COMMAND_CLASS_KEY = 0x36;

    /**
     * Basic Tariff Info Get Command Constant
     */
    public final static int BASIC_TARIFF_INFO_GET = 0x01;
    /**
     * Basic Tariff Info Report Command Constant
     */
    public final static int BASIC_TARIFF_INFO_REPORT = 0x02;


    /**
     * Map holding constants for BasicTariffInfoReportProperties1
     */
    private static Map<Integer, String> constantBasicTariffInfoReportProperties1 = new HashMap<Integer, String>();
    static {

        // Constants for BasicTariffInfoReportProperties1
        constantBasicTariffInfoReportProperties1.put(0x80, "DUAL");
    }

    /**
     * Creates a new message with the BASIC_TARIFF_INFO_GET command.
     * <p>
     * Basic Tariff Info Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getBasicTariffInfoGet() {
        logger.debug("Creating command message BASIC_TARIFF_INFO_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(BASIC_TARIFF_INFO_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the BASIC_TARIFF_INFO_GET command.
     * <p>
     * Basic Tariff Info Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleBasicTariffInfoGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }


    /**
     * Creates a new message with the BASIC_TARIFF_INFO_REPORT command.
     * <p>
     * Basic Tariff Info Report
     *
     * @param totalNoImportRates {@link Integer}
     * @param dual {@link Boolean}
     * @param e1CurrentRateInUse {@link Integer}
     * @param e1RateConsumptionRegister {@link Long}
     * @param e1TimeForNextRateHours {@link Integer}
     * @param e1TimeForNextRateMinutes {@link Integer}
     * @param e1TimeForNextRateSeconds {@link Integer}
     * @param e2CurrentRateInUse {@link Integer}
     * @param e2RateConsumptionRegister {@link Long}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getBasicTariffInfoReport(Integer totalNoImportRates, Boolean dual, Integer e1CurrentRateInUse,
            Long e1RateConsumptionRegister, Integer e1TimeForNextRateHours, Integer e1TimeForNextRateMinutes,
            Integer e1TimeForNextRateSeconds, Integer e2CurrentRateInUse, Long e2RateConsumptionRegister) {
        logger.debug("Creating command message BASIC_TARIFF_INFO_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(BASIC_TARIFF_INFO_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= totalNoImportRates & 0x0F;
        valProperties1 |= dual ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Properties2'
        outputData.write(e1CurrentRateInUse & 0x0F);

        // Process 'E1 Rate Consumption Register'
        outputData.write((byte) ((e1RateConsumptionRegister >> 24) & 0xff));
        outputData.write((byte) ((e1RateConsumptionRegister >> 16) & 0xff));
        outputData.write((byte) ((e1RateConsumptionRegister >> 8) & 0xff));
        outputData.write((byte) (e1RateConsumptionRegister & 0xff));

        // Process 'E1 Time for Next Rate Hours'
        outputData.write(e1TimeForNextRateHours);

        // Process 'E1 Time for Next Rate Minutes'
        outputData.write(e1TimeForNextRateMinutes);

        // Process 'E1 Time for Next Rate Seconds'
        outputData.write(e1TimeForNextRateSeconds);

        // Process 'Properties3'
        outputData.write(e2CurrentRateInUse & 0x0F);

        // Process 'E2 Rate Consumption Register'
        outputData.write((byte) ((e2RateConsumptionRegister >> 24) & 0xff));
        outputData.write((byte) ((e2RateConsumptionRegister >> 16) & 0xff));
        outputData.write((byte) ((e2RateConsumptionRegister >> 8) & 0xff));
        outputData.write((byte) (e2RateConsumptionRegister & 0xff));

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the BASIC_TARIFF_INFO_REPORT command.
     * <p>
     * Basic Tariff Info Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>TOTAL_NO_IMPORT_RATES {@link Integer}
     * <li>DUAL {@link Boolean}
     * <li>E1_CURRENT_RATE_IN_USE {@link Integer}
     * <li>E1_RATE_CONSUMPTION_REGISTER {@link Long}
     * <li>E1_TIME_FOR_NEXT_RATE_HOURS {@link Integer}
     * <li>E1_TIME_FOR_NEXT_RATE_MINUTES {@link Integer}
     * <li>E1_TIME_FOR_NEXT_RATE_SECONDS {@link Integer}
     * <li>E2_CURRENT_RATE_IN_USE {@link Integer}
     * <li>E2_RATE_CONSUMPTION_REGISTER {@link Long}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleBasicTariffInfoReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("TOTAL_NO_IMPORT_RATES", Integer.valueOf(payload[2] & 0x0F));
        response.put("DUAL", Boolean.valueOf((payload[2] & 0x80) != 0));

        // Process 'Properties2'
        response.put("E1_CURRENT_RATE_IN_USE", Integer.valueOf(payload[3] & 0x0F));

        // Process 'E1 Rate Consumption Register'
        response.put("E1_RATE_CONSUMPTION_REGISTER", Long.valueOf((payload[4] << 24) + (payload[5] << 16) + (payload[6] << 8) + payload[7]));

        // Process 'E1 Time for Next Rate Hours'
        response.put("E1_TIME_FOR_NEXT_RATE_HOURS", Integer.valueOf(payload[8]));

        // Process 'E1 Time for Next Rate Minutes'
        response.put("E1_TIME_FOR_NEXT_RATE_MINUTES", Integer.valueOf(payload[9]));

        // Process 'E1 Time for Next Rate Seconds'
        response.put("E1_TIME_FOR_NEXT_RATE_SECONDS", Integer.valueOf(payload[10]));

        // Process 'Properties3'
        response.put("E2_CURRENT_RATE_IN_USE", Integer.valueOf(payload[11] & 0x0F));

        // Process 'E2 Rate Consumption Register'
        response.put("E2_RATE_CONSUMPTION_REGISTER", Long.valueOf((payload[12] << 24) + (payload[13] << 16) + (payload[14] << 8) + payload[15]));

        // Return the map of processed response data;
        return response;
    }

}
