package next.cesar.school.springaula6.entities;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "PROD")
public class Produto {
	@Id
	@UuidGenerator
	@Column(name = "PROD_ID", nullable=false, unique=true, updatable=false)
	private String id;	
	@Column(name = "PROD_NOME", nullable=false)
	private String name;
	
	//@ManyToOne
	//private Categoria categoria;
}
