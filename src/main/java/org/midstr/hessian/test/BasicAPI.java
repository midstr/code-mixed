package org.midstr.hessian.test;

import java.util.Map;

/**
 * @author yaogangli
 * @date 2013-5-22 上午10:54:45
 */
public interface BasicAPI {

	public String hello();

	public Cup getCup();
	
	public void post(Cup cup);
	
	public Map<String, String> getData(int id);
}
