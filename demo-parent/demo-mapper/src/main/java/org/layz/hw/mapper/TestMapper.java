package org.layz.hw.mapper;

import java.util.List;
import java.util.Map;
/**
 * 测试Mapper
 * @author w
 *
 */
public interface TestMapper {
	/**
	 * 获取数据库表的数据
	 * @return
	 */
	public List<Map<String, Object>> list();
}
