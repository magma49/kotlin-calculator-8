package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

import org.junit.jupiter.api.Test

internal class ApplicationTest : NsTest() {

    @Test
    fun 기능_빈_문자열() {
        assertSimpleTest {
            run("\n")
            assertThat(output()).contains("결과: 0")
        }
    }

    @Test
    fun 기능_일반적인_경우() {
        assertSimpleTest {
            run("1,2,3")
            assertThat(output()).contains("결과: 6")
        }
    }

    @Test
    fun 기능_일반적인_경우_빈_문자열만() {
        assertSimpleTest {
            run(",,,")
            assertThat(output()).contains("결과: 0")
        }
    }

    @Test
    fun 기능_구문추가() {
        assertSimpleTest {
            run("//;\\n4;5,6")
            assertThat(output()).contains("결과: 15")
        }
    }

    @Test
    fun 기능_구문추가_복잡하게() {
        assertSimpleTest {
            run("//;.&\\n1.2&3:4;5,6")
            assertThat(output()).contains("결과: 21")
        }
    }

    @Test
    fun 예외_음수인_경우() {
        assertSimpleTest {
            assertThatThrownBy { runException("2,3,-1") }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Test
    fun 예외_문자인_경우() {
        assertSimpleTest {
            assertThatThrownBy { runException("2,3,k") }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Test
    fun 예외_숫자사이에_공백이_있는_경우() {
        assertSimpleTest {
            assertThatThrownBy { runException("2,3 4") }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Test
    fun 예외_추가하지_않은_구문() {
        assertSimpleTest {
            assertThatThrownBy { runException("//;\\n4;5&6") }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    override fun runMain() {
        main()
    }
}