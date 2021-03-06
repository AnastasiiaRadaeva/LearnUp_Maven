# LearnUp_Maven
## Игра “Зелёный свет, красный свет”
**Правила игры:** есть светофор, он может гореть зелёным, может гореть красным (isGreenLight). Если горит зелёным, то все игроки могут двигаться с любой скоростью. Если горит красным, то все игроки, двигающиеся со скоростью выше нуля или максимально допустимой скорости (maxSpeed), выбывают.

## Состав проекта
### Класс Game
Игроки выбывают при скорости выше 0 при красном свете.   

- При создании объекта класса требуется указать свет светофора по умолчанию.
- Для установки света прописаны **getIsGreenLight()** и **setIsGreenLight()**.

### Класс SpeedyGame
Игроки выбывают при скорости выше максимально допустимой при красном свете.   

- Наследуется от класса Game.
- При создании объекта класса требуется указать свет светофора и максимальную скорость по умолчанию. 
- Для установки максимальной скорости прописаны **getMaxSpeed()** и **setMaxSpeed()**. 
- Установка света светофора производится с использованием инструментов родительского класса.

### Класс GameManager
- При создании объекта требуется передать объект игры.
- метод **countOfRounds()** принимает массив скоростей одного игрока и возвращает количество раундов, которые продержался игрок в данной игре со своими скоростями.
- метод **lose()** принимает 2 игрока (p1, p2), игру (game) и число раундов (rounds). Возвращает -1, если p1 проиграет раньше в game при rounds раундов; Возвращает 1, если p2 проиграет раньше в game при rounds раундов; Возвращает 0, если никто не успел проиграть.

### Интерфейс Moveable
Описывает все сущности, имеющие скорость.   
- **getSpeed()** единственный метод.

### Класс ConstantPlayer
Имплементирует интерфейс "Movable".   
Описывает игрока, который всегда передвигается с одной скоростью, установленной в конструкторе.

- метод **getSpeed()** возвращает скорость игрока.

### Класс FastPlayer
Имплементирует интерфейс "Movable".   
Описывает игрока, который меняет свою скорость с установленной в конструкторе на шаг, указанный в конструкторе.
- метод **getSpeed()** возвращает текущую скорость игрока. При каждом новом вызове метода скорость игрока увеличивается на speedStep, начинаяя со startStep.

## Дополнительно
Программа собирается с помощью фреймворка Apache Maven.  
При каждом новом коммите происходит запуск тестов благодаря настройке Maven CI на основе Github Actions.
