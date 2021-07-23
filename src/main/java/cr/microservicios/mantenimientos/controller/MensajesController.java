package cr.microservicios.mantenimientos.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MensajesController {

	/*@RequestMapping(method = { RequestMethod.OPTIONS,
			RequestMethod.GET }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> prueba(@RequestBody Object data) {
		//System.out.println(data.toString());
		return ResponseEntity.ok("test");
	}*/
	
	@GetMapping("/test")
	public ResponseEntity<?> prueba() {
		//System.out.println(data.toString());
		return ResponseEntity.ok("test");
	}

}
