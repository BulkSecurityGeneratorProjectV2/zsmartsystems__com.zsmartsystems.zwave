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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_REMOTE_ASSOCIATION_ACTIVATE</b> version <b>1</b>.
 * <p>
 * Command Class Remote Association Activate
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x7C.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassRemoteAssociationActivateV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassRemoteAssociationActivateV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_REMOTE_ASSOCIATION_ACTIVATE
     */
    public final static int COMMAND_CLASS_KEY = 0x7C;

    /**
     * Remote Association Activate Command Constant
     */
    public final static int REMOTE_ASSOCIATION_ACTIVATE = 0x01;


    /**
     * Creates a new message with the REMOTE_ASSOCIATION_ACTIVATE command.
     * <p>
     * Remote Association Activate
     *
     * @param groupingIdentifier {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getRemoteAssociationActivate(Integer groupingIdentifier) {
        logger.debug("Creating command message REMOTE_ASSOCIATION_ACTIVATE version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(REMOTE_ASSOCIATION_ACTIVATE);

        // Process 'Grouping identifier'
        outputData.write(groupingIdentifier);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the REMOTE_ASSOCIATION_ACTIVATE command.
     * <p>
     * Remote Association Activate
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>GROUPING_IDENTIFIER {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleRemoteAssociationActivate(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Grouping identifier'
        response.put("GROUPING_IDENTIFIER", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }

}
