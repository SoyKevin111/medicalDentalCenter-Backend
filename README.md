# 🦷 Gestión de Consulta Médica Odontológica (Backend)

Este proyecto es un sistema backend para gestionar consultas médicas odontológicas, permitiendo el registro y
seguimiento de pacientes, evaluaciones previas y consultas médicas con especialistas.

## 🏥 **Narrativa del sistema**

Un paciente acude a un centro especialista de odontologia para solicitar una consulta.
Si el paciente no esta registrado, se procede a solicitar sus datos personales y crear una ficha medica.
Si el paciente esta registrado, una enfermera encargada procede a hace una pequena toma de signos vitales actualizando
la ficha medica del paciente donde se especifica el caso para determinar que especialista lo atendera en la consulta.
Posteriormente se realiza la consulta medica con el especialista asignado, donde el medico genera un diagnostico que se
agrega la consulta medica actual y se guarda la consulta medica actual en la ficha medica del paciente.

### 🔍 **Casos y Especialistas Asignados**

- **Caries** → 🦷 Odontólogo General
- **Brackets** → 🏗️ Ortodoncista
- **Encías** → 🌿 Periodoncista
- **Otro** → 🦷 Odontólogo General

---

# 🗂️ **Entidades del Sistema**

## 🏥 **Centro Médico**

### `CentroMedico`
| **Campo** | **Descripción** |
|-----------|----------------|
| `id`      | Identificador único |
| `nombre`  | Nombre del centro médico |

---

## 📋 **Ficha Médica**

### `FichaMedica`
| **Campo**         | **Descripción** |
|-------------------|----------------|
| `id`             | Identificador único |
| `Paciente p`     | Paciente asociado a la ficha |
| `EvaluacionPrevia evlp` | Evaluación previa realizada |
| `ConsultaMedica cm` | Consulta médica registrada |
| `fechaApertura`  | Fecha de apertura de la ficha |

---

## 🩺 **Evaluación Previa**

### `EvaluacionPrevia`
| **Campo**        | **Descripción** |
|------------------|----------------|
| `id`            | Identificador único |
| `List<EvaluacionPreviaDetalles> evls` | Lista de detalles de la evaluación previa |
| `caso`          | Descripción del caso |
| `Enfermera e`   | Enfermera que realizó la evaluación |

---

## 🩻 **Detalle de Evaluación Previa**

### `EvaluacionPreviaDetalle`
| **Campo**        | **Descripción** |
|------------------|----------------|
| `id`            | Identificador único |
| `Sintoma stm`   | Síntoma registrado |
| `tieneSintoma`  | Indica si el paciente presenta el síntoma (`true` o `false`) |

---

## 🏨 **Consulta Médica**

### `ConsultaMedica`
| **Campo**             | **Descripción** |
|-----------------------|----------------|
| `id`                 | Identificador único |
| `MedicoEspecialista mdep` | Médico especialista que atiende la consulta |
| `diagnostico`        | Diagnóstico de la consulta |

---

## 👤 **Paciente**

### `Paciente` (INPUT)
| **Campo**    | **Descripción** |
|-------------|----------------|
| `id`        | Identificador único |
| `nombre`    | Nombre del paciente |
| `apellido`  | Apellido del paciente |
| `edad`      | Edad del paciente |
| `genero`    | Género del paciente |
| `cedula`    | Número de cédula del paciente |
| `...otros datos personales` | Otros detalles del paciente |

---

## ⚕️ **Síntoma**

### `Sintoma`
| **Campo**    | **Descripción** |
|-------------|----------------|
| `id`        | Identificador único |
| `nombre`    | Nombre del síntoma |

---

## 👨‍⚕️ **Médico Especialista**

### `MedicoEspecialista`
| **Campo**      | **Descripción** |
|---------------|----------------|
| `id`          | Identificador único |
| `nombre`      | Nombre del médico |
| `especialidad` | Especialidad médica |

---

## 👩‍⚕️ **Enfermera**

### `Enfermera`
| **Campo**    | **Descripción** |
|-------------|----------------|
| `id`        | Identificador único |
| `nombre`    | Nombre de la enfermera |


##  🧾**Avances - API**

![Result](src/main/resources/static/api-progress/img/documentation/img_3.png)
![Result](src/main/resources/static/api-progress/img/documentation/img.png)
![Result](src/main/resources/static/api-progress/img/documentation/img_4.png)
![Result](src/main/resources/static/api-progress/img/previous_evaluation/previous-evaluation-create-validation3.png)
![Result](src/main/resources/static/api-progress/img/readme/img-1.png)



