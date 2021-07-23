package cr.microservicios.mantenimientos.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.microservicios.common.controller.CommonController;
import cr.microservicios.commons.entity.Cliente;
import cr.microservicios.mantenimientos.services.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController extends CommonController<Cliente, ClienteService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Cliente cliente, @PathVariable Long id) {
		Optional<Cliente> clienteopt = service.findById(id);
		if (!clienteopt.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Cliente db = clienteopt.get();
		db.setRazonsocial(cliente.getRazonsocial());
		
		service.save(db);
		return ResponseEntity.status(HttpStatus.OK).body(db);
	}

}
