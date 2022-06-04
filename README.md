Spring Security: Intro

##TODO

###1. Włącz uwierzytelnianie HTTP BASIC

###2. Publicznie dostępne zasoby:
2a  - dodaj w IndexController /contact

2b  - skonfiguruj tak, aby był publicznie dostępny

###3. AuthenticationEntryPoint, konfiguracja:
3a   - Zwracaj kod odpowiedzi 401

3b   - Zwracaj header HTTP WWW-Authenticate: Basic 

3c   - Zwróć JSON-a { "message": "unauthenticated" }.

###4. SecurityContextHolder, użycie:
4a   - Zwróć w IndexController nazwę zalogowanego użytkownika


##Zmiana konfiguracji w nowszych wersjach Spring Boot
W większości artykułów dostępnych w sieci, nie ma najnowszego sposobu konfiguracji.
Nie oznacza to, że podane sposoby nie działają, czy są niepoprawne.

https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

