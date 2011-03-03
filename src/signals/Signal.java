/**
 * Created by IntelliJ IDEA.
 * User: Steffen funke <info@steffen-funke.de>
 * Date: 03.03.11
 * Time: 19:54
 */
package signals;

import java.util.LinkedList;
import java.util.List;

public class Signal
{
	private Class[] mValueClasses;
	private Object[] mValueObjects;

	private List<SignalListener> listeners;

	public Signal(Class... valueClasses)
	{
		mValueClasses = valueClasses;
		listeners = new LinkedList<SignalListener>();
	}

	public void add(SignalListener listener)
	{
		createListenerRelationship(listener);
	}

	public void dispatch(Object... valueObjects)
	{
		mValueObjects = valueObjects;
	}


	//--------------------------------------------------------------------------
	//
	//  private API
	//
	//--------------------------------------------------------------------------

	private void createListenerRelationship(SignalListener listener)
	{
		// If there are no previous listeners, add the first one as quickly as possible.
		if (listeners.size() == 0)
		{
			listeners.add(listener);
			return;
		}

		// Don't add the same listener twice.
		if (listeners.contains(listener))
			return;

		listeners.add(listener);
	}
}
