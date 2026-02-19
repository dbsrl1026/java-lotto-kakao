package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

    private static final List<LottoNumber> CACHE = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .mapToObj(LottoNumber::new)
            .toList();

    private final int num;

    private LottoNumber(int num) {
        if (num < START_NUMBER || num > END_NUMBER) {
            throw new RuntimeException("로또 번호는 " + START_NUMBER + "-" + END_NUMBER + " 사이 값이어야 합니다");
        }
        this.num = num;
    }

    public static LottoNumber of(int num) {
        validate(num);
        return CACHE.get(num - START_NUMBER);
    }

    private static void validate(int num) {
        if (num < START_NUMBER || num > END_NUMBER) {
            throw new RuntimeException("로또 번호는 " + START_NUMBER + "-" + END_NUMBER + " 사이 값이어야 합니다");
        }
    }

    public static List<LottoNumber> getAllNumbers() {
        return Collections.unmodifiableList(CACHE);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LottoNumber)) return false;
        LottoNumber number = (LottoNumber) obj;
        return this.num == number.num;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(num);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.num, other.num);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}