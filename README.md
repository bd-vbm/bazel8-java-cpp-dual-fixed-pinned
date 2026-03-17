# Bazel 8 dual-mode starter (Java + C++) — Pinned & Lockfile-ready

This project now pins **rules_jvm_external 6.10** with SHA256 and is configured to generate a
`maven_install.json` lockfile in both Bzlmod and WORKSPACE modes.

## What changed
- WORKSPACE uses `rules_jvm_external@6.10` with SHA256 `e5f83b8f2678d2b26441e5eafefb1b061826608417b8d24e5e8e15e585eab1ba` and the **tar.gz** release URL.
- Added `rules_jvm_external_deps()` and `rules_jvm_external_setup()` per the release instructions.
- `maven_install_json = "//:maven_install.json"` (WORKSPACE) and `lock_file = "//:maven_install.json"` (Bzlmod) target the **same** lock file.
- Java toolchains/defaults set to **Java 17** in `.bazelrc`.

## Generate the lockfile (maven_install.json)
You only need to do this once (or when deps change):

**Bzlmod (default):**
```bash
bazel build //:all_apps
# With rules_jvm_external 6.10, the lock_file will be written during resolution.
```

**WORKSPACE mode:**
```bash
bazel run --config=workspace @maven//:pin
```

The generated file will appear at the repo root: `maven_install.json`.

## Build & run
**Bzlmod (default):**
```bash
bazel build //...
bazel run //java_app:app
bazel run //cpp_app:hello
```

**WORKSPACE mode:**
```bash
bazel build --config=workspace //...
bazel run --config=workspace //java_app:app
bazel run --config=workspace //cpp_app:hello
```

## Notes
- If your host JDK is not 17, export JAVA_HOME (macOS):
  ```bash
  export JAVA_HOME=$(/usr/libexec/java_home -v 17)
  ```
- Then clean and rebuild:
  ```bash
  bazel clean --expunge && bazel build //...
  ```
