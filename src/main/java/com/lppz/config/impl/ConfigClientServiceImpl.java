package com.lppz.config.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.otter.shared.common.model.config.channel.ChannelParameter.RemedyAlgorithm;
import com.alibaba.otter.shared.common.model.config.channel.ChannelParameter.SyncConsistency;
import com.alibaba.otter.shared.common.model.config.channel.ChannelParameter.SyncMode;
import com.alibaba.otter.shared.common.model.config.data.DataMediaPair;
import com.alibaba.otter.shared.common.model.config.node.Node;
import com.alibaba.otter.shared.common.model.config.parameter.SystemParameter.RetrieverType;
import com.alibaba.otter.shared.common.model.config.pipeline.Pipeline;
import com.alibaba.otter.shared.common.model.config.pipeline.PipelineParameter;
import com.alibaba.otter.shared.common.model.config.pipeline.PipelineParameter.ArbitrateMode;
import com.alibaba.otter.shared.common.model.config.pipeline.PipelineParameter.LoadBanlanceAlgorithm;
import com.alibaba.otter.shared.common.model.config.pipeline.PipelineParameter.PipeChooseMode;
import com.alibaba.otter.shared.common.model.config.pipeline.PipelineParameter.SelectorMode;
import com.lppz.config.ConfigClientService;

@Service
public class ConfigClientServiceImpl implements ConfigClientService {

	@Override
	public Pipeline findPipeline(Long pipelineId) {
		Pipeline pipeline = new Pipeline();
		pipeline.setChannelId(1L);
		pipeline.setDescription("");
		pipeline.setExtractNodes(buildExtractNodes());
		pipeline.setGmtCreate(new Date());
		pipeline.setGmtModified(new Date());
		pipeline.setId(1L);
		pipeline.setLoadNodes(buildLoadNodes());
		pipeline.setName("defaultPinpeline");
		pipeline.setPairs(buildPairs());
		pipeline.setParameters(buildParameters());
		pipeline.setSelectNodes(buildSelectNodes());
		return pipeline;
	}
	
	private List<DataMediaPair> buildPairs() {
		// TODO Auto-generated method stub
		return null;
	}

	private PipelineParameter buildParameters() {
		PipelineParameter parameter = new PipelineParameter();
		parameter.setArbitrateMode(buildArbitrateMode());
		parameter.setBatchTimeout(5000L);
		parameter.setChannelInfo("this is channelinfo");
		parameter.setDdlSync(false);
		parameter.setDestinationName("d name");
		parameter.setDryRun(false);
		parameter.setDumpEvent(false);
		parameter.setDumpSelector(false);
		parameter.setDumpSelectorDetail(false);
		parameter.setEnableCompatibleMissColumn(false);
		parameter.setEnableRemedy(false);
		parameter.setExtractPoolSize(10);
		parameter.setExtractPoolSize(10);
		parameter.setFileDetect(false);
		parameter.setFileLoadPoolSize(10);
		parameter.setHome(false);
		parameter.setLbAlgorithm(buildLbAlgorithm());
		parameter.setLoadPoolSize(10);
		parameter.setMainstemBatchsize(10);
		parameter.setMainstemClientId((short)1);
		parameter.setParallelism(1L);
		parameter.setPipeChooseType(buildPipeChooseMode());
		parameter.setPipelineId(1L);
		parameter.setRemedyAlgorithm(buildRemedyAlgorithm());
		parameter.setRemedyDelayThresoldForMedia(1);
		parameter.setRetriever(buildRetrieverType());
		parameter.setSelectorMode(buildSelectMode());
		parameter.setSkipDdlException(false);
		parameter.setSkipFreedom(false);
		parameter.setSkipLoadException(false);
		parameter.setSkipNoRow(false);
		parameter.setSkipSelectException(false);
		parameter.setSyncConsistency(buildSyncConsistency());
		parameter.setSyncMode(buildSyncMode());
		parameter.setUseBatch(false);
		parameter.setUseExternalIp(false);
		parameter.setUseFileEncrypt(false);
		parameter.setUseLocalFileMutliThread(false);
		parameter.setUseTableTransform(false);
		// TODO Auto-generated method stub
		return null;
	}
	
	private SyncMode buildSyncMode() {
		// TODO Auto-generated method stub
		return null;
	}

	private SyncConsistency buildSyncConsistency() {
		// TODO Auto-generated method stub
		return null;
	}

	private SelectorMode buildSelectMode() {
		// TODO Auto-generated method stub
		return null;
	}

	private RetrieverType buildRetrieverType() {
		// TODO Auto-generated method stub
		return null;
	}

	private RemedyAlgorithm buildRemedyAlgorithm() {
		// TODO Auto-generated method stub
		return null;
	}

	private PipeChooseMode buildPipeChooseMode() {
		// TODO Auto-generated method stub
		return null;
	}

	private LoadBanlanceAlgorithm buildLbAlgorithm() {
		// TODO Auto-generated method stub
		return null;
	}

	private ArbitrateMode buildArbitrateMode() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Node> buildSelectNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Node> buildExtractNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Node> buildLoadNodes() {
		// TODO Auto-generated method stub
		return null;
	}

}
