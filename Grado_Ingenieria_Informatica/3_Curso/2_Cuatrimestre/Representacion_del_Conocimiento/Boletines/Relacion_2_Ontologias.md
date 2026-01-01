# RC - Relación 2: Ontologías y Web Semántica (Oficial UHU)

La Representación del Conocimiento en la Web Semántica se aleja del procesamiento de datos tradicional para centrarse en el significado (semántica) y la inferencia automática.

## 1. El Grafo de Datos: RDF (Resource Description Framework)
RDF describe el mundo mediante **Tripletas**: `Sujeto -> Predicado -> Objeto`.
- **Sujeto**: El recurso (URI).
- **Predicado**: La propiedad.
- **Objeto**: El valor o otro recurso.

### 📝 Ejercicio Técnico: Modelado en Turtle
Modele la siguiente frase en sintaxis Turtle: "Pepe conoce a Juan y Pepe es un Estudiante".

```turtle
@prefix ex: <http://example.org/> .
@prefix foaf: <http://xmlns.com/foaf/0.1/> .

ex:pepe a ex:Estudiante ;
        foaf:knows ex:juan .
```

## 2. Ontologías con OWL (Web Ontology Language)
OWL permite definir jerarquías de clases, restricciones de cardinalidad y propiedades transitivas o simétricas para que un **Razonador** (como Pellet o HermiT) infiera nuevo conocimiento.

### 📝 Ejercicio Técnico: Inferencia Lógica
Dada la ontología:
1. `PadreDe` es una propiedad inversa de `HijoDe`.
2. `PadreDe` es una propiedad transitiva.
3. Hechos: `Juan PadreDe Pepe`, `Pepe PadreDe Luis`.

**¿Qué infiere el razonador?**
*Respuesta*:
- Por transitividad: `Juan PadreDe Luis`.
- Por simetría inversa: `Pepe HijoDe Juan`, `Luis HijoDe Pepe`, `Luis HijoDe Juan`.

## 3. Consultas con SPARQL
Es el "SQL" de las ontologías. Permite buscar patrones en los grafos RDF.

```sparql
SELECT ?nombre
WHERE {
  ?persona a ex:Estudiante .
  ?persona foaf:name ?nombre .
}
```

---
> [!TIP]
> **Open World Assumption (OWA)**: A diferencia de las bases de datos SQL, en la Web Semántica si algo no se conoce, no se asume falso, simplemente se asume que no se sabe (Mundo Abierto).
