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

	public final Signal<MyTestVO> valueObjSignal = new Signal<MyTestVO>();
	public final Signal<String> stringSignal = new Signal<String>();


	public Main()
	{
		//----------------------------------
		//  creating listeners
		//----------------------------------
		valueObjSignal.add(new SignalListener<MyTestVO>(){
			public void execute(MyTestVO valueObject)
			{
				System.out.println("Hello from MyTestVO Listener\n" +
						"name: " + valueObject.name + "\n" +
						"likes: " + valueObject.likes.toString()
				);

			}
		});

		stringSignal.add(new SignalListener<String>()
		{
			public void execute(String valueObject)
			{
				System.out.println("hello, value is: " + valueObject);
			}
		});

		stringSignal.add(new SignalListener<String>()
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

		valueObjSignal.dispatch(testVO);
		stringSignal.dispatch("TESSST");
	}


	public static void main(String[] args)
	{
		Main main = new Main();
	}
}
