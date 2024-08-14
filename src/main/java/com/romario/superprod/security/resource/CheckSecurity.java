package com.romario.superprod.security.resource;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface CheckSecurity {

	public @interface Molde {

		@PreAuthorize("hasAuthority('C_MOL')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeCadastrar {}

		@PreAuthorize("hasAuthority('D_MOL')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeExcluir {}
	
		@PreAuthorize("hasAuthority('U_MOL')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAtualizar {}
		
		@PreAuthorize("hasAuthority('R_MOL')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {}
		
		@PreAuthorize("hasAuthority('U_MOL')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAlterarStatus {}

	}

	public @interface Maquina {

		@PreAuthorize("hasAuthority('C_MAQ')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeCadastrar {}

		@PreAuthorize("hasAuthority('D_MAQ')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeExcluir {}
	
		@PreAuthorize("hasAuthority('U_MAQ')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAtualizar {}
		
		@PreAuthorize("hasAuthority('R_MAQ')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {}
		
		@PreAuthorize("hasAuthority('S_MAQ')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAlterarStatus {}

	}
	
	public @interface Operador {

		@PreAuthorize("hasAuthority('C_OPE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeCadastrar {}

		@PreAuthorize("hasAuthority('D_OPE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeExcluir {}
	
		@PreAuthorize("hasAuthority('U_OPE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAtualizar {}
		
		@PreAuthorize("hasAuthority('R_OPE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {}
		
		@PreAuthorize("hasAuthority('S_OPE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAlterarStatus {}

	}
	
	public @interface Producao {

		@PreAuthorize("hasAuthority('C_PRODU')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeCadastrar {}

		@PreAuthorize("hasAuthority('D_PRODU')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeExcluir {}
	
		@PreAuthorize("hasAuthority('U_PRODU')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAtualizar {}
		
		@PreAuthorize("hasAuthority('R_PRODU')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {}
		
		@PreAuthorize("hasAuthority('S_PRODU')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAlterarStatus {}

	}
	
	public @interface Usuario {

		@PreAuthorize("hasAuthority('C_USU')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeCadastrar {}

		@PreAuthorize("hasAuthority('D_USU')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeExcluir {}
	
		@PreAuthorize("hasAuthority('U_USU')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAtualizar {}
		
		@PreAuthorize("hasAuthority('R_USU')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {}
		
		@PreAuthorize("hasAuthority('S_USU')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAlterarStatus {}

	}
	public @interface Produto {
		
		@PreAuthorize("hasAuthority('C_PROD')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeCadastrar {}
		
		@PreAuthorize("hasAuthority('D_PROD')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeExcluir {}
		
		@PreAuthorize("hasAuthority('U_PROD')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAtualizar {}
		
		@PreAuthorize("hasAuthority('R_PROD')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {}
		
		@PreAuthorize("hasAuthority('S_PROD')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAlterarStatus {}
		
	}

	
}
