
package com.fouo.common.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 集合工具类
 *
 * @author Sam
 */
public class CollectionUtil extends CollectionUtils {

	/**
	 * Check whether the given Array contains the given element.
	 *
	 * @param array   the Array to check
	 * @param element the element to look for
	 * @param <T>     The generic tag
	 * @return {@code true} if found, {@code false} else
	 */
	public static <T> boolean contains(@Nullable T[] array, final T element) {
		if (array == null) {
			return false;
		}
		return Arrays.stream(array).anyMatch(x -> ObjectUtil.nullSafeEquals(x, element));
	}

	/**
	 * 对象是否为数组对象
	 *
	 * @param obj 对象
	 * @return 是否为数组对象，如果为{@code null} 返回false
	 */
	public static boolean isArray(Object obj) {
		if (null == obj) {
			return false;
		}
		return obj.getClass().isArray();
	}

	/**
	 * Determine whether the given Collection is not empty:
	 * i.e. {@code null} or of zero length.
	 *
	 * @param coll the Collection to check
	 * @return boolean
	 */
	public static boolean isNotEmpty(@Nullable Collection<?> coll) {
		return !CollectionUtils.isEmpty(coll);
	}

	/**
	 * Determine whether the given Map is not empty:
	 * i.e. {@code null} or of zero length.
	 *
	 * @param map the Map to check
	 * @return boolean
	 */
	public static boolean isNotEmpty(@Nullable Map<?, ?> map) {
		return !CollectionUtils.isEmpty(map);
	}


	/**
	 * 不可变 Set
	 *
	 * @param es  对象
	 * @param <E> 泛型
	 * @return 集合
	 */
	@SafeVarargs
	public static <E> Set<E> ofImmutableSet(E... es) {
		Objects.requireNonNull(es, "args es is null.");
		return Arrays.stream(es).collect(Collectors.toSet());
	}

	/**
	 * 不可变 List
	 *
	 * @param es  对象
	 * @param <E> 泛型
	 * @return 集合
	 */
	@SafeVarargs
	public static <E> List<E> ofImmutableList(E... es) {
		Objects.requireNonNull(es, "args es is null.");
		return Arrays.stream(es).collect(Collectors.toList());
	}

	/**
	 * Iterable 转换为List集合
	 * @param elements Iterable
	 * @param <E> 泛型
	 * @return 集合
	 */
	public static <E> List<E> toList(Iterable<E> elements) {
		Objects.requireNonNull(elements, "elements es is null.");
		if (elements instanceof Collection) {
			return new ArrayList<E>((Collection) elements);
		}
		Iterator<E> iterator = elements.iterator();
		List<E> list = new ArrayList<>();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}

}
