package org.example.junit5

import io.qameta.allure.Allure
import io.qameta.allure.Allure.step
import io.qameta.allure.Step
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StepTest {

    @BeforeAll
    fun beforeAll() {
        step("step beforeAll1") { _ ->
            step("step beforeAll1.1")
            step("step beforeAll1.2") { _ ->
                Allure.addAttachment("Test", "test attachment")
                if (1 == 1) {
                    throw RuntimeException("test exception")
                }
            }
        }
        step("step beforeAll2") { _ ->
        }
    }

    @Test
    fun `test with lambda steps`() {
        step("step 1") { _ ->
            step("step 1.1")
            step("step 1.2") { _ ->

            }
        }
        step("step 2") { _ ->
        }
    }

    @Test
    fun `test with annotation steps`() {
        step1()
        step2()
    }

    @Step("step 1")
    fun step1() {
        step11()
        step12()
    }

    @Step("step 1.1")
    fun step11() {
    }

    @Step("step 1.2")
    fun step12() {
    }

    @Step("step 2")
    fun step2() {
    }
}
