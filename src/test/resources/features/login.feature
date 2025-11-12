Feature: Login en Practice Test Automation
  Como usuario de la web de práctica
  Quiero iniciar sesión y cerrar sesión
  Para validar el flujo básico de autenticación

  Background:
    Given que navego a la página de login

  Scenario: Login válido
    When introduzco usuario "student" y contraseña "Password123"
    And hago clic en Login
    Then debería ver el mensaje de éxito "Logged In Successfully"
    And debería poder cerrar sesión

  Scenario Outline: Login inválido
    When introduzco usuario "<user>" y contraseña "<pass>"
    And hago clic en Login
    Then debería ver el mensaje de error "Your username is invalid!" or "Your password is invalid!"

    Examples:
      | user    | pass         |
      | student | badpass      |
      | baduser | Password123  |

  @negative @smoke
  Scenario: No permite login con campos vacíos
    Given que navego a la página de login
    When introduzco usuario "" y contraseña ""
    And hago clic en Login
    Then debería ver el mensaje de error "invalid"
