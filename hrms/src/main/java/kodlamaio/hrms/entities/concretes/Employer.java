package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
public class Employer extends User {
	
	@Column(name="company_name")
	@NotNull
	@NotBlank
	private String companyName;
	
	@Column(name="web")
	@NotNull
	@NotBlank
	private String web;
	
	@Column(name="phone")
	@NotNull
	@NotBlank
	private String phone;
	
	@Column(name = "admin_approval")
	//@JsonIgnore
	private boolean adminApproval=false;
	
}
