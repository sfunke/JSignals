/**
 * Created by IntelliJ IDEA.
 * User: Steffen funke <info@steffen-funke.de>
 * Date: 03.03.11
 * Time: 21:39
 */
package test;

import signals.Signal;

public class SignalBus
{
	private static SignalBus _instance;

	public static SignalBus getInstance()
	{
		if (_instance == null)
		{
			_instance = new SignalBus();
		}
		return _instance;
	}

	

	public final Signal<MyTestVO> VALUEOBJ_SIGNAL = new Signal<MyTestVO>();
	public final Signal<String> SOME_STRING_SIGNAL = new Signal<String>();

}
