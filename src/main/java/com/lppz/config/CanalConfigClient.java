package com.lppz.config;

import com.alibaba.otter.canal.instance.manager.model.Canal;

public interface CanalConfigClient {

	 public Canal findCanal(String destination);
}
