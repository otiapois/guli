

package com.fouo.common.utils;

import lombok.experimental.UtilityClass;

/**
 * 多线程工具类
 *
 * @author Sam
 */
@UtilityClass
public class ThreadUtil {

	/**
	 * Thread sleep
	 *
	 * @param millis 时长
	 */
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
