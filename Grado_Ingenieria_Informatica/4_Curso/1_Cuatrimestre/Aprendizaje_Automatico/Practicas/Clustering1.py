import numpy as np 
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.metrics import silhouette_score

# Función para inicialización K-Means
def inicializar_centroides(data, clusters, random_state=42):
    np.random.seed(random_state)
    centroides = []
    
    # Seleccionar el primer centroide aleatoriamente
    centroides.append(data[np.random.choice(len(data))])
    
    for _ in range(1, clusters):
        # Calcular la distancia mínima al centroide más cercano
        distancias = np.min(np.linalg.norm(data[:, np.newaxis] - np.array(centroides), axis=2), axis=1)
        # Seleccionar un nuevo centroide proporcional a la distancia al cuadrado
        prob = distancias ** 2 / np.sum(distancias ** 2)
        centroide = data[np.random.choice(len(data), p=prob)]
        centroides.append(centroide)
    
    return np.array(centroides)

# Implementación del algoritmo K-Means con múltiples inicializaciones
def kmeans(data, clusters, max_iter=300, tol=1e-4, random_state=42):
    # Inicializar centroides con K-Means
    centroides = inicializar_centroides(data, clusters, random_state=random_state)
    prevEtiquetas = None

    for iter in range(max_iter):
        # Asignar puntos al centroide más cercano
        distancias = np.linalg.norm(data[:, np.newaxis] - centroides, axis=2)  # Distancia euclidea
        etiquetas = np.argmin(distancias, axis=1)
        
        # Recalcular centroides
        NuevosCentroides = []
        for i in range(clusters):
            puntosCluster = data[etiquetas == i]
            if len(puntosCluster) > 0:
                # Calcular el nuevo centroide como la media de los puntos
                NuevosCentroides.append(puntosCluster.mean(axis=0))
            else:
                # Cluster vacío: Recolocar el centroide aleatoriamente
                NuevosCentroides.append(data[np.random.choice(len(data))])
        
        NuevosCentroides = np.array(NuevosCentroides)
        
        # Verificar convergencia
        if prevEtiquetas is not None and np.array_equal(etiquetas, prevEtiquetas):
            print(f"Convergencia alcanzada en la iteración {iter} (etiquetas estables)")
            break
        if np.all(np.abs(NuevosCentroides - centroides) < tol):
            print(f"Convergencia alcanzada en la iteración {iter} (centroides estables)")
            break
        
        centroides = NuevosCentroides
        prevEtiquetas = etiquetas
    
    return centroides, etiquetas

# Función para ejecutar K-Means múltiples veces y seleccionar el mejor resultado
def kmeans_multiple(data, clusters, n_init=10, max_iter=300, tol=1e-4, random_state=42):
    mejoresCentroides = None
    mejoresEtiquetas = None
    mejorSilhouette = -1  # Comenzamos con el peor valor posible para el silhouette score
    
    for i in range(n_init):
        centroides, etiquetas = kmeans(data, clusters, max_iter=max_iter, tol=tol, random_state=random_state + i)
        
        # Calcular el silhouette score
        silhouette = silhouette_score(data, etiquetas)
        
        if silhouette > mejorSilhouette:
            mejorSilhouette = silhouette
            mejoresCentroides = centroides
            mejoresEtiquetas = etiquetas
    
    return mejoresCentroides, mejoresEtiquetas, mejorSilhouette

def determinar_clusters(data, max_clusters=80, silhouette_threshold=0.97, n_init=10):
    puntuaciones = []
    rangoClusters = range(2, max_clusters + 1)
    clustersValidos = []
    mejor_k = None
    mejores_centroides = None
    mejores_etiquetas = None
    mejor_silhouette = -1

    for k in rangoClusters:
        centroides, etiquetas, silhouette = kmeans_multiple(data, clusters=k, n_init=n_init)
        puntuaciones.append(silhouette)
        
        if silhouette > silhouette_threshold:
            clustersValidos.append((k, centroides, etiquetas, silhouette))
        
        if silhouette > mejor_silhouette:  # Guardar el mejor k
            mejor_k = k
            mejores_centroides = centroides
            mejores_etiquetas = etiquetas
            mejor_silhouette = silhouette

    # Visualizar el Silhouette Score
    plt.figure(figsize=(8, 6))
    plt.plot(rangoClusters, puntuaciones, marker='o')
    plt.title('Silhouette Score para diferentes valores de k')
    plt.xlabel('Número de clusters (k)')
    plt.ylabel('Silhouette Score')
    plt.show()

    # Graficar los clusters para valores de k con silhouette > threshold
    for k, centroides, etiquetas, silhouette in clustersValidos:
        print(f"Graficando clusters para k={k} con Silhouette Score={silhouette:.2f}")
        plt.figure(figsize=(8, 6))
        plt.scatter(data[:, 0], data[:, 1], c=etiquetas, cmap='viridis', s=50)
        plt.scatter(centroides[:, 0], centroides[:, 1], c='red', marker='x', s=200)
        plt.title(f"Clusters para k={k} (Silhouette Score={silhouette:.2f})")
        plt.xlabel('Latitud')
        plt.ylabel('Longitud')
        plt.xlim([-90, 90])
        plt.ylim([-180, 180])
        plt.show()

    return rangoClusters, puntuaciones, clustersValidos, mejor_k, mejores_centroides, mejores_etiquetas


# Leer el dataset 
df = pd.read_csv('Stations_Bueno.csv')
coordenadas = df[['latitude', 'longitude']].values

# Llamar a determinar_clusters y recuperar valores directamente
rangoClusters, puntuaciones, clustersValidos, kOptimo, centroides, etiquetas = determinar_clusters(coordenadas)
print(f"Número óptimo de clusters: {kOptimo}")

# Asignar clusters al DataFrame original
df['city_cluster'] = etiquetas

# Visualizar los puntos
plt.figure(figsize=(10, 8))
plt.scatter(coordenadas[:, 0], coordenadas[:, 1], c=etiquetas, cmap='viridis', s=10, alpha=0.7)
plt.title(f"Clustering completo con k={kOptimo}")
plt.xlabel('Latitud')
plt.ylabel('Longitud')
plt.xlim([-90, 90])
plt.ylim([-180, 180])
plt.colorbar(label='Cluster')
plt.show()

# Guardar las etiquetas en el archivo
df.to_csv('Stations_Clustered.csv', index=False)
print("Etiquetas de cluster guardadas en 'Stations_Clustered.csv'")
