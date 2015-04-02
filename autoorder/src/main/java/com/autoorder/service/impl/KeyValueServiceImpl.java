package com.autoorder.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.autoorder.bo.KeyValue;
import com.autoorder.dao.KeyValueMapper;
import com.autoorder.service.KeyValueService;

/**
 * @autor Seaven
 * @time 上午1:31:46
 *
 */
@Service("keyValueService")
public class KeyValueServiceImpl implements KeyValueService{

	@Autowired
	private KeyValueMapper keyValueMapper;
	
	/**
	 * {@inheritDoc}
	 */
	public Map<String, Object> getKeyValuesByName(String... keyNames) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		for (String keyName : keyNames) {
			if (!StringUtils.isEmpty(keyName)) {
				KeyValue keyValue = keyValueMapper.queryKeyValueByKeyName(keyName);
				result.put(keyName, convertKeyValuesByType(keyValue));
			}
		}
		
		return result;
	}
	
	private Object convertKeyValuesByType(KeyValue keyValue) {
		Object obj = null;
		
		if (KeyValue.KEY_TYPE_MAP.equals(keyValue.getKeyType())) {
			obj = convertKeyValueToMap(keyValue);
		} else if (KeyValue.KEY_TYPE_LIST.equals(keyValue.getKeyType())){
			obj = convertKeyValueToList(keyValue);
		}
		
		return obj;
	}

	private Map<String, String> convertKeyValueToMap(KeyValue keyValue) {
		Map<String, String> map = new HashMap<String, String>();
		
		if (!StringUtils.isEmpty(keyValue.getKeyValue())) {
			String[] array = keyValue.getKeyValue().split(",");
			
			for (String str : array) {
				String[] kv = str.split(":");
				if (2 == kv.length) {
					map.put(kv[0], kv[1]);					
				}
			}
		}
		
		return map;
	}
	
	private List<String> convertKeyValueToList(KeyValue keyValue) {
		List<String> list = new ArrayList<String>();
		
		if (!StringUtils.isEmpty(keyValue.getKeyValue())) {
			String[] array = keyValue.getKeyValue().split(",");
			
			for (String str : array) {
				if (!StringUtils.isEmpty(str)) {
					list.add(str);
				}
			}
		}
		
		return list;
	}
}
