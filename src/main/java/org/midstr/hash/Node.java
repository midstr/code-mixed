package org.midstr.hash;

/**
 * @author yaogangli
 * @date 2013-6-18 下午3:10:33
 */
public class Node {

	private String ip;

	/**
	 * 
	 */
	public Node(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node[ip=" + ip + "]";
	}

}
