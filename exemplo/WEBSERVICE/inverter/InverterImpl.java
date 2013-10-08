package inverter;
import javax.jws.WebService;

@WebService(endpointInterface = "inverter.InverterItf")
public class InverterImpl implements InverterItf{
	public String inverter(String msg) {
		StringBuffer strbuf = new StringBuffer(msg);
		System.out.println("Recebido: "+msg);
		String retorno = (strbuf.reverse()).toString();
		return retorno;
	}
}

