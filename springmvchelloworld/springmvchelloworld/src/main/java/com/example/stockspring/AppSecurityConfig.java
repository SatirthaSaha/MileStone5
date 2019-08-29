package com.example.stockspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		List<UserDetails> users= new ArrayList<>();
		UserDetails u1=User.withDefaultPasswordEncoder().username("satirtha").password("root").roles("USER").build();
		UserDetails u2=User.withDefaultPasswordEncoder().username("satrishna").password("root1").roles("USER").build();
		UserDetails u3=User.withDefaultPasswordEncoder().username("shounak").password("root2").roles("USER").build();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		return new InMemoryUserDetailsManager(users);
		
	}

	
	
} */
