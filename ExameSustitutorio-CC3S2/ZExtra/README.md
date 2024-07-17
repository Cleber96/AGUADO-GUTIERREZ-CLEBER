# Diseño de Clases y Métodos:
## ¿Cómo podrías mejorar la estructura de las clases Project y Task para hacerlas más extensibles y mantenibles?
- podríamos introducir interfacespara Project y Task para desacoplar su implementación, así cambiar fácilmente las implementaciones sin afectar otras partes del código.
-  se pueden separar responsabilidades haciendo cada clase tenga una única responsabilidad. Por ejemplo, Project debería manejar detalles específicos del proyecto como fechas y descripción, mientras que Task debe manejar detalles específicos de las tareas como asignaciones y estado.
## ¿Qué otros atributos o métodos podrías añadir a las clases Project y Task para mejorar la funcionalidad de la aplicación?
- Para Project se puede agregar métodos para manejar recursos, presupuestos, o dependencias entre proyectos.
- Para Task puedo considerar métodos para manejar dependencias entre tareas, categorías para organizar tareas, y métodos para calcular el tiempo restante hasta la fecha de vencimiento.
# Patrones de diseño:
## ¿Por qué es útil el patrón Observer en este contexto? ¿Podrías pensar en otros escenarios donde este patrón sería beneficioso?
- El patrón Observer es útil aquí porque permite la notificación de cambios en las tareas del proyecto a múltiples observadores de forma desacoplada. Otros escenarios pueden ser sistemas de monitoreo en tiempo real para una empresa de tranporte que indica a los posibles pasajeros los tiempos de llegada y notifica a la central la demanda, también en sistemas de alarmas antirobo donde vecinos, bomberos y policias deben ser notificadosdependiendo delcaso.
## ¿Cómo podrías modificar la implementación del patrón Strategy para soportar múltiples estrategias de asignación de tareas simultáneamente?
# Principios SOLID:
## ¿Cómo aplicaste el principio de Responsabilidad Única (Single Responsibility Principle) en tus clases? Da ejemplos específicos.
- Project: Responsable de representar y gestionar los detalles específicos de un proyecto (nombre, fechas, descripción) y ya no de realizar los métodos updateTask, removeTask, addTask
- Task: Responsable de representar y gestionar los detalles específicos de una tarea (asignaciones, estado, fecha de vencimiento), mientras que sus modificaciones serán gestionadas por otra clase 
## ¿Qué beneficios observas al aplicar el principio de Inversión de Dependencias (Dependency Inversion Principle) en la gestión de estrategias de asignación de tareas?
- facilita la extensión: permitió introducir nuevas estrategias de asignación sin modificar el código existente de ProjectManager.
- Promueve el desacoplamiento. Por ejemplo, después de los cambios, ProjectManager depende de abstracciones (interfaces TaskAssignmentStrategy) en lugar de implementaciones concretas, lo que facilita la sustitución y la prueba.
# Medición de cohesión y acoplamiento:
## ¿Qué cambios realizarías en el código para mejorar la métrica de Lack of Cohesion of Methods (LCOM) en la clase Project?
- agrupar métodos relacionados en interfaces o clases auxiliares.
- dividir métodos grandes y complejos en métodos más pequeños y específicos que realicen una única tarea.
## ¿Qué acciones tomarías si detectas un alto acoplamiento entre las clases Project y Task?¿Cómo reducirías este acoplamiento?
- introduciría interfaces para Project y Task y prográmarlo contra estas interfaces en lugar de las implementaciones concretas.
- Utilizar patrones de diseño como el Adapter para desacoplar dependencias específicas.
# Pruebas y TDD:
## ¿Cuál fue el mayor desafío al aplicar la metodología TDD (Red-Green-Refactor) en este ejercicio? ¿Cómo lo superaste?
- en la sección refactor el mayor problema inicial es que la mayoría de clases se encuentran sobrecargados de responsabilidades, por lo que al separarlos en clases de responsabilidad única se tenía que reescribir también los test, y luego ver la integración.
- para superarlo trataba de escribir cada prueba en diferentes test.java para que cuando las clases se separacen, no afectara los test
## ¿Cómo podrías extender las pruebas unitarias y de integración para asegurar una mayor cobertura y robustez del código?
- en las pruebas unitarias me aseguraría de cubrir todos los caminos de ejecución posibles para métodos críticos como addTask, updateTask, y removeTask.
- en las pruebas de3 Integración probaría  la interacción entre Project, Task, y ProjectManager para asegurar que los flujos de trabajo funcionan correctamente.
# Seguridad:
## ¿Qué otras tácticas de seguridad podrías implementar en este sistema para proteger la información sensible?
- niveles de autorización: todos no podrían utilizar todos los métodos. dependerá de su nivel de autorización del usuraio
## ¿Cómo validarías la eficacia de las medidas de seguridad implementadas en el sistema?
# Estilo de código y documentación:
# Refactorización:
## ¿Qué partes del código consideras que podrían beneficiarse más de una refactorización? Justifica tu respuesta con ejemplos específicos.
- en mtodos largos como Main podría beneficiarse de dividir la lógica en métodos más pequeños y específicos, como separar la autenticación del manejo de tareas.
- en clases sobrecargadascomo ProjectManager podría dividirse en servicios más especializados como TaskManager y ProjectObserver.
## ¿Qué técnicas de refactorización podrías aplicar para mejorar la legibilidad y mantenimiento del código sin alterar su funcionalidad?
- Extracción de métodos paRA identificar bloques de código repetitivos y extraerlos a métodos separados para mejorar la reutilización y legibilidad.
- Inyección de dependencias: Para desacoplar componentes y facilitar las pruebas unitarias.