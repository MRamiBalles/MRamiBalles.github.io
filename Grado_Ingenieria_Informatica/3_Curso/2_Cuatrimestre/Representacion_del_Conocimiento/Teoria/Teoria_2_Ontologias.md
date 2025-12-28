# RC - Teoría 2: Ingeniería Ontológica y Web Semántica (Oficial UHU)

La Representación del Conocimiento ha evolucionado desde sistemas cerrados basados en reglas hacia arquitecturas abiertas e interoperables fundamentadas en ontologías.

## 1. Concepto de Ontología
Una ontología es una especificación formal y explícita de una conceptualización compartida. Define un vocabulario de conceptos (clases), propiedades (relaciones) y restricciones dentro de un dominio específico.

## 2. Lógicas de Descripción (DL)
Constituyen la base formal de los lenguajes de ontologías modernos (como OWL). Permiten realizar razonamientos automáticos sobre la jerarquía de conceptos.
- **Suscunción**: Determinar si un concepto es una especialización de otro.
- **Consistencia**: Verificar que las definiciones no contienen contradicciones lógicas.

## 3. El Stack de la Web Semántica
- **RDF (Resource Description Framework)**: Modelo de datos basado en tripletas (Sujeto, Predicado, Objeto).
- **RDFS**: Extensión para definir esquemas léxicos elementales.
- **OWL (Web Ontology Language)**: Lenguaje para definir ontologías complejas con alta expresividad lógica.
- **SPARQL**: Lenguaje de consulta para datos RDF, equivalente funcional al SQL en bases de datos relacionales.

## 📝 Ejercicio Teórico
Considere la definición de un concepto $Padre$ en DL:
$Padre \equiv Hombre \sqcap \exists tieneHijo.Persona$

Identifique las condiciones necesarias y suficientes para que un individuo sea clasificado automáticamente como $Padre$ por un motor de inferencia.
*Respuesta*: Un individuo será clasificado como $Padre$ si y solo si pertenece a la clase $Hombre$ y existe al menos una relación del tipo `tieneHijo` hacia un individuo de la clase $Persona$.
