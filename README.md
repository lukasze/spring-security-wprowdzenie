## Tematy do przeanalizwoania

###1. Mechanizm wylogowania

    SecurityConfiguration

      .logout()

###2. Bcrypt

    SecurityConfiguration, DBSeeder, hasło w bazie

###3. Użytkownicy w bazie

    SecurityConfiguration, UserRepository
###4. Konfiguracja security dla h2

    .antMatchers("/h2-console/**").permitAll()    
    
    .csrf().disable()
    .headers().frameOptions().disable()