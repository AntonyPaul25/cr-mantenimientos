package cr.microservicios.mantenimientos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({ "edymar.microservicios.commons.entity" })
public class MicroserviciosMantenimientosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosMantenimientosApplication.class, args);
	}

}
