package org.layz.hx.erp.provider.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.container.Main;

public class ErpSystemProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(ErpSystemProvider.class);
	
	public static void main(String[] args) {
		LOGGER.debug("erpSystemProvider start...");
		Main.main(args);
	}
}
