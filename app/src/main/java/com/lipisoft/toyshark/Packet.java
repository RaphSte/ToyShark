/*
 *  Copyright 2014 AT&T
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package com.lipisoft.toyshark;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.lipisoft.toyshark.application.IApplication;
import com.lipisoft.toyshark.network.ip.IPv4Header;
import com.lipisoft.toyshark.transport.ITransportHeader;

/**
 * Data structure that encapsulate both IPv4Header and TCPHeader
 * @author Borey Sao
 * Date: May 27, 2014
 */
public class Packet {
	@NonNull private IPv4Header ipHeader;
	@NonNull private ITransportHeader transportHeader;
	@Nullable private IApplication application;
	@NonNull private byte[] buffer;

//	public Packet(IPv4Header ipHeader, ITransportHeader transportHeader, IApplication application, byte[] data) {
	public Packet(@NonNull IPv4Header ipHeader, @NonNull ITransportHeader transportHeader, @NonNull byte[] data) {
		this.ipHeader = ipHeader;
		this.transportHeader = transportHeader;
		this.application = application;
		buffer = data;
	}

	public byte getProtocol() {
		return ipHeader.getProtocol();
	}

	@NonNull
	public ITransportHeader getTransportHeader() {
		return transportHeader;
	}

	public int getSourcePort() {
		return transportHeader.getSourcePort();
	}

	public int getDestinationPort() {
		return transportHeader.getDestinationPort();
	}

	@NonNull
	public IPv4Header getIpHeader() {
		return ipHeader;
	}

	/**
	 * the whole packet data as an array of byte
	 * @return byte[]
	 */
	@NonNull
	public byte[] getBuffer() {
		return buffer;
	}

	@Nullable
	public IApplication getApplication() {
		return application;
	}
}
