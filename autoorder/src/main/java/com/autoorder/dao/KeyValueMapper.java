package com.autoorder.dao;

import com.autoorder.bo.KeyValue;

/**
 * @autor Seaven
 * @time 上午1:15:18
 *
 */
public interface KeyValueMapper {

	public KeyValue queryKeyValueByKeyName(String keyName);
}
