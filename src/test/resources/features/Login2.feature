Feature: User olarak Login sonrası işlemleri gerçekleştirir.
  Ana sayfa görüntüleme, Ürün listeleme gibi özellikleri test eder.

  Background: Ana sayfa açılır ve Login sayfasıan erişilir.
    Given Open the web site
    When Enter 'standard_user' and 'secret_sauce' and click login button

  Scenario: Ürünleri listeler
    Then Product list container is shown


  Scenario Outline: Add product to cart
    When Click '<button_click>' button on Product Page
    Then Check '<button_check>' button is shown


    Examples:
      | button_click | button_check |
      | add to cart  | remove       |
      | remove       | add to cart  |
