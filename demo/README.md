
Post / http://localhost:8080/clients /  Добавление нового клиента
Patch / http://localhost:8080/clients/id /  Добавление нового контакта клиента (телефон или email)
Get / http://localhost:8080/clients /  Получение списка клиентов
Get / http://localhost:8080/clients/id /  Получение информации по заданному клиенту (по id)
Get / http://localhost:8080/clients/id/contacts /  Получение списка контактов заданного клиента
Get / http://localhost:8080/clients/id/contacts?contactType=email /  Получение списка контактов заданного типа заданного клиента