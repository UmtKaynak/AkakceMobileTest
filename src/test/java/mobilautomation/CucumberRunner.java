package mobilautomation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;

/**
 *  allure serve AkakceMobilTest/allure-results  komutu ile rapora ulaşılabilir.
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Test",
        features = "src/test/resources/features",
        glue = {"mobilautomation.base",
                "mobilautomation.stepdefinitions"
        },
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}

)
public class CucumberRunner {
}
