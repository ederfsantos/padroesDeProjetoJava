package model.service;


import model.Endereco;

public interface EnderecoService {
	Iterable <Endereco> buscarTodos();
	Endereco buscarPorId(String cep);
	void inserir(Endereco endereco);
	void atualizar(Long id,Endereco endereco);
	void deletar(Long id);
}
