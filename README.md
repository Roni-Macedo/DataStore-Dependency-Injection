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
kotlin = "2.0.21"
dagger-hilt = "2.56.2"
ksp = "2.0.21-1.0.27" # versão compatível com seu Kotlin
datastorePreferences = "1.1.7"

[libraries]
androidx-datastore-preferences = { module = "androidx.datastore:datastore-preferences", version.ref = "datastorePreferences" }
dagger-hilt = { module = "com.google.dagger:hilt-android", version.ref = "dagger-hilt"}
hilt-compiler = { module = "com.google.dagger:hilt-android-compiler", version.ref = "dagger-hilt" }

[plugins]
dagger-hilt = { id = "com.google.dagger.hilt.android", version.ref = "dagger-hilt"}
ksp = { id = "com.google.devtools.ksp", version.ref = "ksp"}
```

## ⚙️ Configuração do build.gradle.kts do módulo :project

```
plugins {
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.dagger.hilt) apply false
}
```

## ⚙️ Configuração do build.gradle.kts do módulo :app

```
plugins {
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
}

dependencies {
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.dagger.hilt)
    ksp(libs.hilt.compiler)

    // Outras dependências: Compose, Room etc.
}

```

