import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

# Leer el dataset con etiquetas de clusters
df = pd.read_csv('Stations_Clustered.csv')

# Implementación del clustering jerárquico aglomerativo
def clustering_jerarquico_aglomerativo(data, num_clusters, linkage='single'):
    """
    Realiza clustering jerárquico aglomerativo sin librerías externas.
    
    Parámetros:
        - data: Array de coordenadas (numpy array de NxM, donde N es el número de puntos).
        - num_clusters: Número de clusters deseados.
        - linkage: Método de enlace, 'single' para distancia mínima.
        
    Retorna:
        - cluster_labels: Array con la etiqueta del cluster para cada punto.
    """
    n = len(data)
    # Inicializar cada punto como un cluster único
    clusters = {i: [i] for i in range(n)}
    distancias = np.full((n, n), np.inf)  # Matriz de distancias
    
    # Calcular distancias iniciales entre todos los puntos
    for i in range(n):
        for j in range(i + 1, n):
            distancias[i, j] = distancias[j, i] = np.linalg.norm(data[i] - data[j])
    
    while len(clusters) > num_clusters:
        # Encontrar los clusters más cercanos
        min_dist = np.inf
        cluster_pair = (None, None)
        
        for i in clusters:
            for j in clusters:
                if i < j:  # Evitar redundancias
                    if linkage == 'single':  # Distancia mínima
                        d = min(distancias[a, b] for a in clusters[i] for b in clusters[j])
                    else:
                        raise ValueError("Método de enlace no soportado en esta implementación.")
                    
                    if d < min_dist:
                        min_dist = d
                        cluster_pair = (i, j)
        
        # Fusionar los clusters más cercanos
        i, j = cluster_pair
        clusters[i].extend(clusters[j])  # Combinar los elementos
        del clusters[j]  # Eliminar el cluster fusionado
    
    # Crear etiquetas finales
    cluster_labels = np.zeros(n, dtype=int)
    for cluster_id, points in enumerate(clusters.values()):
        for point in points:
            cluster_labels[point] = cluster_id
    
    return cluster_labels


# Función para realizar el clustering jerárquico en una ciudad
def clustering_jerarquico_ciudad(idCiudad, numClusters=80):
    """
    Realiza clustering jerárquico en las estaciones de una ciudad específica.
    """
    # Filtrar estaciones en la ciudad seleccionada
    datosCiudad = df[df['city_cluster'] == idCiudad]
    coordenadasCiudad = datosCiudad[['latitude', 'longitude']].to_numpy()
    
    if coordenadasCiudad.shape[0] == 0:
        print(f"No hay estaciones en la ciudad con ID {idCiudad}.")
        return
    
    # Realizar clustering jerárquico aglomerativo
    etiquetas = clustering_jerarquico_aglomerativo(coordenadasCiudad, numClusters)
    
    # Mostrar resultados
    datosCiudad = datosCiudad.copy()  # Evitar modificar el original
    datosCiudad['sub_cluster'] = etiquetas
    print(f"Subclusters dentro de la ciudad {idCiudad}:")
    print(datosCiudad[['station_id', 'sub_cluster']])
    
    # Graficar los subclusters
    plt.scatter(datosCiudad['latitude'], datosCiudad['longitude'], c=datosCiudad['sub_cluster'], cmap='viridis', s=50)
    plt.title(f"Subclusters en la ciudad {idCiudad}")
    plt.xlabel('Latitud')
    plt.ylabel('Longitud')
    plt.show()


# Ejemplo: Subdividir la ciudad con ID 5 en 10 clusters
clustering_jerarquico_ciudad(idCiudad=5, numClusters=10)
