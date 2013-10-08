import inverter.InverterItf;
import inverter.InverterImplService;
public class Cliente {
	public static void main(String[] args){
		InverterImplService service = new InverterImplService();
		InverterItf inverterservice = service.getInverterImplPort();
		
		System.out.println(inverterservice.inverter("Teste"));
	}
}
