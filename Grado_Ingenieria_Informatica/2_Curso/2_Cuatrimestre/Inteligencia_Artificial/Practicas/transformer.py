import numpy as np
from keras_transformer import get_model, decode
from pickle import load
from google.colab import drive
np.random.seed(0)

drive.mount('/content/drive')
filename = 'content/drive/My drive/videos/2020-07-06/english-spanish.pkl'

dataset = load(open(filename, 'rb'))
print(dataset[120000,0])
print(dataset[120000,1])


