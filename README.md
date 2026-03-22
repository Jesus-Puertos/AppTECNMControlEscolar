# TecNM Control Escolar App


Aplicación móvil Android desarrollada en **Kotlin + Jetpack Compose** para estudiantes del **Tecnológico Nacional de México (TecNM)**.

La aplicación permite a los estudiantes gestionar su día a día mediante:

📅**Horario Inteligente:** Consulta de clases detallada.

🔔**Seguimiento en Tiempo Real:** Visualización de la clase actual y la siguiente.

🎓**Perfil Académico:** Resumen de situación escolar (promedio, carrera, semestre).

📍**Localizador de Campus:** Mapa interactivo para ubicar edificios y aulas.


# Tecnologías utilizadas 💡

| **HERRAMIENTA**            | 🎯 **PROPÓSITO**                     |
|:---------------------------|:-------------------------------------|
| 🟦 **Kotlin**              | Lógica de negocio y backend local.   |
| 🤖 **Android Studio**      | Entorno de desarrollo (Iguana+).     |
| 🎨 **Jetpack Compose**     | UI Declarativa y animaciones.        |
| 💎 **Material Design 3**   | Componentes visuales y tematización. |
| 🗺️ **Navigation Compose** | Enrutamiento de la aplicación.       |
---

# Requisitos 🛠️

Antes de ejecutar el proyecto asegurate de tener instalado:

### 🔳1. Android Studio
Descargar desde:

https://developer.android.com/studio

Versión recomendada: **Android Studio Iguana o superior**

---

### 🔳2. SDK Android

Durante la instalación asegúrate de instalar:

- Android SDK
- Android Emulator
- Android SDK Platform

Minimum SDK del proyecto:
21

---

### 🔳3. Gradle

No necesitas instalar Gradle manualmente.

El proyecto incluye **Gradle Wrapper**, por lo que Android Studio lo configurará automáticamente.

---

# Clonar el proyecto

Abre una terminal y ejecuta:
git clone https://github.com/Jesus-Puertos/AppTECNMControlEscolar.git


Luego entra a la carpeta:
cd AppTECNMControlEscolar


---
🚀 Configuración y Apertura del Proyecto
Sigue estos pasos para importar correctamente el proyecto en tu entorno de desarrollo:

➜ **Iniciar IDE:** Abre Android Studio (versión Jellyfish o superior recomendada).

➜ **Importar Proyecto:** En la pantalla de bienvenida, haz clic en el botón Open.

Navega en tu explorador de archivos hasta la carpeta donde clonaste el repositorio: AppTECNMControlEscolar.

Selecciónala y presiona OK.

➜ **Sincronización de Gradle:** Una vez abierto, observa la barra de estado inferior. Android Studio iniciará automáticamente el Gradle Sync.

⏳ Nota: Este proceso descarga las dependencias necesarias (Jetpack Compose, Material 3, etc.). Puede tardar de 2 a 5 minutos dependiendo de tu conexión a internet.

➜ **Verificación de Índice:** Espera a que aparezca el mensaje Gradle build finished.

    Si ves un error de "SDK missing", haz clic en el enlace azul que aparecerá en la consola para instalar la versión necesaria automáticamente.
---

# Ejecutar la aplicación

## Opción 1 — Usar emulador

🖥️ Uso del Emulador (Dispositivo Virtual)
Ideal para pruebas rápidas sin necesidad de cables.

🔸**Abrir el Administrador:** Dirígete al menú superior y selecciona Tools → Device Manager.

🔸**Configurar Dispositivo:** Haz clic en Create Device.

🔸**Selecciona una categoría de teléfono** (se recomienda un Pixel 6 o 7 por su resolución).

🔸**Elige una imagen de sistema (Recomendado:** API 31 o superior).

🔸**Lanzamiento:** Haz clic en el icono de "Play" (triángulo verde) junto a tu dispositivo creado para iniciar el emulador.

🔸**Despliegue:** Una vez que el emulador haya cargado el sistema Android, presiona el botón Run (ícono verde de reproducción ▶) en la barra de herramientas superior de Android Studio.
## Opción 2:  — Dispositivo Fisico
📱Uso de Dispositivo Físico
Esta opción es la mejor para probar la fluidez de las animaciones de Jetpack Compose.

### 1.Preparar el Teléfono:

➤Ve a Configuración → Acerca del teléfono.

➤Pulsa 7 veces seguidas sobre el Número de compilación hasta que aparezca el mensaje: "¡Ya eres desarrollador!".

### 2.Habilitar Conexión:

