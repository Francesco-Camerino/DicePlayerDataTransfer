package it.its.diceplayerdatatransfer;

public class DiceLogic {
    private Integer dicePlayer;
    private Integer diceAndroid;
    private Integer countPlayer = 0;
    private Integer countAndroid = 0;

    public byte getRandom() {
        dicePlayer =  (int) (Math.random() * 6) + 1;
        diceAndroid =  (int) (Math.random() * 6) + 1;
        if (dicePlayer > diceAndroid ) {
           countPlayer++;
           return 0;
        } else if (dicePlayer < diceAndroid) {
            countAndroid++;
            return 1;
        } else {
            return -1;
        }
    }

    public Integer getDicePlayer() {
        return dicePlayer;
    }

    public Integer getDiceAndroid() {
        return diceAndroid;
    }

    public Integer getCountPlayer() {
        return countPlayer;
    }

    public void setCountPlayer(Integer countPlayer) {
        this.countPlayer = countPlayer;
    }

    public Integer getCountAndroid() {
        return countAndroid;
    }

    public void setCountAndroid(Integer countAndroid) {
        this.countAndroid = countAndroid;
    }
}
