package com.icodeap.ecommerce.infrastructure.dto;

import com.icodeap.ecommerce.domain.User;
import com.icodeap.ecommerce.domain.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private String username;
    //anotaciaon notblack tengo que tener informacion sino aviento mensaje
    @NotBlank (message = "Nombre es requerido")
    private String firstName;
    @NotBlank (message = "Apellido es requerido")
    private String lastName;
    @Email(message = "Debe ingresar un email valido")
    private String email;
    @NotBlank (message = "Dirección es requerido")
    private String address;
    @NotBlank (message = "Celular es requerido")
    private String cellphone;
    @NotBlank (message = "Clave es requerido")
    private String password;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User userDtoToUser(){
		User usuario=new User();
		 usuario.Inicializar(null,this.getEmail(),this.getFirstName(), this.getLastName(),this.getEmail(), this.getAddress(), this.getCellphone(), this.getPassword(), UserType.USER, LocalDateTime.now());
    
        return usuario;
        		}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", address=" + address + ", cellphone=" + cellphone + ", password=" + password + "]";
	}
    
    
    
}
