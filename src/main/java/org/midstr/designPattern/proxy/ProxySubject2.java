package org.midstr.designPattern.proxy;

public class ProxySubject2 extends Subject{
	
    /**
     * 代理主题角色可能不知道真实主题角色的存在，而仅仅持有一个被代理主题角色的接口，这时代理主题
     * 不能创建被代理主题对象，真实主题角色由系统的其它角色创建并传入。增加了灵活性
     */
    private Subject realSubject;
    
    public ProxySubject2(Subject realSubject){
    	//FIXME 好像有点像装饰器模式？
    	//TODO 这个realSubject也可以通过set方法进行初始化
    	this.realSubject = realSubject;
    }

	@Override
	public void request() {
		preRequest();
		realSubject.request();
		postRequest();
	}
	
	private void preRequest(){
		System.out.println("before Request");
	}

	private void postRequest(){
		System.out.println("after Request");
	}
}
