package org.midstr.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author yaogangli
 * @date 2013-6-18 下午3:08:58
 */
public class SimpleHashFunction implements HashFunction {
	/* (non-Javadoc)
	 * @see org.midstr.hash.HashFunction#hash(java.lang.Object)
	 */
	@Override
	public int hash(Object key) {
		try {
			// MD5 太慢了？
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(key.toString().getBytes());
			byte[] digesta = digest.digest();
			return Arrays.hashCode(digesta);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return key.hashCode();
		}
	}

}
