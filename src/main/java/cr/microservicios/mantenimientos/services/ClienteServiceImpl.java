package cr.microservicios.mantenimientos.services;

import org.springframework.stereotype.Service;

import cr.microservicios.common.services.CommonServiceImpl;

import cr.microservicios.mantenimientos.respository.ClienteRepository;
import cr.microservicios.commons.entity.Cliente;

@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, ClienteRepository> implements ClienteService {

}
