/**
 * Created by IntelliJ IDEA.
 * User: Steffen funke <info@steffen-funke.de>
 * Date: 03.03.11
 * Time: 19:54
 */
package signals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Signal<T>
{
	private Class[] mValueClasses;
	private Object[] mValueObjects;

	private List<SignalListener<T>> listeners;
	private T mValueObject;

	public Signal()
	{
		listeners = new LinkedList<SignalListener<T>>();
	}

	public void add(SignalListener<T> listener)
	{
		createListenerRelationship(listener);
	}

	public void dispatch(T valueObject)
	{
		mValueObject = valueObject;
		Iterator<SignalListener<T>> iterator = listeners.iterator();
		while (iterator.hasNext())
		{
			iterator.next().execute(valueObject);
		}
	}


	//--------------------------------------------------------------------------
	//
	//  private API
	//
	//--------------------------------------------------------------------------

	private void createListenerRelationship(SignalListener<T> listener)
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
