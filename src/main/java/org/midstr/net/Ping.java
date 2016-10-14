package org.midstr.net;

import java.io.IOException;
import java.net.MalformedURLException;

public interface Ping {

	void startURL() throws MalformedURLException;

	void startSocket();

	void startNioChannels();

	void startWindows() throws IOException, InterruptedException;

}