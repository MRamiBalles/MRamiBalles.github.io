# PHVIM - Procesamiento del Habla y Videoconferencia Multimedia (Oficial UHU)

Este módulo se centra en las tecnologías de procesamiento digital de señales aplicadas al habla y la síntesis de voz, así como en los estándares de compresión y transmisión de multimedia.

## 📂 Recursos de Datos Relacionados
Este directorio contiene un corpus a gran escala para experimentos de reconocimiento de voz:

- **DeepSpeech Corpus**: Conjunto de datos optimizado para el motor de *Speech-to-Text* de Mozilla (DeepSpeech). Incluye archivos de audio y metadatos para el entrenamiento de redes neuronales acústicas.
- **mozilladstest**: Subconjunto de pruebas para la validación de modelos de lenguaje y precisión de transcripción (WER - Word Error Rate).

## 🧠 Áreas Temáticas Principales
1. **Producción del Habla**: Modelado del tracto vocal y análisis mediante formantes.
2. **Síntesis de Voz (TTS)**: Técnicas de síntesis por concatenación y modelado estadístico paramétrico.
3. **Reconocimiento Automático del Habla (ASR)**: Modelos Ocultos de Markov (HMM) y arquitecturas basadas en Deep Learning (RNN/LSTM).
4. **Codificación Multimedia**: Estándares de compresión de audio (MP3, AAC, Opus) y video (H.264, HEVC).

---
*Nota Técnica*: Debido al volumen de archivos en el subdirectorio `DeepSpeech`, se recomienda el uso de herramientas de procesamiento por lotes (*batch processing*) para la manipulación del corpus.
