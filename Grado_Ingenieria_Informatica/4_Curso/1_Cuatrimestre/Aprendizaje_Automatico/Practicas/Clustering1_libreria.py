import pandas as pd
from sklearn.cluster import KMeans
from sklearn.metrics import silhouette_score
import matplotlib.pyplot as plt

# Función para determinar el número óptimo de clusters basado en el Silhouette Score
def encontrar_clusters(data, max_clusters=80, silhouette_threshold=0.97):
    puntuaciones = []
    rangoClusters = range(2, max_clusters + 1)
    clustersValidos = []

    for k in rangoClusters:
        kmeans = KMeans(n_clusters=k, random_state=42, n_init=10)
        kmeans.fit(data)
        silhouette = silhouette_score(data, kmeans.labels_)
        puntuaciones.append(silhouette)
        
        # Guardar los clusters con silhouette score > threshold
        if silhouette > silhouette_threshold:
            clustersValidos.append((k, kmeans, silhouette))

    # Graficar el Silhouette Score
    plt.figure(figsize=(8, 6))
    plt.plot(rangoClusters, puntuaciones, marker='o')
    plt.title('Silhouette Score para diferentes valores de k')
    plt.xlabel('Número de clusters (k)')
    plt.ylabel('Silhouette Score')
    plt.show()

    # Graficar los clusters para valores de k con silhouette > threshold
    for k, modelo, silhouette in clustersValidos:
        print(f"Graficando clusters para k={k} con Silhouette Score={silhouette:.2f}")
        plt.figure(figsize=(8, 6))
        plt.scatter(data['latitude'], data['longitude'], c=modelo.labels_, cmap='viridis', s=50)
        plt.scatter(modelo.cluster_centers_[:, 0], modelo.cluster_centers_[:, 1], c='red', marker='x', s=200)
        plt.title(f"Clusters para k={k} (Silhouette Score={silhouette:.2f})")
        plt.xlabel('Latitud')
        plt.ylabel('Longitud')
        plt.xlim(-90, 90)
        plt.ylim(-180, 180)
        plt.show()

    return rangoClusters, puntuaciones, clustersValidos



# Leer el archivo
df = pd.read_csv('Stations_Bueno.csv')
coordenadas = df[['latitude', 'longitude']]

# Determinar el número óptimo de clusters 
rangoClusters, puntuaciones, clustersValidos = encontrar_clusters(coordenadas)

# Seleccionar el número óptimo de clusters según silhouette score
kOptimo = puntuaciones.index(max(puntuaciones)) + 2
print(f"Número óptimo de clusters: {kOptimo}")

# Aplicar K-Means con el número óptimo de clusters
kmeans = KMeans(n_clusters=kOptimo, random_state=42, n_init=10)
coordenadas['city_cluster'] = kmeans.fit_predict(coordenadas)

# Mapear los clusters al DataFrame original
df['city_cluster'] = coordenadas['city_cluster']

# Visualizar todos los puntos con los clusters asignados
plt.figure(figsize=(10, 8))
plt.scatter(coordenadas['latitude'], coordenadas['longitude'], c=coordenadas['city_cluster'], cmap='viridis', s=10, alpha=0.7)
plt.title(f"Clustering completo con k={kOptimo}")
plt.xlabel('Latitud')
plt.ylabel('Longitud')
plt.xlim([-90, 90])
plt.ylim([-180, 180])
plt.colorbar(label='Cluster')
plt.show()

# Guardar los datos con los clusters asignados en un archivo CSV
df.to_csv('Stations_Clustered_library.csv', index=False)
print("Etiquetas de cluster guardadas en 'Stations_Clustered_library.csv'")