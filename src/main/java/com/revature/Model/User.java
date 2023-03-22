package com.revature.Model;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@Column(unique = true)
	protected String username;
	@Column
	protected String passwd;
}
