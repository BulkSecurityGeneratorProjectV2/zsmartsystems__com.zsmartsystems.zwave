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
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_ZIP</b> version <b>2</b>.
 * <p>
 * Command Class Z/IP
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x23.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassZipV2 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassZipV2.class);

    /**
     * Integer command class key for COMMAND_CLASS_ZIP
     */
    public final static int COMMAND_CLASS_KEY = 0x23;

    /**
     * Zip Packet Command Constant
     */
    public final static int COMMAND_ZIP_PACKET = 0x02;


    /**
     * Map holding constants for CommandZipPacketProperties1
     */
    private static Map<Integer, String> constantCommandZipPacketProperties1 = new HashMap<Integer, String>();

    /**
     * Map holding constants for CommandZipPacketProperties2
     */
    private static Map<Integer, String> constantCommandZipPacketProperties2 = new HashMap<Integer, String>();

    /**
     * Map holding constants for CommandZipPacketProperties3
     */
    private static Map<Integer, String> constantCommandZipPacketProperties3 = new HashMap<Integer, String>();

    /**
     * Map holding constants for CommandZipPacketProperties4
     */
    private static Map<Integer, String> constantCommandZipPacketProperties4 = new HashMap<Integer, String>();
    static {

        // Constants for CommandZipPacketProperties1
        constantCommandZipPacketProperties1.put(0x10, "NACK_WAITING");
        constantCommandZipPacketProperties1.put(0x20, "NACK_RESPONSE");
        constantCommandZipPacketProperties1.put(0x40, "ACK_RESPONSE");
        constantCommandZipPacketProperties1.put(0x04, "NACK_OPTION_ERROR");
        constantCommandZipPacketProperties1.put(0x08, "NACK_QUEUE_FULL");
        constantCommandZipPacketProperties1.put(0x80, "ACK_REQUEST");

        // Constants for CommandZipPacketProperties2
        constantCommandZipPacketProperties2.put(0x10, "SECURE_ORIGIN");
        constantCommandZipPacketProperties2.put(0x20, "MORE_INFORMATION");
        constantCommandZipPacketProperties2.put(0x40, "Z_WAVE_CMD_INCLUDED");
        constantCommandZipPacketProperties2.put(0x80, "HEADER_EXT_INCLUDED");

        // Constants for CommandZipPacketProperties3

        // Constants for CommandZipPacketProperties4
        constantCommandZipPacketProperties4.put(0x80, "BIT_ADDRESS");
    }

    /**
     * Creates a new message with the COMMAND_ZIP_PACKET command.
     * <p>
     * Zip Packet
     *
     * @param nackOptionError {@link Boolean}
     * @param nackQueueFull {@link Boolean}
     * @param nackWaiting {@link Boolean}
     * @param nackResponse {@link Boolean}
     * @param ackResponse {@link Boolean}
     * @param ackRequest {@link Boolean}
     * @param secureOrigin {@link Boolean}
     * @param moreInformation {@link Boolean}
     * @param zWaveCmdIncluded {@link Boolean}
     * @param headerExtIncluded {@link Boolean}
     * @param seqNo {@link Integer}
     * @param sourceEndPoint {@link Integer}
     * @param destinationEndPoint {@link Integer}
     * @param bitAddress {@link Boolean}
     * @param headerLength {@link Integer}
     * @param headerExtension {@link byte[]}
     * @param zWaveCommand {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getCommandZipPacket(Boolean nackOptionError, Boolean nackQueueFull, Boolean nackWaiting,
            Boolean nackResponse, Boolean ackResponse, Boolean ackRequest, Boolean secureOrigin, Boolean moreInformation,
            Boolean zWaveCmdIncluded, Boolean headerExtIncluded, Integer seqNo, Integer sourceEndPoint,
            Integer destinationEndPoint, Boolean bitAddress, Integer headerLength, byte[] headerExtension,
            byte[] zWaveCommand) {
        logger.debug("Creating command message COMMAND_ZIP_PACKET version 2");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(COMMAND_ZIP_PACKET);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= nackOptionError ? 0x04 : 0;
        valProperties1 |= nackQueueFull ? 0x08 : 0;
        valProperties1 |= nackWaiting ? 0x10 : 0;
        valProperties1 |= nackResponse ? 0x20 : 0;
        valProperties1 |= ackResponse ? 0x40 : 0;
        valProperties1 |= ackRequest ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Properties2'
        int valProperties2 = 0;
        valProperties2 |= secureOrigin ? 0x10 : 0;
        valProperties2 |= moreInformation ? 0x20 : 0;
        valProperties2 |= zWaveCmdIncluded ? 0x40 : 0;
        valProperties2 |= headerExtIncluded ? 0x80 : 0;
        outputData.write(valProperties2);

        // Process 'Seq No'
        outputData.write(seqNo);

        // Process 'Properties3'
        outputData.write(sourceEndPoint & 0x7F);

        // Process 'Properties4'
        int valProperties4 = 0;
        valProperties4 |= destinationEndPoint & 0x7F;
        valProperties4 |= bitAddress ? 0x80 : 0;
        outputData.write(valProperties4);

        // Process 'Header Length'
        outputData.write(headerLength);

        // Process 'Header extension'
        if (headerExtension != null) {
            try {
                outputData.write(headerExtension);
            } catch (IOException e) {
            }
        }

        // Process 'Z-Wave command'
        if (zWaveCommand != null) {
            try {
                outputData.write(zWaveCommand);
            } catch (IOException e) {
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the COMMAND_ZIP_PACKET command.
     * <p>
     * Zip Packet
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>NACK_OPTION_ERROR {@link Boolean}
     * <li>NACK_QUEUE_FULL {@link Boolean}
     * <li>NACK_WAITING {@link Boolean}
     * <li>NACK_RESPONSE {@link Boolean}
     * <li>ACK_RESPONSE {@link Boolean}
     * <li>ACK_REQUEST {@link Boolean}
     * <li>SECURE_ORIGIN {@link Boolean}
     * <li>MORE_INFORMATION {@link Boolean}
     * <li>Z_WAVE_CMD_INCLUDED {@link Boolean}
     * <li>HEADER_EXT_INCLUDED {@link Boolean}
     * <li>SEQ_NO {@link Integer}
     * <li>SOURCE_END_POINT {@link Integer}
     * <li>DESTINATION_END_POINT {@link Integer}
     * <li>BIT_ADDRESS {@link Boolean}
     * <li>HEADER_LENGTH {@link Integer}
     * <li>HEADER_EXTENSION {@link byte[]}
     * <li>Z_WAVE_COMMAND {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleCommandZipPacket(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("NACK_OPTION_ERROR", Boolean.valueOf((payload[msgOffset] & 0x04) != 0));
        response.put("NACK_QUEUE_FULL", Boolean.valueOf((payload[msgOffset] & 0x08) != 0));
        response.put("NACK_WAITING", Boolean.valueOf((payload[msgOffset] & 0x10) != 0));
        response.put("NACK_RESPONSE", Boolean.valueOf((payload[msgOffset] & 0x20) != 0));
        response.put("ACK_RESPONSE", Boolean.valueOf((payload[msgOffset] & 0x40) != 0));
        response.put("ACK_REQUEST", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Properties2'
        response.put("SECURE_ORIGIN", Boolean.valueOf((payload[msgOffset] & 0x10) != 0));
        response.put("MORE_INFORMATION", Boolean.valueOf((payload[msgOffset] & 0x20) != 0));
        response.put("Z_WAVE_CMD_INCLUDED", Boolean.valueOf((payload[msgOffset] & 0x40) != 0));
        response.put("HEADER_EXT_INCLUDED", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Seq No'
        response.put("SEQ_NO", Integer.valueOf(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Properties3'
        response.put("SOURCE_END_POINT", Integer.valueOf(payload[msgOffset] & 0x7F));
        msgOffset += 1;

        // Process 'Properties4'
        response.put("DESTINATION_END_POINT", Integer.valueOf(payload[msgOffset] & 0x7F));
        response.put("BIT_ADDRESS", Boolean.valueOf((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Header Length' (optional)
        if (true) {
            response.put("HEADER_LENGTH", Integer.valueOf(payload[msgOffset]));
        }
        msgOffset += 1;

        // Process 'Header extension' (optional)
        if (true) {
            ByteArrayOutputStream valHeaderExtension = new ByteArrayOutputStream();
            int lenHeaderExtension = payload[msgOffset - 1];
            for (int cntHeaderExtension = 0; cntHeaderExtension < lenHeaderExtension; cntHeaderExtension++) {
                valHeaderExtension.write(payload[msgOffset + cntHeaderExtension]);
            }
            response.put("HEADER_EXTENSION", valHeaderExtension.toByteArray());
            msgOffset += lenHeaderExtension;
        }

        // Process 'Z-Wave command' (optional)
        if (true) {
            ByteArrayOutputStream valZWaveCommand = new ByteArrayOutputStream();
            while (msgOffset < payload.length) {
                valZWaveCommand.write(payload[msgOffset]);
                msgOffset++;
            }
            response.put("Z_WAVE_COMMAND", valZWaveCommand);
        }

        // Return the map of processed response data;
        return response;
    }

}
