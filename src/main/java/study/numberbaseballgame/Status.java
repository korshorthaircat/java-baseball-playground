package study.numberbaseballgame;

public class Status {
    private final int strikeCount;
    private final int ballCount;
    private final int noBallCount;

    public Status(int strikeCount, int ballCount, int noBallCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.noBallCount = noBallCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getNoBallCount() {
        return noBallCount;
    }
}
