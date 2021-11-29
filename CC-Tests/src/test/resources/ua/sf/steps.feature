Feature: Positive and negative password field test
  Scenario: Correct password entry in the registration form
    Given url of remanga 'https://remanga.org/'
    When website is open click button inside
    Then click button registration
    Then enter in the field username text 'Tornado'
    And enter in the field password '056789'
    And enter in the field confirmPassword '056789'
    Then click button create account
  Scenario: Wrong password in the password field
    Given url of remanga 'https://remanga.org/'
    When website is open click button inside
    Then click button registration
    Then enter in the field username text 'Tornado'
    And enter in the field password '78946'
    And enter in the field confirmPassword '78946'
    Then click button create account
    And assert that user got message 'Слишком короткий пароль'
