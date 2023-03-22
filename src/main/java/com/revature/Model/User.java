package com.revature.Model;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Data
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	@Column
	private String passwd;
}
