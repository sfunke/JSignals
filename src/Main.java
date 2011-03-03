import signals.SignalListener;
import test.MyTestVO;
import test.SignalBus;

/**
 * Created by IntelliJ IDEA.
 * User: Steffen funke <info@steffen-funke.de>
 * Date: 03.03.11
 * Time: 19:50
 */

public class Main
{

	public Main()
	{
		// getting signal bus
		SignalBus signalBus = SignalBus.getInstance();


		//----------------------------------
		//  creating listeners
		//----------------------------------
		signalBus.VALUEOBJ_SIGNAL.add(new SignalListener<MyTestVO>(){
			public void execute(MyTestVO valueObject)
			{
				System.out.println("Hello from MyTestVO Listener\n" +
						"name: " + valueObject.name + "\n" +
						"likes: " + valueObject.likes.toString()
				);

			}
		});

		signalBus.SOME_STRING_SIGNAL.add(new SignalListener<String>()
		{
			public void execute(String valueObject)
			{
				System.out.println("hello, value is: " + valueObject);
			}
		});

		signalBus.SOME_STRING_SIGNAL.add(new SignalListener<String>()
		{
			public void execute(String valueObject)
			{
				System.out.println("other listener: value is: " + valueObject);
			}
		});



		//----------------------------------
		//  Signal dispatching
		//----------------------------------
		MyTestVO testVO = new MyTestVO();
		testVO.name = "Holzkissen";
		testVO.likes = new String[]{"lila", "sex", "nunu"};

		signalBus.VALUEOBJ_SIGNAL.dispatch(testVO);
		signalBus.SOME_STRING_SIGNAL.dispatch("TESSST");
	}


	public static void main(String[] args)
	{
		Main main = new Main();
	}
}
