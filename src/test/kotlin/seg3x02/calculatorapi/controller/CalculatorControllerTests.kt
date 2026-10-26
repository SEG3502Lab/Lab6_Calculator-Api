package seg3x02.calculatorapi.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTests(@Autowired val mvc: MockMvc) {

    private fun check(url: String, expected: String) {
        mvc.get(url).andExpect {
            status { isOk() }
            content { string(expected) }
        }
    }

    @Test
    fun add() = check("/calculator/add/10/2", "12.0")

    @Test
    fun subtract() = check("/calculator/subtract/10/2", "8.0")

    @Test
    fun multiply() = check("/calculator/multiply/10/2", "20.0")

    @Test
    fun divide() = check("/calculator/divide/10/2", "5.0")

    @Test
    fun divideByZero() {
        mvc.get("/calculator/divide/10/0").andExpect {
            status { isBadRequest() }
            content { string("Division by zero is not allowed") }
        }
    }

    @Test
    fun openApiDocs() {
        mvc.get("/v3/api-docs").andExpect {
            status { isOk() }
            jsonPath("$.paths['/calculator/add/{a}/{b}']") { exists() }
        }
    }
}
