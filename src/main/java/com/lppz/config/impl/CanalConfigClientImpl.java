package com.lppz.config.impl;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.otter.canal.instance.manager.model.Canal;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.BatchMode;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.ClusterMode;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.DataSourcing;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.HAMode;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.IndexMode;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.MetaMode;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.RunMode;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.SourcingType;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.StorageMode;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.StorageScavengeMode;
import com.alibaba.otter.canal.instance.manager.model.CanalStatus;
import com.lppz.config.CanalConfigClient;

@Service
public class CanalConfigClientImpl implements CanalConfigClient {

	@Override
	public Canal findCanal(String destination) {
		Canal canal = new Canal();
		canal.setCanalParameter(buildCanalParameter());
		canal.setDesc("desc");
		canal.setGmtCreate(new Date());
		canal.setGmtModified(new Date());
		canal.setId(1L);
		canal.setName("canal name");
		canal.setStatus(CanalStatus.STOP);
		return canal;
	}

	private CanalParameter buildCanalParameter() {
		CanalParameter parameter = new CanalParameter();
		
		parameter.setApp("app");
		parameter.setBlackFilter("");
		parameter.setCanalId(1L);
		parameter.setClusterMode(buildClusterMode());
		parameter.setConnectionCharset("UTF-8");
//		parameter.setConnectionCharsetNumber(connectionCharsetNumber);
		parameter.setDbAddresses(buildDbAddresses());
		parameter.setDbPassword("mysqlroot");
		parameter.setDbUsername("root");
		parameter.setDdlIsolation(false);
		parameter.setDefaultConnectionTimeoutInSeconds(50);
		parameter.setDefaultDatabaseName("omsext");
		parameter.setDetectingEnable(false);
		parameter.setDetectingIntervalInSeconds(5);
		parameter.setDetectingRetryTimes(0);
		parameter.setDetectingSQL("");
		parameter.setDetectingTimeoutThresholdInSeconds(5);
		parameter.setFallbackIntervalInSeconds(10);
		parameter.setFileStorageDirectory("");
		parameter.setFileStoragePercentThresold(1);
		parameter.setFileStorageRollverCount(1);
		parameter.setFileStorageStoreCount(1);
		parameter.setFilterTableError(false);
		parameter.setGroup("");
		parameter.setGroupDbAddresses(buildGroupDbAddresses());
		parameter.setHaMode(buildHaMode());
		parameter.setHeartbeatHaEnable(false);
		parameter.setIndexMode(buildIndexMode());
		parameter.setLocalBinlogDirectory("");
		parameter.setMasterAddress(buildMasterAddress());
		parameter.setMasterLogfileName("");
		parameter.setMasterPassword("");
		parameter.setMasterTimestamp(new Date().getTime());
		parameter.setMasterUsername("");
		parameter.setMediaGroup("");
		parameter.setMemoryStorageBufferMemUnit(1000);
		parameter.setMemoryStorageBufferSize(100);
		parameter.setMetaMode(buildMetaMode());
		parameter.setMetaqStoreUri("");
		parameter.setPort(3306);
		parameter.setPositions(buildPositions());
		parameter.setReceiveBufferSize(1000);
		parameter.setRunMode(buildRunMode());
		parameter.setScavengeSchdule("");
		parameter.setSendBufferSize(1000);
		parameter.setSlaveId(1L);
		parameter.setSourcingType(buildSourcingType());
		parameter.setStandbyAddress(buildStandbyAddress());
		parameter.setStandbyLogfileName("");
		parameter.setStandbyLogfileOffest(1L);
		parameter.setStandbyPassword("");
		parameter.setStandbyTimestamp(new Date().getTime());
		parameter.setStandbyUsername("");
		parameter.setStorageBatchMode(BatchMode.ITEMSIZE);
		parameter.setStorageMode(StorageMode.MEMORY);
		parameter.setStorageScavengeMode(StorageScavengeMode.ON_ACK);
		parameter.setTransactionSize(1000);
		parameter.setZkClusterId(1L);
		parameter.setZkClusters(buildZkClusters());
		
		return parameter;
	}

	private List<String> buildZkClusters() {
		// TODO Auto-generated method stub
		return null;
	}

	private InetSocketAddress buildStandbyAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	private SourcingType buildSourcingType() {
		return SourcingType.MYSQL;
	}

	private RunMode buildRunMode() {
		return RunMode.SERVICE;
	}

	private List<String> buildPositions() {
		// TODO Auto-generated method stub
		return null;
	}

	private MetaMode buildMetaMode() {
		return MetaMode.MEMORY;
	}

	private InetSocketAddress buildMasterAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	private IndexMode buildIndexMode() {
		return IndexMode.MIXED;
	}

	private HAMode buildHaMode() {
		return HAMode.HEARTBEAT;
	}

	private List<List<DataSourcing>> buildGroupDbAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<InetSocketAddress> buildDbAddresses() {
		List<InetSocketAddress> addresses = new ArrayList<InetSocketAddress>();
		InetSocketAddress address = new InetSocketAddress("10.6.24.55", 3306);
		addresses.add(address);
		return addresses;
	}

	private ClusterMode buildClusterMode() {
		return ClusterMode.STANDALONE;
	}

}
