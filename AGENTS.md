# Repository Guidelines

This is the learning repository for android compose especially Navigation 3. Never give a complete code as a response, just
give the the recommendation of the best practice so i can learn deep than usual.

## Project Structure & Module Organization

This repository is a single-module Android app. Root Gradle files live in `build.gradle.kts`,
`settings.gradle.kts`, and `gradle/libs.versions.toml`. Application code is under
`app/src/main/java/com/ramstudio/navigation`, with Compose UI split between `ui/presentation` for
screens and `ui/theme` for theme tokens. Resources live in `app/src/main/res`. Local JVM tests are
in `app/src/test`, and instrumented/device tests are in `app/src/androidTest`.

## Build, Test, and Development Commands

Use the Gradle wrapper from the repository root:

- `./gradlew assembleDebug` builds the debug APK.
- `./gradlew testDebugUnitTest` runs local JUnit tests in `app/src/test`.
- `./gradlew connectedDebugAndroidTest` runs instrumented tests on a device or emulator.
- `./gradlew lintDebug` runs Android Lint checks for the debug variant.
- `./gradlew :app:compileDebugKotlin -q` is useful for quick Kotlin compile validation.

## Coding Style & Naming Conventions

Write Kotlin with 4-space indentation and keep trailing commas where the formatter already uses
them. Follow standard Compose naming: screen composables use `PascalCase` and end with `Screen` when
they represent a route, for example `HomeScreen` or `ProfileScreen`. Keep packages lowercase under
`com.ramstudio.navigation`. Prefer small composables, state hoisted through parameters, and theme
values from `ui/theme` instead of inline color or typography constants.

## Testing Guidelines

Use JUnit4 for local unit tests and AndroidX test libraries for instrumented tests. Name test files
after the class or feature under test, and prefer method names that describe behavior, such as
`navigateToProfile_opensProfileScreen`. Add or update tests for navigation changes, state handling,
and any non-trivial UI logic. Run `testDebugUnitTest` before pushing; run
`connectedDebugAndroidTest` when changing Android-specific behavior.

## Commit & Pull Request Guidelines

Git history currently contains only `Initial commit`, so no strong convention is established yet.
Use short, imperative commit subjects such as `Add profile navigation state` or
`Fix favorite screen label`. Keep commits focused. For pull requests, include a clear summary, note
any test commands you ran, and attach screenshots or recordings for Compose UI changes.

## Configuration Notes

Do not commit machine-specific changes from `local.properties`. Manage dependency and plugin
versions through `gradle/libs.versions.toml` instead of hardcoding versions in module build files.
