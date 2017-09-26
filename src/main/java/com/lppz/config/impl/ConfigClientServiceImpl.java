package com.lppz.config.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.otter.shared.common.model.autokeeper.AutoKeeperCluster;
import com.alibaba.otter.shared.common.model.config.ConfigException;
import com.alibaba.otter.shared.common.model.config.channel.Channel;
import com.alibaba.otter.shared.common.model.config.channel.ChannelParameter;
import com.alibaba.otter.shared.common.model.config.channel.ChannelParameter.RemedyAlgorithm;
import com.alibaba.otter.shared.common.model.config.channel.ChannelParameter.SyncConsistency;
import com.alibaba.otter.shared.common.model.config.channel.ChannelParameter.SyncMode;
import com.alibaba.otter.shared.common.model.config.channel.ChannelStatus;
import com.alibaba.otter.shared.common.model.config.data.DataMediaPair;
import com.alibaba.otter.shared.common.model.config.node.Node;
import com.alibaba.otter.shared.common.model.config.node.NodeParameter;
import com.alibaba.otter.shared.common.model.config.node.NodeStatus;
import com.alibaba.otter.shared.common.model.config.parameter.SystemParameter.RetrieverType;
import com.alibaba.otter.shared.common.model.config.pipeline.Pipeline;
import com.alibaba.otter.shared.common.model.config.pipeline.PipelineParameter;
import com.alibaba.otter.shared.common.model.config.pipeline.PipelineParameter.ArbitrateMode;
import com.alibaba.otter.shared.common.model.config.pipeline.PipelineParameter.LoadBanlanceAlgorithm;
import com.alibaba.otter.shared.common.model.config.pipeline.PipelineParameter.PipeChooseMode;
import com.alibaba.otter.shared.common.model.config.pipeline.PipelineParameter.SelectorMode;
import com.alibaba.otter.shared.common.utils.cache.RefreshMemoryMirror;
import com.alibaba.otter.shared.common.utils.cache.RefreshMemoryMirror.ComputeFunction;
import com.google.common.base.Function;
import com.google.common.collect.MapMaker;
import com.lppz.config.ConfigClientService;

@Service
public class ConfigClientServiceImpl implements ConfigClientService {
	private static final String                NID_NAME       = "nid";
	private static final Long                  DEFAULT_PERIOD = 60 * 1000L;
    private static final Logger                logger         = LoggerFactory.getLogger(ConfigClientServiceImpl.class);

    private Long                               timeout        = DEFAULT_PERIOD;
    private Long                               nid;
	private RefreshMemoryMirror<Long, Channel> channelCache;
	private Map<Long, Long>                    channelMapping; // 将pipelineId映射为channelId
	private RefreshMemoryMirror<Long, Node>    nodeCache;

	@Override
	public Pipeline findPipeline(Long pipelineId) {
		Long channelId = channelMapping.get(pipelineId);
        Channel channel = channelCache.get(channelId);
        List<Pipeline> pipelines = channel.getPipelines();
        for (Pipeline pipeline : pipelines) {
            if (pipeline.getId().equals(pipelineId)) {
                return pipeline;
            }
        }

        throw new ConfigException("no pipeline for pipelineId[" + pipelineId + "]");
	}
	
	private Pipeline buildPipeline(Long channelId, Long pipelineId){
		Pipeline pipeline = new Pipeline();
		pipeline.setChannelId(channelId);
		pipeline.setDescription("");
		pipeline.setExtractNodes(buildExtractNodes());
		pipeline.setGmtCreate(new Date());
		pipeline.setGmtModified(new Date());
		pipeline.setId(pipelineId);
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
		return RetrieverType.MR4J;
	}

	private RemedyAlgorithm buildRemedyAlgorithm() {
		// TODO Auto-generated method stub
		return null;
	}

	private PipeChooseMode buildPipeChooseMode() {
		return PipeChooseMode.AUTOMATIC;
	}

	private LoadBanlanceAlgorithm buildLbAlgorithm() {
		// TODO Auto-generated method stub
		return null;
	}

