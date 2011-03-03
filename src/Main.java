import signals.Signal;
import signals.SignalListener;
import test.MyTestVO;

/**
 * Created by IntelliJ IDEA.
 * User: Steffen funke <info@steffen-funke.de>
 * Date: 03.03.11
 * Time: 19:50
 */

public class Main
{

	public final Signal testSignal = new Signal(MyTestVO.class);


	public Main()
	{
		//----------------------------------
		//  creating listeners
		//----------------------------------
		testSignal.add(new SignalListener()
		{
			public void execute(Object... params)
			{
				System.out.println("Hello from Listener 1");
			}
		});


		testSignal.add(new SignalListener()
		{
			public void execute(Object... params)
			{
				System.out.println("Hello from Listener 2");
			}
		});



		//----------------------------------
		//  Signal dispatching
		//----------------------------------
		MyTestVO testVO = new MyTestVO();
		testVO.name = "Holzkissen";
		testVO.likes = new String[]{"lila", "sex", "nunu"};

		testSignal.dispatch(testVO);
	}


	public static void main(String[] args)
	{
		Main main = new Main();
	}
}
