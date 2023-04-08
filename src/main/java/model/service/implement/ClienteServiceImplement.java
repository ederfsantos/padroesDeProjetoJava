package model.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cliente;
import model.Endereco;
import model.repository.ClienteRepository;
import model.repository.EnderecoRepository;
import model.service.ClienteService;
import model.viacep.ViaCepService;
@Service
public class ClienteServiceImplement implements ClienteService {
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private EnderecoRepository endRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Cliente> buscarTodos() {
		// TODO Auto-generated method stub

		return repository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente =repository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		// TODO Auto-generated method stub
		salvarClienteComCep(cliente);
	}

	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = endRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			endRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		repository.save(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		Optional<Cliente> clienteBd = repository.findById(id);
		if(clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
