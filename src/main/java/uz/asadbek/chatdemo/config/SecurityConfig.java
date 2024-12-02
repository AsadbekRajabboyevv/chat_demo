package uz.asadbek.chatdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/chat-websocket/**", "/templates").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .csrf(csrf -> csrf.disable()
                );
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("jony")
                .password("jony")
                .roles("USER")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("rahimboy")
                .password("rahimboy")
                .roles("user")
                .build();

        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("asadbek")
                .password("asadbek")
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(user1, user2,user3);
    }

}
