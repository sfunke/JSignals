/**
 * Created by IntelliJ IDEA.
 * User: Steffen funke <info@steffen-funke.de>
 * Date: 03.03.11
 * Time: 20:00
 */
package signals;

public interface SignalListener<T>
{
	public void execute(T valueObject);
}
