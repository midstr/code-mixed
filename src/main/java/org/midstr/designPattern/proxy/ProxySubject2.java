package org.midstr.designPattern.proxy;

public class ProxySubject2 extends Subject{
	
    /**
     * ���������ɫ���ܲ�֪����ʵ�����ɫ�Ĵ��ڣ�����������һ�������������ɫ�Ľӿڣ���ʱ��������
     * ���ܴ������������������ʵ�����ɫ��ϵͳ��������ɫ���������롣�����������
     */
    private Subject realSubject;
    
    public ProxySubject2(Subject realSubject){
    	//FIXME �����е���װ����ģʽ��
    	//TODO ���realSubjectҲ����ͨ��set�������г�ʼ��
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
