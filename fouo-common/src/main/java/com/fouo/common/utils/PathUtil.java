package com.fouo.common.utils;

import lombok.experimental.UtilityClass;
import org.springframework.lang.Nullable;

import java.io.File;
import java.net.URL;

/**
 * 用来获取各种目录
 *
 * @author Sam
 */
@UtilityClass
public class PathUtil {
	public static final String FILE_PROTOCOL = "file";
	public static final String JAR_PROTOCOL = "jar";
	public static final String ZIP_PROTOCOL = "zip";
	public static final String FILE_PROTOCOL_PREFIX = "file:";
	public static final String JAR_FILE_SEPARATOR = "!/";

}
