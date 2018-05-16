package com.yj.word;

import java.util.UUID;

/**
 * @author YJ
 * @date 2018年5月16日 下午1:25:49
 * @描述 uuid工具类
 */
public class UUIDUtil {
	/**
	 * 返回32位无连接符uuid
	 */
	public static String get32UUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 返回带分割符的uuid，36位
	 */
	public static String getBaseUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 返回不带分割符分64位uuid
	 */
	public static String get64UUID() {
		return get32UUID() + get32UUID();
	}

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		System.out.println(get32UUID());
	}
}