	private ArbitrateMode buildArbitrateMode() {
		return ArbitrateMode.AUTOMATIC;
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

	@Override
	public Channel findChannelByPipelineId(Long pipelineId) {
		Long channelId = channelMapping.get(pipelineId);
        return channelCache.get(channelId);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		 // 获取一下nid变量
        String nid = System.getProperty(NID_NAME);
        if (StringUtils.isEmpty(nid)) {
            throw new ConfigException("nid is not set!");
        }

        this.nid = Long.valueOf(nid);

        channelMapping = new MapMaker().makeComputingMap(new Function<Long, Long>() {

            public Long apply(Long pipelineId) {
                // 处理下pipline -> channel映射关系不存在的情况
                Channel channel = buildChannelByPipelineId(pipelineId);
                try {
                    if (channel != null) {
                        updateMapping(channel, pipelineId);// 排除下自己
                        channelCache.put(channel.getId(), channel);// 更新下channelCache
                        return channel.getId();
                    }
                } catch (Exception e) {
                    logger.error("call_manager_error", e);
                }

                throw new ConfigException("No Such Channel by pipelineId[" + pipelineId + "]");
            }

        });

        nodeCache = new RefreshMemoryMirror<Long, Node>(timeout, new ComputeFunction<Long, Node>() {

            public Node apply(Long key, Node oldValue) {
                try {
                	Node node = buildNodeByNid(key);
                    if (node != null) {
                        return node;
                    } else {
                        throw new ConfigException("No Such Node by id[" + key + "]");
                    }
                } catch (Exception e) {
                    logger.error("call_manager_error", e);
                }
                // 其他情况直接返回内存中的旧值
                return oldValue;
            }
        });

        channelCache = new RefreshMemoryMirror<Long, Channel>(timeout, new ComputeFunction<Long, Channel>() {

            public Channel apply(Long key, Channel oldValue) {
                try {
                	 Channel channel = buildChannel(key);
                    if (channel != null) {
                        updateMapping(channel, null);// 排除下自己
                        return channel;
                    } else {
                        throw new ConfigException("No Such Channel by pipelineId[" + key + "]");
                    }
                } catch (Exception e) {
                    logger.error("call_manager_error", e);
                }
                // 其他情况直接返回内存中的旧值
                return oldValue;
            }
        });
	}
	

	private Node buildNodeByNid(Long key) {
		Node node = new Node();
		node.setId(key);
		// TODO Auto-generated method stub
		return node;
	}
	
	private Channel buildChannelByPipelineId(Long pipelineId) {
		long channelId = 1L;
		Channel channel = new Channel();
		channel.setId(channelId);
		channel.setName("channel name");
		channel.setParameters(buildChannelParameter(channelId));
		channel.setPipelines(buildPipelines(channelId,pipelineId));
		channel.setStatus(ChannelStatus.STOP);
		return channel;
	}
	
	private Channel buildChannel(Long channelId){
		Channel channel = new Channel();
		channel.setId(channelId);
		channel.setName("channel name");
		channel.setParameters(buildChannelParameter(channelId));
		channel.setPipelines(buildPipelines(channelId));
		channel.setStatus(ChannelStatus.STOP);
		return channel;
	}

    private List<Pipeline> buildPipelines(long channelId, Long pipelineId) {
    	List<Pipeline> pipelines = new ArrayList<>();
    	pipelines.add(buildPipeline(channelId, pipelineId));
    	return pipelines;
	}

	private List<Pipeline> buildPipelines(long channelId) {
    	List<Pipeline> pipelines = new ArrayList<>();
    	for (int i = 1; i <= 1; i++) {
    		pipelines.add(buildPipeline(channelId, (long)i));
		}
		return pipelines;
	}

	private ChannelParameter buildChannelParameter(Long channelId) {
		ChannelParameter parameter = new ChannelParameter();
		parameter.setChannelId(channelId);
		parameter.setEnableRemedy(false);
		parameter.setRemedyAlgorithm(buildRemedyAlgorithmChannel());
		parameter.setRemedyDelayThresoldForMedia(buildRemedyDelayThresoldForMedia());
		parameter.setSyncConsistency(buildSyncConsistencyChannel());
		parameter.setSyncMode(SyncMode.ROW);
		return parameter;
	}

	private SyncConsistency buildSyncConsistencyChannel() {
		// TODO  是否与buildSyncConsistency可重用
		return null;
	}

	private int buildRemedyDelayThresoldForMedia() {
		// TODO Auto-generated method stub
		return 0;
	}

	private RemedyAlgorithm buildRemedyAlgorithmChannel() {
		// TODO  是否与buildRemedyAlgorithm可重用
		return null;
	}

	public void createOrUpdateChannel(Channel channel) {
        channelCache.put(channel.getId(), channel);
        updateMapping(channel, null);
    }

    private void updateMapping(Channel channel, Long excludeId) {
        Long channelId = channel.getId();
        List<Pipeline> pipelines = channel.getPipelines();
        for (Pipeline pipeline : pipelines) {
            if (excludeId == null || !pipeline.getId().equals(excludeId)) {
                channelMapping.put(pipeline.getId(), channelId);
            }
        }
    }

	@Override
	public Node currentNode() {
		Node node = new Node();
		node.setId(1L);
		node.setName("node55");
		node.setPort(1000L);
		node.setIp("10.6.24.55");
		node.setStatus(NodeStatus.STOP);
		node.setParameters(buildNodeParameter());
		// TODO Auto-generated method stub
		return node;
	}

	private NodeParameter buildNodeParameter() {
		NodeParameter parameter = new NodeParameter();
		parameter.setDownloadPort(2000);
		parameter.setExternalIp("10.6.24.55");
		parameter.setMbeanPort(20001);
		parameter.setUseExternalIp(false);
		parameter.setZkCluster(buildAutoKeeperCluser());
		return parameter;
	}

	private AutoKeeperCluster buildAutoKeeperCluser() {
		AutoKeeperCluster cluster = new AutoKeeperCluster();
		// TODO Auto-generated method stub
		return cluster;
	}
	
	@Override
	public List<Channel> getChannelByNodeId(Long nodeId) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
	
	@Override
	public void stopCurrentNode() {
		// TODO Auto-generated method stub
		
	}
}
