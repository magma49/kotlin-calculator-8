package calculator

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

internal class ApplicationTest : NsTest() {
    @Test
    fun 빈문자열() {
        assertSimpleTest({
            run("\n")
            assertThat(output()).contains("결과: 0")
        })
    }

    @Test
    fun 일반적인경우() {
        assertSimpleTest({
            run("1,2,3")
            assertThat(output()).contains("[1, 2, 3]", "결과: 2")
        })
    }

    @Test
    fun 구문추가() {
        assertSimpleTest({
            run("//;\\n1")
            assertThat(output()).contains("결과: 1")
        })
    }

    override fun runMain() {
        main()
    }
}