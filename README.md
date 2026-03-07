# TecNM Control Escolar App

Aplicación móvil Android desarrollada en **Kotlin + Jetpack Compose** para estudiantes del **Tecnológico Nacional de México (TecNM)**.

La app permite a los estudiantes:

- Consultar su **horario de clases**
- Ver su **clase actual**
- Revisar su **perfil académico**
- Localizar **edificios del campus**
- Escanear **QR para asistencia**

Actualmente el proyecto utiliza **datos de prueba (FakeData)** para simular el backend antes de conectarlo a Supabase.

---

# Tecnologías utilizadas

- Kotlin
- Android Studio
- Jetpack Compose
- Material Design 3
- Navigation Compose

---

# Requisitos

Antes de ejecutar el proyecto debes tener instalado:

### 1. Android Studio
Descargar desde:

https://developer.android.com/studio

Versión recomendada: **Android Studio Iguana o superior**

---

### 2. SDK Android

Durante la instalación asegúrate de instalar:

- Android SDK
- Android Emulator
- Android SDK Platform

Minimum SDK del proyecto:
21

---

### 3. Gradle

No necesitas instalar Gradle manualmente.

El proyecto incluye **Gradle Wrapper**, por lo que Android Studio lo configurará automáticamente.

---

# Clonar el proyecto

Abre una terminal y ejecuta:
git clone https://github.com/Jesus-Puertos/AppTECNMControlEscolar.git


Luego entra a la carpeta:
cd AppTECNMControlEscolar


---

# Abrir el proyecto en Android Studio

1. Abrir **Android Studio**
2. Click en **Open**
3. Seleccionar la carpeta del proyecto
4. Esperar a que Android Studio haga:
Gradle Sync

Esto puede tardar unos minutos la primera vez.

---

# Ejecutar la aplicación

## Opción 1 — Usar emulador

1. Ir a:
Tools → Device Manager

2. Crear un dispositivo virtual (Pixel recomendado)

3. Iniciar el emulador

4. Presionar:

RUN
---

## Opción 2 — Usar celular físico

1. Activar **Opciones de desarrollador**
2. Activar **USB Debugging**
3. Conectar el teléfono por cable
4. Ejecutar la app con:
   RUN

---

# Estructura del proyecto
app
│
├── data
│ ├── model
│ │ ├── Student.kt
│ │ ├── ClassSession.kt
│ │ └── Building.kt
│ │
│ └── FakeData.kt
│
├── navigation
│ ├── AppScreens.kt
│ └── AppNavigation.kt
│
├── ui
│ ├── components
│ │ └── BottomBar.kt
│ │
│ ├── screens
│ │ ├── HomeScreen.kt
│ │ ├── ScheduleScreen.kt
│ │ ├── MapScreen.kt
│ │ └── ProfileScreen.kt
│ │
│ └── theme
│
└── MainActivity.kt


---

# Pantallas actuales

La aplicación contiene actualmente:

### Home
- saludo al estudiante
- clase actual
- próximas clases

### Schedule
- horario del día
- materias con tarjetas de color

### Map
- buscador de edificios
- simulación de mapa del campus
- lista de edificios cercanos

### Profile
- matrícula
- semestre
- promedio
- carrera
- clases del día

---

# Datos de prueba

Actualmente la aplicación utiliza:
FakeData.kt

para simular:

- alumno
- horario
- edificios del campus

Esto permite probar la interfaz antes de conectar el backend.

---

# Próximos pasos del proyecto

- Conectar backend con **Supabase**
- Implementar **login**
- Agregar **escáner QR para asistencia**
- Implementar **mapa real del campus**
- Mostrar **calificaciones**

---

# Problemas comunes

## Error de Gradle

Solución:
File → Sync Project with Gradle Files

---

## Iconos no encontrados

Agregar en `build.gradle`:
implementation("androidx.compose.material:material-icons-extended")

Luego:
Sync Now

---

## La app no corre en el emulador

Verificar que el emulador esté iniciado desde:
Device Manager

---

# Equipo

Proyecto desarrollado para la materia Aplicaciones Moviles del **TecNM**.

Integrantes:
- Jesús Alberto Rodríguez Puertos
- Arlyn Alfaro Dominguez

---

# Licencia

Proyecto académico.
