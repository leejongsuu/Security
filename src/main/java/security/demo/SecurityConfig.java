package security.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        // UserDetailsService 대신 InMemoryUserDetailsManager도 가능
//        UserDetails user1 = User.withUsername("user1")
//                .password("{noop}123")
//                .authorities("USER")
//                .build();
//
//        UserDetails user2 = User.withUsername("user2")
//                .password("{noop}123")
//                .authorities("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
}
