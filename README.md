# testPersonController


Два контроллера /person/saveToDb и /person/saveToCsv

Принимает на вход json формата
{"firstName": String,
"secondName": String, 
"sex":String, 
"age":Integer}

Валидация на null отсутствует. 

CSV пишется в файл, который указан в csv.path.person в application.properties 
