# DataStore-Dependency-Injection

# ✅ Projeto Android com Hilt + KSP + (`libs.versions.toml`)

---

## 🧱 Estrutura de Tecnologias

- [x] **Jetpack Compose**
- [x] **Hilt (com KSP)**
- [x] **Version Catalog (`libs.versions.toml`)**
- [x] **Modular e escalável**

> ⚠️ **ATENÇÃO:**  
> O plugin `ksp` deve estar na mesma linha da versão do Kotlin usada no projeto.  
> Consulte sempre a versão correta neste link oficial:  
> 🔗 https://github.com/google/ksp

---

## 📦 Configuração do `libs.versions.toml`

Arquivo localizado em: `gradle/libs.versions.toml`

```toml
[versions]
hilt = "2.51"
androidx-hilt-navigation-compose = "1.2.0"
ksp = "1.9.23-1.0.20" # versão compatível com seu Kotlin
kotlin = "1.9.23"

[libraries]
hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hilt" }
hilt-ksp-compiler = { module = "com.google.dagger:hilt-compiler", version.ref = "hilt" }
hilt-navigation-compose = { module = "androidx.hilt:hilt-navigation-compose", version.ref = "androidx-hilt-navigation-compose" }

[plugins]
hilt = { id = "com.google.dagger.hilt.android", version.ref = "hilt" }
ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
```

## ⚙️ Configuração do build.gradle.kts do módulo :app

```
plugins {
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.seuprojeto.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.seuprojeto.app"
        minSdk = 21
        targetSdk = 34
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.12" // ajuste conforme sua versão
    }
}

dependencies {
    implementation(libs.hilt.android)
    ksp(libs.hilt.ksp.compiler)
    implementation(libs.hilt.navigation.compose)

    // Outras dependências: Compose, Room etc.
}

```

