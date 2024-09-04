package newday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiamondKataGenerator {

  public List<String> generate(char centerCharacter) {
    if(!Character.isAlphabetic(centerCharacter))
      return List.of();

    int size = (centerCharacter - 'A') * 2 + 1;
    List<String> rows = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      rows.add(generate(i, size));
    }

    return rows;
  }

  private String generate(int rowIndex, int totalSize) {
    char[] array = new char[totalSize];
    Arrays.fill(array, '_');
    int halfSize = totalSize / 2;
    int characterPosition;
    if (rowIndex <= halfSize)
      characterPosition = rowIndex;
    else
      characterPosition = totalSize - 1 - rowIndex;
    char character = (char) ('A' + characterPosition);
    array[halfSize - characterPosition] = character;
    array[halfSize + characterPosition] = character;

    return new String(array);
  }

}
