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
@Table(name="CAT_CATEGORIES")
public class Category {
	
	@Id
	@UuidGenerator
	@Column(name="CAT_ID", nullable=false, updatable=false, unique=true)
	private String id;
	@Column(name="CAT_NAME", nullable=false)
	private String name;
	
	
}
