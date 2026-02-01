Explanation of Key Folders

src/ – Contains all Java code for automation:

main/java/ – Core and business logic for the automation framework:

business/ – Page objects:

data/ – Common data used across tests (e.g., test input values, Base URL etc.)

pages/ – Page Object classes (e.g., LandingPage)

BasePage.java – Base class for page objects, contains common page methods

core/ – Helper classes used in tests (e.g., ActionHelper, WaitHelper, etc.)

test/java/ – Test scripts and test infrastructure:

autoTests/ – Automated test cases:

landingPage/ – Test classes for the landing page (e.g., LandingPageTest)

BaseTest.java – Base test class for initializing WebDriver and test setup

listener/ – TestNG/JUnit listeners (e.g., Listeners.java)

screenshots/ – Stores screenshots captured during automated test execution for debugging or reporting failures.

.idea/ – IntelliJ IDEA project settings (for IDE convenience, usually ignored by Git via .gitignore).

.gitignore – Specifies files and folders that Git should ignore, such as IDE configs, Maven target folder, or temporary files.

pom.xml – Maven project file that manages dependencies (e.g., Selenium WebDriver), plugins, and build configuration.

README.md – Project documentation, instructions, and overview (this file).

target/ – Maven’s default output directory for compiled code, test reports, and temporary files. Usually ignored in Git.
