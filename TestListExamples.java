import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

class IsSun implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("sun");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "d");
    List<String> right = Arrays.asList("a", "b", "c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeLong() {
    List<String> left = Arrays.asList("a", "a", "a", "a", "a", "a", "a", "a");
    List<String> right = Arrays.asList("b", "b", "b", "b", "b", "b", "b", "b", "b", "b");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "a", "a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b", "b",
        "b", "b", "b");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeAlternate() {
    List<String> left = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
    List<String> right = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "b", "c", "c", "d", "d", "e", "e", "f", "f", "g", "g", "h", "h");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeWords() {
    List<String> left = Arrays.asList("aa", "ab", "ac", "ad");
    List<String> right = Arrays.asList("aa", "ad", "ae", "af");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("aa", "aa", "ab", "ac", "ad", "ad", "ae", "af");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeEmpty() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList("a", "b", "c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c");
    assertEquals(expected, merged);
  }

  @Test
  public void testMergeTwoEmpty() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList();
    assertEquals(expected, merged);
  }

  @Test
  public void testFilterMoon() {
    List<String> list = Arrays.asList("this", "is", "not", "the", "moon");
    List<String> filtered = ListExamples.filter(list, new IsMoon());
    List<String> expected = Arrays.asList("moon");
    assertEquals(expected, filtered);
  }

  @Test
  public void testFilterMoon2() {
    List<String> list = Arrays.asList("this", "is", "not", "the", "sun");
    List<String> filtered = ListExamples.filter(list, new IsMoon());
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }

  @Test
  public void testFilterSun() {
    List<String> list = Arrays.asList("this", "is", "not", "the", "sun");
    List<String> filtered = ListExamples.filter(list, new IsSun());
    List<String> expected = Arrays.asList("sun");
    assertEquals(expected, filtered);
  }

  @Test
  public void testFilterSun2() {
    List<String> list = Arrays.asList("this", "is", "not", "the", "moon");
    List<String> filtered = ListExamples.filter(list, new IsSun());
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }
}
