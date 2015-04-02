package com.autoorder.service;

import java.util.Map;

/**
 * @autor Seaven
 * @time 上午1:28:03
 *
 */
public interface KeyValueService {

	/**
	 * 查找一堆key-value值，并将其转换成对应的类型，并放入map中
	 * @param keyNames
	 * @return
	 */
	public Map<String, Object> getKeyValuesByName(String... keyNames);
}
