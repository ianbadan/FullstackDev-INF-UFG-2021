/*package br.ufg.inf.springbootfs2021;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity()
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    //private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        //auth.userDetailsService(userDetailsService)
                //.passwordEncoder(passwordEncoder);

		auth.inMemoryAuthentication()
			.withUser("luiz")
			.password(passwordEncoder.encode("1234"))
			.roles("ADMIN")
			.and()
			.withUser("jose")
			.password(passwordEncoder.encode("1111"))
			.roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //	.formLogin()
                //	.and()
                .httpBasic()
                .and().csrf().ignoringAntMatchers("/h2-console/**")
                .and().headers().frameOptions().sameOrigin();


		 http
		  .csrf().disable()
		 .authorizeRequests()
		 	 .antMatchers("/h2-console/**").permitAll()
			 .anyRequest()
			 .authenticated()
		 .and()
		 .httpBasic()
		 	.and().csrf().ignoringAntMatchers("/h2-console/**")
	        .and().headers().frameOptions().sameOrigin();
    }
}

 */
