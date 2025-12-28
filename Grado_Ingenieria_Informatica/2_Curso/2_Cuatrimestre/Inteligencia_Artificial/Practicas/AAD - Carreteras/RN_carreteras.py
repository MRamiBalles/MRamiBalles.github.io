from keras import models
from keras import layers
import cv2
import numpy as np
import os
from sklearn.model_selection import train_test_split
from keras.utils import to_categorical

#pip install opencv-python, tensorflow
#(train_images, train_labels), (test_images, test_labels) = mnist.load_data()

dir_imagenes = r'C:\Users\Manu\Desktop\IAAR\AAD - Carreteras\images'
dir_mascaras = r'C:\Users\Manu\Desktop\IAAR\AAD - Carreteras\masks'
imagenes = []
mascaras = []
for filename in os.listdir(dir_imagenes):
    image = cv2.imread(os.path.join(dir_imagenes,filename), cv2.IMREAD_COLOR)
    image = image.astype(np.float32)/255.
    imagenes.append(image)   

for filename in os.listdir(dir_mascaras):
    mask = cv2.imread(os.path.join(dir_mascaras, filename), cv2.IMREAD_COLOR)
    mask = mask.astype(np.float32)/255
    mascaras.append(mask)

# Convierte las listas en arreglos numpy
images = np.array(imagenes)
masks = np.array(mascaras)

# Verifica las dimensiones de las imágenes y las máscaras
print('Dimensiones de imágenes:', images.shape)
print('Dimensiones de máscaras:', masks.shape)

train_images, test_images, train_masks, test_masks = train_test_split(images, masks, test_size=0.3, random_state=42)

print('Imagenes para entrenamiento:', train_images.shape)
print('Imagenes para test:', test_images.shape)
print('Mascaras para entrenamiento:', train_masks.shape)
print('Mascaras para test:', test_masks.shape)

test_masks = to_categorical(test_masks)  # No en train!!

model = models.Sequential()
model = models.Sequential()
# Encoder
model.add(layers.Conv2D(64, (3, 3), activation='relu', padding='same', input_shape=(720,1280,3)))
model.add(layers.BatchNormalization())
model.add(layers.Conv2D(64, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
model.add(layers.MaxPooling2D((2, 2)))
    
model.add(layers.Conv2D(128, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
model.add(layers.Conv2D(128, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
model.add(layers.MaxPooling2D((2, 2)))
    
model.add(layers.Conv2D(256, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
model.add(layers.Conv2D(256, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
model.add(layers.MaxPooling2D((2, 2)))
  
model.add(layers.Conv2D(512, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
model.add(layers.Conv2D(512, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
model.add(layers.MaxPooling2D((2, 2)))
    
# Bridge
model.add(layers.Conv2D(1024, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
model.add(layers.Conv2D(1024, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
    
# Decoder
model.add(layers.Conv2DTranspose(512, (2, 2), strides=(2, 2), padding='same'))
model.add(layers.Conv2D(512, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
#model.add(layers.Concatenate()) 

model.add(layers.Conv2D(512, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
    
model.add(layers.Conv2DTranspose(256, (2, 2), strides=(2, 2), padding='same'))
model.add(layers.Conv2D(256, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())

model.add(layers.Conv2D(256, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
    
model.add(layers.Conv2DTranspose(128, (2, 2), strides=(2, 2), padding='same'))
model.add(layers.Conv2D(128, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())

model.add(layers.Conv2D(128, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
    
model.add(layers.Conv2DTranspose(64, (2, 2), strides=(2, 2), padding='same'))
model.add(layers.Conv2D(64, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())

model.add(layers.Conv2D(64, (3, 3), activation='relu', padding='same'))
model.add(layers.BatchNormalization())
    
# Output layer
model.add(layers.Conv2D(3, (1, 1), activation='softmax', padding='same'))

model.compile(optimizer='adam', loss='categorical_crossentropy', metrics=['accuracy'])

model.fit(train_images, train_masks, epochs=5, batch_size=100, verbose=1)

test_loss, test_acc = model.evaluate(test_images, test_masks)
print('Precision:', test_acc)