➤Entra en Ajustes del sistema → Opciones de desarrollador.

➤Activa la casilla de Depuración por USB (USB Debugging).

### 3.Conexión Física:
Conecta tu celular a la computadora mediante un cable USB de buena calidad. Si aparece un mensaje en tu teléfono preguntando "¿Permitir depuración por USB?", selecciona Permitir siempre.

### 4.Instalación:
En la barra superior de Android Studio, asegúrate de que el nombre de tu modelo de teléfono aparezca en el selector de dispositivos.

## Presiona 🟢 RUN y espera a que la app se instale y abra automáticamente.

---

# Estructura del proyecto

📦 app
├── 📂 data                # Capa de datos y lógica de negocio
│    ├── 📂 model          # Clases de datos (POJOs/Entities)
│    │    ├── 📄 Student.kt
│    │    ├── 📄 ClassSession.kt
│    │    └── 📄 Building.kt
│    └── 📄 FakeData.kt     # Repositorio de datos de prueba (Mock)
│
├── 📂 navigation          # Control de flujo y rutas de la app
│    ├── 📄 AppScreens.kt
│    └── 📄 AppNavigation.kt
│
├── 📂 ui                  # Capa de presentación (Jetpack Compose)
│    ├── 📂 components     # Componentes reutilizables (Widgets)
│    │    └── 📄 BottomBar.kt
│    ├── 📂 screens        # Vistas principales de la aplicación
│    │    ├── 📄 HomeScreen.kt
│    │    ├── 📄 ScheduleScreen.kt
│    │    ├── 📄 MapScreen.kt
│    │    └── 📄 ProfileScreen.kt
│    └── 📂 theme          # Configuración de Material 3 (Colores, Tipografía)
│
└── 📄 MainActivity.kt     # Punto de entrada principal de la aplicación


---

# 🖼️ Módulos y Pantallas de la Aplicación
La aplicación se divide en cuatro módulos principales, cada uno diseñado para resolver una necesidad específica del estudiante:

## 🏠 1. Dashboard de Inicio (Home)
Es el centro de operaciones del estudiante. Proporciona una vista rápida del estado actual de su día académico.

🔹 **Interfaz de Bienvenida:** Saludo personalizado al usuario (ej. "Hola, Arlyn").

🔹 **Monitor de Clase Actual:** Tarjeta dinámica que muestra la materia en curso, el edificio y el docente asignado.

🔹 **Indicador de Progreso:** Barra visual que calcula el tiempo restante de la clase actual (ej. 35 min restantes).

🔹 **Próximas Clases:** Lista cronológica de las materias siguientes para evitar confusiones de horario.

![35876.jpg](../../Downloads/35876.jpg)

## 📅 2. Horario Académico (Schedule)
Un sistema de gestión de tiempo organizado por días de la semana.

🔹 **Calendario Semanal:** Selector de días (Lun - Vie) con indicadores visuales del día seleccionado.

🔹 **Tarjetas de Materias:** Cada materia se distingue por códigos de color (azul para ciencias, verde para laboratorios, etc.) para una rápida identificación visual.

🔹 **Detalles de Sesión:** Muestra el rango de horas exacto y la ubicación (ej. Lab 3, Edificio A).

🔹 **Gestión de Pausas:** Incluye etiquetas visuales para el "Lunch Break" o tiempos libres.

![35877.jpg](../../Downloads/35877.jpg)

## 📍 3. Localizador de Campus (Map)
Herramienta de navegación interna para facilitar el desplazamiento entre edificios.

🔹 **Buscador Inteligente:** Barra de búsqueda para filtrar rápidamente edificios o aulas específicas.

🔹 **Filtros Rápidos:** Botones de acceso directo para Aulas, Laboratorios y Cafetería.

🔹 **Mapa Interactivo:** Representación visual del plano del campus con nodos interactivos que muestran información del edificio seleccionado.

🔹 **Geolocalización Simbolizada:** Ubicación precisa de puntos clave para estudiantes de nuevo ingreso.

![35878.jpg](../../Downloads/35878.jpg)

## 👤 4. Perfil y Estatus Académico (Profile)
Resumen administrativo y personal del estudiante en una vista consolidada.

🔹 **Identificación Oficial:** Muestra la matrícula única, carrera (Ingeniería en Sistemas) y semestre actual.

🔹 **Métrica de Desempeño:** Visualización destacada del Promedio General (Average Grade) mediante tarjetas de Material 3.

🔹 **Resumen de Jornada:*** Lista compacta de las clases que el estudiante tiene programadas para el día actual.

