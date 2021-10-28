# LearnUp_Maven
## Игра “Зелёный цвет, красный цвет”
**Правила игры:** есть светофор, он может гореть зелёным, может гореть красным (isGreenLight). Если горит зелёным, то все игроки могут двигаться с любой скоростью. Если горит красным, то все игроки, двигающиеся со скоростью выше максимально допустимой скорости (MAX_SPEED), выбывают.

### Методы
**play** - принимает скорость игрока и возвращает ответ на вопрос, выбыл ли игрок.  
**countOfLose** - принимает массив скоростей игроков и возвращает количество выбывающих игроков.  
**speedOfLose** - принимает массив скоростей игроков и возвращает массив из скоростей выбывающих (в том же порядке, что и в исходном массиве).  
**speedOfWin** - принимает массив скоростей игроков и возвращает массив из скоростей не выбывающих (в том же порядке, что и в исходном массиве).  
**namesOfWin** - принимает массив строк вида “имя скорость” и возвращает массив имён выживших игроков.

## Дополнительно
Программа собирается с помощью фреймворка Apache Maven.  
При каждом новом коммите происходит запуск тестов благодаря настройке Maven CI на основе Github Actions.
