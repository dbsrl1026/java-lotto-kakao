package lotto;

import java.util.Arrays;
import java.util.Comparator;

public enum WinningRank {

    NONE(0,1000,0,0),
    FIFTH(5000,5,3,0),
    FOURTH(50000,4,4, 0),
    THIRD(1_500_000,3,5, 0),
    SECOND(30_000_000,2,5,1),
    FIRST(2_000_000_000, 1, 6,0)
    ;

    public final Money winningPrice;
    public final int rank;
    private final int matchCount;
    private final int bounceCount;

    WinningRank(int winningPrice, int rank, int matchCount, int bounceCount) {
        this.winningPrice = new Money(winningPrice);
        this.rank = rank;
        this.matchCount = matchCount;
        this.bounceCount = bounceCount;
    }

    public boolean isSatisfied(int matchCount, int bounceCount) {
        return matchCount >= this.matchCount
                && bounceCount >= this.bounceCount;
    }

    public static WinningRank getRank(int matchCount, int bounceCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.isSatisfied(matchCount, bounceCount))
                .min(Comparator.comparingInt(r -> r.rank))
                .orElse(NONE);
    }
}
