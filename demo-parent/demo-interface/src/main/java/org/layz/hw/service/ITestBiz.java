package org.layz.hw.service;

import java.util.List;
import java.util.Map;
/**
 * 测试Biz接口
 * @author w
 *
 */
public interface ITestBiz {
	/**
	 * 获取数据库的数据列表
	 * @return
	 */
	public List<Map<String, Object>> list();
}
