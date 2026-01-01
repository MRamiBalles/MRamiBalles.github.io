# PCD - Relación 2: Programación Distribuida (Sockets y RMI) (Oficial UHU)

La programación distribuida extiende la concurrencia a múltiples computadores interconectados, permitiendo la construcción de sistemas escalables y tolerantes a fallos.

## 1. Comunicación mediante Sockets (Nivel de Transporte)
Un socket es un punto final de comunicación entre dos procesos. En la UHU se estudian tanto Sockets TCP (orientados a conexión) como UDP (no orientados).

### 📝 Ejercicio Técnico: Servidor de Eco en Java (TCP)
Implemente un servidor que escuche en el puerto 5000 y devuelva cualquier mensaje recibido en mayúsculas.

```java
import java.io.*;
import java.net.*;

public class ServidorEco {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Servidor a la escucha...");
        
        while (true) {
            try (Socket client = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                
                String linea = in.readLine();
                if (linea != null) {
                    out.println(linea.toUpperCase());
                }
            } catch (IOException e) {
                System.err.println("Error con cliente: " + e.getMessage());
            }
        }
    }
}
```

## 2. Invocación de Métodos Remotos (RMI)
RMI permite que un objeto en una máquina virtual Java invoque métodos de un objeto en otra JVM, abstrayendo la comunicación de red.

### 📝 Estructura de un Sistema RMI
1. **Interfaz Remota**: Define los métodos que se pueden llamar (hereda de `Remote`).
2. **Objeto Remoto**: Implementa la interfaz.
3. **Servidor**: Crea la instancia y la registra en el `RMI Registry`.
4. **Cliente**: Busca el objeto y llama a sus métodos.

```java
// 1. Interfaz
public interface Calculadora extends Remote {
    int sumar(int a, int b) throws RemoteException;
}

// 2. Implementación
public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {
    public int sumar(int a, int b) { return a + b; }
}
```

## 3. Middleware y RPC vs RMI
- **RPC (Remote Procedure Call)**: Basado en procedimientos (lenguaje C). Usa `XDR` para representación de datos.
- **RMI (Remote Method Invocation)**: Basado en objetos (Java). Soporta polimorfismo y paso de objetos por serialización.

---
> [!CAUTION]
> **Serialización**: En RMI, cualquier objeto pasado como parámetro debe implementar la interfaz `Serializable`, de lo contrario lanzará una `NotSerializableException`.