🔹 **Edición de Perfil:** Acceso rápido para actualizar la fotografía o información de contacto del alumno.

![35879.jpg](../../Downloads/35879.jpg)

--- 
# 📋 Datos de Prueba
Actualmente, la lógica de negocio se alimenta de: `data/FakeData.kt`

Esta capa de simulación incluye:
* 🆔 **Perfil del Estudiante:** Datos demográficos y académicos.
* 🕰️ **Horario Escolar:** Listado de materias y docentes por hora.
* 🏛️ **Mapeo de Campus:** Catálogo de edificios y puntos de interés.

> [!TIP]
> **Nota técnica:** Este archivo será reemplazado por un Repositorio de Datos (Repository Pattern) una vez que se implementen los servicios de **Supabase** y **Retrofit**.
---

## 🚀 Hoja de Ruta (Roadmap)

| Estatus | Funcionalidad | Descripción | Prioridad |
| :---: | :--- | :--- | :---: |
| 🔄 | **Conexión Supabase** | Migración de `FakeData` a una base de datos real en la nube. | Alta |
| 🔐 | **Sistema de Login** | Autenticación segura para alumnos del TecNM. | Alta |
| 📸 | **Escáner QR** | Registro de asistencia mediante escaneo de códigos en aula. | Media |
| 🗺️ | **Mapa Real (GPS)** | Integración con Google Maps SDK para navegación real. | Media |
| 📝 | **Módulo de Notas** | Consulta de calificaciones parciales y finales. | Alta |

> 🟢 **Leyenda:** 🔄 En progreso | 🔐 Próximamente | ✅ Completado

> [!NOTE]
> La implementación del escáner QR usará la librería de **CameraX** para Android.
---

# Problemas comunes

## 🛠️ Solución de Problemas

| Estado | 🛑 Problema Detectado | 🟢 Solución Sugerida |
| :---: | :--- | :--- |
| 🐘 | **Error de Gradle** | Ir a `File` ➤ `Sync Project with Gradle Files`. |
| 📋 | **Líneas rojas en el código** | `Build` ➤ `Clean Project` y luego `Rebuild Project`. |
| 🖼️ | **Iconos no cargan** | Añadir `material-icons-extended` en el `build.gradle`. |
| 📱 | **Emulador lento** | Activar la **Aceleración Hardware** en la BIOS. |
| 🔌 | **Celular no detectado** | Verificar que `USB Debugging` esté **ON**. |

---

## 🔧 Solución de Errores Comunes

Si encuentras algún problema técnico, sigue estas guías rápidas:

### 🎨 1. Iconos no encontrados
Si los iconos de la interfaz no aparecen o el código marca error en `Icons.Default`:
* **Acción:** Abre tu archivo `build.gradle.kts` (Module :app) y agrega:

implementation("androidx.compose.material:material-icons-extended")

---

### 📱 La app no corre en el emulador
Si al presionar **RUN** ▶️ no sucede nada o marca error de conexión:

* 🛠️ **Paso 1:** Ve al menú superior: `Tools` ➤ `Device Manager`.
* 🛠️ **Paso 2:** Verifica que el emulador esté **encendido** (debe aparecer un icono de "Stop" cuadrado si ya está corriendo).
* 🛠️ **Paso 3:** Si el dispositivo aparece como *Offline*, haz clic en los tres puntos `⋮` y selecciona **Cold Boot Now** para reiniciarlo por completo.

---
## 👥 Equipo de Desarrollo

Este proyecto ha sido desarrollado con ❤️ por estudiantes del **TecNM Campus Zongolica** para la materia de *Aplicaciones Móviles*.

### 💻 Desarrollo de Software
> 👤 **Jesús Alberto Rodríguez Puertos**
> * **Rol:** Lead Developer & Software Architect
> * **Especialidad:** Kotlin, Jetpack Compose & Backend Integration
> * 🔗 [GitHub Profile](https://github.com/Jesus-Puertos)

---

### ✍️ Documentación y Calidad (QA)
> 👤 **Arlyn Alfaro Dominguez**
> * **Rol:** Documentation Specialist & UX/UI Tester
> * **Especialidad:** Technical Writing & Quality Assurance
> * 🔗 [Contacto / GitHub](#)
---
## ⚖️ Licencia

Este es un **Proyecto Académico** sin fines de lucro.
> 🔓 **Nota:** El código es libre para consulta y fines educativos dentro del marco del TecNM.

---
<p align="center">
  <b>© 2024 - TecNM Control Escolar App</b>
</p>
