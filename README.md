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
ksp = "2.0.21-1.0.27" # versão compatível com seu Kotlin
kotlin = "2.0.21"
datastorePreferences = "1.1.7"

[libraries]
androidx-datastore-preferences = { module = "androidx.datastore:datastore-preferences", version.ref = "datastorePreferences" }
hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hilt" }
hilt-ksp-compiler = { module = "com.google.dagger:hilt-compiler", version.ref = "hilt" }

[plugins]
hilt = { id = "com.google.dagger.hilt.android", version.ref = "hilt" }
ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
```

## ⚙️ Configuração do build.gradle.kts do módulo :project

```
plugins {
    alias(libs.plugins.hilt.android.gradle.plugin) apply false
    alias(libs.plugins.ksp) apply false
}
```

## ⚙️ Configuração do build.gradle.kts do módulo :app

```
plugins {
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(libs.hilt.android)
    ksp(libs.hilt.ksp.compiler)
    // Para o DataStore
    implementation(libs.androidx.datastore.preferences)

    // Outras dependências: Compose, Room etc.
}

```

