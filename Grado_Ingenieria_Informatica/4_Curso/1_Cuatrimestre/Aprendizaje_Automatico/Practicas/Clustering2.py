import pandas as pd
import scipy.cluster.hierarchy as sch
from sklearn.cluster import AgglomerativeClustering
import matplotlib.pyplot as plt

# Leer el dataset con etiquetas de clusters
df = pd.read_csv('Stations_Clustered.csv')

# Función para clustering jerárquico dentro de una ciudad
def clustering_jerarquico_ciudad(idCiudad, numClusters=80):
    # Filtrar estaciones en la ciudad seleccionada
    datosCiudad = df[df['city_cluster'] == idCiudad]
    coordenadasCiudad = datosCiudad[['latitude', 'longitude']]
    
    if coordenadasCiudad.empty:
        print(f"No hay estaciones en la ciudad con ID {idCiudad}.")
        return
    
    # Crear dendrograma
    plt.figure(figsize=(10, 5))
    sch.dendrogram(sch.linkage(coordenadasCiudad, method='single'))
    plt.title(f"Dendrograma - Ciudad {idCiudad}")
    plt.xlabel('Estaciones')
    plt.ylabel('Distancia')
    plt.show()
    
    # Aplicar clustering jerárquico aglomerativo
    hc = AgglomerativeClustering(n_clusters=min(numClusters, len(coordenadasCiudad)), affinity='euclidean', linkage='single')
    datosCiudad['sub_cluster'] = hc.fit_predict(coordenadasCiudad)
    
    # Mostrar resultados
    print(f"Subclusters dentro de la ciudad {idCiudad}:")
    print(datosCiudad[['station_id', 'sub_cluster']])
    
    # Graficar los subclusters
    plt.scatter(coordenadasCiudad['latitude'], coordenadasCiudad['longitude'], c=datosCiudad['sub_cluster'], cmap='viridis', s=50)
    plt.title(f"Subclusters en la ciudad {idCiudad}")
    plt.xlabel('Latitud')
    plt.ylabel('Longitud')
    plt.show()

# Ejemplo: Subdividir la ciudad con ID 5 en 10 clusters
clustering_jerarquico_ciudad(idCiudad=5, numClusters=10)
