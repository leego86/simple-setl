package com.lppz.config;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import com.alibaba.otter.shared.common.model.config.channel.Channel;
import com.alibaba.otter.shared.common.model.config.node.Node;
import com.alibaba.otter.shared.common.model.config.pipeline.Pipeline;

public interface ConfigClientService extends InitializingBean {

	public Pipeline findPipeline(Long pipelineId);

	public Channel findChannelByPipelineId(Long pipelineId);

	public Node currentNode();
	
	   /**
     * 创建或者更新本地service的数据
     */
    public void createOrUpdateChannel(Channel channel);
    
    public List<Channel> getChannelByNodeId(Long nodeId);
    
    public void stopCurrentNode();
}
