package org.midstr.language;

public interface Tree {
	void printTree();

	interface Node {
		void printNode();
	}
	
	static interface StaticNode {
		void printStaticNode();
	}
}
