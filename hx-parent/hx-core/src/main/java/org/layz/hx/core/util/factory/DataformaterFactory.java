package org.layz.hx.core.util.factory;

import org.layz.hx.core.util.SpringContextUtil;
import org.layz.hx.core.util.formater.Dataformater;
import org.layz.hx.core.util.formater.DefaultDataformater;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class DataformaterFactory {
	private static final List<Dataformater> repository;
	private static final Dataformater defaultFormater = new DefaultDataformater();
	
	static {
		repository = new ArrayList<>();
		ServiceLoader<Dataformater> load = ServiceLoader.load(Dataformater.class);
		for (Dataformater dataformater : load) {
			repository.add(dataformater);
		}
	}
	/**
	 * 获取转换器
	 * @param formatType
	 * @param name
	 * @return
	 */
	public static Dataformater getDataformater(String formatType, String name) {
		if(Dataformater.CONTEXT.equals(formatType)) {
			return SpringContextUtil.getBean(name);
		}
		for (Dataformater dataformater : repository) {
			if(dataformater.support(formatType)) {
				return dataformater;
			}
		}
		return defaultFormater;
	}
}
