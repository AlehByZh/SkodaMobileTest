# AGENTS.md

Mobile UI tests for the Skoda app (`ru.skoda.service`): Maven + Java 21 + Appium Java client + JUnit 6 (milestone) + Allure.
Everything lives in `src/test/java`; there is no `src/main`, no CI, no Maven wrapper, and no lint/format/typecheck config — compilation is the only static gate.

## Prerequisites (AGENTS would otherwise fail silently or hang)

- Start the Appium server at `http://127.0.0.1:4723/` (base path `/`, not the old `/wd/hub`), with the UiAutomator2 driver installed.
- An Android emulator named `sdk_gphone_x86_64` must exist. Device names and capabilities are hardcoded in `src/test/java/org/example/factory/MobileCapabilities.java`; edit them there, not in tests.
- The APK is referenced by an **absolute** path (`MobileCapabilities.java:15`). Cloning or moving the repo breaks `setApp` until that path is updated. The iOS capability points to `Skoda_1.0.16.ipa`, which is not in the repo, and only `ANDROID` is wired up in tests.
- JDK 21 and Maven 3.9+ on `PATH` (verified with Corretto 21.0.7 / Maven 3.9.6). No `./mvnw`.

## Commands

```powershell
mvn test                                        # full suite; ~50 s with an emulator running
mvn test -Dtest=MainTests                       # one class
mvn test -Dtest=MainTests#serviceButtonTest     # one test method
```

Allure results are written to `target/allure-results` (set in `src/test/resources/allure.properties` and the `allure-maven` config). View them with either:

```powershell
mvn allure:serve
.\.allure\allure-2.29.0\bin\allure.bat serve target\allure-results
```

`.allure/` is a downloaded Allure CLI distribution that is untracked and **not** gitignored — never commit it.

## Structure

- `org.example.tests.MainTests` — the only test class. A driver is created per test in `@BeforeEach` and quit in `@AfterEach`, so every test relaunches/cleans the app; don't add cross-test state.
- `org.example.screens.*` — page objects built with Selenium `PageFactory` + `AppiumFieldDecorator` (10 s implicit wait). They own all locators; tests only call screen methods. Screen methods return `this` for chaining.
- `org.example.factory.*` — `MobileFactory.getDriver("ANDROID")` / `getAndroidDriver()` / `getIosDriver()` plus the capabilities above.
- Locators are Android resource ids / UiAutomator selectors tied to the Russian build. Offscreen elements use `@AndroidFindBy(uiAutomator = "new UiScrollable(...).scrollIntoView(...)")`; plain id lookup fails until scrolled, so keep that pattern.
- Test names end in `Tests` (`*Tests` is a surefire default pattern). Allure `@Epic` / `@DisplayName` / `@Step` strings are Russian and user-visible — write new ones in Russian to stay consistent.
- Assertion style is mixed: `AboutScreen` uses JUnit `assertTrue`; `MainScreen`/`ServiceScreen` use bare Java `assert` (only active with `-ea`, which surefire and IntelliJ enable by default). Prefer JUnit assertions for new checks.

## Known failure to expect

The last recorded run in `target/surefire-reports` had `checkLawInfoCardTest` erroring on `new UiSelector().resourceId("ru.skoda.service:id/toolbarTitle").text("ЮРИДИЧЕСКИЕ УСЛОВИЯ")` — a `text()` UiSelector with Cyrillic. If such a locator stops matching, first check the app language/version and hardcoded Russian strings before suspecting test logic.

The working tree currently has uncommitted dependency upgrades in `pom.xml`: JUnit `6.1.0-M1` (property still named `junit5.version`) and Allure `2.34.0`. The surefire `argLine` injects `aspectjweaver` from the local `~/.m2` repository — `mvn test` fails if that jar is missing, and Allure `@Step` reporting depends on it.
