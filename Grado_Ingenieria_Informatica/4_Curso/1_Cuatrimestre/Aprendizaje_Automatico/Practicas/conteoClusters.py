import pandas as pd

df = pd.read_csv('Stations_Clustered.csv')
conteo_clusters = df['city_cluster'].value_counts().sort_index()
print("Cantidad de estaciones por cluster:")
print(conteo_clusters)

# Si quieres guardar los resultados en un archivo CSV
conteo_clusters.to_csv('Cantidad_Estaciones_Por_Cluster.csv', header=['Cantidad'], index_label='Cluster')
print("El conteo se ha guardado en 'Cantidad_Estaciones_Por_Cluster.csv'.")
