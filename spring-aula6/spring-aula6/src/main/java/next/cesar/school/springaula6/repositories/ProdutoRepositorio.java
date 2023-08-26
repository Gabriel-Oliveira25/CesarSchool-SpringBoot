package next.cesar.school.springaula6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import next.cesar.school.springaula6.entities.Produto;


public interface ProdutoRepositorio extends JpaRepository<Produto, String>{

}
