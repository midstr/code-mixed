package org.midstr.exception;


@SuppressWarnings("serial")
public class TestException extends Exception {

	public TestException(String message, Throwable cause) {
		super(message, cause);
	}

	public TestException(String message) {
		super(message);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Throwable
		 *    -- Error
		 *    -- Excpetion
		 *        --RuntimeException
		 * */
		
		/**
		 * http://tech.e800.com.cn/articles/2009/79/1247105040929_1.html
		 * http://www.javaeye.com/topic/857443
		 * 
		 * 1． 选择Checked还是Unchecked的几个经典依据
		 *   a.是软件bug还是业务异常，软件bug是Unchecked Exception,否则是Checked Exception 
             b.如果把该异常抛给用户，用户能否做出补救。如果客户端无能为力，则用Unchecked Exception，否则抛Checked Exception( 比如金币够不够的异常)
		 * 2． Exception的封装问题
		 * 3． 如无必要不要创建自己的Exception
		 *     Java API中提供了丰富的unchecked excetpion，譬如：NullPointerException , IllegalArgumentException 和 IllegalStateException等
		 * 4． 不要用Exception来作流程控制
		 * 5． 不要轻易的忽略捕获的Exception
		 * 6． 不要简单地捕获顶层的Exception
		 * 
		 * 
		 * 是不是搞一个ERROR_CODE呢？
		 * ApplicationException/BusinessException
		 * 总之需要一个统一的地方去处理异常:action?service?
		 * */
		
		// TODO 有时间看看spring的异常设计体系
		
		//根据惯例，Throwable 类及其子类有两个构造方法，一个不带参数，
		//另一个带有 String 参数，此参数可用于生成详细消息。此外，这些
		//子类很可能有与其相关联的 cause，因此也应有两个构造方法，一个
		//带 Throwable (cause)，一个带 String（详细消息）和 Throwable (cause)。
		
		// 另外我们设计的类，一般不需要增加类变量cause，因为在Throwable中已经有了
		
		// 对于我们设计的子类，如果已经是顶级异常（类似java.lang.IndexOutOfBoundsException），
		// 则不再需要带cause的参数
		
		//RuntimeException 是那些可能在 Java 虚拟机正常运行期间抛出的异常的超类。 
		//可能在执行方法期间抛出但未被捕获的 RuntimeException 的任何子类都无需在 throws 子句中进行声明
		
		//Cause 可以通过两种方式与 throwable 关联起来：通过一个将 cause 看作
		//参数的构造方法；或者通过 initCause(Throwable) 方法
	}

}
