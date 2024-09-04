package diamondkata;

import newday.DiamondKataGenerator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiamondKataTest {

  private static DiamondKataGenerator diamondKataGenerator;

  @BeforeAll
  public static void init() {
    diamondKataGenerator = new DiamondKataGenerator();
  }

  @DisplayName("Test to generate a diamond with the input character being the midpoint of the diamond")
  @ParameterizedTest(name = "#{index} - Run test with {0}")
  @MethodSource("provideTestParameters")
  void given_ACharacter_Then_GenerateDiamondKataAsExpected(char diamondCharacter, List<String> expectedRows) {
    List<String> actualRows = diamondKataGenerator.generate(diamondCharacter);
    assertEquals(expectedRows, actualRows);
  }

  private static Stream<Arguments> provideTestParameters() {
    return Stream.of(
      Arguments.of('A', asList(
        "A"
      )),
      Arguments.of('B', asList(
        "_A_",
        "B_B",
        "_A_"
      )),
      Arguments.of('C', asList(
        "__A__",
        "_B_B_",
        "C___C",
        "_B_B_",
        "__A__"
      )),
      Arguments.of('D', asList(
        "___A___",
        "__B_B__",
        "_C___C_",
        "D_____D",
        "_C___C_",
        "__B_B__",
        "___A___"
      ))
    );
  }

}

