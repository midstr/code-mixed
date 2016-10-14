package org.midstr.hessian.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

import com.caucho.hessian.server.HessianServlet;

/**
 * @author yaogangli
 * @date 2013-5-22 上午10:57:01
 */
@WebServlet("/test")
public class BasicService extends HessianServlet implements BasicAPI {
	private static final long serialVersionUID = -2571039781512262096L;

	private String _greeting = "Hello, world";

	public void setGreeting(String greeting) {
		_greeting = greeting;
	}

	public String hello() {
		return _greeting;
	}
	
	/* (non-Javadoc)
	 * @see org.midstr.hessian.test.BasicAPI#getCup()
	 */
	@Override
	public Cup getCup() {
		Cup cup = new Cup("cup_id");
		cup.setName("cup_name");
		cup.setType(1);
		return cup;
	}

	/* (non-Javadoc)
	 * @see org.midstr.hessian.test.BasicAPI#post(java.lang.String, int)
	 */
	@Override
	public void post(Cup cup) {
		System.out.println(cup);
	}

	/* (non-Javadoc)
	 * @see org.midstr.hessian.test.BasicAPI#getData(int)
	 */
	@Override
	public Map<String, String> getData(int id) {
		System.out.println(id);
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		return map;
	}
	
	
}