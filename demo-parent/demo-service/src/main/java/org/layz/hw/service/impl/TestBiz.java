package org.layz.hw.service.impl;

import java.util.List;
import java.util.Map;

import org.layz.hw.mapper.TestMapper;
import org.layz.hw.service.ITestBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 测试Biz实现类
 * @author w
 *
 */
@Service
public class TestBiz implements ITestBiz{
	@Autowired
	TestMapper testMapper;
	public List<Map<String, Object>> list(){
		return testMapper.list();
	}
}
