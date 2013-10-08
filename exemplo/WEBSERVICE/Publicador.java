import javax.xml.ws.Endpoint;
import inverter.InverterImpl;

public class Publicador {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/inverter",
			new InverterImpl());
	}
}

