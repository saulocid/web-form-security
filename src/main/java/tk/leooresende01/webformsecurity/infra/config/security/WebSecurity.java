package tk.leooresende01.webformsecurity.infra.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurity {
	
	@Bean
	public SecurityFilterChain definirConfiguracoesDeSeguranca(HttpSecurity http) throws Exception {
		//Definir caminho de login (raiz) e arquivos estaticos como permitido sem autenticação em requisições GET e POST
		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http.authorizeRequests();
		authorizeRequests.antMatchers(HttpMethod.GET, "/").permitAll();
		authorizeRequests.antMatchers(HttpMethod.POST, "/login").permitAll();
		authorizeRequests.antMatchers(HttpMethod.GET, "/logout").permitAll();
		authorizeRequests.antMatchers(HttpMethod.GET, "/assert/**").permitAll();
		
		//Pedindo autenticação para qualquer outro caminho
		authorizeRequests.anyRequest().authenticated();
		
		//Desabilitar cache de requisição (Para evitar problemas com o cabeçalho)
		 http.requestCache().disable();
		 
		//Desativando formulario de login padrao (Vai ser feito manualmente)
		http.formLogin().disable();
		
		//Habilitando formulario de logout
		http.logout(logout -> logout.logoutSuccessUrl("/").logoutUrl("/logout"));
		
		//Desabilitando Anti-CSRF
		http.csrf().disable();
		
		//Construindo as configurações de login
		return http.build();
	}
	
	@Bean
	public AuthenticationManager getAuthManager(AuthenticationConfiguration authConfig) throws Exception {
		//Criando gerenciador de autenticação
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//Criando o responsavel por criptografar as senhas do banco de dados
		return new BCryptPasswordEncoder();
	}
}
