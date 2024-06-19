# RESOLUCIÓN
me basaré en el uso de TDD: primero crear clases sin implementar funcionalidades para escribir los test
## Implementación de pruebas
1. se crean las clases, interfaces y abstract que se identifican
    - class `Game`: Clase principal.lógica del juego.
    ![base_game](Image/base_game.png)
    - class `Map`: Representa el mapa del juego.
    ![implementar_map](Image/implementar_map.png)
    - class`Wave`: Maneja las oleadas de enemigos.
    - class `Player`: Representa al jugador y sus estadísticas.
    ![base_wavePlayer_noFunciones](Image/base_wavePlayer_noFunciones.png)
    - interface `EnemyFactory`:
        - abstract class`Enemy`: Clase base para enemigos.
            - class `BasicEnemy`  ->  (1,100,10)
            - class `FastEnemy`   ->  (2,50,10)
            - class `BossEnemy`   ->  (1,200,20)
        - ![base_enemigos_noFunciones](Image/base_enemigos_noFunciones.png)
    - interface `TowerFactory`: 
        - abstract `Tower`: Clase base para todas las torres. 
            - class `CannonTower`  ->  (50,2,3)
            - class `LaserTower`   ->  (30,4,5)
            - class `ArrowTower`   ->  (10,3,8)
        - ![base_torres_noFunciones](Image/base_enemigos_noFunciones.png)

2. Resultado Inicial: pero lo curiosos es que se puede modificar para que las posiciones iniciales vayan cambiando
- ![E.S.Iniciales](Image/E.S.Iniciales.png)