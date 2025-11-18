package calculator

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

internal class ApplicationTest : NsTest() {
    @Test
    fun test() {
        assertSimpleTest({
            run("")
            assertThat(output()).contains("")
        })
    }

    override fun runMain() {
        main()
    }
}