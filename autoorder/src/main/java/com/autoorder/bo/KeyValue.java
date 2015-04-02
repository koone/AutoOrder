package com.autoorder.bo;

/**
 * @autor Seaven
 * @time 上午1:09:46
 *
 */
public class KeyValue {

	/**
	 * keyValue为 key1:value1, key2:value2
	 */
	public static Integer KEY_TYPE_MAP = 1;
	
	/**
	 * keyValue为 value1, value2, value3
	 */
	public static Integer KEY_TYPE_LIST = 2;
	
	private Long id;
	
	private String keyName;
	
	private String keyValue;
	
	private String keyDescripe;
	
	private Integer keyType;
	
	private Boolean isDelete;

	public static Integer getKEY_TYPE_MAP() {
		return KEY_TYPE_MAP;
	}

	public static void setKEY_TYPE_MAP(Integer kEY_TYPE_MAP) {
		KEY_TYPE_MAP = kEY_TYPE_MAP;
	}

	public static Integer getKEY_TYPE_LIST() {
		return KEY_TYPE_LIST;
	}

	public static void setKEY_TYPE_LIST(Integer kEY_TYPE_LIST) {
		KEY_TYPE_LIST = kEY_TYPE_LIST;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getKeyDescripe() {
		return keyDescripe;
	}

	public void setKeyDescripe(String keyDescripe) {
		this.keyDescripe = keyDescripe;
	}

	public Integer getKeyType() {
		return keyType;
	}

	public void setKeyType(Integer keyType) {
		this.keyType = keyType;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "KeyValue [id=" + id + ", keyName=" + keyName + ", keyValue="
				+ keyValue + ", keyDescripe=" + keyDescripe + ", keyType="
				+ keyType + ", isDelete=" + isDelete + "]";
	}
}
