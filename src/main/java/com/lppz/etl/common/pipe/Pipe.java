/*
 * Copyright (C) 2010-2101 Alibaba Group Holding Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lppz.etl.common.pipe;

import com.lppz.etl.common.pipe.exception.PipeException;

/**
 * S.E.T.L模块之间的数据交互工具
 * 
 * @author jianghang 2011-10-10 下午04:48:44
 * @version 4.0.0
 */
public interface Pipe<T, KEY extends PipeKey> {

    /**
     * 向管道中添加数据
     * 
     * @param data
     */
    public KEY put(T data) throws PipeException;

    /**
     * 通过key获取管道中的数据
     * 
     * @param key
     * @return
     */
    public T get(KEY key) throws PipeException;
}
