package com.cantinho.cms.sqs;

import com.cantinho.cms.bean.Message;

import java.util.List;

/**
 * Copyright 2016 Cantinho. All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * @author Samir Trajano Feitosa
 * @author Jordão Ezequiel Serafim de Araújo
 * @author Cantinho - Github https://github.com/Cantinho
 * @since 2016
 * @license Apache 2.0
 *
 * This file is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.  For additional information regarding
 * copyright in this work, please see the NOTICE file in the top level
 * directory of this distribution.
 *
 */
public interface MessageQueue {

    void createMessageQueue(final String queueName) throws Exception;

    void setMessageQueueClassName(final String messageQueueClassName);

    boolean produceMessageToMaster(final String masterId, final Message message) throws Exception;

    Message peekMessageOfMaster(final String masterId) throws Exception;

    Message consumeMessageOfMaster(final String masterId) throws Exception;

    List<Message> consumeMessageOfMaster(final String masterId, final int amount) throws Exception;

    boolean produceMessageToSlave(final String masterId, final String slaveId, Message message) throws Exception;

    boolean broadcastMessageToSlave(String masterId, String slaveId, Message message) throws Exception;

    Message peekMessageOfSlave(final String masterId, final String slaveId) throws Exception;

    Message consumeMessageOfSlave(final String masterId, final String slaceId) throws Exception;

    List<Message> consumeMessageOfSlave(final String masterId, final String slaveId, final int amount) throws Exception;

    String addSlaveMessageQueue(String masterId, String slaveId) throws Exception;

    List<String> listMessageQueues();

}
